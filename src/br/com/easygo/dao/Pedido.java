package br.com.easygo.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import br.com.easygo.model.Pedido;

public class PedidoDao {
	private Connection connection = null;
	private Statement stmt = null;
	private ResultSet resultSet = null;
	private String tabela = "";
	
	public PedidoDao(){
		this.tabela = "localhost.easygo.Pedido";
	}
	
	private Connection getConnection() throws SQLException{
		Connection conn;
		conn = ConnectionFactory.getInstance().getConnection();
		return conn;
	}
	
	public boolean salvaRegistro(Pedido pedido) {
		boolean retorno = false;
		String queryString;
		
		if (pedido.getId() == 0) {
			queryString = "INSERT INTO " + this.tabela + " VALUES('" + pedido.getDataHoraInclusao() + "','" + pedido.getDataHoraConfirmacao() + "', '" + pedido.getIdGarcom + "', '" + pedido.getIdSolicitacao + "')";
		} else {
			queryString = "UPDATE " + this.tabela + " SET DATAHORAINCLUSAO = '" + pedido.getDataHoraInclusao() + "', DATAHORACONFIRMACAO = '" + pedido.getDataHoraConfirmacao() + "', IDGARCOM = '" + pedido.getIdGarcom + "', IDSOLICITACAO = '" + pedido.getIdSolicitacao + "')";
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