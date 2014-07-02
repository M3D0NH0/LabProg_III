package com.senac.view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.senac.Dao.LoginDAO;
import com.senac.Dao.LoginDAOBD;
import com.senac.conexao.PreparaConexao;
import com.senac.models.Login;

public class TelaLogin extends PreparaConexao {

	private JFrame jf_frame;
	private JPanel pn_painelBotoes, pn_principal, pn_organizaLogin, pn_organizaSenha;
	private JLabel lb_login,lb_senha;
	private JTextField tx_login, tx_senha;
	private JButton bt_login, bt_sair;
	private int permissao;
	private TelaUsuario tl_user;
	private TelaFuncionario tl_funcionario;
	private JMenuBar mb_Menu;
	private JMenu mn_Arquivo;
	private JMenuItem mi_Sair;
	private int idLogin;



	public void iniciaTelaLogin(){

		tl_user = new TelaUsuario();

		tl_funcionario = new TelaFuncionario();

		lb_login = new JLabel("Login: ");
		lb_senha = new JLabel("Senha: ");

		tx_login = new JTextField(10);
		tx_senha = new JTextField(10);

		bt_login = new JButton("Login");
		bt_sair = new JButton("Sair");

		new JPanel();
		pn_painelBotoes = new JPanel();
		pn_organizaLogin = new JPanel(new FlowLayout());
		pn_organizaSenha = new JPanel(new FlowLayout());
		pn_principal = new JPanel(new GridLayout(4,2));

		jf_frame = new JFrame();

		bt_login.addActionListener(new tratadorBotoes());
		bt_sair.addActionListener(new tratadorBotoes());

		mb_Menu = new JMenuBar();

		mn_Arquivo = new JMenu("Arquivo");

		mi_Sair = new JMenuItem("Sair");

		mi_Sair.addActionListener(new tratadorMenu());

		mn_Arquivo.add(mi_Sair);

		mb_Menu.add(mn_Arquivo);

		pn_organizaLogin.add(lb_login);
		pn_organizaLogin.add(tx_login);
		pn_principal.add(pn_organizaLogin);
		pn_organizaSenha.add(lb_senha);
		pn_organizaSenha.add(tx_senha);
		pn_principal.add(pn_organizaSenha);
		pn_painelBotoes.add(bt_login);
		pn_painelBotoes.add(bt_sair);

		jf_frame.add(mb_Menu ,BorderLayout.NORTH);
		new BorderLayout();
		jf_frame.add(pn_painelBotoes,BorderLayout.SOUTH);
		jf_frame.add(pn_principal);

		jf_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf_frame.setResizable(false);
		jf_frame.setLocationRelativeTo(null);
		jf_frame.setSize(200,200);
		jf_frame.setVisible(true);
		jf_frame.setTitle("Login");

	}

	public int getIdLogin() {
		return idLogin;
	}

	public void setIdLogin(int idLogin) {
		this.idLogin = idLogin;
	}

	private class tratadorBotoes implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {

			if(e.getSource().equals(bt_login)){
				try {
					if((validaLogin(tx_login.getText(), tx_senha.getText())) == true){
						if(permissao == 1){
							jf_frame.setVisible(false);
							tl_funcionario.iniciaTelaFuncionario();

						}else{
							jf_frame.setVisible(false);
							tl_user.iniciaTelaUsuario();

						}
					}else{
						JOptionPane.showMessageDialog(null, "Login Falhado");
					}
				} catch (SQLException e1) {
					e1.printStackTrace();
				} catch (HeadlessException e1) {
					e1.printStackTrace();
				} catch (ClassNotFoundException e1) {
					e1.printStackTrace();
				}
			}
			if(e.getSource().equals(bt_sair)){
				System.exit(0);
			}
		}
	}

	public class tratadorMenu implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource().equals(mi_Sair)){
				System.exit(0);
			}
		}
	}	


	public boolean validaLogin(String usuario, String senha) throws SQLException, ClassNotFoundException{
		boolean validaLogin=false;

		LoginDAO daoLogin = new LoginDAOBD();
		Login login = daoLogin.getLogin(usuario, senha);
		
		if(login == null) return false;
		
		permissao = login.getPermissao();
		if(permissao == 1){
			login.setCodFuncionario(permissao);
		}else{
			login.setMatricula(permissao);
		}
		validaLogin = true;

		return validaLogin;
	}

}

