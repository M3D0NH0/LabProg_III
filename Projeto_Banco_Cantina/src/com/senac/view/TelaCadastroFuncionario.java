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

public class TelaCadastroFuncionario {
	private JFrame fr_FuncionarioCadastro;
	private JPanel pn_Botoes;
	private JButton bt_CadastrarFuncionario,bt_CadastrarCliente, bt_CadastrarProduto, bt_editar, bt_remover, bt_voltar;
	private JMenuBar mb_Menu;
	private JMenu mn_Arquivo;
	private JMenuItem mi_Logout, mi_Sair;

	public void iniciaTelaCadastroFuncionario(){

		fr_FuncionarioCadastro = new JFrame();

		pn_Botoes = new JPanel();

		bt_CadastrarFuncionario = new JButton("Cadastrar Funcionario");
		bt_CadastrarCliente = new JButton("Cadastrar Cliente");
		bt_CadastrarProduto = new JButton("Cadastrar Produto");
		bt_editar = new JButton("Editar");
		bt_remover = new JButton("Remover");
		bt_voltar = new JButton("Voltar");

		bt_CadastrarFuncionario.addActionListener(new tratadorBotoes());
		bt_CadastrarCliente.addActionListener(new tratadorBotoes());
		bt_CadastrarProduto.addActionListener(new tratadorBotoes());
		bt_editar.addActionListener(new tratadorBotoes());
		bt_remover.addActionListener(new tratadorBotoes());
		bt_voltar.addActionListener(new tratadorBotoes());

		mb_Menu = new JMenuBar();

		mn_Arquivo = new JMenu("Arquivo");

		mi_Logout = new JMenuItem("Logout");
		mi_Logout.addActionListener(new tratadorMenu());
		mi_Sair = new JMenuItem("Sair");
		mi_Sair.addActionListener(new tratadorMenu());

		pn_Botoes.setLayout(new FlowLayout());
		pn_Botoes.add(bt_CadastrarFuncionario);
		pn_Botoes.add(bt_CadastrarCliente);
		pn_Botoes.add(bt_CadastrarProduto);
		pn_Botoes.add(bt_editar);
		pn_Botoes.add(bt_remover);
		pn_Botoes.add(bt_voltar);

		mn_Arquivo.add(mi_Logout);
		mn_Arquivo.add(mi_Sair);

		mb_Menu.add(mn_Arquivo);

		fr_FuncionarioCadastro.add(mb_Menu ,BorderLayout.NORTH);
		fr_FuncionarioCadastro.add(pn_Botoes);

		fr_FuncionarioCadastro.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fr_FuncionarioCadastro.setResizable(false);
		fr_FuncionarioCadastro.setLocationRelativeTo(null);
		fr_FuncionarioCadastro.setSize(400,200);
		fr_FuncionarioCadastro.setTitle("Menu do Funcionario");
		fr_FuncionarioCadastro.setVisible(true);
	}

	public class tratadorMenu implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource().equals(mi_Logout)){
				TelaLogin login = new TelaLogin();
				fr_FuncionarioCadastro.setVisible(false);
				login.iniciaTelaLogin();
			}else if(e.getSource().equals(mi_Sair)){
				System.exit(0);
			}
		}


	}

	public class tratadorBotoes implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource().equals(bt_CadastrarFuncionario)){
				
				fr_FuncionarioCadastro.setVisible(false);
				TelaFuncionarioCadastroFuncionario tl_funcionarioCadastroFuncionario = new TelaFuncionarioCadastroFuncionario();
				tl_funcionarioCadastroFuncionario.iniciaTelaFuncionarioCadastroFuncionario();
			}else if(e.getSource().equals(bt_CadastrarCliente)){
				
				fr_FuncionarioCadastro.setVisible(false);
				TelaFuncionarioCadastroCliente tl_funcionarioCadastroCliente = new TelaFuncionarioCadastroCliente();
				tl_funcionarioCadastroCliente.iniciaTelaFuncionarioCadastroCliente();
			}else if(e.getSource().equals(bt_CadastrarProduto)){
				
				fr_FuncionarioCadastro.setVisible(false);
				TelaFuncionarioCadastroProduto tl_funcionarioCadastroProduto = new TelaFuncionarioCadastroProduto();
				tl_funcionarioCadastroProduto.iniciaTelaFuncionarioCadastroProduto();
			}else if(e.getSource().equals(bt_editar)){

			}else if(e.getSource().equals(bt_remover)){

			}else if(e.getSource().equals(bt_voltar)){
				fr_FuncionarioCadastro.setVisible(false);
				TelaFuncionario tl_funcionario = new TelaFuncionario();
				tl_funcionario.iniciaTelaFuncionario();
			}

		}

	}
}
