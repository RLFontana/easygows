package br.com.easygo.model;

public class Mesa {
	private int id;
	private int quantidadeCadeiras;
	private String situacao;
	
	public Mesa(int id, int quantidadeCadeiras, String situacao) {
		super();
		this.id = id;
		this.quantidadeCadeiras = quantidadeCadeiras;
		this.situacao = situacao;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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