package com.senac.view;

import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import com.senac.models.Cliente;

public class TabelaRelatorioFuncionario extends JPanel{

	private static final long serialVersionUID = 1L;
	JTable tabelaCliente;
	RelatorioModelo modelo;
	
	public TabelaRelatorioFuncionario(){
		String[] colunas = {"ID Venda", "ID Funcionario"};
		
		modelo = new RelatorioModelo(colunas);
		
		tabelaCliente = new JTable(modelo);
		
		tabelaCliente.setPreferredScrollableViewportSize(new Dimension(500,100));
		tabelaCliente.setFillsViewportHeight(true);
		
		JScrollPane scrollPane = new JScrollPane(tabelaCliente);
		
		add(scrollPane);
	}
	
	
	
	public JTable getTabela(){
		return tabelaCliente;
	}
	
	public int getLinha(){
		int aux=-1;
		aux = tabelaCliente.getSelectedRow();
		return aux;
	}
	
	public double getValues(){
		int linha = 0, coluna = 0;
		
		linha = getLinha();
		coluna = modelo.getColumnCount();
		
		return (double) modelo.getValueAt(linha, coluna);
		
	}
	
	
	public void adicionaFuncionario(Cliente cliente){
		RelatorioModelo modelo = (RelatorioModelo)getTabela().getModel();
		modelo.addCliente(cliente);
		getTabela().updateUI();
	}
	
	public void removeFuncionario(int linha){
		RelatorioModelo modelo = (RelatorioModelo)getTabela().getModel();
		System.out.println("Nome: "+ modelo.getCliente(linha).getNome());
		modelo.removeCliente(linha);
		getTabela().updateUI();
	}
	
	
	public void removeFuncionarioSelecionada(){
		int linha = getTabela().getSelectedRow();
		if(linha >= 0){
			removeFuncionario(linha);
		}
		
	}
}
