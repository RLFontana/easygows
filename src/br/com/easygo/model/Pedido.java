package br.com.easygo.model;

import java.util.Date;
import java.util.List;

public class Pedido {
	private int id;
	private int numero;
	private Date dataHoraInclusao;
	private Date dataHoraConfirmacao;
	private Garcom garcom;
	private List<ItemPedido> listaItemPedido; 
	
	public Pedido() {
		this(0, 0, null, null, null, null);
	}
	
	public Pedido(int id, int numero, Date dataHoraInclusao, Date dataHoraConfirmacao, Garcom garcom, List<ItemPedido> listaItemPedido) {
		super();
		this.id = id;
		this.numero = numero;
		this.dataHoraInclusao = dataHoraInclusao;
		this.dataHoraConfirmacao = dataHoraConfirmacao;
		this.setGarcom(garcom);
		this.setListaItemPedido(listaItemPedido);
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public Date getDataHoraInclusao() {
		return dataHoraInclusao;
	}
	public void setDataHoraInclusao(Date dataHoraInclusao) {
		this.dataHoraInclusao = dataHoraInclusao;
	}
	public Date getDataHoraConfirmacao() {
		return dataHoraConfirmacao;
	}
	public void setDataHoraConfirmacao(Date dataHoraConfirmacao) {
		this.dataHoraConfirmacao = dataHoraConfirmacao;
	}
	public Garcom getGarcom() {
		return garcom;
	}
	public void setGarcom(Garcom garcom) {
		this.garcom = garcom;
	}
	public List<ItemPedido> getListaItemPedido() {
		return listaItemPedido;
	}
	public void setListaItemPedido(List<ItemPedido> listaItemPedido) {
		this.listaItemPedido = listaItemPedido;
	}
}