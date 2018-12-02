package br.com.easygo.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import br.com.easygo.model.AssocItemPedidoComanda;

public class AssocItemPedidoComandaDao {
	private Connection connection = null;
	private Statement stmt = null;
	private ResultSet resultSet = null;
	private String tabela = "";
	
	public AssocItemPedidoComandaDao(){
		this.tabela = "assocpedidocomanda";
	}
	
	private Connection getConnection() throws SQLException{
		Connection conn;
		conn = ConnectionFactory.getInstance().getConnection();
		return conn;
	}
	
	public AssocItemPedidoComanda[] getListaAssocItemPedidoComanda() {
		AssocItemPedidoComanda assocItemPedidoComanda = null;
		AssocItemPedidoComanda[] retorno = null;
		String queryString = "SELECT * FROM associtempedidocomanda";
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
			
			retorno = new AssocItemPedidoComanda[rowCount];
			
			while(resultSet.next()) {
				assocItemPedidoComanda = new AssocItemPedidoComanda();
				
				assocItemPedidoComanda.setId(resultSet.getInt("id"));
				assocItemPedidoComanda.setIdComanda(resultSet.getInt("idcomanda"));
				assocItemPedidoComanda.setIdItemPedido(resultSet.getInt("iditempedido"));
				
				retorno[i] = assocItemPedidoComanda;
				
				i++;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return retorno;
	}
	
	public AssocItemPedidoComanda getAssocItemPedidoComandaByCodigo(int id) {
		AssocItemPedidoComanda assocItemPedidoComanda = new AssocItemPedidoComanda();
		String queryString = "SELECT * FROM associtempedidocomanda WHERE id = " + id;
		
		try {
			connection = getConnection();
			stmt = connection.createStatement();
			resultSet = stmt.executeQuery(queryString);
			
			if (resultSet.first()) {
				assocItemPedidoComanda.setId(resultSet.getInt("id"));
				assocItemPedidoComanda.setIdComanda(resultSet.getInt("idcomanda"));
				assocItemPedidoComanda.setIdItemPedido(resultSet.getInt("iditempedido"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return assocItemPedidoComanda;
	}
	
	public boolean salvaRegistro(AssocItemPedidoComanda assocItemPedidoComanda) {
		boolean retorno = false;
		String queryString;
		
		if (assocItemPedidoComanda.getId() == 0) {
			queryString = "INSERT INTO " + this.tabela + " VALUES('" + assocItemPedidoComanda.getIdItemPedido() + "','" + assocItemPedidoComanda.getIdComanda() + "')";
		} else {
			queryString = "UPDATE " + this.tabela + " SET IDPEDIDO = '" + assocItemPedidoComanda.getIdItemPedido() + "', IDCOMANDA = '" + assocItemPedidoComanda.getIdComanda() + "' WHERE ID = " + assocItemPedidoComanda.getId();
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