package com.senac.models;

public class Cliente {
	String matricula;
	String nome;
	String email;
	String usuario;
	String senha;
	int codPermissao;
	
	
	
	public String getMatricula() {
		return matricula;
	}
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
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
