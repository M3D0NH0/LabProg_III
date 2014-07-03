package com.senac.view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class TabelaRelatorioCliente{
	
	private JFrame fr_RelatorioCliente;
	private JPanel pn_Relatorio;
	private JTextArea txa_Cliente;
	
	
	
	public void iniciaRelatorioCliente(){
		fr_RelatorioCliente = new JFrame();
		
		pn_Relatorio = new JPanel();
		
		txa_Cliente = new JTextArea();
		
		
		
		
		
		fr_RelatorioCliente.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fr_RelatorioCliente.setResizable(false);
		fr_RelatorioCliente.setLocationRelativeTo(null);
		fr_RelatorioCliente.setSize(400,200);
		fr_RelatorioCliente.setTitle("Relatorio Cliente");
		fr_RelatorioCliente.setVisible(true);
		
	}
	
	
}
