package com.senac.view;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import com.senac.Dao.ProdutoDAO;
import com.senac.Dao.ProdutoDAOBD;
import com.senac.models.Produto;

public class ProdutoModelo extends AbstractTableModel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String colunas[];
	List<Produto> listaProduto;
	
	public ProdutoModelo(){
		listaProduto = new ArrayList<Produto>();
	}
	
	public ProdutoModelo(String[] colunas){
		this.colunas = colunas;
		ProdutoDAO daoProduto = new ProdutoDAOBD();
		this.listaProduto = daoProduto.getTodosProdutos();
	}
	
	public ProdutoModelo(String[] colunas, List<Produto> ListaProduto){
		this.colunas = colunas;
		this.listaProduto = ListaProduto;
	}
	
	public int getRowCount(){
		return(listaProduto.size());
	}
	
	public int getColumnCount(){
		return(4);
	}
	
	public String getColumnname(int column){
		return colunas[column];
	}
	
	public Object getValueAt(int indexLinha, int indexColuna){
		if (indexColuna == 0) {
			return(listaProduto.get(indexLinha).getCodProduto());
		}else if(indexColuna == 1){
			return(listaProduto.get(indexLinha).getNome());
		}else if(indexColuna == 2){
			return(listaProduto.get(indexLinha).getTipo());
		}else{
			return(listaProduto.get(indexLinha).getPreco());
		}
	}
	
	public void adicionaProduto(Produto produto){
		ProdutoDAO daoProduto = new ProdutoDAOBD();
		listaProduto.add(daoProduto.insere(produto));
	}
	
	public void removeProduto(int linha){
		ProdutoDAO daoProduto = new ProdutoDAOBD();
		daoProduto.remover(listaProduto.get(linha));
		listaProduto.remove(linha);
	}
	
	public Produto getProduto(int linha){
		return(listaProduto.get(linha));
	}
	
}
