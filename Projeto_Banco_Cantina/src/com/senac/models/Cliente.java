package com.senac.models;

import java.io.Serializable;

public class Cliente implements Serializable {
	private int codCliente;
	private String matricula;
	private String nome;
	private String email;
	private String usuario;
	private String senha;
	private int codPermissao;
	
	public Cliente(int codCliente,String matricula, String nome, String email, String usuario, String senha, int codPermissao){
		this.codCliente = codCliente;
		this.nome = nome;
		this.matricula = matricula;
		this.email = email;
		this.usuario = usuario;
		this.senha = senha;
		this.codPermissao = codPermissao;
		
	}
	public Cliente(String matricula, String nome, String email){
		this.matricula = matricula;
		this.nome = nome;
		this.email = email;
	}
	public Cliente(String email, String senha, int codPermissao){
		this.email = email;
		this.senha = senha;
		this.codPermissao = codPermissao;
	}
	public Cliente(){
		this.nome = "";
		this.matricula = "";
		this.email = "";
		this.usuario = "";
		this.senha = "";
		this.codPermissao = 0;
	}
	
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
	public int getCodCliente() {
		return codCliente;
	}
	public void setCodCliente(int codCliente) {
		this.codCliente = codCliente;
	}
	
	@Override
	public String toString(){
		return "Cliente{"+ "codcliente="+codCliente+", matricula="+ matricula+", nome="+nome+", email="+email+"}";
	}
	
}
