package br.com.easygo.model;

public class AssocItemPedidoComanda {

	private int id;
	private int idItemPedido;
	private int idComanda;
	
	public AssocItemPedidoComanda() {
		this(0, 0, 0);
	}

	public AssocItemPedidoComanda(int id, int idItemPedido, int idComanda) {
		super();
		this.id = id;
		this.idItemPedido = idItemPedido;
		this.idComanda = idComanda;
	}
	
	public AssocItemPedidoComanda(int idItemPedido, int idComanda) {
		this(0, idItemPedido, idComanda);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdItemPedido() {
		return idItemPedido;
	}

	public void setIdItemPedido(int idItemPedido) {
		this.idItemPedido = idItemPedido;
	}

	public int getIdComanda() {
		return idComanda;
	}

	public void setIdComanda(int idComanda) {
		this.idComanda = idComanda;
	}
}