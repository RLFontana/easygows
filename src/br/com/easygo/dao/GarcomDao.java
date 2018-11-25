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
		this.tabela = "localhost.easygo.Garcom";
	}
	
	private Connection getConnection() throws SQLException{
		Connection conn;
		conn = ConnectionFactory.getInstance().getConnection();
		return conn;
	}
	
	public boolean salvaRegistro(Garcom garcom) {
		boolean retorno = false;
		String queryString;
		
		if (garcom.getId() == 0) {
			queryString = "INSERT INTO " + this.tabela + " VALUES('" + garcom.getMatricula() + "','" + garcom.getNome() + "')";
		} else {
			queryString = "UPDATE " + this.tabela + " SET MATRICULA = '" + garcom.getMatricula() + "', NOME = '" + garcom.getNome() + "')";
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