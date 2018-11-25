package br.com.easygo.model;

public class AssocPedidoComanda {

	private int id;
	private int numeroPedido;
	private int numeroComanda;
	
	public AssocPedidoComanda() {
		this(0, 0, 0);
	}

	public AssocPedidoComanda(int id, int numeroPedido, int numeroComanda) {
		super();
		this.id = id;
		this.numeroPedido = numeroPedido;
		this.numeroComanda = numeroComanda;
	}
	
	public AssocPedidoComanda(int numeroPedido, int numeroComanda) {
		this(0, numeroPedido, numeroComanda);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getNumeroPedido() {
		return numeroPedido;
	}

	public void setNumeroPedido(int numeroPedido) {
		this.numeroPedido = numeroPedido;
	}

	public int getNumeroComanda() {
		return numeroComanda;
	}

	public void setNumeroComanda(int numeroComanda) {
		this.numeroComanda = numeroComanda;
	}
}