package br.com.easygo.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import br.com.easygo.model.Cliente;

public class ClienteDao {
	private Connection connection = null;
	private Statement stmt = null;
	private ResultSet resultSet = null;
	private String tabela = "";
	
	public ClienteDao(){
		this.tabela = "localhost.easygo.cliente";
	}
	
	private Connection getConnection() throws SQLException{
		Connection conn;
		conn = ConnectionFactory.getInstance().getConnection();
		return conn;
	}
	
	public boolean salvaRegistro(Cliente cliente) {
		boolean retorno = false;
		String queryString;
		
		if (cliente.getId() == 0) {
			queryString = "INSERT INTO " + this.tabela + " VALUES('" + cliente.getNome() + "','" + cliente.getTelefone() + "','" + cliente.getDataNascimento() + "','" + cliente.getFoto()+"')";
		} else {
			queryString = "UPDATE " + this.tabela + " SET NOME = '" + cliente.getNome() + "', TELEFONE = '" + cliente.getTelefone() + "', DATANASCIMENTO = '" + cliente.getDataNascimento() + "', FOTO = '" + cliente.getFoto() + "')";
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
