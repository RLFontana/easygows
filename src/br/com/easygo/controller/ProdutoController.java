package br.com.easygo.controller;

import java.sql.SQLException;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;

import br.com.easygo.dao.ConnectionFactory;
import br.com.easygo.model.Produto;

@Path("/produto")
public class ProdutoController {
	
	@GET
	@Produces("application/json")
	public Response produtos() {
		Gson gson = new Gson();
		Produto produto = new Produto();
		try {
			ConnectionFactory.getInstance().getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Response.status(200).entity(gson.toJson(produto)).build();
	}
	
	@GET
	@Produces("application/json")
	@Path("/{codigo}")
	public Response produto(@PathParam("codigo") int codigo) {
		Gson gson = new Gson();
		Produto produto = new Produto();
		produto.setId(codigo);
		return Response.status(200).entity(gson.toJson(produto)).build();
	}
}
