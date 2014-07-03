package com.senac.Dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.senac.conexao.PreparaConexao;
import com.senac.models.Cliente;
import com.senac.models.Produto;
import com.senac.models.Relatorio;

public class RelatorioDAOBD extends PreparaConexao implements RelatorioDAO{

	@Override
	public List<Relatorio> getTodosRelatorios() {
		List<Relatorio> listaRelatorios = new ArrayList<>();
		try {
			conexaoPrepared("select * from relatorio");
			ResultSet resultado = comando.executeQuery();
			while (resultado.next()) {
				Relatorio relatorio = new Relatorio(
						resultado.getInt("codrelatorio"),
						resultado.getInt("codproduto"),
						resultado.getInt("codfuncionario"),
						resultado.getInt("matricula"),
						resultado.getDate("data")
						);
				listaRelatorios.add(relatorio);
			} 
		}catch (ClassNotFoundException ex) {
			Logger.getLogger(ClienteDAOBD.class.getName()).log(Level.SEVERE, null, ex);
		}catch (SQLException ex) {
			Logger.getLogger(ClienteDAOBD.class.getName()).log(Level.SEVERE, null, ex);
		}
		return (listaRelatorios);
	}

	@Override
	public List<Relatorio> getRelatorioCliente(int matricula) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Relatorio> getRelatorioFuncionario(int codFuncionario) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Relatorio> getRelatorioMes(Date data) {
		// TODO Auto-generated method stub
		return null;
	}

	

	
	
}
