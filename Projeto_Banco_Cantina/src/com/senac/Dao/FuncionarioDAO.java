package com.senac.Dao;

import java.util.List;

import com.senac.models.Funcionario;


public interface FuncionarioDAO {

	public Funcionario insere(Funcionario funcionario);

	public void remover(Funcionario funcionario);

	public void atualizar(Funcionario funcionario);

	public List<Funcionario>getTodosFuncionario();

	public Funcionario getFuncionarioPorId(int id);

}
