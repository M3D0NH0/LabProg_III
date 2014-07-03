package com.senac.Dao;

import java.util.List;

import com.senac.models.Cliente;
import com.senac.models.Funcionario;
import com.senac.models.Produto;
import com.senac.models.Relatorio;


public interface FuncionarioDAO {

	public Funcionario insere(Funcionario funcionario);

	public void remover(Funcionario funcionario);

	public void atualizar(Funcionario funcionario);

	public List<Funcionario>getTodosFuncionario();

	public Funcionario getFuncionarioPorId(int id);
	
	public Funcionario criaRelatorio(Cliente cliente, Relatorio relatorio, Produto produto);

}
