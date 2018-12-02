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

import br.com.easygo.dao.ItemPedidoDao;
import br.com.easygo.model.ItemPedido;

@Path("/itemPedido")
public class ItemPedidoController {
	
	@GET
	@Produces("application/json")
	public Response associacoes() {
		Gson gson = new Gson();
		
		ItemPedidoDao dao = new ItemPedidoDao();
		
		ItemPedido[] itemPedidos = dao.getListaItemPedido();
		
		String retorno = gson.toJson(itemPedidos, ItemPedidoDao[].class);
		
		return Response.status(200).entity(retorno).build();
	}
	
	@GET
	@Produces("application/json")
	@Path("/{numero}")
	public Response itemPedido(@PathParam("numero") int numero) {
		Gson gson = new Gson();
		
		ItemPedidoDao dao = new ItemPedidoDao();
		
		ItemPedido itemPedido = dao.getItemPedidoByCodigo(numero);
		
		return Response.status(200).entity(gson.toJson(itemPedido)).build();
	}
	
	@POST
	public Response insereItemPedido(String body){
		int status;
		
		Gson gson = new Gson();
		
		ItemPedidoDao dao = new ItemPedidoDao();
		
		status = dao.salvaRegistro(gson.fromJson(body, ItemPedido.class)) ? 200 : 400;
		
		return Response.status(status).build();
	}
	
	@PUT
	public Response atualizaItemPedido(String body){
		int status;
		
		Gson gson = new Gson();
		
		ItemPedidoDao dao = new ItemPedidoDao();
		
		status = dao.salvaRegistro(gson.fromJson(body, ItemPedido.class)) ? 200 : 400;
		
		return Response.status(status).build();
	}
	
	@DELETE
	@Path("/{codigo}")
	public Response deletaItemPedido(@PathParam("codigo") int codigo) {
		int status;
		
		ItemPedidoDao dao = new ItemPedidoDao();
		
		status = dao.deletaRegistro(codigo) ? 200 : 400;
		
		return Response.status(status).build();
	}
}