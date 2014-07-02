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

import com.senac.Dao.FuncionarioDAO;
import com.senac.Dao.FuncionarioDAOBD;
import com.senac.Dao.LoginDAO;
import com.senac.Dao.LoginDAOBD;
import com.senac.models.Funcionario;
import com.senac.models.Login;

public class TelaFuncionarioCadastroFuncionario {
	JFrame fr_FuncionarioCadastraFuncionario;
	JLabel lb_nome,lb_telefone,lb_usuario, lb_senha,lb_codFuncionario;
	JTextField tf_nome,tf_telefone,tf_usuario, tf_senha, tf_codFuncionario;
	JButton bt_cadastrar, bt_voltar, bt_sair;
	JMenuBar mb_Menu;
	JMenu mn_Arquivo;
	JMenuItem mi_Logout, mi_Sair;
	JPanel pn_botoes, pn_fichaCadastro;

	public void iniciaTelaFuncionarioCadastroFuncionario(){

		fr_FuncionarioCadastraFuncionario = new JFrame();

		pn_botoes = new JPanel();
		pn_fichaCadastro = new JPanel();

		lb_nome = new JLabel("Nome:");
		lb_usuario = new JLabel("Usuario:");
		lb_senha = new JLabel("Senha:");
		lb_codFuncionario = new JLabel("Codigo do Funcionario:");
		lb_telefone = new JLabel("Telefone:");

		tf_nome = new JTextField();
		tf_usuario = new JTextField();
		tf_senha = new JTextField();
		tf_codFuncionario = new JTextField();
		tf_telefone = new JTextField();

		pn_fichaCadastro.setLayout(new GridLayout(5,2));

		pn_fichaCadastro.add(lb_codFuncionario);
		pn_fichaCadastro.add(tf_codFuncionario);
		pn_fichaCadastro.add(lb_nome);
		pn_fichaCadastro.add(tf_nome);
		pn_fichaCadastro.add(lb_telefone);
		pn_fichaCadastro.add(tf_telefone);
		pn_fichaCadastro.add(lb_usuario);
		pn_fichaCadastro.add(tf_usuario);
		pn_fichaCadastro.add(lb_senha);
		pn_fichaCadastro.add(tf_senha);

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

		fr_FuncionarioCadastraFuncionario.add(mb_Menu ,BorderLayout.NORTH);
		fr_FuncionarioCadastraFuncionario.add(pn_fichaCadastro);
		fr_FuncionarioCadastraFuncionario.add(pn_botoes,BorderLayout.SOUTH);

		fr_FuncionarioCadastraFuncionario.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fr_FuncionarioCadastraFuncionario.setResizable(false);
		fr_FuncionarioCadastraFuncionario.setLocationRelativeTo(null);
		fr_FuncionarioCadastraFuncionario.setSize(300,200);
		fr_FuncionarioCadastraFuncionario.setTitle("Pagina de Cadastro Funcionario");
		fr_FuncionarioCadastraFuncionario.setVisible(true);

	}

	public class tratadorMenu implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource().equals(mi_Logout)){
				TelaLogin login = new TelaLogin();
				fr_FuncionarioCadastraFuncionario.setVisible(false);
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
				Funcionario funcionario = new Funcionario();
				Login login = new Login();
				
				FuncionarioDAO daoFuncionario = new FuncionarioDAOBD();
				LoginDAO daoLogin = new LoginDAOBD();
				
				funcionario.setCodFuncionario(Integer.parseInt(tf_codFuncionario.getText()));
				funcionario.setNome(tf_nome.getText());
				funcionario.setTelefone(tf_telefone.getText());
				daoFuncionario.insere(funcionario);
				
				login.setCodFuncionario(Integer.parseInt(tf_codFuncionario.getText()));
				login.setUsuario(tf_usuario.getText());
				login.setSenha(tf_senha.getText());
				login.setPermissao(1);
				daoLogin.insereLoginFuncionario(login);
				
				JOptionPane.showMessageDialog(null, "Funcionario Cadastrado com Sucesso!");
				tf_codFuncionario.setText("");
				tf_nome.setText("");
				tf_senha.setText("");
				tf_telefone.setText("");
				tf_usuario.setText("");
			}else if(e.getSource().equals(bt_voltar)){
				fr_FuncionarioCadastraFuncionario.setVisible(false);
				TelaCadastroFuncionario tl_CadastroFuncionario = new TelaCadastroFuncionario();
				tl_CadastroFuncionario.iniciaTelaCadastroFuncionario();
			}else if(e.getSource().equals(bt_sair)){
				System.exit(0);
			}
		}


	}

}
