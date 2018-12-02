package br.com.easygo.controller;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;

import br.com.easygo.dao.GarcomDao;
import br.com.easygo.model.Garcom;

@Path("/garcom")
public class GarcomController {
	
	@GET
	@Produces("application/json")
	public Response associacoes() {
		Gson gson = new Gson();
		
		GarcomDao dao = new GarcomDao();
		
		Garcom[] garcoms = dao.getListaGarcom();
		
		String retorno = gson.toJson(garcoms, GarcomDao[].class);
		
		return Response.status(200).entity(retorno).build();
	}
	
	@GET
	@Produces("application/json")
	@Path("/{matricula}")
	public Response garcom(@PathParam("matricula") String matricula) {
		Gson gson = new Gson();
		
		GarcomDao dao = new GarcomDao();
		
		Garcom garcom = dao.getGarcomByMatricula(matricula);
		
		return Response.status(200).entity(gson.toJson(garcom)).build();
	}
	
	@POST
	public Response insereGarcom(String body){
		int status;
		
		Gson gson = new Gson();
		
		GarcomDao dao = new GarcomDao();
		
		status = dao.salvaRegistro(gson.fromJson(body, Garcom.class)) ? 200 : 400;
		
		return Response.status(status).build();
	}
	
	@PUT
	public Response atualizaGarcom(String body){
		int status;
		
		Gson gson = new Gson();
		
		GarcomDao dao = new GarcomDao();
		
		status = dao.salvaRegistro(gson.fromJson(body, Garcom.class)) ? 200 : 400;
		
		return Response.status(status).build();
	}
	
	@DELETE
	@Path("/{codigo}")
	public Response deletaGarcom(@PathParam("codigo") int codigo) {
		int status;
		
		GarcomDao dao = new GarcomDao();
		
		status = dao.deletaRegistro(codigo) ? 200 : 400;
		
		return Response.status(status).build();
	}
}