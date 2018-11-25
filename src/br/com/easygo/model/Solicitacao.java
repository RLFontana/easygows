package br.com.easygo.model;

public class Solicitacao {

	private int id;
	private int idComanda;
	private int idGarcom;
	private bool atendido;
	
	public Solicitacao() {
		this(0, 0, 0, false);
	}

	public Solicitacao(int id, int idComanda, idGarcom, atendido) {
		super();
		this.id = id;
		this.idComanda = idComanda;
		this.idGarcom = idGarcom;
		this.atendido = atendido;
	}
	
	public Solicitacao(int idComanda, int idGarcom, bool atendido) {
		this(0, idComanda, idGarcom, atendido);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdComanda() {
		return idComanda;
	}

	public void setIdComanda(int idComanda) {
		this.idComanda = idComanda;
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