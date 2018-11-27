package br.com.easygo.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import br.com.easygo.model.Solicitacao;

public class SolicitacaoDao {
	private Connection connection = null;
	private Statement stmt = null;
	private ResultSet resultSet = null;
	private String tabela = "";
	
	public SolicitacaoDao(){
		this.tabela = "solicitacao";
	}
	
	private Connection getConnection() throws SQLException{
		Connection conn;
		conn = ConnectionFactory.getInstance().getConnection();
		return conn;
	}
	
	public Solicitacao[] getSolicitacao() {
		Solicitacao solicitacao = null;
		Solicitacao[] retorno = null;
		String queryString = "SELECT * FROM solicitacao";
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
			
			retorno = new Solicitacao[rowCount];
			
			while(resultSet.next()) {
				solicitacao = new Solicitacao();
				
				solicitacao.setId(resultSet.getInt("id"));
				solicitacao.setAtendido(resultSet.getBoolean("atendido"));
				solicitacao.setIdComanda(resultSet.getInt("idComanda"));
				solicitacao.setIdGarcom(resultSet.getInt("idGarcom"));
				
				retorno[i] = solicitacao;
				
				i++;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return retorno;
	}
	
	public Solicitacao getByCodigo(int id) {
		Solicitacao solicitacao = new Solicitacao();
		
		String queryString = "SELECT * FROM solicitacao WHERE ID = " + id;
		
		try {
			connection = getConnection();
			stmt = connection.createStatement();
			resultSet = stmt.executeQuery(queryString);
			
			if (resultSet.first()) {
				solicitacao.setId(resultSet.getInt("id"));
				solicitacao.setAtendido(resultSet.getBoolean("atendido"));
				solicitacao.setIdComanda(resultSet.getInt("idComanda"));
				solicitacao.setIdGarcom(resultSet.getInt("idGarcom"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return solicitacao;
	}
	
	public boolean salvaRegistro(Solicitacao solicitacao) {
		boolean retorno = false;
		String queryString;
		
		if (solicitacao.getId() == 0) {
			queryString = "INSERT INTO " + this.tabela + " VALUES('" + solicitacao.getIdComanda() + "','" + solicitacao.getIdGarcom() + "', '" + solicitacao.getAtendido() + "')";
		} else {
			queryString = "UPDATE " + this.tabela + " SET IDCOMANDA = '" + solicitacao.getIdComanda() + "', IDGARCOM = '" + solicitacao.getIdGarcom() + "', ATENDIDO = '" + solicitacao.getAtendido() + "' WHERE ID = " + solicitacao.getId();;
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