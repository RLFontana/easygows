package br.com.easygo.model;

public class Mesa {
	private int numero;
	private int quantidadeCadeiras;
	private String situacao;
	
	public Mesa(int numero, int quantidadeCadeiras, String situacao) {
		super();
		this.numero = numero;
		this.quantidadeCadeiras = quantidadeCadeiras;
		this.situacao = situacao;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
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
