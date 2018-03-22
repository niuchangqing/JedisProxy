package com.jedis.proxy;

import net.sf.cglib.proxy.Enhancer;
import redis.clients.jedis.Jedis;

/**
* @author Niucqing
* @email niucqing@gmail.com
* @version 创建时间：2018年3月22日 上午11:15:56
* 类说明
*/
public class JedisProxy {
	public static Jedis create(Jedis jedis) {
		Enhancer enhancer = new Enhancer();
		enhancer.setSuperclass(Jedis.class);
		enhancer.setCallback(new JedisInterceptor(jedis));
		return (Jedis) enhancer.create();
	}

}
