package br.com.easygo.model;

import java.util.Date;

public class Comanda {
	private int id;
	private Date dataHoraAbertura;
	private Date dataHoraFechamento;
	private int idCliente;
	private int idMesa;
	
	public Comanda(int id, Date dataHoraAbertura, Date dataHoraFechamento, int idCliente, int idMesa) {
		super();
		this.id = id;
		this.dataHoraAbertura = dataHoraAbertura;
		this.dataHoraFechamento = dataHoraFechamento;
		this.idCliente = idCliente;
		this.idMesa = idMesa;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getDataHoraAbertura() {
		return dataHoraAbertura;
	}
	public void setDataHoraAbertura(Date dataHoraAbertura) {
		this.dataHoraAbertura = dataHoraAbertura;
	}
	public Date getDataHoraFechamento() {
		return dataHoraFechamento;
	}
	public void setDataHoraFechamento(Date dataHoraFechamento) {
		this.dataHoraFechamento = dataHoraFechamento;
	}
	public int getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}
	public int getIdMesa() {
		return idMesa;
	}
	public void setIdMesa(int idMesa) {
		this.idMesa = idMesa;
	}
}