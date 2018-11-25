package br.com.easygo.model;

import java.util.Date;

public class Pedido {
	private int numero;
	private Date dataHoraInclusao;
	private Date dataHoraConfirmacao;
	private int idGarcom;
	private int numeroComanda;
	public Pedido(int numero, Date dataHoraInclusao, Date dataHoraConfirmacao, int idGarcom, int numeroComanda) {
		super();
		this.numero = numero;
		this.dataHoraInclusao = dataHoraInclusao;
		this.dataHoraConfirmacao = dataHoraConfirmacao;
		this.idGarcom = idGarcom;
		this.numeroComanda = numeroComanda;
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
	public int getIdGarcom() {
		return idGarcom;
	}
	public void setIdGarcom(int idGarcom) {
		this.idGarcom = idGarcom;
	}
	public int getNumeroComanda() {
		return numeroComanda;
	}
	public void setNumeroComanda(int numeroComanda) {
		this.numeroComanda = numeroComanda;
	}
	
	
}
