package framework.persistentstore;

public interface PersistentStore {
	
	PersistentStore put(String key, String value);
	String get(String key);
	PersistentStore remove(String string);

}
