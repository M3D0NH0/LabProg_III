/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pacote1;

import java.awt.*;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.SpringLayout.Constraints;

/**
 *
 * @author lhries
 */
public class FormularioCadastro extends JFrame{
    
	private TextField nome;
	private TextField telefone;
	private JButton salvar;
	
    public FormularioCadastro()
    {
        super("Formulario de Cadastro");

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(300,300);
        setLayout(new BorderLayout());
        setLocationRelativeTo(null);
        iniciaComponentes();
        setVisible(true);
    }

    private void iniciaComponentes() {
    	JPanel flow = new JPanel(new FlowLayout());
    	JPanel bt_flow = new JPanel(new FlowLayout());
    	JPanel formulario = new JPanel();
    	formulario.setLayout(new GridLayout(2,2,5,5));
    	
    	nome = new TextField(10);
    	telefone = new TextField(10);
    	
    	JLabel labelNome = new JLabel("Nome:",SwingConstants.LEFT);
    	JLabel labelTelefone = new JLabel("Telefone:",SwingConstants.LEFT);
    	
    	formulario.add(labelNome);
    	formulario.add(nome);
    	formulario.add(labelTelefone);
    	formulario.add(telefone);
    	
    	salvar = new JButton("Salvar");
    	
    	salvar.addActionListener(null);
    	
    	/*
    	cadastro.setLayout(new GridLayout(2,4,1,2));
    	Panel panelNome = new Panel();
    	panelNome.setLayout(new GridLayout(1,2,1,1));
    	JLabel labelNome = new JLabel("Nome: ");
    	JTextField textoNome = new JTextField();
    	JLabel labelTelefone = new JLabel("Telefone: ");
    	JTextField textoTelefone = new JTextField();
    	panelNome.add(labelNome);
    	panelNome.add(textoNome);
    	
    	
    	cadastro.add(panelNome);
    	
    	cadastro.add(labelTelefone);
    	cadastro.add(textoTelefone);
    	*/
    	
    	flow.add(formulario);
    	bt_flow.add(salvar);
    	
    	add(flow,BorderLayout.CENTER);
    	add(bt_flow,BorderLayout.SOUTH);
    }
    
    public ActionListener Bt_Salvar(){
    	
    
    	
    	
    	
		return null;
    	
    }
    
    
    
}
