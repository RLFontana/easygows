package br.com.easygo.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	private String driverClassName = "com.mysql.cj.jdbc.Driver";
	private static ConnectionFactory connectionFactory = null;

	private String connectionUrl = "jdbc:mysql://localhost:3306/easygo";
	
	private ConnectionFactory(){
		try{
			Class.forName(driverClassName);
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}catch(NullPointerException np){
			np.printStackTrace();
		}
	}

	public Connection getConnection() throws SQLException {
		Connection conn = null;
		conn = DriverManager.getConnection(connectionUrl, "root", "root");
		return conn;
	}

	public static ConnectionFactory getInstance(){
		if(connectionFactory == null){
			connectionFactory = new ConnectionFactory();
		}
		return connectionFactory;
	}
}
