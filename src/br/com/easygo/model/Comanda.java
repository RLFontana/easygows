package br.com.easygo.model;

import java.util.Date;

public class Comanda {
	private int id;
	private int numero;
	private Date dataHoraAbertura;
	private Date dataHoraFechamento;
	private int idCliente;
	private int idMesa;
	
	public Comanda() {
		this(0, 0, null, null, 0, 0);
	}
	
	public Comanda(int id, int numero, Date dataHoraAbertura, Date dataHoraFechamento, int idCliente, int idMesa) {
		super();
		this.id = id;
		this.numero = numero;
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