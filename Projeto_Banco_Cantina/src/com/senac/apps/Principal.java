package com.senac.apps;

import java.sql.SQLException;

import com.senac.Dao.TelaLogin;
import com.senac.conexao.ConexaoBanco;

public class Principal extends ConexaoBanco{
	static TelaLogin login;
	static ConexaoBanco conexao;
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		login = new TelaLogin();
		
		conexao.iniciaConexao();
		
		login.iniciaTelaLogin();
	}
}
