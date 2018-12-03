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

import br.com.easygo.dao.ComandaDao;
import br.com.easygo.model.Comanda;

@Path("/comanda")
public class ComandaController {
	
	/*@GET
	@Produces("application/json")
	public Response associacoes() {
		Gson gson = new Gson();
		
		ComandaDao dao = new ComandaDao();
		
		Comanda[] comandas = dao.getListaComanda();
		
		String retorno = gson.toJson(comandas, ComandaDao[].class);
		
		return Response.status(200).entity(retorno).build();
	}*/
	
	@GET
	@Produces("application/json")
	@Path("/{numero}")
	public Response comanda(@PathParam("numero") int numero) {
		Gson gson = new Gson();
		
		ComandaDao dao = new ComandaDao();
		
		Comanda comanda = dao.getComandaByCodigo(numero);
		
		return Response.status(200).entity(gson.toJson(comanda)).build();
	}
	
	@POST
	public Response insereComanda(String body){
		int status;
		
		Gson gson = new Gson();
		
		ComandaDao dao = new ComandaDao();
		
		status = dao.salvaRegistro(gson.fromJson(body, Comanda.class)) ? 200 : 400;
		
		return Response.status(status).build();
	}
	
	@PUT
	public Response atualizaComanda(String body){
		int status;
		
		Gson gson = new Gson();
		
		ComandaDao dao = new ComandaDao();
		
		status = dao.salvaRegistro(gson.fromJson(body, Comanda.class)) ? 200 : 400;
		
		return Response.status(status).build();
	}
	
	@DELETE
	@Path("/{codigo}")
	public Response deletaComanda(@PathParam("codigo") int codigo) {
		int status;
		
		ComandaDao dao = new ComandaDao();
		
		status = dao.deletaRegistro(codigo) ? 200 : 400;
		
		return Response.status(status).build();
	}
}