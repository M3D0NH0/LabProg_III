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

public class TelaFuncionarioVenda {
	
	private JFrame fr_FuncionarioVenda;
	private JButton bt_Comprar, bt_voltar, bt_sair;
	private JPanel pn_Botoes, pn_table;
	private JMenuBar mb_Menu;
	private JMenu mn_Arquivo;
	private JMenuItem mi_Logout, mi_Sair;
	private TabelaProdutos tabelaProdutos;
	
	public void iniciaTelaFuncionarioVenda(){
		
		fr_FuncionarioVenda = new JFrame();
		
		tabelaProdutos = new TabelaProdutos();
		
		pn_Botoes = new JPanel();
		pn_table = new JPanel();
		
		bt_Comprar = new JButton("Comprar");
		bt_voltar = new JButton("Voltar");
		bt_sair = new JButton("Sair");
		
		bt_Comprar.addActionListener(new tratadorBotoes());
		bt_voltar.addActionListener(new tratadorBotoes());
		bt_sair.addActionListener(new tratadorBotoes());
		
		pn_Botoes.add(bt_Comprar);
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
		
		fr_FuncionarioVenda.add(mb_Menu ,BorderLayout.NORTH);
		fr_FuncionarioVenda.add(pn_table,BorderLayout.CENTER);
		fr_FuncionarioVenda.add(pn_Botoes, BorderLayout.SOUTH);

		fr_FuncionarioVenda.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fr_FuncionarioVenda.setResizable(false);
		fr_FuncionarioVenda.setLocationRelativeTo(null);
		fr_FuncionarioVenda.setSize(600,200);
		fr_FuncionarioVenda.setTitle("Menu de Venda");
		fr_FuncionarioVenda.setVisible(true);
		
	}
	
	public class tratadorMenu implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource().equals(mi_Logout)){
				TelaLogin login = new TelaLogin();
				fr_FuncionarioVenda.setVisible(false);
				login.iniciaTelaLogin();
			}else if(e.getSource().equals(mi_Sair)){
				System.exit(0);
			}
		}
	}
	
	
	public class tratadorBotoes implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			
			if(e.getSource().equals(bt_Comprar)){
				System.out.println(tabelaProdutos.getLinha());
				
				String aux = JOptionPane.showInputDialog("Digite A matricula do Cliente");
				if(aux == null){
					
				}else{
					int matricula = Integer.parseInt(aux);
					ClienteDAO daoCliente = new ClienteDAOBD();
					Cliente cliente = new Cliente();
					cliente = daoCliente.getClientePorMatricula(matricula);
					
					
					
					if((cliente.getSaldo() - tabelaProdutos.getValues()) >= 0){
						double saldo = cliente.getSaldo();
						saldo = saldo - tabelaProdutos.getValues();
						cliente.setSaldo(saldo);
						daoCliente.atualizar(cliente);
					}else{
						JOptionPane.showMessageDialog(null, "Saldo Insuficiente.\n Seu Saldo é : "+ cliente.getSaldo());
					}
				}
				
				
				
			}else if(e.getSource().equals(bt_voltar)){
				fr_FuncionarioVenda.setVisible(false);
				TelaFuncionario tl_Funcionario = new TelaFuncionario();
				tl_Funcionario.iniciaTelaFuncionario();
				
			}else if(e.getSource().equals(bt_sair)){
				System.exit(0);
			}
		}
	}
	
	
}
