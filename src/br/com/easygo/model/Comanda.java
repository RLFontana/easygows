package br.com.easygo.model;

import java.util.Date;

public class Comanda {
	private int id;
	private int numero;
	private Date dataHoraAbertura;
	private Date dataHoraFechamento;
	private Cliente cliente;
	
	public Comanda() {
		this(0, 0, null, null, null);
	}
	
	public Comanda(int id, int numero, Date dataHoraAbertura, Date dataHoraFechamento, Cliente cliente) {
		super();
		this.id = id;
		this.numero = numero;
		this.dataHoraAbertura = dataHoraAbertura;
		this.dataHoraFechamento = dataHoraFechamento;
		this.cliente = cliente;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public int getNumero() {
		return numero;
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
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
}