package com.senac.Dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.senac.conexao.PreparaConexao;
import com.senac.models.Cliente;
import com.senac.models.Login;

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
		try{
			conexaoPrepared("Delete from clientes where codcliente=?");
			comando.setInt(1, cliente.getCodCliente());
			comando.executeQuery();
			fecharPrepared();
		}catch (ClassNotFoundException ex) {
			Logger.getLogger(ClienteDAOBD.class.getName()).log(Level.SEVERE, null, ex);
		}catch (SQLException ex) {
			Logger.getLogger(ClienteDAOBD.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	@Override
	public void atualizar(Cliente cliente) {
		try {
			conexaoPrepared("update clientes set matricula=?, nome=?, email=? where codcliente=?");
			comando.setString(1, cliente.getMatricula());
			comando.setString(2, cliente.getNome());
			comando.setString(3, cliente.getEmail());
			comando.setInt(4, cliente.getCodCliente());

			comando.executeQuery();
			fecharPrepared();
		} catch (ClassNotFoundException ex) {
			Logger.getLogger(ClienteDAOBD.class.getName()).log(Level.SEVERE, null, ex);
		}catch (SQLException ex) {
			Logger.getLogger(ClienteDAOBD.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	@Override
	public List<Cliente> getTodosClientes() {
		List<Cliente> listaClientes = new ArrayList<>();
		try {
			conexaoPrepared("select * from clientes");
			ResultSet resultado = comando.executeQuery();
			while (resultado.next()) {
				Cliente cliente = new Cliente(
						resultado.getInt("codcliente"),
						resultado.getString("matricula"),
						resultado.getString("nome"), 
						resultado.getString("email")
						);
				listaClientes.add(cliente);
			} 
		}catch (ClassNotFoundException ex) {
			Logger.getLogger(ClienteDAOBD.class.getName()).log(Level.SEVERE, null, ex);
		}catch (SQLException ex) {
			Logger.getLogger(ClienteDAOBD.class.getName()).log(Level.SEVERE, null, ex);
		}
		return (listaClientes);
	}

	@Override
	public Cliente getClientePorId(int id) {
		try {
			conexaoPrepared("select * from clientes where codcliente=?");
			comando.setInt(1, id);
			ResultSet resultado = comando.executeQuery();
			while (resultado.next()) {
				Cliente cliente = new Cliente(
						resultado.getInt("codcliente"),
						resultado.getString("matricula"),
						resultado.getString("nome"), 
						resultado.getString("email")
						);
				return cliente;
			}			
		} catch (ClassNotFoundException ex) {
			Logger.getLogger(ClienteDAOBD.class.getName()).log(Level.SEVERE, null, ex);
		}catch (SQLException ex) {
			Logger.getLogger(ClienteDAOBD.class.getName()).log(Level.SEVERE, null, ex);
		}
		return (null);
	}
}
