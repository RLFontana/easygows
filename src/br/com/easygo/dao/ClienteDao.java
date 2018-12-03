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
		this.tabela = "cliente";
	}
	
	private Connection getConnection() throws SQLException{
		Connection conn;
		conn = ConnectionFactory.getInstance().getConnection();
		return conn;
	}
	
	public Cliente[] getListaCliente() {
		Cliente cliente = null;
		Cliente[] retorno = null;
		String queryString = "SELECT * FROM cliente";
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
			
			retorno = new Cliente[rowCount];
			
			while(resultSet.next()) {
				cliente = new Cliente();
				
				cliente.setId(resultSet.getInt("id"));
				cliente.setDataNascimento(resultSet.getDate("dataNascimento"));
				cliente.setFoto(resultSet.getString("foto"));
				cliente.setNome(resultSet.getString("nome"));
				cliente.setTelefone(resultSet.getString("telefone"));
				
				retorno[i] = cliente;
				
				i++;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return retorno;
	}
	
	public Cliente getClienteByCodigo(int id) {
		Cliente cliente = new Cliente();
		String queryString = "SELECT * FROM Cliente WHERE id = " + id;
		
		try {
			connection = getConnection();
			stmt = connection.createStatement();
			resultSet = stmt.executeQuery(queryString);
			
			if (resultSet.first()) {
				cliente.setId(resultSet.getInt("id"));
				cliente.setDataNascimento(resultSet.getDate("dataNascimento"));
				cliente.setFoto(resultSet.getString("foto"));
				cliente.setNome(resultSet.getString("nome"));
				cliente.setTelefone(resultSet.getString("telefone"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return cliente;
	}
	
	public boolean salvaRegistro(Cliente cliente) {
		boolean retorno = false;
		String queryString;
		
		if (cliente.getId() == 0) {
			queryString = "INSERT INTO " + this.tabela + " VALUES('" + cliente.getNome() + "','" + cliente.getTelefone() + "','" + cliente.getDataNascimento() + "','" + cliente.getFoto() + "')";
		} else {
			queryString = "UPDATE " + this.tabela + " SET NOME = '" + cliente.getNome() + "', TELEFONE = '" + cliente.getTelefone() + "', DATANASCIMENTO = '" + cliente.getDataNascimento() + "', FOTO = '" + cliente.getFoto() + "' WHERE ID = " + cliente.getId();
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