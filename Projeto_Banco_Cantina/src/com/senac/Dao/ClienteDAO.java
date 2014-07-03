package com.senac.Dao;

import java.util.List;

import com.senac.models.Cliente;

public interface ClienteDAO {
	public Cliente insere(Cliente cliente);
	
	public void remover(Cliente cliente);
	
	public void atualizar(Cliente cliente);
	
	public List<Cliente>getTodosClientes();
	
	public Cliente getClientePorMatricula(int matricula);
	
	public double getSaldo(int matricula);
	
	public void insereRelatorio(Cliente cliente, int codProduto);
	
}
