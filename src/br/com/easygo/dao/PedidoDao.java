package br.com.easygo.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import br.com.easygo.model.Pedido;
import br.com.easygo.model.Garcom;

public class PedidoDao {
	private Connection connection = null;
	private Statement stmt = null;
	private ResultSet resultSet = null;
	private String tabela = "";
	
	public PedidoDao(){
		this.tabela = "pedido";
	}
	
	private Connection getConnection() throws SQLException{
		Connection conn;
		conn = ConnectionFactory.getInstance().getConnection();
		return conn;
	}
	
	/*public Pedido[] getListaPedido() {
		Pedido pedido = null;
		Pedido[] retorno = null;
		String queryString = "SELECT * FROM pedido";
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
			
			retorno = new Pedido[rowCount];
			
			while(resultSet.next()) {
				pedido = new Pedido();
				
				pedido.setId(resultSet.getInt("id"));
				pedido.setDataHoraConfirmacao(resultSet.getDate("dataHoraConfirmacao"));
				pedido.setDataHoraInclusao(resultSet.getDate("dataHoraInclusao"));
				pedido.setIdGarcom(resultSet.getInt("idGarcom"));
				pedido.setNumero(resultSet.getInt("numero"));
				
				retorno[i] = pedido;
				
				i++;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return retorno;
	}*/
	
	public Pedido getPedidoByCodigo(int numero) {
		Pedido pedido = new Pedido();
		String queryString = "SELECT * FROM pedido WHERE numero = " + numero;
		
		try {
			connection = getConnection();
			stmt = connection.createStatement();
			resultSet = stmt.executeQuery(queryString);
			
			if (resultSet.first()) {
				pedido.setId(resultSet.getInt("id"));
				pedido.setDataHoraConfirmacao(resultSet.getDate("dataHoraConfirmacao"));
				pedido.setDataHoraInclusao(resultSet.getDate("dataHoraInclusao"));
				pedido.setNumero(resultSet.getInt("numero"));
				
				queryString = "SELECT * FROM garcom WHERE id = " + resultSet.getInt("idGarcom");
				
				try {
					resultSet = stmt.executeQuery(queryString);
					
					if (resultSet.first()) {
						Garcom garcom = new Garcom();
						
						garcom.setId(resultSet.getInt("id"));
						garcom.setMatricula(resultSet.getString("matricula"));
						garcom.setNome(resultSet.getString("nome"));
						
						pedido.setGarcom(garcom);
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return pedido;
	}
	
	public boolean salvaRegistro(Pedido pedido) {
		boolean retorno = false;
		String queryString;
		
		if (pedido.getId() == 0) {
			//queryString = "INSERT INTO " + this.tabela + " VALUES('" + pedido.getNumero() + "','" + pedido.getDataHoraInclusao() + "','" + pedido.getDataHoraConfirmacao() + "', '" + pedido.getIdGarcom() + "')";
			queryString = "INSERT INTO " + this.tabela + " VALUES('" + pedido.getNumero() + "','" + pedido.getDataHoraInclusao() + "','" + pedido.getDataHoraConfirmacao() + "')";
		} else {
			//queryString = "UPDATE " + this.tabela + " SET NUMERO = '" + pedido.getNumero() + "', DATAHORAINCLUSAO = '" + pedido.getDataHoraInclusao() + "', DATAHORACONFIRMACAO = '" + pedido.getDataHoraConfirmacao() + "', IDGARCOM = '" + pedido.getIdGarcom() + "' WHERE ID = " + pedido.getId();
			queryString = "UPDATE " + this.tabela + " SET NUMERO = '" + pedido.getNumero() + "', DATAHORAINCLUSAO = '" + pedido.getDataHoraInclusao() + "', DATAHORACONFIRMACAO = '" + pedido.getDataHoraConfirmacao() + " WHERE ID = " + pedido.getId();
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