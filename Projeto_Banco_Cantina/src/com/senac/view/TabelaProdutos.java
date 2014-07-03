package com.senac.view;

import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import com.senac.models.Produto;

public class TabelaProdutos extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JTable tabelaProdutos;
	ProdutoModelo modelo;

	public TabelaProdutos(){
		String[] colunas = {"Codigo Produto","Nome","Tipo","Preco"};

		modelo = new ProdutoModelo(colunas);

		tabelaProdutos = new JTable(modelo);

		tabelaProdutos.setPreferredScrollableViewportSize(new Dimension(500,100));
		tabelaProdutos.setFillsViewportHeight(true);

		JScrollPane scrollPane = new JScrollPane(tabelaProdutos);

		add(scrollPane);
	}



	public JTable getTabela(){
		return tabelaProdutos;
	}

	public int getLinha(){
		int aux=-1;
		aux = tabelaProdutos.getSelectedRow();
		return aux;
	}

	public double getValues(){
		int linha = 0, coluna = 0;

		linha = getLinha();
		coluna = modelo.getColumnCount();

		return (double) modelo.getValueAt(linha, coluna);

	}

	public int getPrimeiraColuna(){
		int linha = 0, coluna = 0;;

		linha = getLinha();

		return (int) modelo.getValueAt(linha, 1);
	}


	public void adicionaProduto(Produto produto){
		ProdutoModelo modelo = (ProdutoModelo)getTabela().getModel();
		modelo.adicionaProduto(produto);
		getTabela().updateUI();
	}

	public void removeProduto(int linha){
		ProdutoModelo modelo = (ProdutoModelo)getTabela().getModel();
		System.out.println("Nome: "+ modelo.getProduto(linha).getNome());
		modelo.removeProduto(linha);
		getTabela().updateUI();
	}

	public void removeProdutoSelecionada(){
		int linha = getTabela().getSelectedRow();
		if(linha >= 0){
			removeProduto(linha);
		}

	}

}
