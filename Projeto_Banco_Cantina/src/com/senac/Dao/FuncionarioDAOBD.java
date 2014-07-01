package com.senac.Dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.senac.conexao.PreparaConexao;
import com.senac.models.Cliente;
import com.senac.models.Funcionario;

public class FuncionarioDAOBD extends PreparaConexao implements FuncionarioDAO{

	@Override
	public Funcionario insere(Funcionario funcionario) {
		try {
			conexaoPrepared("INSERT INTO funcionarios(codfuncionario,nome,telefone) VALUES (?,?,?)");
			comando.setInt(1, funcionario.getCodFuncionario());
			comando.setString(2, funcionario.getNome());
			comando.setString(3, funcionario.getTelefone());
			comando.executeUpdate();
			return funcionario;
			
		} catch (ClassNotFoundException ex) {
			Logger.getLogger(FuncionarioDAOBD.class.getName()).log(Level.SEVERE, null, ex);
		}catch (SQLException ex) {
			Logger.getLogger(FuncionarioDAOBD.class.getName()).log(Level.SEVERE, null, ex);
		}
		return null;
	}

	@Override
	public void remover(Funcionario funcionario) {
		try{
			conexaoPrepared("Delete from funcionarios where codfuncionario=?");
			comando.setInt(1, funcionario.getCodFuncionario());
			comando.executeQuery();
			fecharPrepared();
		}catch (ClassNotFoundException ex) {
			Logger.getLogger(FuncionarioDAOBD.class.getName()).log(Level.SEVERE, null, ex);
		}catch (SQLException ex) {
			Logger.getLogger(FuncionarioDAOBD.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	@Override
	public void atualizar(Funcionario funcionario) {
		try {
			conexaoPrepared("update funcionarios set nome=?, telefone=? where codfuncionario=?");
			comando.setString(1, funcionario.getNome());
			comando.setString(2, funcionario.getTelefone());
			comando.setInt(3, funcionario.getCodFuncionario());
			comando.executeQuery();
			fecharPrepared();
		} catch (ClassNotFoundException ex) {
			Logger.getLogger(FuncionarioDAOBD.class.getName()).log(Level.SEVERE, null, ex);
		}catch (SQLException ex) {
			Logger.getLogger(FuncionarioDAOBD.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	@Override
	public List<Funcionario> getTodosFuncionario() {
		List<Funcionario> listaFuncionarios = new ArrayList<>();
		try {
			conexaoPrepared("select * from funcionarios");
			ResultSet resultado = comando.executeQuery();
			while (resultado.next()) {
				Funcionario funcionario = new Funcionario(
						resultado.getInt("codfuncionario"),
						resultado.getString("nome"),
						resultado.getString("telefone")
						);
				listaFuncionarios.add(funcionario);
			} 
		}catch (ClassNotFoundException ex) {
			Logger.getLogger(FuncionarioDAOBD.class.getName()).log(Level.SEVERE, null, ex);
		}catch (SQLException ex) {
			Logger.getLogger(FuncionarioDAOBD.class.getName()).log(Level.SEVERE, null, ex);
		}
		return (listaFuncionarios);
	}

	@Override
	public Funcionario getFuncionarioPorId(int id) {
		try {
			conexaoPrepared("select * from funcionarios where codfuncionario=?");
			comando.setInt(1, id);
			ResultSet resultado = comando.executeQuery();
			while (resultado.next()) {
				Funcionario funcionario = new Funcionario(
						resultado.getInt("codfuncionario"),
						resultado.getString("nome"),
						resultado.getString("telefone")
						);
				return funcionario;
			}			
		} catch (ClassNotFoundException ex) {
			Logger.getLogger(FuncionarioDAOBD.class.getName()).log(Level.SEVERE, null, ex);
		}catch (SQLException ex) {
			Logger.getLogger(FuncionarioDAOBD.class.getName()).log(Level.SEVERE, null, ex);
		}
		return (null);
	}

}
