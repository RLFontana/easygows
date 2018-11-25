package br.com.easygo.model;

public class Solicitacao {

	private int id;
	private int numeroComanda;
	private int idGarcom;
	private bool atendido;
	
	public Solicitacao() {
		this(0, 0, 0, false);
	}

	public Solicitacao(int id, int numeroComanda, idGarcom, atendido) {
		super();
		this.id = id;
		this.numeroComanda = numeroComanda;
		this.idGarcom = idGarcom;
		this.atendido = atendido;
	}
	
	public Solicitacao(int numeroComanda, int idGarcom, bool atendido) {
		this(0, numeroComanda, idGarcom, atendido);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getNumeroComanda() {
		return numeroComanda;
	}

	public void setNumeroComanda(int numeroComanda) {
		this.numeroComanda = numeroComanda;
	}
	
	public int getIdGarcom() {
		return idGarcom;
	}

	public void setIdGarcom(int idGarcom) {
		this.idGarcom = idGarcom;
	}
	
	public int getAtendido() {
		return atendido;
	}

	public void setAtendido(bool atendido) {
		this.atendido = atendido;
	}
}