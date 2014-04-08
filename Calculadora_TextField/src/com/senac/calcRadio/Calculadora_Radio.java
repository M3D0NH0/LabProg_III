package com.senac.calcRadio;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.security.acl.Group;

import javax.naming.ldap.Rdn;
import javax.swing.*;

//http://docs.oracle.com/javase/tutorial/uiswing/components/button.html
//famfamfam icons

public class Calculadora_Radio {
	JFrame janela;
	JLabel lb_val1;
	JLabel lb_val2;
	JLabel lb_Result;
	JTextField tx_val1;
	JTextField tx_val2;
	JTextField tx_resultado;
	JRadioButton rd_Soma;
	JRadioButton rd_Subtrair;
	JRadioButton rd_Multiplicar;
	JRadioButton rd_Dividir;
	JButton bt_Limpar;
	JButton bt_Calcular;
	JPanel pn_painel1;
	JPanel pn_painelBotoes;
	JPanel pn_BotoesRadio;
	ButtonGroup grupoRadio;
	

	public Calculadora_Radio(){
		janela =new JFrame();
		janela.setResizable(false);
		janela.setLocationRelativeTo(null);
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		janela.setTitle("Calculadora");
		janela.getContentPane().setLayout(new GridLayout(2,2));
		grupoRadio = new ButtonGroup();
		lb_val1 = new JLabel("Valor 1:");
		lb_val2 = new JLabel("Valor 2:");
		lb_Result = new JLabel("Resultado:");
		tx_val1 = new JTextField(15);
		tx_val2 = new JTextField(15);
		tx_resultado = new JTextField("Resultado");
		tx_resultado.setEditable(false);
		rd_Soma = new JRadioButton("Somar");
		rd_Subtrair = new JRadioButton("Subtrair");
		rd_Multiplicar = new JRadioButton("Multiplicar");
		rd_Dividir = new JRadioButton("Dividir");
		bt_Limpar = new JButton("Limpar");
		bt_Calcular = new JButton("Calcular");
		
		grupoRadio.add(rd_Soma);
		grupoRadio.add(rd_Subtrair);
		grupoRadio.add(rd_Multiplicar);
		grupoRadio.add(rd_Dividir);
		grupoRadio.add(bt_Limpar);

		pn_painel1 = new JPanel();
		pn_painelBotoes = new JPanel();
		pn_BotoesRadio = new JPanel();
		//pn_BotoesRadio.setLayout(new GridLayout(1,4));
		pn_BotoesRadio.setLayout(new FlowLayout());
		pn_painelBotoes.setLayout(new FlowLayout());
		pn_painel1.setLayout(new GridLayout(3,2));

		rd_Soma.addActionListener(new Resultado());
		rd_Subtrair.addActionListener(new Resultado());
		rd_Multiplicar.addActionListener(new Resultado());
		rd_Dividir.addActionListener(new Resultado());
		bt_Limpar.addActionListener(new Resultado());
		bt_Calcular.addActionListener(new Resultado());

		pn_painel1.add(lb_val1);
		pn_painel1.add(tx_val1);
		pn_painel1.add(lb_val2);
		pn_painel1.add(tx_val2);
		pn_painel1.add(lb_Result);
		pn_painel1.add(tx_resultado);

		pn_BotoesRadio.add(rd_Soma);
		pn_BotoesRadio.add(rd_Subtrair);
		pn_BotoesRadio.add(rd_Multiplicar);
		pn_BotoesRadio.add(rd_Dividir);
		
		pn_painelBotoes.add(bt_Calcular);
		pn_painelBotoes.add(bt_Limpar);

		janela.add(pn_painel1);
		janela.add(pn_BotoesRadio);
		janela.add(pn_painelBotoes, new BorderLayout().SOUTH);

		janela.setSize(400, 160);
		janela.setVisible(true);

	}

