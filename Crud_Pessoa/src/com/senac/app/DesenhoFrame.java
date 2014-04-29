package com.senac.app;

import javax.swing.JFrame;


public class DesenhoFrame extends JFrame {
	TelaDesenho telaDesenho;
	
	public DesenhoFrame(){
		super("Tela de Desenho");
		
		iniciaComponentes();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500, 500);
		setVisible(true);
				
	}
	
		
	
	private void iniciaComponentes(){
		telaDesenho = new TelaDesenho();
		getContentPane().add(telaDesenho);
		
	}
	
	
	
}
