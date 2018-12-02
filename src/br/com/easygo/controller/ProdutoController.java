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

import br.com.easygo.dao.ProdutoDao;
import br.com.easygo.model.Produto;

@Path("/produto")
public class ProdutoController {
	
	@GET
	@Produces("application/json")
	public Response produtos() {
		Gson gson = new Gson();
		
		ProdutoDao dao = new ProdutoDao();
		
		Produto[] produtos = dao.getListaProduto();
		
		String retorno = gson.toJson(produtos, Produto[].class);
		
		return Response.status(200).entity(retorno).build();
	}
	
	@GET
	@Produces("application/json")
	@Path("/{codigo}")
	public Response produto(@PathParam("codigo") int codigo) {
		Gson gson = new Gson();
		
		ProdutoDao dao = new ProdutoDao();
		
		Produto produto = dao.getProdutoByCodigo(codigo);
		
		return Response.status(200).entity(gson.toJson(produto)).build();
	}
	
	@POST
	public Response insereProduto(String body){
		int status;
		
		Gson gson = new Gson();
		
		ProdutoDao dao = new ProdutoDao();
		
		status = dao.salvaRegistro(gson.fromJson(body, Produto.class)) ? 200 : 400;
		
		return Response.status(status).build();
	}
	
	@PUT
	public Response atualizaProduto(String body){
		int status;
		
		Gson gson = new Gson();
		
		ProdutoDao dao = new ProdutoDao();
		
		status = dao.salvaRegistro(gson.fromJson(body, Produto.class)) ? 200 : 400;
		
		return Response.status(status).build();
	}
	
	@DELETE
	@Path("/{codigo}")
	public Response deletaProduto(@PathParam("codigo") int codigo) {
		int status;
		
		ProdutoDao dao = new ProdutoDao();
		
		status = dao.deletaRegistro(codigo) ? 200 : 400;
		
		return Response.status(status).build();
	}
}