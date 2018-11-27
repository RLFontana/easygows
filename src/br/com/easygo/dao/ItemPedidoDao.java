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
		this.tabela = "itempedido";
	}
	
	private Connection getConnection() throws SQLException{
		Connection conn;
		conn = ConnectionFactory.getInstance().getConnection();
		return conn;
	}
	
	public ItemPedido[] getItemPedido() {
		ItemPedido itemPedido = null;
		ItemPedido[] retorno = null;
		String queryString = "SELECT * FROM itempedido";
		int rowCount = 0;
		int i = 0;
		
		try {
			connection = getConnection();
			stmt = connection.createStatement();
			resultSet = stmt.executeQuery(queryString);
			
			if (resultSet.last()) {
				rowCount = resultSet.getRow();
				resultSet.beforeFirst();
			}
			
			retorno = new ItemPedido[rowCount];
			
			while(resultSet.next()) {
				itemPedido = new ItemPedido();
				
				itemPedido.setId(resultSet.getInt("id"));
				itemPedido.setDataHoraEntrega(resultSet.getDate("dataHoraEntrega"));
				itemPedido.setIdGarcom(resultSet.getInt("idGarcom"));
				itemPedido.setIdMesa(resultSet.getInt("idMesa"));
				itemPedido.setIdPedido(resultSet.getInt("idPedido"));
				itemPedido.setIdProduto(resultSet.getInt("idProduto"));
				itemPedido.setPrecoUnitario(resultSet.getDouble("precoUnitario"));
				itemPedido.setQuantidade(resultSet.getInt("quantidade"));
				itemPedido.setSituacao(resultSet.getString("situacao"));
				
				retorno[i] = itemPedido;
				
				i++;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return retorno;
	}
	
	public ItemPedido getItemPedidoByCodigo(int numero) {
		ItemPedido itemPedido = new ItemPedido();
		String queryString = "SELECT * FROM itempedido WHERE numero = " + numero;
		
		try {
			connection = getConnection();
			stmt = connection.createStatement();
			resultSet = stmt.executeQuery(queryString);
			
			if (resultSet.first()) {
				itemPedido.setId(resultSet.getInt("id"));
				itemPedido.setDataHoraEntrega(resultSet.getDate("dataHoraEntrega"));
				itemPedido.setIdGarcom(resultSet.getInt("idGarcom"));
				itemPedido.setIdMesa(resultSet.getInt("idMesa"));
				itemPedido.setIdPedido(resultSet.getInt("idPedido"));
				itemPedido.setIdProduto(resultSet.getInt("idProduto"));
				itemPedido.setPrecoUnitario(resultSet.getDouble("precoUnitario"));
				itemPedido.setQuantidade(resultSet.getInt("quantidade"));
				itemPedido.setSituacao(resultSet.getString("situacao"));	
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return itemPedido;
	}
	
	public boolean salvaRegistro(ItemPedido itemPedido) {
		boolean retorno = false;
		String queryString;
		
		if (itemPedido.getId() == 0) {
			queryString = "INSERT INTO " + this.tabela + " VALUES('" + itemPedido.getQuantidade() + "','" + itemPedido.getSituacao() + "','" + itemPedido.getPrecoUnitario() + "','" + itemPedido.getDataHoraEntrega() + "','" + itemPedido.getIdPedido() + "','" + itemPedido.getIdGarcom() + "','" + itemPedido.getIdMesa() + "','" + itemPedido.getIdPedido() + "')";
		} else {
			queryString = "UPDATE " + this.tabela + " SET QUANTIDADE = '" + itemPedido.getQuantidade() + "', SITUACAO = '" + itemPedido.getSituacao() + "', PRECOUNITARIO = '" + itemPedido.getPrecoUnitario() + "', DATAHORAENTREGA = '" + itemPedido.getDataHoraEntrega() + "', IDPRODUTO = '" + itemPedido.getIdPedido() + "', IDMESA = '" + itemPedido.getIdMesa() + "' WHERE ID = " + itemPedido.getId();;
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
	
	public boolean deletaRegistro(int id) {
		boolean retorno = false;
		String queryString = "DELETE FROM " + this.tabela + " WHERE id = " + id;
		
		try {
			connection = getConnection();
			stmt = connection.createStatement();
			stmt.execute(queryString);
			retorno = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return retorno;
	}
}