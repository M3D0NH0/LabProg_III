package com.senac.models;

import java.io.Serializable;

public class Cliente implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int matricula;
	private String nome;
	private String email;
	private String usuario;
	private String senha;
	private int codPermissao;
	private double saldo;
	
	public double getSaldo() {
		return saldo;
	}
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	public Cliente(int matricula, String nome, String email, String usuario, String senha, int codPermissao, double saldo){
		this.nome = nome;
		this.matricula = matricula;
		this.email = email;
		this.usuario = usuario;
		this.senha = senha;
		this.codPermissao = codPermissao;
		this.saldo = saldo;
		
	}
	public Cliente(int matricula, String nome, String email, double saldo){
		this.matricula = matricula;
		this.nome = nome;
		this.email = email;
		this.saldo = saldo;
	}
	public Cliente(String email, String senha, int codPermissao){
		this.email = email;
		this.senha = senha;
		this.codPermissao = codPermissao;
	}
	public Cliente(){
		this.nome = "";
		this.matricula = 0;
		this.email = "";
		this.usuario = "";
		this.senha = "";
		this.codPermissao = 0;
	}
	
	public int getMatricula() {
		return matricula;
	}
	public void setMatricula(int matricula) {
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
	
	@Override
	public String toString(){
		return "Cliente{"+ " matricula="+ matricula+", nome="+nome+", email="+email+", saldo = "+ saldo+"}";
	}
	
}
