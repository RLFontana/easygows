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

import br.com.easygo.dao.MesaDao;
import br.com.easygo.model.Mesa;

@Path("/mesa")
public class MesaController {
	
	@GET
	@Produces("application/json")
	public Response associacoes() {
		Gson gson = new Gson();
		
		MesaDao dao = new MesaDao();
		
		Mesa[] mesas = dao.getListaMesa();
		
		String retorno = gson.toJson(mesas, MesaDao[].class);
		
		return Response.status(200).entity(retorno).build();
	}
	
	@GET
	@Produces("application/json")
	@Path("/{numero}")
	public Response mesa(@PathParam("numero") int numero) {
		Gson gson = new Gson();
		
		MesaDao dao = new MesaDao();
		
		Mesa mesa = dao.getMesaByCodigo(numero);
		
		return Response.status(200).entity(gson.toJson(mesa)).build();
	}
	
	@POST
	public Response insereMesa(String body){
		int status;
		
		Gson gson = new Gson();
		
		MesaDao dao = new MesaDao();
		
		status = dao.salvaRegistro(gson.fromJson(body, Mesa.class)) ? 200 : 400;
		
		return Response.status(status).build();
	}
	
	@PUT
	public Response atualizaMesa(String body){
		int status;
		
		Gson gson = new Gson();
		
		MesaDao dao = new MesaDao();
		
		status = dao.salvaRegistro(gson.fromJson(body, Mesa.class)) ? 200 : 400;
		
		return Response.status(status).build();
	}
	
	@DELETE
	@Path("/{codigo}")
	public Response deletaMesa(@PathParam("codigo") int codigo) {
		int status;
		
		MesaDao dao = new MesaDao();
		
		status = dao.deletaRegistro(codigo) ? 200 : 400;
		
		return Response.status(status).build();
	}
}