package framework.rest;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import framework.persistentstore.PersistentStores;
@Path("/tests")
public class RestMappings {

	    @GET
	    @Path("test")
	    @Produces(MediaType.TEXT_PLAIN)
	    public String test() {
	        return "Test";
	    }
	    
	    @POST
	    @Path("timer")
	    public Response time(@QueryParam("time") long time) throws InterruptedException { 
	    	long timer = System.currentTimeMillis();
	    	Thread.sleep(time);
	    	timer = System.currentTimeMillis() - timer;
	    	PersistentStores.getRedisStore().put("test-time-1", Long.toString(timer));
	    	return Response.ok().build();
	    }
}
