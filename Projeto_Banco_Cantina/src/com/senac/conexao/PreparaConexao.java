package com.senac.conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class PreparaConexao {
	private Connection conexao = null;
	protected PreparedStatement comando = null;
		
	public void conexaoPrepared(String sql) throws ClassNotFoundException, SQLException{
		conexao = ConexaoBanco.getConexaoPostgres();
		comando = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
		
	}
	
	public void fecharPrepared() throws SQLException{
		comando.close();
		conexao.close();
	}
	
	
}
