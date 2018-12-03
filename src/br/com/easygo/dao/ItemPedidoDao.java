package br.com.easygo.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import br.com.easygo.model.ItemPedido;
import br.com.easygo.model.Mesa;
import br.com.easygo.model.Produto;

public class ItemPedidoDao {
	private Connection connection = null;
	private Statement stmt = null;
	private ResultSet resultSet = null;
	private String tabela = "";
	
	public ItemPedidoDao(){
		this.tabela = "itempedido";
	}
	
	private Connection getConnection() throws SQLException{
		Connection conn;
		conn = ConnectionFactory.getInstance().getConnection();
		return conn;
	}
	
	/*public ItemPedido[] getListaItemPedido() {
		ItemPedido itemPedido = null;
		ItemPedido[] retorno = null;
		String queryString = "SELECT * FROM itempedido";
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
			
			retorno = new ItemPedido[rowCount];
			
			while(resultSet.next()) {
				itemPedido = new ItemPedido();
				
				itemPedido.setId(resultSet.getInt("id"));
				itemPedido.setDataHoraEntrega(resultSet.getDate("dataHoraEntrega"));
				itemPedido.setIdGarcom(resultSet.getInt("idGarcom"));
				itemPedido.setQtComanda(resultSet.getInt("qtComanda"));
				itemPedido.setIdMesa(resultSet.getInt("idMesa"));
				itemPedido.setIdPedido(resultSet.getInt("idPedido"));
				itemPedido.setIdProduto(resultSet.getInt("idProduto"));
				itemPedido.setPrecoUnitario(resultSet.getDouble("precoUnitario"));
				itemPedido.setQuantidade(resultSet.getInt("quantidade"));
				itemPedido.setSituacao(resultSet.getString("situacao"));
				
				retorno[i] = itemPedido;
				
				i++;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return retorno;
	}*/
	
	public ItemPedido getItemPedidoByCodigo(int numero) {
		ItemPedido itemPedido = new ItemPedido();
		String queryString = "SELECT * FROM itempedido WHERE numero = " + numero;
		
		try {
			connection = getConnection();
			stmt = connection.createStatement();
			resultSet = stmt.executeQuery(queryString);
			
			if (resultSet.first()) {
				itemPedido.setId(resultSet.getInt("id"));
				itemPedido.setDataHoraEntrega(resultSet.getDate("dataHoraEntrega"));
				itemPedido.setQtComanda(resultSet.getInt("qtComanda"));
				itemPedido.setPrecoUnitario(resultSet.getDouble("precoUnitario"));
				itemPedido.setQuantidade(resultSet.getInt("quantidade"));
				itemPedido.setSituacao(resultSet.getString("situacao"));
				
				queryString = "SELECT * FROM mesa WHERE id = " + resultSet.getInt("idMesa");
				
				try {
					resultSet = stmt.executeQuery(queryString);
					
					if (resultSet.first()) {
						Mesa mesa = new Mesa();
						
						mesa.setId(resultSet.getInt("id"));
						mesa.setNumero(resultSet.getInt("numero"));
						mesa.setQuantidadeCadeiras(resultSet.getInt("quantidadedecadeiras"));
						mesa.setSituacao(resultSet.getString("situacao"));
						
						itemPedido.setMesa(mesa);
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
				
				queryString = "SELECT * FROM produto WHERE id = " + resultSet.getInt("idProduto");
				
				try {
					resultSet = stmt.executeQuery(queryString);
					
					if (resultSet.first()) {
						Produto produto = new Produto();
						
						produto.setId(resultSet.getInt("id"));
						produto.setDescricao(resultSet.getString("descricao"));
						produto.setCodigo(resultSet.getInt("codigo"));
						produto.setNome(resultSet.getString("nome"));
						produto.setPreco(resultSet.getDouble("preco"));
						produto.setTipo(resultSet.getString("tipo"));
						
						itemPedido.setProduto(produto);
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return itemPedido;
	}
	
	public boolean salvaRegistro(ItemPedido itemPedido) {
		boolean retorno = false;
		String queryString;
		
		if (itemPedido.getId() == 0) {
			queryString = "INSERT INTO " + this.tabela + " VALUES('" + itemPedido.getQuantidade() + "','" + itemPedido.getSituacao() + "','" + itemPedido.getPrecoUnitario() + "','" + itemPedido.getDataHoraEntrega() + "','" + itemPedido.getQtComanda() + "','" + itemPedido.getPedido().getId() + "','" + itemPedido.getGarcom().getId() + "','" + itemPedido.getMesa().getId() + "','" + itemPedido.getPedido().getId() + "')";
		} else {
			queryString = "UPDATE " + this.tabela + " SET QUANTIDADE = '" + itemPedido.getQuantidade() + "', SITUACAO = '" + itemPedido.getSituacao() + "', PRECOUNITARIO = '" + itemPedido.getPrecoUnitario() + "', DATAHORAENTREGA = '" + itemPedido.getDataHoraEntrega() + ", QTCOMANDA='" + itemPedido.getQtComanda() + "', IDPRODUTO = '" + itemPedido.getPedido() .getId()+ "', IDMESA = '" + itemPedido.getMesa().getId() + "' WHERE ID = " + itemPedido.getId();
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