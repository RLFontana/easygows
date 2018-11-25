package br.com.easygo.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import br.com.easygo.model.ItemPedido;

public class ItemPedidoDao {
	private Connection connection = null;
	private Statement stmt = null;
	private ResultSet resultSet = null;
	private String tabela = "";
	
	public ItemPedidoDao(){
		this.tabela = "localhost.easygo.ItemPedido";
	}
	
	private Connection getConnection() throws SQLException{
		Connection conn;
		conn = ConnectionFactory.getInstance().getConnection();
		return conn;
	}
	
	public boolean salvaRegistro(ItemPedido itemPedido) {
		boolean retorno = false;
		String queryString;
		
		if (ItemPedido.getId() == 0) {
			queryString = "INSERT INTO " + this.tabela + " VALUES('" + itemPedido.getQuantidade() + "','" + itemPedido.getSituacao() + "','" + itemPedido.getPrecoUnitario() + "','" + itemPedido.getDataHoraEntrega() + "','" + itemPedido.getIdProduto() + "','" + itemPedido.getIdGarcom() + "','" + itemPedido.getIdMesa() + "','" + itemPedido.getIdPedido() + "')";
		} else {
			queryString = "UPDATE " + this.tabela + " SET QUANTIDADE = '" + itemPedido.getMatricula() + "', SITUACAO = '" + itemPedido.getSituacao() + "', PRECOUNITARIO = '" + itemPedido.getPrecoUnitario() + "', DATAHORAENTREGA = '" + itemPedido.getDataHoraEntrega() + "', IDPRODUTO = '" + itemPedido.getIdProduto() + "', IDMESA = '" + itemPedido.getIdMesa() + "')";
		}
		
		try{
			connection = getConnection();
			stmt = connection.createStatement();
			stmt.execute(queryString);
			retorno = true;
		}catch (SQLException e){
			e.printStackTrace();
		}
		
		return retorno;
	}
}