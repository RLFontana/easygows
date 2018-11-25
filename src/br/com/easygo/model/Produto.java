package br.com.easygo.model;

public class Produto {

	private int codigo;
	private String nome;
	private String tipo;
	private String descricao;
	private double preco;
	
	public Produto() {
		this(0, "", "", "", 0.0);
	}

	public Produto(int codigo, String nome, String tipo, String descricao, double preco) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.tipo = tipo;
		this.descricao = descricao;
		this.preco = preco;
	}
	
	public Produto(String nome, String tipo, String descricao, double preco) {
		this(0, nome, tipo, descricao, preco);
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}
}
