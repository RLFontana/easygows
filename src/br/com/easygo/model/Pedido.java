package br.com.easygo.model;

import java.util.Date;

public class Pedido {
	private int id;
	private int numero;
	private Date dataHoraInclusao;
	private Date dataHoraConfirmacao;
	private int idGarcom;
	private int idSolicitacao;
	
	public Pedido() {
		this(0, 0, null, null, 0, 0);
	}
	
	public Pedido(int id, int numero, Date dataHoraInclusao, Date dataHoraConfirmacao, int idGarcom, int idSolicitacao) {
		super();
		this.id = id;
		this.numero = numero;
		this.dataHoraInclusao = dataHoraInclusao;
		this.dataHoraConfirmacao = dataHoraConfirmacao;
		this.idGarcom = idGarcom;
		this.idSolicitacao = idSolicitacao;
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
	public int getIdGarcom() {
		return idGarcom;
	}
	public void setIdGarcom(int idGarcom) {
		this.idGarcom = idGarcom;
	}
	public int getIdSolicitacao() {
		return idSolicitacao;
	}
	public void setIdSolicitacao(int idSolicitacao) {
		this.idSolicitacao = idSolicitacao;
	}
}