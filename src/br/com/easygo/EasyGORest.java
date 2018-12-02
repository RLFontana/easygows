package br.com.easygo;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.core.Application;

import br.com.easygo.controller.ProdutoController;
import br.com.easygo.controller.ClienteController;
import br.com.easygo.controller.ComandaController;
import br.com.easygo.controller.GarcomController;
import br.com.easygo.controller.ItemPedidoController;
import br.com.easygo.controller.MesaController;
import br.com.easygo.controller.PedidoController;

public class EasyGORest extends Application{

	private Set<Object> singletons = new HashSet<Object>();
	private Set<Class<?>> empty = new HashSet<Class<?>>();
	static String path;

	public EasyGORest() {
		
		this.singletons.add(new EasyGO());
		this.singletons.add(new Authentication());
		this.singletons.add(new ProdutoController());
		this.singletons.add(new ClienteController());
		this.singletons.add(new ComandaController());
		this.singletons.add(new GarcomController());
		this.singletons.add(new ItemPedidoController());
		this.singletons.add(new MesaController());
		this.singletons.add(new PedidoController());
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