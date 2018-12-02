package br.com.easygo.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import br.com.easygo.model.Mesa;

public class MesaDao {
	private Connection connection = null;
	private Statement stmt = null;
	private ResultSet resultSet = null;
	private String tabela = "";
	
	public MesaDao(){
		this.tabela = "mesa";
	}
	
	private Connection getConnection() throws SQLException{
		Connection conn;
		conn = ConnectionFactory.getInstance().getConnection();
		return conn;
	}
	
	public Mesa[] getListaMesa() {
		Mesa mesa = null;
		Mesa[] retorno = null;
		String queryString = "SELECT * FROM mesa";
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
			
			retorno = new Mesa[rowCount];
			
			while(resultSet.next()) {
				mesa = new Mesa();
				
				mesa.setId(resultSet.getInt("id"));
				mesa.setNumero(resultSet.getInt("numero"));
				mesa.setQuantidadeCadeiras(resultSet.getInt("quantidadeCadeiras"));
				mesa.setSituacao(resultSet.getString("situacao"));
				
				retorno[i] = mesa;
				
				i++;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return retorno;
	}
	
	public Mesa getMesaByCodigo(int numero) {
		Mesa mesa = new Mesa();
		String queryString = "SELECT * FROM mesa WHERE numero = " + numero;
		
		try {
			connection = getConnection();
			stmt = connection.createStatement();
			resultSet = stmt.executeQuery(queryString);
			
			if (resultSet.first()) {
				mesa.setId(resultSet.getInt("id"));
				mesa.setNumero(resultSet.getInt("numero"));
				mesa.setQuantidadeCadeiras(resultSet.getInt("quantidadeCadeiras"));
				mesa.setSituacao(resultSet.getString("situacao"));	
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return mesa;
	}
	
	public boolean salvaRegistro(Mesa mesa) {
		boolean retorno = false;
		String queryString;
		
		if (mesa.getId() == 0) {
			queryString = "INSERT INTO " + this.tabela + " VALUES('" + mesa.getNumero() + "','" + mesa.getQuantidadeCadeiras() + "','" + mesa.getSituacao() + "')";
		} else {
			queryString = "UPDATE " + this.tabela + " SET NUMERO = '" + mesa.getNumero() + "', QUANTIDADEDECADEIRAS = '" + mesa.getQuantidadeCadeiras() + "', SITUACAO = '" + mesa.getSituacao() + "' WHERE ID = " + mesa.getId();;
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