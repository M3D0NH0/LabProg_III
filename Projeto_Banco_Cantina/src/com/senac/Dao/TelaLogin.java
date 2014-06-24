package com.senac.Dao;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.senac.conexao.ConexaoBanco;

public class TelaLogin extends ConexaoBanco {

	private JFrame jf_frame;
	private JPanel pn_painelBotoes, pn_principal, pn_organizaLogin, pn_organizaSenha;
	private JLabel lb_login,lb_senha;
	private JTextField tx_login, tx_senha;
	private JButton bt_login, bt_sair;
	private int permissao;

	public void iniciacomponentes(){

		lb_login = new JLabel("Login: ");
		lb_senha = new JLabel("Senha: ");
		tx_login = new JTextField(10);
		tx_senha = new JTextField(10);
		bt_login = new JButton("Login");
		bt_sair = new JButton("Sair");
		pn_painelBotoes = new JPanel();
		pn_organizaLogin = new JPanel(new FlowLayout());
		pn_organizaSenha = new JPanel(new FlowLayout());
		pn_principal = new JPanel(new GridLayout(4,2));
		jf_frame = new JFrame();
		bt_login.addActionListener(new tratadorBotoes());
		bt_sair.addActionListener(new tratadorBotoes());

		pn_organizaLogin.add(lb_login);
		pn_organizaLogin.add(tx_login);
		pn_principal.add(pn_organizaLogin);
		pn_organizaSenha.add(lb_senha);
		pn_organizaSenha.add(tx_senha);
		pn_principal.add(pn_organizaSenha);
		pn_painelBotoes.add(bt_login);
		pn_painelBotoes.add(bt_sair);

		jf_frame.add(pn_painelBotoes, BorderLayout.SOUTH);
		jf_frame.add(pn_principal);

		jf_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf_frame.setResizable(false);
		jf_frame.setLocationRelativeTo(null);
		jf_frame.setSize(200,200);
		jf_frame.setVisible(true);
		jf_frame.setTitle("Login");

	}

	private class tratadorBotoes implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {

			if(e.getSource().equals(bt_login)){
				try {
					if((validaLogin(tx_login.getText(), tx_senha.getText())) == true){
						if(permissao == 1){
							JOptionPane.showMessageDialog(null, "Login Completo Funcionario!");
						}else{
							JOptionPane.showMessageDialog(null, "Login Completo Cliente!");
						}
					}else{
						JOptionPane.showMessageDialog(null, "Login Falhado");
					}
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
			if(e.getSource().equals(bt_sair)){
				System.exit(0);
			}
		}
	}

	public boolean validaLogin(String usuario, String senha) throws SQLException{
		boolean validaLogin=false;
		Statement stm = conexao.createStatement();
		ResultSet resultado = stm.executeQuery("Select * from login");
		while(resultado.next()){
			if(usuario.equals(resultado.getString("usuario"))){
				if(senha.equals(resultado.getString("senha"))){
					permissao = resultado.getInt("permissao");
					validaLogin = true;
				}
			}
		}
		return validaLogin;
	}

}

