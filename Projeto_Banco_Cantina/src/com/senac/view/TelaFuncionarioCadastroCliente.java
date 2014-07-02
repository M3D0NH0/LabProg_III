package com.senac.view;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.senac.Dao.ClienteDAO;
import com.senac.Dao.ClienteDAOBD;
import com.senac.Dao.LoginDAO;
import com.senac.Dao.LoginDAOBD;
import com.senac.models.Cliente;
import com.senac.models.Login;

public class TelaFuncionarioCadastroCliente {
	
	JFrame fr_FuncionarioCadastraCliente;
	JLabel lb_nome,lb_matricula, lb_email,lb_usuario, lb_senha, lb_saldo;
	JTextField tf_nome,tf_matricula, tf_email, tf_usuario,tf_senha,tf_saldo;
	JButton bt_cadastrar, bt_voltar, bt_sair;
	JMenuBar mb_Menu;
	JMenu mn_Arquivo;
	JMenuItem mi_Logout, mi_Sair;
	JPanel pn_botoes, pn_fichaCadastro;
	
	public void iniciaTelaFuncionarioCadastroCliente(){
		
		fr_FuncionarioCadastraCliente = new JFrame();
		
		pn_botoes = new JPanel();
		pn_fichaCadastro = new JPanel();
		
		lb_nome = new JLabel("Nome:");
		lb_usuario = new JLabel("Usuario:");
		lb_matricula = new JLabel("Matricula:");
		lb_email = new JLabel("Email:");
		lb_senha = new JLabel("Senha:");
		lb_saldo = new JLabel("Saldo:");
		
		tf_nome = new JTextField();
		tf_email = new JTextField();
		tf_matricula = new JTextField();
		tf_usuario = new JTextField();
		tf_senha = new JTextField();
		tf_saldo = new JTextField();
		
		pn_fichaCadastro.setLayout(new GridLayout(6,2));
		
		pn_fichaCadastro.add(lb_nome);
		pn_fichaCadastro.add(tf_nome);
		pn_fichaCadastro.add(lb_usuario);
		pn_fichaCadastro.add(tf_usuario);
		pn_fichaCadastro.add(lb_senha);
		pn_fichaCadastro.add(tf_senha);
		pn_fichaCadastro.add(lb_matricula);
		pn_fichaCadastro.add(tf_matricula);
		pn_fichaCadastro.add(lb_email);
		pn_fichaCadastro.add(tf_email);
		pn_fichaCadastro.add(lb_saldo);
		pn_fichaCadastro.add(tf_saldo);

		bt_cadastrar = new JButton("Cadastrar");
		bt_voltar = new JButton("Voltar");
		bt_sair = new JButton("Sair");
		
		pn_botoes.add(bt_cadastrar);
		pn_botoes.add(bt_voltar);
		pn_botoes.add(bt_sair);
		
		bt_cadastrar.addActionListener(new tratadorBotoes());
		bt_voltar.addActionListener(new tratadorBotoes());
		bt_sair.addActionListener(new tratadorBotoes());
		
		mb_Menu = new JMenuBar();
		
		mn_Arquivo = new JMenu("Arquivo");

		mi_Logout = new JMenuItem("Logout");
		mi_Logout.addActionListener(new tratadorMenu());
		mi_Sair = new JMenuItem("Sair");
		mi_Sair.addActionListener(new tratadorMenu());
		
		mn_Arquivo.add(mi_Logout);
		mn_Arquivo.add(mi_Sair);

		mb_Menu.add(mn_Arquivo);
		
		fr_FuncionarioCadastraCliente.add(mb_Menu ,BorderLayout.NORTH);
		fr_FuncionarioCadastraCliente.add(pn_fichaCadastro);
		fr_FuncionarioCadastraCliente.add(pn_botoes,BorderLayout.SOUTH);
		
		fr_FuncionarioCadastraCliente.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fr_FuncionarioCadastraCliente.setResizable(false);
		fr_FuncionarioCadastraCliente.setLocationRelativeTo(null);
		fr_FuncionarioCadastraCliente.setSize(300,200);
		fr_FuncionarioCadastraCliente.setTitle("Pagina de Cadastro Usuario");
		fr_FuncionarioCadastraCliente.setVisible(true);
		
	}
	
	public class tratadorMenu implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource().equals(mi_Logout)){
				TelaLogin login = new TelaLogin();
				fr_FuncionarioCadastraCliente.setVisible(false);
				login.iniciaTelaLogin();
			}else if(e.getSource().equals(mi_Sair)){
				System.exit(0);
			}
		}
	}
	
	public class tratadorBotoes implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource().equals(bt_cadastrar)){
				Cliente cliente = new Cliente();
				Login login = new Login();
				
				ClienteDAO daoCliente = new ClienteDAOBD();
				LoginDAO daoLogin = new LoginDAOBD();
				
				cliente.setMatricula(Integer.parseInt(tf_matricula.getText()));
				cliente.setNome(tf_nome.getText());
				cliente.setEmail(tf_email.getText());
				cliente.setSaldo(Double.parseDouble(tf_saldo.getText()));
				daoCliente.insere(cliente);
				
				login.setMatricula(Integer.parseInt(tf_matricula.getText()));
				login.setUsuario(tf_usuario.getText());
				login.setSenha(tf_senha.getText());
				login.setPermissao(2);
				daoLogin.insereLoginCliente(login);
				
				JOptionPane.showMessageDialog(null, "Cliente Cadastrado com Sucesso!");
				tf_email.setText("");
				tf_nome.setText("");
				tf_senha.setText("");
				tf_matricula.setText("");
				tf_usuario.setText("");
				tf_saldo.setText("");
				
				
			}else if(e.getSource().equals(bt_voltar)){
				fr_FuncionarioCadastraCliente.setVisible(false);
				TelaCadastroFuncionario tl_CadastroFuncionario = new TelaCadastroFuncionario();
				tl_CadastroFuncionario.iniciaTelaCadastroFuncionario();
			}else if(e.getSource().equals(bt_sair)){
				System.exit(0);
			}
		}
		
	
	}
	
	
	
	
}
