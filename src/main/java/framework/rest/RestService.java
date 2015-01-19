package framework.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import framework.persistentstore.PersistentStore;
import framework.persistentstore.PersistentStores;

@Path("/api")
public class RestService {
	private final PersistentStore store;

	public RestService() {
		store = PersistentStores.getRedisStore();
	}
	
	@Path("{key}")
	@Produces(MediaType.TEXT_PLAIN)
	@GET
	public String getPeople(@PathParam("key") final String key) {
		return store.get(key);
	}

}