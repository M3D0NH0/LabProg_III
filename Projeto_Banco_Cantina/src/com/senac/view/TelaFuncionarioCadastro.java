package com.senac.view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.senac.Dao.ClienteDAO;
import com.senac.Dao.ClienteDAOBD;
import com.senac.Dao.LoginDAO;
import com.senac.Dao.LoginDAOBD;
import com.senac.models.Cliente;
import com.senac.models.Login;

public class TelaFuncionarioCadastro {
	
	JFrame fr_FuncionarioCadastra;
	JLabel lb_nome,lb_matricula, lb_email,lb_usuario, lb_senha;
	JTextField tf_nome,tf_matricula, tf_email, tf_usuario,tf_senha;
	JButton bt_cadastrar, bt_voltar, bt_sair;
	JMenuBar mb_Menu;
	JMenu mn_Arquivo;
	JMenuItem mi_Logout, mi_Sair;
	JPanel pn_botoes, pn_fichaCadastro;
	
	public void iniciaTelaCadastro(){
		
		fr_FuncionarioCadastra = new JFrame();
		
		pn_botoes = new JPanel();
		pn_fichaCadastro = new JPanel();
		
		lb_nome = new JLabel("Nome:");
		lb_usuario = new JLabel("Usuario:");
		lb_matricula = new JLabel("Matricula:");
		lb_email = new JLabel("Email:");
		lb_senha = new JLabel("Senha:");
		
		tf_nome = new JTextField();
		tf_email = new JTextField();
		tf_matricula = new JTextField();
		tf_usuario = new JTextField();
		tf_senha = new JTextField();
		
		pn_fichaCadastro.setLayout(new GridLayout(5,2));
		
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
		
		fr_FuncionarioCadastra.add(mb_Menu ,BorderLayout.NORTH);
		fr_FuncionarioCadastra.add(pn_fichaCadastro);
		fr_FuncionarioCadastra.add(pn_botoes,BorderLayout.SOUTH);
		
		fr_FuncionarioCadastra.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fr_FuncionarioCadastra.setResizable(false);
		fr_FuncionarioCadastra.setLocationRelativeTo(null);
		fr_FuncionarioCadastra.setSize(300,200);
		fr_FuncionarioCadastra.setTitle("Pagina de Cadastro");
		fr_FuncionarioCadastra.setVisible(true);
		
	}
	
	public class tratadorMenu implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource().equals(mi_Logout)){
				TelaLogin login = new TelaLogin();
				fr_FuncionarioCadastra.setVisible(false);
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
				
				cliente.setCodCliente(10);
				cliente.setNome(tf_nome.getText());
				cliente.setEmail(tf_email.getText());
				cliente.setMatricula(tf_matricula.getText());
				daoCliente.insere(cliente);
				
				login.setCodCliente(10);
				login.setUsuario(tf_usuario.getText());
				login.setSenha(tf_senha.getText());
				login.setPermissao(2);
				daoLogin.insereLoginCliente(login);
				
				
			}else if(e.getSource().equals(bt_voltar)){
				fr_FuncionarioCadastra.setVisible(false);
				TelaFuncionario tl_funcionario = new TelaFuncionario();
				tl_funcionario.iniciaTelaFuncionario();
			}else if(e.getSource().equals(bt_sair)){
				System.exit(0);
			}
		}
		
	
	}
	
	
	
	
}
