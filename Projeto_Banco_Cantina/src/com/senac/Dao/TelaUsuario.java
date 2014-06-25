package com.senac.Dao;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class TelaUsuario {

	JFrame fr_Usuario;
	JPanel pn_Botoes;
	JButton bt_Comprar, bt_Transferir, bt_RelatorioCompras, bt_Saldo;
	JMenuBar mb_Menu;
	JMenu mn_Arquivo;
	JMenuItem mi_Logout, mi_Sair;

	public void iniciaTelaUsuario(){

		fr_Usuario = new JFrame();
		fr_Usuario.setLayout(new FlowLayout());

		pn_Botoes = new JPanel();

		bt_Comprar = new JButton("Comprar");
		bt_RelatorioCompras = new JButton("Relatorio de Compras");
		bt_Saldo = new JButton("Ver Saldo");
		bt_Transferir = new JButton("Transferir");
		
		bt_Comprar.addActionListener(new tratadorBotoes());
		bt_RelatorioCompras.addActionListener(new tratadorBotoes());
		bt_Saldo.addActionListener(new tratadorBotoes());
		bt_Transferir.addActionListener(new tratadorBotoes());
		

		mb_Menu = new JMenuBar();

		mn_Arquivo = new JMenu("Arquivo");

		mi_Logout = new JMenuItem("Logout");
		mi_Sair = new JMenuItem("Sair");

		pn_Botoes.setLayout(new GridLayout(2,2));
		pn_Botoes.add(bt_Comprar);
		pn_Botoes.add(bt_Transferir);
		pn_Botoes.add(bt_RelatorioCompras);
		pn_Botoes.add(bt_Saldo);

		mn_Arquivo.add(mi_Logout);
		mn_Arquivo.add(mi_Sair);

		mb_Menu.add(mn_Arquivo);

		fr_Usuario.add(pn_Botoes);
		fr_Usuario.add(mb_Menu);

		fr_Usuario.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fr_Usuario.setResizable(false);
		fr_Usuario.setLocationRelativeTo(null);
		fr_Usuario.setSize(400,200);
		fr_Usuario.setTitle("Menu do Usuario");
		fr_Usuario.setVisible(true);
	}
	
	public class tratadorBotoes implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource().equals(bt_Comprar)){
				
			}else if(e.getSource().equals(bt_RelatorioCompras)){
				
			}else if(e.getSource().equals(bt_Saldo)){
				
			}else if(e.getSource().equals(bt_Transferir)){
				
			}
			
		}
		
	}
	
	
	
}
