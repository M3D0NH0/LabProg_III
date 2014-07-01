package com.senac.models;

public class Funcionario {
	String nome;
	String telefone;
	String usuario;
	String senha;
	int codPermissao;
	int codFuncionario;
	
	public Funcionario(int codFuncionario, String nome, String telefone, String usuario, String senha, int codPermissao){
		this.codFuncionario = codFuncionario;
		this.nome = nome;
		this.telefone = telefone;
		this.usuario = usuario;
		this.senha = senha;
		this.codPermissao = codPermissao;
	}
	
	public Funcionario(int codFuncionario, String nome, String telefone){
		this.codFuncionario = codFuncionario;
		this.nome = nome;
		this.telefone = telefone;
	}
	
	public int getCodFuncionario() {
		return codFuncionario;
	}
	public void setCodFuncionario(int codFuncionario) {
		this.codFuncionario = codFuncionario;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public int getCodPermissao() {
		return codPermissao;
	}
	public void setCodPermissao(int codPermissao) {
		this.codPermissao = codPermissao;
	}
	
}
