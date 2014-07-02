package com.senac.conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PreparaConexao extends ConexaoBanco {
	private Connection conexao = null;
	protected PreparedStatement comando = null;
		
	public void conexaoPrepared(String sql) throws ClassNotFoundException, SQLException{
		conexao = ConexaoBanco.getConexaoPostgres();
		comando = conexao.prepareStatement(sql);
		
	}
	
	public void fecharPrepared() {
		try {
			comando.close();
			conexao.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
}
