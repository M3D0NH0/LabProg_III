package com.senac.conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoBanco {
	public final static String BANCO= "cantina";
	public final static String USER= "postgres";
	public final static String SENHA= "a123456z";
	public static Connection conexao;
	
	
	
	public static void iniciaConexao() throws ClassNotFoundException, SQLException{
		
		Class.forName("org.postgresql.Driver");
		String url = "jdbc:postgresql://localhost:5432/"+ BANCO;
		conexao = DriverManager.getConnection(url, USER, SENHA);
	}
	
	public boolean fechaConexao() throws SQLException{
		return conexao.isClosed();
	}
	
	
}
