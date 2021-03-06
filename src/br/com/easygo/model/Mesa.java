package br.com.easygo.model;

public class Mesa {
	private int id;
	private int numero;
	private int quantidadeCadeiras;
	private String situacao;
	
	public Mesa() {
		this(0, 0, 0, "");
	}
	
	public Mesa(int id, int numero, int quantidadeCadeiras, String situacao) {
		super();
		this.id = id;
		this.numero = numero;
		this.quantidadeCadeiras = quantidadeCadeiras;
		this.situacao = situacao;
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
		this.id = numero;
	}

	public int getQuantidadeCadeiras() {
		return quantidadeCadeiras;
	}

	public void setQuantidadeCadeiras(int quantidadeCadeiras) {
		this.quantidadeCadeiras = quantidadeCadeiras;
	}

	public String getSituacao() {
		return situacao;
	}

	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}
}