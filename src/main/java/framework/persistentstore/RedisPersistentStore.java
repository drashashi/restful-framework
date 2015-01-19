package framework.persistentstore;

import com.sun.istack.internal.Pool;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class RedisPersistentStore implements PersistentStore {
	
	private final JedisPool pool;
	
	private RedisPersistentStore(JedisPool pool) {
		this.pool = pool; 
	}
	
	static PersistentStore getRedisStore() {
		return new RedisPersistentStore(new JedisPool(new JedisPoolConfig(), "ashashi-linux",6379));
	}

	@Override
	public PersistentStore put(String key, String value) {
		pool.getResource().set(key, value);
		pool.getResource().bgsave();
		return this;
	}

	@Override
	public String get(String key) {
		return pool.getResource().get(key);
	}
	
	public PersistentStore remove(String key) {
		pool.getResource().del(key);
		return this;
	}
	
	public static void main(String[] args) {
		PersistentStore redis = getRedisStore();
		System.out.println(redis.get("test"));
		
	}
}
