package br.com.easygo.model;

import java.util.Date;

public class ItemPedido {
	private int id;
	private int quantidade;
	private String situacao;
	private double precoUnitario;
	private Date dataHoraEntrega;
	private int qtComanda;
	private Produto produto;
	private Garcom garcom;
	private Mesa mesa;
	private Pedido pedido;
	
	public ItemPedido() {
		this(0, 0, "", 0.0, null, 0, null, null, null, null);
	}
	
	public ItemPedido(int id, int quantidade, String situacao, double precoUnitario, Date dataHoraEntrega,
			int qtComanda, Produto produto, Garcom garcom, Mesa mesa, Pedido pedido) {
		super();
		this.id = id;
		this.quantidade = quantidade;
		this.situacao = situacao;
		this.precoUnitario = precoUnitario;
		this.dataHoraEntrega = dataHoraEntrega;
		this.qtComanda = qtComanda;
		this.produto = produto;
		this.garcom = garcom;
		this.mesa = mesa;
		this.pedido = pedido;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	public String getSituacao() {
		return situacao;
	}
	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}
	public double getPrecoUnitario() {
		return precoUnitario;
	}
	public void setPrecoUnitario(double precoUnitario) {
		this.precoUnitario = precoUnitario;
	}
	public Date getDataHoraEntrega() {
		return dataHoraEntrega;
	}
	public void setDataHoraEntrega(Date dataHoraEntrega) {
		this.dataHoraEntrega = dataHoraEntrega;
	}
	public void setQtComanda(int qtComanda) {
		this.qtComanda = qtComanda;
	}
	public int getQtComanda() {
		return qtComanda;
	}
	public Produto getProduto() {
		return produto;
	}
	public void setProduto(Produto produto) {
		this.produto = produto;
	}	
	public Garcom getGarcom() {
		return garcom;
	}
	public void setGarcom(Garcom garcom) {
		this.garcom = garcom;
	}
	public Mesa getMesa() {
		return mesa;
	}
	public void setMesa(Mesa mesa) {
		this.mesa = mesa;
	}
	public Pedido getPedido() {
		return pedido;
	}
	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}
}