	class Resultado implements ActionListener{
		Calculos calc = new Calculos();
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			/*if(e.getSource()== rd_Soma){
				calc.soma(tx_val1.getText(), tx_val2.getText());
			}
			if(e.getSource()== rd_Subtrair){
				calc.subtrair(tx_val1.getText(), tx_val2.getText());
			}
			if(e.getSource()== rd_Multiplicar){
				calc.multiplicar(tx_val1.getText(), tx_val2.getText());
			}
			if(e.getSource()== rd_Dividir){
				calc.dividir(tx_val1.getText(), tx_val2.getText());
			}*/
			if(e.getSource() == bt_Calcular){
				//grupoRadio.getElements();
				
				if(grupoRadio.getSelection() == rd_Soma){
					calc.soma(tx_val1.getText(), tx_val2.getText());
				}else if(rd_Subtrair.isSelected()){
					calc.subtrair(tx_val1.getText(), tx_val2.getText());
				}else if(rd_Multiplicar.isSelected()){
					calc.multiplicar(tx_val1.getText(), tx_val2.getText());
				}else if(rd_Dividir.isSelected()){
					calc.dividir(tx_val1.getText(), tx_val2.getText());
				}
			}else if(e.getSource() == bt_Limpar){
				tx_val1.setText("");
				tx_val1.setForeground(Color.black);
				tx_val2.setText("");
				tx_val2.setForeground(Color.black);
				tx_resultado.setText("Resultado");
				tx_val1.requestFocus();
			}
		}
	}

	public static void main(String[] args) {

		new Calculadora_Radio();

	}

	public class Calculos{
				
		public void soma(String val1, String val2) {
			try{
				String a="";
				if((val1 == null)||(val2 == null)){
					tx_resultado.setText(a);
				}else{
					int soma = Integer.parseInt(val1) + Integer.parseInt(val2);
					a += soma;
					tx_resultado.setText((a));
				}
			}catch(Exception e){
				Alerta();
			}
		}

		public void subtrair(String val1, String val2){
			try{
				String a="";
				if((val1 == null)||(val2 == null)){
					tx_resultado.setText(a);
				}else{

					int subtrair = Integer.parseInt(val1) - Integer.parseInt(val2);
					a += subtrair;
					tx_resultado.setText((a));
				}
			}catch(Exception e){
				Alerta();
			}
		}

		public void multiplicar(String val1, String val2){
			try{
				String a="";
				if((val1 == null)||(val2 == null)){
					tx_resultado.setText(a);
				}else{
					int multiplicar = Integer.parseInt(val1) * Integer.parseInt(val2);
					a += multiplicar;
					tx_resultado.setText((a));
				}
			}catch(Exception e){
				Alerta();
			}
		}

		public void dividir(String val1, String val2){
			try{
				String a="";
				if((val1 == null)||(val2 == null)){
					tx_resultado.setText(a);
				}else{
					int dividir = Integer.parseInt(val1) / Integer.parseInt(val2);
					a += dividir;
					tx_resultado.setText((a));
				}
			}catch(Exception e){
				Alerta();
			}
		}




	}
	
	public boolean Alerta(){
		try{
			Integer.parseInt(tx_val1.getText());
		}catch(NumberFormatException a){
			if(tx_val1.getText().isEmpty()){
				tx_val1.setText("O Valor nao pode ser vazio.");
				tx_val1.setForeground(Color.red);
			}else{
				tx_val1.setText("Digite somente Numeros.");
				tx_val1.setForeground(Color.red);
			}

		}
		try{
			Integer.parseInt(tx_val2.getText());
		}catch(NumberFormatException a){
			if(tx_val2.getText().isEmpty()){
				tx_val2.setText("O Valor nao pode ser vazio.");
				tx_val2.setForeground(Color.red);
			}else{
				tx_val2.setText("Digite somente Numeros.");
				tx_val2.setForeground(Color.red);
			}

		}
		return true;
	}
	
}
	

