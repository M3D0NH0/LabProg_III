package com.senac.models;

import java.util.Date;

public class Relatorio {
	int codRelatorio, matricula, codFuncionario, codProduto;
	Date data;	
	
	public Relatorio(int codRelatorio, int codProduto, int codFuncionario, int matricula, Date data){
		this.codFuncionario = codFuncionario;
		this.codProduto = codProduto;
		this.codRelatorio = codRelatorio;
		this.data = data;
	}
	
	public Relatorio(int codRelatorio, int matricula, Date data){
		this.codRelatorio = codRelatorio;
		this.matricula = matricula;
		this.data = data;
	}
	
	public Relatorio(int codRelatorio, Date data, int codFuncionario){
		this.codRelatorio = codRelatorio;
		this.data = data;
		this.codFuncionario = codFuncionario;
	}
	
	public Relatorio(int codRelatorio, int matricula, int codFuncionario, Date data){
		this.codRelatorio = codRelatorio;
		this.matricula = matricula;
		this.codFuncionario = codFuncionario;
		this.data = data;
	}
	
	public Relatorio(){
		
	}
	
	public int getCodRelatorio() {
		return codRelatorio;
	}
	public void setCodRelatorio(int codRelatorio) {
		this.codRelatorio = codRelatorio;
	}
	public int getMatricula() {
		return matricula;
	}
	public void setMatricula(int matricula) {
		this.matricula = matricula;
	}
	public int getCodFuncionario() {
		return codFuncionario;
	}
	public void setCodFuncionario(int codFuncionario) {
		this.codFuncionario = codFuncionario;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	
	
	
	
}
