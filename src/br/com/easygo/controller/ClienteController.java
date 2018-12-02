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

import br.com.easygo.dao.ClienteDao;
import br.com.easygo.model.Cliente;

@Path("/cliente")
public class ClienteController {
	
	@GET
	@Produces("application/json")
	public Response associacoes() {
		Gson gson = new Gson();
		
		ClienteDao dao = new ClienteDao();
		
		Cliente[] clientes = dao.getListaCliente();
		
		String retorno = gson.toJson(clientes, ClienteDao[].class);
		
		return Response.status(200).entity(retorno).build();
	}
	
	@GET
	@Produces("application/json")
	@Path("/{codigo}")
	public Response cliente(@PathParam("codigo") int codigo) {
		Gson gson = new Gson();
		
		ClienteDao dao = new ClienteDao();
		
		Cliente cliente = dao.getClienteByCodigo(codigo);
		
		return Response.status(200).entity(gson.toJson(cliente)).build();
	}
	
	@POST
	public Response insereCliente(String body){
		int status;
		
		Gson gson = new Gson();
		
		ClienteDao dao = new ClienteDao();
		
		status = dao.salvaRegistro(gson.fromJson(body, Cliente.class)) ? 200 : 400;
		
		return Response.status(status).build();
	}
	
	@PUT
	public Response atualizaCliente(String body){
		int status;
		
		Gson gson = new Gson();
		
		ClienteDao dao = new ClienteDao();
		
		status = dao.salvaRegistro(gson.fromJson(body, Cliente.class)) ? 200 : 400;
		
		return Response.status(status).build();
	}
	
	@DELETE
	@Path("/{codigo}")
	public Response deletaCliente(@PathParam("codigo") int codigo) {
		int status;
		
		ClienteDao dao = new ClienteDao();
		
		status = dao.deletaRegistro(codigo) ? 200 : 400;
		
		return Response.status(status).build();
	}
}