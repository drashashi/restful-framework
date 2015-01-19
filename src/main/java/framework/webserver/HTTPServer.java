package framework.webserver;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.ServerConnector;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.eclipse.jetty.util.resource.Resource;

import com.sun.jersey.api.core.ClassNamesResourceConfig;
import com.sun.jersey.spi.container.servlet.ServletContainer;

import framework.rest.RestMappings;

public class HTTPServer {
	
	public static void main(String[] args) throws Exception {
		
		 ServletHolder sh = new ServletHolder(ServletContainer.class);
		 sh.setInitParameter("com.sun.jersey.config.property.resourceConfigClass", "com.sun.jersey.api.core.PackagesResourceConfig");
		 sh.setInitParameter("com.sun.jersey.config.property.packages", "framework.rest");//Set the package where the services reside
		 sh.setInitParameter("com.sun.jersey.api.json.POJOMappingFeature", "true");
		 Server server = new Server(9999);
		 ServletContextHandler context = new ServletContextHandler(server, "/", ServletContextHandler.SESSIONS);
		 context.addServlet(sh, "/*");
		 server.start();
		 server.join();
		 }
}