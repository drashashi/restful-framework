package framework.persistentstore;

public class PersistentStores {
	
	public static PersistentStore getRedisStore(){
		return RedisPersistentStore.getRedisStore();
	}

}
