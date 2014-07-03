package com.senac.view;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import com.senac.Dao.ClienteDAO;
import com.senac.Dao.ClienteDAOBD;
import com.senac.models.Cliente;
import com.senac.view.TelaFuncionarioVenda.tratadorBotoes;
import com.senac.view.TelaFuncionarioVenda.tratadorMenu;

public class TelaFuncionarioRelatorio {

	private JFrame fr_FuncionarioRelatorios;
	private JButton bt_RelatorioCliente, bt_RelatorioFuncionario, bt_RelatorioMes,bt_voltar, bt_sair;
	private JPanel pn_Botoes, pn_table;
	private JMenuBar mb_Menu;
	private JMenu mn_Arquivo;
	private JMenuItem mi_Logout, mi_Sair;
	private TabelaProdutos tabelaProdutos;

	public void iniciaTelaFuncionarioRelatorio(){

		fr_FuncionarioRelatorios = new JFrame();

		tabelaProdutos = new TabelaProdutos();

		pn_Botoes = new JPanel();
		pn_table = new JPanel();

		bt_RelatorioCliente = new JButton("Comprar");
		bt_RelatorioFuncionario = new JButton();
		bt_RelatorioMes = new JButton();
		bt_voltar = new JButton("Voltar");
		bt_sair = new JButton("Sair");

		bt_RelatorioCliente.addActionListener(new tratadorBotoes());
		bt_RelatorioFuncionario.addActionListener(new tratadorBotoes());
		bt_RelatorioMes.addActionListener(new tratadorBotoes());
		bt_voltar.addActionListener(new tratadorBotoes());
		bt_sair.addActionListener(new tratadorBotoes());

		pn_Botoes.add(bt_RelatorioCliente);
		pn_Botoes.add(bt_RelatorioFuncionario);
		pn_Botoes.add(bt_RelatorioMes);
		pn_Botoes.add(bt_voltar);
		pn_Botoes.add(bt_sair);

		pn_table.add(tabelaProdutos);

		mb_Menu = new JMenuBar();

		mn_Arquivo = new JMenu("Arquivo");

		mi_Logout = new JMenuItem("Logout");
		mi_Logout.addActionListener(new tratadorMenu());
		mi_Sair = new JMenuItem("Sair");
		mi_Sair.addActionListener(new tratadorMenu());

		mn_Arquivo.add(mi_Logout);
		mn_Arquivo.add(mi_Sair);

		mb_Menu.add(mn_Arquivo);

		fr_FuncionarioRelatorios.add(mb_Menu ,BorderLayout.NORTH);
		fr_FuncionarioRelatorios.add(pn_table,BorderLayout.CENTER);
		fr_FuncionarioRelatorios.add(pn_Botoes, BorderLayout.SOUTH);

		fr_FuncionarioRelatorios.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fr_FuncionarioRelatorios.setResizable(false);
		fr_FuncionarioRelatorios.setLocationRelativeTo(null);
		fr_FuncionarioRelatorios.setSize(600,200);
		fr_FuncionarioRelatorios.setTitle("Menu de Venda");
		fr_FuncionarioRelatorios.setVisible(true);

	}

	public class tratadorMenu implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource().equals(mi_Logout)){
				TelaLogin login = new TelaLogin();
				fr_FuncionarioRelatorios.setVisible(false);
				login.iniciaTelaLogin();
			}else if(e.getSource().equals(mi_Sair)){
				System.exit(0);
			}
		}
	}


	public class tratadorBotoes implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {

		
		}
	}



}
