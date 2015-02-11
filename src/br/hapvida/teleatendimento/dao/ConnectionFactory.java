package br.hapvida.teleatendimento.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



public class ConnectionFactory {
	public Connection getConnection(String usuario, String pass){
		try{
			DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
			return DriverManager.getConnection(
					"jdbc:oracle:thin:@10.1.17.26:1521:hospital",usuario,pass);
		}catch (SQLException e){
			throw new RuntimeException(e.getMessage());
		}
	}
}
