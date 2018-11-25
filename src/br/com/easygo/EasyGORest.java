package br.com.easygo;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.core.Application;

import br.com.easygo.controller.ProdutoController;

public class EasyGORest extends Application{

	private Set<Object> singletons = new HashSet<Object>();
	private Set<Class<?>> empty = new HashSet<Class<?>>();
	static String path;

	public EasyGORest() {
		
		this.singletons.add(new EasyGO());
		this.singletons.add(new Authentication());
		this.singletons.add(new ProdutoController());
	}

	@Override
	public Set<Class<?>> getClasses() {
		return this.empty;
	}

	@Override
	public Set<Object> getSingletons() {
		return this.singletons;
	}
}
