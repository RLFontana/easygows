package br.com.easygo.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import br.com.easygo.model.Garcom;

public class GarcomDao {
	private Connection connection = null;
	private Statement stmt = null;
	private ResultSet resultSet = null;
	private String tabela = "";
	
	public GarcomDao(){
		this.tabela = "garcom";
	}
	
	private Connection getConnection() throws SQLException{
		Connection conn;
		conn = ConnectionFactory.getInstance().getConnection();
		return conn;
	}
	
	public Garcom[] getListaGarcom() {
		Garcom garcom = null;
		Garcom[] retorno = null;
		String queryString = "SELECT * FROM garcom";
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
			
			retorno = new Garcom[rowCount];
			
			while(resultSet.next()) {
				garcom = new Garcom();
				
				garcom.setId(resultSet.getInt("id"));
				garcom.setMatricula(resultSet.getString("matricula"));
				garcom.setNome(resultSet.getString("nome"));
				
				retorno[i] = garcom;
				
				i++;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return retorno;
	}
	
	public Garcom getGarcomByMatricula(String matricula) {
		Garcom garcom = new Garcom();
		String queryString = "SELECT * FROM garcom WHERE matricula = " + matricula;
		
		try {
			connection = getConnection();
			stmt = connection.createStatement();
			resultSet = stmt.executeQuery(queryString);
			
			if (resultSet.first()) {
				garcom.setId(resultSet.getInt("id"));
				garcom.setMatricula(resultSet.getString("matricula"));
				garcom.setNome(resultSet.getString("nome"));	
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return garcom;
	}
	
	public boolean salvaRegistro(Garcom garcom) {
		boolean retorno = false;
		String queryString;
		
		if (garcom.getId() == 0) {
			queryString = "INSERT INTO " + this.tabela + " VALUES('" + garcom.getMatricula() + "','" + garcom.getNome() + "')";
		} else {
			queryString = "UPDATE " + this.tabela + " SET MATRICULA = '" + garcom.getMatricula() + "', NOME = '" + garcom.getNome() + "' WHERE ID = " + garcom.getId();;
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