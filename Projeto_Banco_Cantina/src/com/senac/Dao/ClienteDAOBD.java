package com.senac.Dao;

import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.senac.conexao.PreparaConexao;
import com.senac.models.Cliente;

public class ClienteDAOBD extends PreparaConexao implements ClienteDAO{

	@Override
	public Cliente insere(Cliente cliente) {
		try {
			conexaoPrepared("INSERT INTO clientes(codcliente,matricula,nome,email) VALUES (?,?,?,?)");
			comando.setInt(1, cliente.getCodCliente());
			comando.setString(2, cliente.getMatricula());
			comando.setString(3, cliente.getNome());
			comando.setString(4, cliente.getEmail());
			comando.executeUpdate();
			return cliente;
			
		} catch (ClassNotFoundException ex) {
			Logger.getLogger(ClienteDAOBD.class.getName()).log(Level.SEVERE, null, ex);
		}catch (SQLException ex) {
			Logger.getLogger(ClienteDAOBD.class.getName()).log(Level.SEVERE, null, ex);
		}
		return null;
	}

	@Override
	public void remover(Cliente cliente) {
		
	}

	@Override
	public void atualizar(Cliente cliente) {
		
	}

	@Override
	public List<Cliente> getTodosClientes() {
		return null;
	}

	@Override
	public Cliente getClientePorId(int id) {
		return null;
	}

	@Override
	public List<Cliente> getClientePorNome(String nome) {
		return null;
	}
	
	
	
	
	
}
