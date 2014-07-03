package com.senac.Dao;

import java.util.Date;
import java.util.List;

import com.senac.models.Relatorio;


public interface RelatorioDAO {
	
	public List<Relatorio>getTodosRelatorios();
	
	//public List<Relatorio>getRelatorioCliente(int matricula);

	//public List<Relatorio>getRelatorioFuncionario(int codFuncionario);
	
	public List<Relatorio>getRelatorioMes(Date data);
	
	public String getRelatorioCliente(int matricula);
	
	public String getRelatorioFuncionario(int codFuncionario);
	
	public String getRelatorioData(Date data);
	
	public Relatorio insere(Relatorio relatorio);
	
}
