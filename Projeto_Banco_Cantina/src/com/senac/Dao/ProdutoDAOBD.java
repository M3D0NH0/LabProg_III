package com.senac.Dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.senac.conexao.PreparaConexao;
import com.senac.models.Cliente;
import com.senac.models.Produto;

public class ProdutoDAOBD extends PreparaConexao implements ProdutoDAO{

	@Override
	public Produto insere(Produto produto) {
		try {
			conexaoPrepared("INSERT INTO produtos(codproduto,nome,tipo,preco) VALUES (?,?,?,?)");
			comando.setInt(1, produto.getCodProduto());
			comando.setString(2, produto.getNome());
			comando.setString(3, produto.getTipo());
			comando.setDouble(4, produto.getPreco());
			comando.executeUpdate();
			return produto;

		} catch (ClassNotFoundException ex) {
			Logger.getLogger(ProdutoDAOBD.class.getName()).log(Level.SEVERE, null, ex);
		}catch (SQLException ex) {
			Logger.getLogger(ProdutoDAOBD.class.getName()).log(Level.SEVERE, null, ex);
		}
		return null;
	}

	@Override
	public void remover(Produto produto) {
		try{
			conexaoPrepared("Delete from produtos where codproduto=?");
			comando.setInt(1, produto.getCodProduto());
			comando.executeQuery();
			fecharPrepared();
		}catch (ClassNotFoundException ex) {
			Logger.getLogger(ProdutoDAOBD.class.getName()).log(Level.SEVERE, null, ex);
		}catch (SQLException ex) {
			Logger.getLogger(ProdutoDAOBD.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	@Override
	public void atualizar(Produto produto) {
		try {
			conexaoPrepared("update produtos set nome=?, tipo=?, preco=? where codproduto=?");
			comando.setString(1, produto.getNome());
			comando.setString(2, produto.getTipo());
			comando.setDouble(3, produto.getPreco());
			comando.setInt(4, produto.getCodProduto());
			comando.executeQuery();
			fecharPrepared();
		} catch (ClassNotFoundException ex) {
			Logger.getLogger(ProdutoDAOBD.class.getName()).log(Level.SEVERE, null, ex);
		}catch (SQLException ex) {
			Logger.getLogger(ProdutoDAOBD.class.getName()).log(Level.SEVERE, null, ex);
		}
		
	}

	@Override
	public List<Produto> getTodosProduto() {
		List<Produto> listaProdutos = new ArrayList<>();
		try {
			conexaoPrepared("select * from produtos");
			ResultSet resultado = comando.executeQuery();
			while (resultado.next()) {
				Produto produto = new Produto(
						resultado.getInt("codproduto"),
						resultado.getString("nome"),
						resultado.getString("tipo"),
						resultado.getDouble("preco")
						);
				listaProdutos.add(produto);
			} 
		}catch (ClassNotFoundException ex) {
			Logger.getLogger(ProdutoDAOBD.class.getName()).log(Level.SEVERE, null, ex);
		}catch (SQLException ex) {
			Logger.getLogger(ProdutoDAOBD.class.getName()).log(Level.SEVERE, null, ex);
		}
		return (listaProdutos);
	}

	@Override
	public Produto getProdutoPorId(int id) {
		try {
			conexaoPrepared("select * from produtos where codproduto=?");
			comando.setInt(1, id);
			ResultSet resultado = comando.executeQuery();
			while (resultado.next()) {
				Produto produto = new Produto(
						resultado.getInt("codproduto"),
						resultado.getString("nome"),
						resultado.getString("tipo"),
						resultado.getDouble("preco")
						);
				return produto;
			}			
		} catch (ClassNotFoundException ex) {
			Logger.getLogger(ProdutoDAOBD.class.getName()).log(Level.SEVERE, null, ex);
		}catch (SQLException ex) {
			Logger.getLogger(ProdutoDAOBD.class.getName()).log(Level.SEVERE, null, ex);
		}
		return (null);
	}

}
