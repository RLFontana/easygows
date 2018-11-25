package br.com.easygo.model;

public class AssocPedidoComanda {

	private int id;
	private int idPedido;
	private int idComanda;
	
	public AssocPedidoComanda() {
		this(0, 0, 0);
	}

	public AssocPedidoComanda(int id, int idPedido, int idComanda) {
		super();
		this.id = id;
		this.idPedido = idPedido;
		this.idComanda = idComanda;
	}
	
	public AssocPedidoComanda(int idPedido, int idComanda) {
		this(0, idPedido, idComanda);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdPedido() {
		return idPedido;
	}

	public void setIdPedido(int idPedido) {
		this.idPedido = idPedido;
	}

	public int getIdComanda() {
		return idComanda;
	}

	public void setIdComanda(int idComanda) {
		this.idComanda = idComanda;
	}
}