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

import com.senac.Dao.ProdutoDAO;
import com.senac.Dao.ProdutoDAOBD;
import com.senac.models.Produto;

public class TelaFuncionarioCadastroProduto {
	JFrame fr_FuncionarioCadastraProduto;
	JLabel lb_nome,lb_tipo,lb_preco,lb_codProduto;
	JTextField tf_nome,tf_tipo,tf_preco,tf_codProduto;
	JButton bt_cadastrar, bt_voltar, bt_sair;
	JMenuBar mb_Menu;
	JMenu mn_Arquivo;
	JMenuItem mi_Logout, mi_Sair;
	JPanel pn_botoes, pn_fichaCadastro;

	public void iniciaTelaFuncionarioCadastroProduto(){

		fr_FuncionarioCadastraProduto = new JFrame();

		pn_botoes = new JPanel();
		pn_fichaCadastro = new JPanel();

		lb_nome = new JLabel("Nome:");
		lb_tipo = new JLabel("Tipo:");
		lb_preco = new JLabel("Preco:");
		lb_codProduto = new JLabel("Codigo do Produto:");

		tf_nome = new JTextField();
		tf_tipo = new JTextField();
		tf_preco = new JTextField();
		tf_codProduto = new JTextField();

		pn_fichaCadastro.setLayout(new GridLayout(4,2));

		pn_fichaCadastro.add(lb_codProduto);
		pn_fichaCadastro.add(tf_codProduto);
		pn_fichaCadastro.add(lb_nome);
		pn_fichaCadastro.add(tf_nome);
		pn_fichaCadastro.add(lb_tipo);
		pn_fichaCadastro.add(tf_tipo);
		pn_fichaCadastro.add(lb_preco);
		pn_fichaCadastro.add(tf_preco);

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

		fr_FuncionarioCadastraProduto.add(mb_Menu ,BorderLayout.NORTH);
		fr_FuncionarioCadastraProduto.add(pn_fichaCadastro);
		fr_FuncionarioCadastraProduto.add(pn_botoes,BorderLayout.SOUTH);

		fr_FuncionarioCadastraProduto.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fr_FuncionarioCadastraProduto.setResizable(false);
		fr_FuncionarioCadastraProduto.setLocationRelativeTo(null);
		fr_FuncionarioCadastraProduto.setSize(300,200);
		fr_FuncionarioCadastraProduto.setTitle("Pagina de Cadastro Produtos");
		fr_FuncionarioCadastraProduto.setVisible(true);

	}

	public class tratadorMenu implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource().equals(mi_Logout)){
				TelaLogin login = new TelaLogin();
				fr_FuncionarioCadastraProduto.setVisible(false);
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
				Produto produto = new Produto();
				ProdutoDAO daoProduto = new ProdutoDAOBD();
				
				produto.setCodProduto(Integer.parseInt(tf_codProduto.getText()));
				produto.setNome(tf_nome.getText());
				produto.setTipo(tf_tipo.getText());
				produto.setPreco(Double.parseDouble(tf_preco.getText()));
				
				daoProduto.insere(produto);
				
				JOptionPane.showMessageDialog(null, "Produto Cadastrado com Sucesso!");
				tf_codProduto.setText("");
				tf_nome.setText("");
				tf_preco.setText("");
				tf_tipo.setText("");
			}else if(e.getSource().equals(bt_voltar)){
				fr_FuncionarioCadastraProduto.setVisible(false);
				TelaCadastroFuncionario tl_CadastroFuncionario = new TelaCadastroFuncionario();
				tl_CadastroFuncionario.iniciaTelaCadastroFuncionario();
			}else if(e.getSource().equals(bt_sair)){
				System.exit(0);
			}
		}


	}
}
