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
		this.tabela = "localhost.easygo.Solicitacao";
	}
	
	private Connection getConnection() throws SQLException{
		Connection conn;
		conn = ConnectionFactory.getInstance().getConnection();
		return conn;
	}
	
	public boolean salvaRegistro(Solicitacao solicitacao) {
		boolean retorno = false;
		String queryString;
		
		if (solicitacao.getId() == 0) {
			queryString = "INSERT INTO " + this.tabela + " VALUES('" + solicitacao.getIdComanda() + "','" + solicitacao.getIdGarcom() + "', '" + solicitacao.getAtendido + "')";
		} else {
			queryString = "UPDATE " + this.tabela + " SET IDCOMANDA = '" + solicitacao.getIdComanda() + "', IDGARCOM = '" + solicitacao.getIdGarcom() + "', ATENDIDO = '" + solicitacao.getAtendido + "')";
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