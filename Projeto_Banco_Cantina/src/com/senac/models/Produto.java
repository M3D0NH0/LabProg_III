package com.senac.models;

public class Produto {
	
	int codProduto;
	String nome;
	String tipo;
	double preco;
	
	public Produto(int codProduto,String nome, String tipo, double preco){
		this.codProduto = codProduto;
		this.nome = nome;
		this.tipo = tipo;
		this.preco = preco;
	}
	
	public Produto(String nome, String tipo, double preco){
		this.nome = nome;
		this.tipo = tipo;
		this.preco = preco;
	}
	
	public int getCodProduto() {
		return codProduto;
	}
	public void setCodProduto(int codProduto) {
		this.codProduto = codProduto;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public double getPreco() {
		return preco;
	}
	public void setPreco(double preco) {
		this.preco = preco;
	}
	
	
}
