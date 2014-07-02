package com.senac.Dao;

import java.util.List;

import com.senac.models.Produto;

public interface ProdutoDAO {
	
	public Produto insere(Produto produto);

	public void remover(Produto produto);

	public void atualizar(Produto produto);

	public List<Produto>getTodosProdutos();

	public Produto getProdutoPorId(int id);
	
	public String getProdutosString();
	
}
