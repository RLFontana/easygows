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

import br.com.easygo.dao.PedidoDao;
import br.com.easygo.model.Pedido;

@Path("/pedido")
public class PedidoController {
	
	@GET
	@Produces("application/json")
	public Response associacoes() {
		Gson gson = new Gson();
		
		PedidoDao dao = new PedidoDao();
		
		Pedido[] pedidos = dao.getListaPedido();
		
		String retorno = gson.toJson(pedidos, PedidoDao[].class);
		
		return Response.status(200).entity(retorno).build();
	}
	
	@GET
	@Produces("application/json")
	@Path("/{numero}")
	public Response pedido(@PathParam("numero") int numero) {
		Gson gson = new Gson();
		
		PedidoDao dao = new PedidoDao();
		
		Pedido pedido = dao.getPedidoByCodigo(numero);
		
		return Response.status(200).entity(gson.toJson(pedido)).build();
	}
	
	@POST
	public Response inserePedido(String body){
		int status;
		
		Gson gson = new Gson();
		
		PedidoDao dao = new PedidoDao();
		
		status = dao.salvaRegistro(gson.fromJson(body, Pedido.class)) ? 200 : 400;
		
		return Response.status(status).build();
	}
	
	@PUT
	public Response atualizaPedido(String body){
		int status;
		
		Gson gson = new Gson();
		
		PedidoDao dao = new PedidoDao();
		
		status = dao.salvaRegistro(gson.fromJson(body, Pedido.class)) ? 200 : 400;
		
		return Response.status(status).build();
	}
	
	@DELETE
	@Path("/{codigo}")
	public Response deletaPedido(@PathParam("codigo") int codigo) {
		int status;
		
		PedidoDao dao = new PedidoDao();
		
		status = dao.deletaRegistro(codigo) ? 200 : 400;
		
		return Response.status(status).build();
	}
}