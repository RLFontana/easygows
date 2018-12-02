package br.com.easygo.model;

import java.util.Date;

public class ItemPedido {
	private int id;
	private int quantidade;
	private String situacao;
	private double precoUnitario;
	private Date dataHoraEntrega;
	private int qtComanda;
	private int idProduto;
	private int idGarcom;
	private int idMesa;
	private int idPedido;
	
	public ItemPedido() {
		this(0, 0, "", 0.0, null, 0, 0, 0, 0, 0);
	}
	
	public ItemPedido(int id, int quantidade, String situacao, double precoUnitario, Date dataHoraEntrega,
			int qtComanda, int idProduto, int idGarcom, int idMesa, int idPedido) {
		super();
		this.id = id;
		this.quantidade = quantidade;
		this.situacao = situacao;
		this.precoUnitario = precoUnitario;
		this.dataHoraEntrega = dataHoraEntrega;
		this.qtComanda = qtComanda;
		this.idProduto = idProduto;
		this.idGarcom = idGarcom;
		this.idMesa = idMesa;
		this.idPedido = idPedido;
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
	public int getIdProduto() {
		return idProduto;
	}
	public void setQtComanda(int qtComanda) {
		this.qtComanda = qtComanda;
	}
	public int getQtComanda() {
		return qtComanda;
	}
	public void setIdProduto(int idProduto) {
		this.idProduto = idProduto;
	}
	public int getIdGarcom() {
		return idGarcom;
	}
	public void setIdGarcom(int idGarcom) {
		this.idGarcom = idGarcom;
	}
	public int getIdMesa() {
		return idMesa;
	}
	public void setIdMesa(int idMesa) {
		this.idMesa = idMesa;
	}
	public int getIdPedido() {
		return idPedido;
	}
	public void setIdPedido(int idPedido) {
		this.idPedido = idPedido;
	}
	
	
}