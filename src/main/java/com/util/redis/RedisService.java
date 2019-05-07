package com.util.redis;

public interface RedisService {
	
	
	//设置
	public String set(String key, String value);
	
	//设置并且设置主键的生存时间
	public String setex(String key, int seconds, String value);
	
	//设置主键的生存时间
	
	public Long expire(String key, int seconds);
	
	//获取
	public String get(String key);
	
	//删除
	public Long del(String key);
	
	//自增
	public Long incr(String key);
	
	//以毫秒为单位返回 key 的剩余的过期时间
	public Long ttl(String key);

	public Boolean hexists(String key, String field);

	public String hget(String key, String field);

	public void hset(String key, String field, String writeValueAsString);

    public void incrBy(String s, int i);
}
