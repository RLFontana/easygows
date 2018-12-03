package br.com.easygo.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import br.com.easygo.model.AssocItemPedidoComanda;
import br.com.easygo.model.Comanda;
import br.com.easygo.model.Cliente;
import br.com.easygo.model.Pedido;
import br.com.easygo.model.ItemPedido;
import br.com.easygo.model.Mesa;
import br.com.easygo.model.Produto;
import br.com.easygo.model.Garcom;

public class AssocItemPedidoComandaDao {
	private Connection connection = null;
	private Statement stmt = null;
	private ResultSet resultSet = null;
	private String tabela = "";
	
	public AssocItemPedidoComandaDao(){
		this.tabela = "assocpedidocomanda";
	}
	
	private Connection getConnection() throws SQLException{
		Connection conn;
		conn = ConnectionFactory.getInstance().getConnection();
		return conn;
	}
	
	/*public AssocItemPedidoComanda[] getListaAssocItemPedidoComanda() {
		AssocItemPedidoComanda assocItemPedidoComanda = null;
		AssocItemPedidoComanda[] retorno = null;
		String queryString = "SELECT * FROM associtempedidocomanda";
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
			
			retorno = new AssocItemPedidoComanda[rowCount];
			
			while(resultSet.next()) {
				assocItemPedidoComanda = new AssocItemPedidoComanda();
				
				assocItemPedidoComanda.setId(resultSet.getInt("id"));
				assocItemPedidoComanda.setIdComanda(resultSet.getInt("idcomanda"));
				assocItemPedidoComanda.setIdItemPedido(resultSet.getInt("iditempedido"));
				
				retorno[i] = assocItemPedidoComanda;
				
				i++;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return retorno;
	}*/
	
	public AssocItemPedidoComanda getAssocItemPedidoComandaByIdItemPedido(int idItemPedido) {
		AssocItemPedidoComanda assocItemPedidoComanda = new AssocItemPedidoComanda();
		String queryString = "SELECT * FROM associtempedidocomanda WHERE iditempedido = " + idItemPedido;
		
		try {
			connection = getConnection();
			stmt = connection.createStatement();
			resultSet = stmt.executeQuery(queryString);
			
			if (resultSet.first()) {
				assocItemPedidoComanda.setId(resultSet.getInt("id"));
				
				ItemPedido itemPedido = new ItemPedido();
				
				itemPedido.setId(resultSet.getInt("id"));
				itemPedido.setDataHoraEntrega(resultSet.getDate("dataHoraEntrega"));
				itemPedido.setPrecoUnitario(resultSet.getDouble("precoUnitario"));
				itemPedido.setQtComanda(resultSet.getInt("qtComanda"));
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
				
				queryString = "SELECT * FROM garcom WHERE id = " + resultSet.getInt("idGarcom");
				
				try {
					resultSet = stmt.executeQuery(queryString);
					
					if (resultSet.first()) {
						Garcom garcom = new Garcom();
						
						garcom.setId(resultSet.getInt("id"));
						garcom.setMatricula(resultSet.getString("matricula"));
						garcom.setNome(resultSet.getString("nome"));
						
						itemPedido.setGarcom(garcom);
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
				
				queryString = "SELECT * FROM pedido WHERE id = " + resultSet.getInt("idPedido");
				
				try {
					resultSet = stmt.executeQuery(queryString);
					
					if (resultSet.first()) {
						Pedido pedido = new Pedido();
						
						pedido.setId(resultSet.getInt("id"));
						pedido.setDataHoraConfirmacao(resultSet.getDate("dataHoraConfirmacao"));
						pedido.setDataHoraInclusao(resultSet.getDate("dataHoraInclusao"));
						pedido.setNumero(resultSet.getInt("numero"));
						
						itemPedido.setPedido(pedido);
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
				
				assocItemPedidoComanda.setItemPedido(itemPedido);
				
				queryString = "SELECT * FROM comanda WHERE id = " + resultSet.getInt("idComanda");
				
				try {
					resultSet = stmt.executeQuery(queryString);
					
					if (resultSet.first()) {
						Comanda comanda = new Comanda();
						
						comanda.setId(resultSet.getInt("id"));
						comanda.setDataHoraAbertura(resultSet.getDate("dataHoraAbertura"));
						comanda.setDataHoraFechamento(resultSet.getDate("dataHoraFechamento"));
						comanda.setNumero(resultSet.getInt("numero"));
						
						queryString = "SELECT * FROM cliente WHERE id = " + resultSet.getInt("idCliente");
						
						try {
							resultSet = stmt.executeQuery(queryString);
							
							if (resultSet.first()) {
								Cliente cliente = new Cliente();
								
								cliente.setId(resultSet.getInt("id"));
								cliente.setDataNascimento(resultSet.getDate("dataNascimento"));
								cliente.setFoto(resultSet.getString("foto"));
								cliente.setNome(resultSet.getString("nome"));
								cliente.setTelefone(resultSet.getString("telefone"));
								
								comanda.setCliente(cliente);
								
								assocItemPedidoComanda.setComanda(comanda);
							}
						} catch (SQLException e) {
							e.printStackTrace();
						}
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return assocItemPedidoComanda;
	}
	
	public boolean salvaRegistro(AssocItemPedidoComanda assocItemPedidoComanda) {
		boolean retorno = false;
		String queryString;
		
		if (assocItemPedidoComanda.getId() == 0) {
			queryString = "INSERT INTO " + this.tabela + " VALUES('" + assocItemPedidoComanda.getItemPedido().getId() + "','" + assocItemPedidoComanda.getComanda().getId() + "')";
		} else {
			queryString = "UPDATE " + this.tabela + " SET IDPEDIDO = '" + assocItemPedidoComanda.getItemPedido().getId() + "', IDCOMANDA = '" + assocItemPedidoComanda.getComanda().getId() + "' WHERE ID = " + assocItemPedidoComanda.getId();
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