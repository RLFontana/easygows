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
		this.tabela = "localhost.easygo.Mesa";
	}
	
	private Connection getConnection() throws SQLException{
		Connection conn;
		conn = ConnectionFactory.getInstance().getConnection();
		return conn;
	}
	
	public boolean salvaRegistro(Mesa mesa) {
		boolean retorno = false;
		String queryString;
		
		if (Mesa.getId() == 0) {
			queryString = "INSERT INTO " + this.tabela + " VALUES('" + mesa.getQuantidadeDeCadeiras() + "','" + mesa.getSituacao() + "')";
		} else {
			queryString = "UPDATE " + this.tabela + " SET QUANTIDADEDECADEIRAS = '" + mesa.getQuantidadeDeCadeiras() + "', SITUACAO = '" + mesa.getSituacao() + "')";
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