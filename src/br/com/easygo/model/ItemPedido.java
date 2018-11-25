package br.com.easygo.model;

import java.util.Date;

public class ItemPedido {
	private int id;
	private int quantidade;
	private String situacao;
	private double precounitario;
	private Date dataHoraEntrega;
	private int codigoproduto;
	private int idGarcom;
	private int numeromesa;
	private int numeroPedido;
	public ItemPedido(int id, int quantidade, String situacao, double precounitario, Date dataHoraEntrega,
			int codigoproduto, int idGarcom, int numeromesa, int numeroPedido) {
		super();
		this.id = id;
		this.quantidade = quantidade;
		this.situacao = situacao;
		this.precounitario = precounitario;
		this.dataHoraEntrega = dataHoraEntrega;
		this.codigoproduto = codigoproduto;
		this.idGarcom = idGarcom;
		this.numeromesa = numeromesa;
		this.numeroPedido = numeroPedido;
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
	public double getPrecounitario() {
		return precounitario;
	}
	public void setPrecounitario(double precounitario) {
		this.precounitario = precounitario;
	}
	public Date getDataHoraEntrega() {
		return dataHoraEntrega;
	}
	public void setDataHoraEntrega(Date dataHoraEntrega) {
		this.dataHoraEntrega = dataHoraEntrega;
	}
	public int getCodigoproduto() {
		return codigoproduto;
	}
	public void setCodigoproduto(int codigoproduto) {
		this.codigoproduto = codigoproduto;
	}
	public int getIdGarcom() {
		return idGarcom;
	}
	public void setIdGarcom(int idGarcom) {
		this.idGarcom = idGarcom;
	}
	public int getNumeromesa() {
		return numeromesa;
	}
	public void setNumeromesa(int numeromesa) {
		this.numeromesa = numeromesa;
	}
	public int getNumeroPedido() {
		return numeroPedido;
	}
	public void setNumeroPedido(int numeroPedido) {
		this.numeroPedido = numeroPedido;
	}
	
	
}