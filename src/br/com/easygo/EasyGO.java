package br.com.easygo;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

@Path("/")
public class EasyGO {
	
	@GET
	@Produces("text/html")
	public Response isRunning() {
		return Response.status(200).entity("<H2>EasyGO REST API is up and running!</H2>").build();
	}
	
	@GET
	@Path("/teste/{status}")
	public Response teste(@PathParam("status") int status) {
		return Response.status(status).build();
	}
}
