package br.com.easygo.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import br.com.easygo.model.Produto;

public class ProdutoDao {
	private Connection connection = null;
	private Statement stmt = null;
	private ResultSet resultSet = null;
	private String tabela = "";
	
	public ProdutoDao(){
		this.tabela = "localhost.easygo.Produto";
	}
	
	private Connection getConnection() throws SQLException{
		Connection conn;
		conn = ConnectionFactory.getInstance().getConnection();
		return conn;
	}
	
	public boolean salvaRegistro(Produto produto) {
		boolean retorno = false;
		String queryString;
		
		if (produto.getId() == 0) {
			queryString = "INSERT INTO " + this.tabela + " VALUES('" + produto.getNome() + "','" + produto.getTipo() + "', '" + produto.getDescricao() + "', '" + produto.getPreco() + "')";
		} else {
			queryString = "UPDATE " + this.tabela + " SET NOME = '" + produto.getNome() + "', TIPO = '" + produto.getTipo() + "', DESCRICAO = '" + produto.getDescricao() + "', PRECO = '" + produto.getPreco() + "')";
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