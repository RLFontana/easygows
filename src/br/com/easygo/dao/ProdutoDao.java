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
		this.tabela = "produto";
	}
	
	private Connection getConnection() throws SQLException{
		Connection conn;
		conn = ConnectionFactory.getInstance().getConnection();
		return conn;
	}
	
	public Produto[] getListaProduto() {
		Produto produto = null;
		Produto[] retorno = null;
		String queryString = "SELECT * FROM produto";
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
			
			retorno = new Produto[rowCount];
			
			while(resultSet.next()) {
				produto = new Produto();
				produto.setDescricao(resultSet.getString("descricao"));
				produto.setId(resultSet.getInt("id"));
				produto.setNome(resultSet.getString("nome"));
				produto.setCodigo(resultSet.getInt("codigo"));
				produto.setPreco(resultSet.getDouble("preco"));
				produto.setTipo(resultSet.getString("tipo"));
				
				retorno[i] = produto;
				
				i++;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return retorno;
	}
	
	public Produto getProdutoByCodigo(int codigo) {
		Produto produto = new Produto();
		String queryString = "SELECT * FROM produto WHERE codigo = " + codigo;
		
		try {
			connection = getConnection();
			stmt = connection.createStatement();
			resultSet = stmt.executeQuery(queryString);
			
			if (resultSet.first()) {
				produto.setDescricao(resultSet.getString("descricao"));
				produto.setId(resultSet.getInt("id"));
				produto.setNome(resultSet.getString("nome"));
				produto.setCodigo(resultSet.getInt("codigo"));
				produto.setPreco(resultSet.getDouble("preco"));
				produto.setTipo(resultSet.getString("tipo"));	
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return produto;
	}
	
	public boolean salvaRegistro(Produto produto) {
		boolean retorno = false;
		String queryString;
		
		if (produto.getId() == 0) {
			queryString = "INSERT INTO " + this.tabela + " VALUES('" + produto.getId() + "','" + produto.getCodigo() + "','" + produto.getNome() + "','" + produto.getTipo() + "', '" + produto.getDescricao() + "', '" + produto.getPreco() + "')";
		} else {
			queryString = "UPDATE " + this.tabela + " SET CODIGO = '" + produto.getCodigo() + "', NOME = '" + produto.getNome() + "', TIPO = '" + produto.getTipo() + "', DESCRICAO = '" + produto.getDescricao() + "', PRECO = '" + produto.getPreco() + "' WHERE ID = " + produto.getId();
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
	
	public boolean deletaRegistro(int codigo) {
		boolean retorno = false;
		String queryString = "DELETE FROM " + this.tabela + " WHERE codigo = " + codigo;
		
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