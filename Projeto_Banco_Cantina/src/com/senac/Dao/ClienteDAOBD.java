package com.senac.Dao;

import java.util.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.senac.conexao.PreparaConexao;
import com.senac.models.Cliente;

public class ClienteDAOBD extends PreparaConexao implements ClienteDAO{

	@Override
	public Cliente insere(Cliente cliente) {
		try {
			conexaoPrepared("INSERT INTO clientes(matricula,nome,email,saldo) VALUES (?,?,?,?)");
			comando.setInt(1, cliente.getMatricula());
			comando.setString(2, cliente.getNome());
			comando.setString(3, cliente.getEmail());
			comando.setDouble(4, cliente.getSaldo());
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
			conexaoPrepared("Delete from clientes where matricula=?");
			comando.setInt(1, cliente.getMatricula());
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
			conexaoPrepared("update clientes set nome=?, email=?, saldo=? where matricula=?");
			comando.setString(1, cliente.getNome());
			comando.setString(2, cliente.getEmail());
			comando.setDouble(3, cliente.getSaldo());
			comando.setInt(4, cliente.getMatricula());
			comando.executeUpdate();
		} catch (ClassNotFoundException ex) {
			Logger.getLogger(ClienteDAOBD.class.getName()).log(Level.SEVERE, null, ex);
		}catch (SQLException ex) {
			Logger.getLogger(ClienteDAOBD.class.getName()).log(Level.SEVERE, null, ex);
		}finally{
			fecharPrepared();
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
						resultado.getInt("matricula"),
						resultado.getString("nome"), 
						resultado.getString("email"),
						resultado.getDouble("saldo")
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
	public Cliente getClientePorMatricula(int matricula) {
		try {
			conexaoPrepared("select * from clientes where matricula=?");
			comando.setInt(1, matricula);
			ResultSet resultado = comando.executeQuery();
			while (resultado.next()) {
				Cliente cliente = new Cliente(
						resultado.getInt("matricula"),
						resultado.getString("nome"), 
						resultado.getString("email"),
						resultado.getDouble("saldo")
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

	@Override
	public double getSaldo(int matricula) {
		try {
			conexaoPrepared("select * from clientes where matricula=?");
			comando.setInt(1, matricula);
			ResultSet resultado = comando.executeQuery();
			while (resultado.next()) {
				Cliente cliente = new Cliente(
						resultado.getInt("matricula"),
						resultado.getString("nome"), 
						resultado.getString("email"),
						resultado.getDouble("saldo")
						);
				return cliente.getSaldo();
			}			
		} catch (ClassNotFoundException ex) {
			Logger.getLogger(ClienteDAOBD.class.getName()).log(Level.SEVERE, null, ex);
		}catch (SQLException ex) {
			Logger.getLogger(ClienteDAOBD.class.getName()).log(Level.SEVERE, null, ex);
		}
		return 0;
	}

	@Override
	public void insereRelatorio(Cliente cliente, int codProduto) {
		String data = new String();
		data = "03/07/2014";
		
		try {
			conexaoPrepared("INSERT INTO relatorio(matricula,codproduto,data) VALUES (?,?,?)");
			comando.setInt(1, cliente.getMatricula());
			comando.setInt(2, codProduto);
			comando.setString(3, data);
			comando.executeUpdate();
		} catch (ClassNotFoundException ex) {
			Logger.getLogger(ClienteDAOBD.class.getName()).log(Level.SEVERE, null, ex);
		}catch (SQLException ex) {
			Logger.getLogger(ClienteDAOBD.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
}
