package com.senac.Dao;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class TelaFuncionario {
	JFrame fr_Funcionario;
	JPanel pn_Botoes;
	JButton bt_Cadastrar, bt_depositar, bt_Relatorios, bt_Vender;
	JMenuBar mb_Menu;
	JMenu mn_Arquivo;
	JMenuItem mi_Logout, mi_Sair;

	public void iniciaTelaFuncionario(){

		fr_Funcionario = new JFrame();
		fr_Funcionario.setLayout(new FlowLayout());

		pn_Botoes = new JPanel();

		bt_Cadastrar = new JButton("Cadastrar");
		bt_Relatorios = new JButton("Relatorios");
		bt_Vender = new JButton("Realizar Vendas");
		bt_depositar = new JButton("Depositar Creditos");


		mb_Menu = new JMenuBar();

		mn_Arquivo = new JMenu("Arquivo");

		mi_Logout = new JMenuItem("Logout");
		mi_Sair = new JMenuItem("Sair");

		pn_Botoes.setLayout(new GridLayout(2,2));
		pn_Botoes.add(bt_Cadastrar);
		pn_Botoes.add(bt_depositar);
		pn_Botoes.add(bt_Relatorios);
		pn_Botoes.add(bt_Vender);

		mn_Arquivo.add(mi_Logout);
		mn_Arquivo.add(mi_Sair);

		mb_Menu.add(mn_Arquivo);

		fr_Funcionario.add(pn_Botoes);
		fr_Funcionario.add(mb_Menu);

		fr_Funcionario.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fr_Funcionario.setResizable(false);
		fr_Funcionario.setLocationRelativeTo(null);
		fr_Funcionario.setSize(400,200);
		fr_Funcionario.setTitle("Menu do Usuario");
		fr_Funcionario.setVisible(true);
	}
}