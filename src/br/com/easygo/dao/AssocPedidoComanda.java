package br.com.easygo.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import br.com.easygo.model.AssocPedidoComanda;

public class AssocPedidoComandaDao {
	private Connection connection = null;
	private Statement stmt = null;
	private ResultSet resultSet = null;
	private String tabela = "";
	
	public AssocPedidoComandaDao(){
		this.tabela = "localhost.easygo.assocpedidocomanda";
	}
	
	private Connection getConnection() throws SQLException{
		Connection conn;
		conn = ConnectionFactory.getInstance().getConnection();
		return conn;
	}
	
	public boolean salvaRegistro(AssocPedidoComanda assocPedidoComanda) {
		boolean retorno = false;
		String queryString;
		
		if (assocPedidoComanda.getId() == 0) {
			queryString = "INSERT INTO " + this.tabela + " VALUES('" + assocPedidoComanda.getIdPedido() + "','" + assocPedidoComanda.getIdComanda() + "')";
		} else {
			queryString = "UPDATE " + this.tabela + " SET IDPEDIDO = '" + assocPedidoComanda.getIdPedido() + "', IDCOMANDA = '" + assocPedidoComanda.getIdComanda() + "')";
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