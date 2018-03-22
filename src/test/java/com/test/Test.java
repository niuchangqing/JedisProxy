package com.test;

import java.util.Set;

import com.jedis.proxy.JedisProxy;

import redis.clients.jedis.Jedis;

/**
* @author Niucqing
* @email niucqing@gmail.com
* @version 创建时间：2018年3月22日 下午1:10:13
* 类说明
*/
public class Test {

	public static void main(String[] args) {
		Jedis je = new Jedis("127.0.0.1", 6379);
		Jedis jedis = JedisProxy.create(je);
		String string = jedis.set("name", "niucqing");
		System.out.println(string);
		jedis.sadd("set", "a", "b");
		Set<String> smembers = jedis.smembers("set");
		System.out.println(smembers);
	}

}
