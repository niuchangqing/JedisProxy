package com.jedis.proxy;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
import redis.clients.jedis.Jedis;

/**
* @author Niucqing
* @email niucqing@gmail.com
* @version 创建时间：2018年3月22日 上午11:14:54
* 类说明
*/
public class JedisInterceptor implements MethodInterceptor {
	private Jedis jedis;

	public JedisInterceptor(Jedis jedis) {
		this.jedis = jedis;
	}

	public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
		Object invoke = null;
		try {
			invoke = proxy.invoke(jedis, args);
			System.err.println("execute jedis comand");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			jedis.close();
			System.err.println("jedis closed");
		}
		return invoke;
	}

}
