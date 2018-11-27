package br.com.easygo.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import br.com.easygo.model.AssocPedidoComanda;

public class AssocPedidoComandaDao {
	private Connection connection = null;
	private Statement stmt = null;
	private ResultSet resultSet = null;
	private String tabela = "";
	
	public AssocPedidoComandaDao(){
		this.tabela = "assocpedidocomanda";
	}
	
	private Connection getConnection() throws SQLException{
		Connection conn;
		conn = ConnectionFactory.getInstance().getConnection();
		return conn;
	}
	
	public AssocPedidoComanda[] getAssocPedidoComanda() {
		AssocPedidoComanda assocPedidoComanda = null;
		AssocPedidoComanda[] retorno = null;
		String queryString = "SELECT * FROM associacaopedidocomanda";
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
			
			retorno = new AssocPedidoComanda[rowCount];
			
			while(resultSet.next()) {
				assocPedidoComanda = new AssocPedidoComanda();
				
				assocPedidoComanda.setId(resultSet.getInt("id"));
				assocPedidoComanda.setIdComanda(resultSet.getInt("idcomanda"));
				assocPedidoComanda.setIdPedido(resultSet.getInt("idpedido"));
				
				retorno[i] = assocPedidoComanda;
				
				i++;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return retorno;
	}
	
	public AssocPedidoComanda getAssocPedidoComandaByCodigo(int id) {
		AssocPedidoComanda assocPedidoComanda = new AssocPedidoComanda();
		String queryString = "SELECT * FROM assocpedidocomanda WHERE id = " + id;
		
		try {
			connection = getConnection();
			stmt = connection.createStatement();
			resultSet = stmt.executeQuery(queryString);
			
			if (resultSet.first()) {
				assocPedidoComanda.setId(resultSet.getInt("id"));
				assocPedidoComanda.setIdComanda(resultSet.getInt("idcomanda"));
				assocPedidoComanda.setIdPedido(resultSet.getInt("idpedido"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return assocPedidoComanda;
	}
	
	public boolean salvaRegistro(AssocPedidoComanda assocPedidoComanda) {
		boolean retorno = false;
		String queryString;
		
		if (assocPedidoComanda.getId() == 0) {
			queryString = "INSERT INTO " + this.tabela + " VALUES('" + assocPedidoComanda.getIdPedido() + "','" + assocPedidoComanda.getIdComanda() + "')";
		} else {
			queryString = "UPDATE " + this.tabela + " SET IDPEDIDO = '" + assocPedidoComanda.getIdPedido() + "', IDCOMANDA = '" + assocPedidoComanda.getIdComanda() + "' WHERE ID = " + assocPedidoComanda.getId();
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