package com.senac.conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoBanco {
	public final static String BANCO= "cantina";
	public final static String USER= "postgres";
	public final static String SENHA= "a123456z";
	
	
	
	public static Connection getConexaoPostgres() throws ClassNotFoundException, SQLException{
		Class.forName("org.postgresql.Driver");
		String url = "jdbc:postgresql://localhost:5432/"+ BANCO;
		
		Connection conexao = DriverManager.getConnection(url, USER, SENHA);
		
		return(conexao);
	}
	
	public static Connection getConexaoMySQL() throws ClassNotFoundException, SQLException{
		Class.forName("org.mysql.jdbc.Driver");
		String url = "jdbc:mysql://localhost:3306/"+ BANCO;
		
		Connection conexao = DriverManager.getConnection(url, USER, SENHA);
		
		return(conexao);
	}
	
}
