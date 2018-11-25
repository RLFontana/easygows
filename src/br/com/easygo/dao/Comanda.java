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
		this.tabela = "localhost.easygo.comanda";
	}
	
	private Connection getConnection() throws SQLException{
		Connection conn;
		conn = ConnectionFactory.getInstance().getConnection();
		return conn;
	}
	
	public boolean salvaRegistro(Comanda comanda) {
		boolean retorno = false;
		String queryString;
		
		if (comanda.getId() == 0) {
			queryString = "INSERT INTO " + this.tabela + " VALUES('" + comanda.getDataHoraAbertura() + "','" + comanda.getDataHoraFechamento() + "','" + comanda.getIdCliente() + "', '" + comanda.getIdMesa() + "')";
		} else {
			queryString = "UPDATE " + this.tabela + " SET DATAHORAABERTURA = '" + comanda.getDataHoraAbertura() + "', DATAHORAFECHAMENTO = '" + comanda.getDataHoraFechamento() + "', IDCLIENTE = '" + comanda.getIdCliente() + "', IDMESA = '" + comanda.getIdMesa() + "')";
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