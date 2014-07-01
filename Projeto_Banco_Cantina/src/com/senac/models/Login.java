package com.senac.models;

import java.io.Serializable;

public class Login implements Serializable{
	
	private String usuario, senha;
	private int codCliente, codFuncionario, permissao, codLogin;
	
	

	public Login(int codLogin ,String usuario, String senha, int permissao, int codCliente, int codFuncionario){
		this.codLogin = codLogin;
		this.usuario = usuario;
		this.senha = senha;
		this.permissao = permissao;
		this.codCliente = codCliente;
		this.codFuncionario = codFuncionario;
	}
	
	
	
	public Login(){
		
	}
	
	public int getCodLogin() {
		return codLogin;
	}

	public void setCodLogin(int codLogin) {
		this.codLogin = codLogin;
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
	public int getCodCliente() {
		return codCliente;
	}
	public void setCodCliente(int codCliente) {
		this.codCliente = codCliente;
	}
	public int getCodFuncionario() {
		return codFuncionario;
	}
	public void setCodFuncionario(int codFuncionario) {
		this.codFuncionario = codFuncionario;
	}
	public int getPermissao() {
		return permissao;
	}
	public void setPermissao(int permissao) {
		this.permissao = permissao;
	}	
}
