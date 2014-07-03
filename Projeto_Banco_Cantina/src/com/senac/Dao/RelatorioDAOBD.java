package com.senac.Dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.senac.conexao.PreparaConexao;
import com.senac.models.Relatorio;

public class RelatorioDAOBD extends PreparaConexao implements RelatorioDAO{

	@Override
	public List<Relatorio> getTodosRelatorios() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Relatorio> getRelatorioMes(Date data) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getRelatorioCliente(int matricula) {
		String saida="";
		try {
			conexaoPrepared("select codrelatorio,matricula,data from relatorio where matricula=?");
			comando.setInt(1, matricula);
			ResultSet resultado = comando.executeQuery();
			while (resultado.next()) {
				saida += "CodigoRelatorio : " + resultado.getInt("codrelatorio")+
						" Matricula : "+ resultado.getInt("matricula")+
						" Data da Compra : "+ resultado.getString("data")+
						"\n";
			} 
		}catch (ClassNotFoundException ex) {
			Logger.getLogger(ClienteDAOBD.class.getName()).log(Level.SEVERE, null, ex);
		}catch (SQLException ex) {
			Logger.getLogger(ClienteDAOBD.class.getName()).log(Level.SEVERE, null, ex);
		}
		return saida;
	}

	@Override
	public String getRelatorioFuncionario(int codFuncionario) {
		String saida="";
		try {
			conexaoPrepared("select codrelatorio,codfuncionario,data from relatorio where codfuncionario = ?");
			comando.setInt(1, codFuncionario);
			ResultSet resultado = comando.executeQuery();
			while (resultado.next()) {
				saida += "Codigo Relatorio : " + resultado.getInt("codrelatorio")+
						" Codigo Funcionario : "+ resultado.getInt("codfuncionario")+
						" Data da Compra : "+ resultado.getString("data")+
						"\n";
			} 
		}catch (ClassNotFoundException ex) {
			Logger.getLogger(ClienteDAOBD.class.getName()).log(Level.SEVERE, null, ex);
		}catch (SQLException ex) {
			Logger.getLogger(ClienteDAOBD.class.getName()).log(Level.SEVERE, null, ex);
		}
		return saida;
	}

	@Override
	public String getRelatorioData(Date data) {
		String saida="";
		try {
			conexaoPrepared("select codrelatorio,codfuncionario,data from relatorio where codfuncionario = ?");
			comando.setDate(1, (java.sql.Date)data);
			ResultSet resultado = comando.executeQuery();
			while (resultado.next()) {
				saida += "Codigo Relatorio : " + resultado.getInt("codrelatorio")+
						" Codigo Funcionario : "+ resultado.getInt("codfuncionario")+
						" Matricula : "+ resultado.getInt("matricula")+
						" Data da Compra : "+ resultado.getString("data")+
						"\n";
			} 
		}catch (ClassNotFoundException ex) {
			Logger.getLogger(ClienteDAOBD.class.getName()).log(Level.SEVERE, null, ex);
		}catch (SQLException ex) {
			Logger.getLogger(ClienteDAOBD.class.getName()).log(Level.SEVERE, null, ex);
		}
		return saida;
	}

	public Relatorio insere(Relatorio relatorio){
		try {
			conexaoPrepared("INSERT INTO relatorio(matricula,codfuncionario,codproduto,data) VALUES (?,?,?,?)");		
			comando.setInt(1, relatorio.getMatricula());
			comando.setInt(2, relatorio.getCodFuncionario());
			comando.setInt(3, relatorio.getCodProduto());
			comando.setDate(4, (java.sql.Date) relatorio.getData());
			comando.executeUpdate();
			return relatorio;
		} catch (ClassNotFoundException ex) {
			Logger.getLogger(ClienteDAOBD.class.getName()).log(Level.SEVERE, null, ex);
		}catch (SQLException ex) {
			Logger.getLogger(ClienteDAOBD.class.getName()).log(Level.SEVERE, null, ex);
		}
		return null;
		
	}



}
