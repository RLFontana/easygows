package br.com.easygo.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import br.com.easygo.model.Comanda;

public class ComandaDao {
	private Connection connection = null;
	private Statement stmt = null;
	private ResultSet resultSet = null;
	private String tabela = "";
	
	public ComandaDao(){
		this.tabela = "comanda";
	}
	
	private Connection getConnection() throws SQLException{
		Connection conn;
		conn = ConnectionFactory.getInstance().getConnection();
		return conn;
	}
	
	public Comanda[] getListaComanda() {
		Comanda comanda = null;
		Comanda[] retorno = null;
		String queryString = "SELECT * FROM comanda";
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
			
			retorno = new Comanda[rowCount];
			
			while(resultSet.next()) {
				comanda = new Comanda();
				
				comanda.setId(resultSet.getInt("id"));
				comanda.setDataHoraAbertura(resultSet.getDate("dataHoraAbertura"));
				comanda.setDataHoraFechamento(resultSet.getDate("dataHoraFechamento"));
				comanda.setIdCliente(resultSet.getInt("idCliente"));
				comanda.setNumero(resultSet.getInt("numero"));
				
				retorno[i] = comanda;
				
				i++;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return retorno;
	}
	
	public Comanda getComandaByCodigo(int numero) {
		Comanda comanda = new Comanda();
		String queryString = "SELECT * FROM comanda WHERE numero = " + numero;
		
		try {
			connection = getConnection();
			stmt = connection.createStatement();
			resultSet = stmt.executeQuery(queryString);
			
			if (resultSet.first()) {
				comanda.setId(resultSet.getInt("id"));
				comanda.setDataHoraAbertura(resultSet.getDate("dataHoraAbertura"));
				comanda.setDataHoraFechamento(resultSet.getDate("dataHoraFechamento"));
				comanda.setIdCliente(resultSet.getInt("idCliente"));
				comanda.setNumero(resultSet.getInt("numero"));	
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return comanda;
	}
	
	public boolean salvaRegistro(Comanda comanda) {
		boolean retorno = false;
		String queryString;
		
		if (comanda.getId() == 0) {
			queryString = "INSERT INTO " + this.tabela + " VALUES('" + comanda.getNumero() + "', '" + comanda.getDataHoraAbertura() + "','" + comanda.getDataHoraFechamento() + "','" + comanda.getIdCliente() + "')";
		} else {
			queryString = "UPDATE " + this.tabela + " SET NUMERO = '" + comanda.getNumero() + "', DATAHORAABERTURA = '" + comanda.getDataHoraAbertura() + "', DATAHORAFECHAMENTO = '" + comanda.getDataHoraFechamento() + "', IDCLIENTE = '" + comanda.getIdCliente() + "' WHERE ID = " + comanda.getId();
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