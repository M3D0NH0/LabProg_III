package com.senac.view;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class TelaFuncionario {
	private JFrame fr_Funcionario;
	private JPanel pn_Botoes;
	private JButton bt_Cadastrar, bt_depositar, bt_Relatorios, bt_Vender;
	private JMenuBar mb_Menu;
	private JMenu mn_Arquivo;
	private JMenuItem mi_Logout, mi_Sair;

	public void iniciaTelaFuncionario(){

		fr_Funcionario = new JFrame();

		pn_Botoes = new JPanel();

		bt_Cadastrar = new JButton("Cadastrar");
		bt_Relatorios = new JButton("Relatorios");
		bt_Vender = new JButton("Realizar Vendas");
		bt_depositar = new JButton("Depositar Creditos");
		
		bt_Cadastrar.addActionListener(new tratadorBotoes());
		bt_Relatorios.addActionListener(new tratadorBotoes());
		bt_Vender.addActionListener(new tratadorBotoes());
		bt_depositar.addActionListener(new tratadorBotoes());

		mb_Menu = new JMenuBar();

		mn_Arquivo = new JMenu("Arquivo");

		mi_Logout = new JMenuItem("Logout");
		mi_Logout.addActionListener(new tratadorMenu());
		mi_Sair = new JMenuItem("Sair");
		mi_Sair.addActionListener(new tratadorMenu());

		pn_Botoes.setLayout(new FlowLayout());
		pn_Botoes.add(bt_Cadastrar);
		pn_Botoes.add(bt_depositar);
		pn_Botoes.add(bt_Relatorios);
		pn_Botoes.add(bt_Vender);

		mn_Arquivo.add(mi_Logout);
		mn_Arquivo.add(mi_Sair);

		mb_Menu.add(mn_Arquivo);

		fr_Funcionario.add(mb_Menu ,BorderLayout.NORTH);
		fr_Funcionario.add(pn_Botoes);

		fr_Funcionario.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fr_Funcionario.setResizable(false);
		fr_Funcionario.setLocationRelativeTo(null);
		fr_Funcionario.setSize(400,200);
		fr_Funcionario.setTitle("Menu do Funcionario");
		fr_Funcionario.setVisible(true);
	}
	
	public class tratadorMenu implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource().equals(mi_Logout)){
				TelaLogin login = new TelaLogin();
				fr_Funcionario.setVisible(false);
				login.iniciaTelaLogin();
			}else if(e.getSource().equals(mi_Sair)){
				System.exit(0);
			}
		}
		
		
	}
	
	public class tratadorBotoes implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource().equals(bt_Cadastrar)){
				fr_Funcionario.setVisible(false);
				TelaCadastroFuncionario tl_cadastroFuncionario = new TelaCadastroFuncionario();
				tl_cadastroFuncionario.iniciaTelaCadastroFuncionario();
			}else if(e.getSource().equals(bt_Relatorios)){
				fr_Funcionario.setVisible(false);
				TelaFuncionarioRelatorio tl_funcionarioRelatorio = new TelaFuncionarioRelatorio();
				tl_funcionarioRelatorio.iniciaTelaFuncionarioRelatorio();
			}else if(e.getSource().equals(bt_Vender)){
				fr_Funcionario.setVisible(false);
				TelaFuncionarioVenda tl_FuncionarioVenda = new TelaFuncionarioVenda();
				tl_FuncionarioVenda.iniciaTelaFuncionarioVenda();
				
			}else if(e.getSource().equals(bt_depositar)){
				
			}
			
		}
		
	}
	
	
}