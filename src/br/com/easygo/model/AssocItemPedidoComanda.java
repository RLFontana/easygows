package br.com.easygo.model;

public class AssocItemPedidoComanda {

	private int id;
	private ItemPedido itemPedido;
	private Comanda comanda;
	
	public AssocItemPedidoComanda() {
		this(0, null, null);
	}

	public AssocItemPedidoComanda(int id, ItemPedido itemPedido, Comanda comanda) {
		super();
		this.id = id;
		this.itemPedido = itemPedido;
		this.comanda = comanda;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public ItemPedido getItemPedido() {
		return itemPedido;
	}

	public void setItemPedido(ItemPedido itemPedido) {
		this.itemPedido = itemPedido;
	}

	public Comanda getComanda() {
		return comanda;
	}

	public void setComanda(Comanda comanda) {
		this.comanda = comanda;
	}
}