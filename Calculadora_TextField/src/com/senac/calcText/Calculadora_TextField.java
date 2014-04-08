package com.senac.calcText;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


public class Calculadora_TextField {
	JFrame janela;
	JLabel lb_val1;
	JLabel lb_val2;
	JLabel lb_Result;
	JTextField tx_val1;
	JTextField tx_val2;
	JTextField tx_resultado;
	JButton bt_Soma;
	JButton bt_Subtrair;
	JButton bt_Multiplicar;
	JButton bt_Dividir;
	JButton bt_Limpar;
	JPanel pn_painel1;
	JPanel pn_painelBotoes;

	public Calculadora_TextField(){
		janela =new JFrame();
		janela.setResizable(false);
		janela.setLocationRelativeTo(null);
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		janela.setTitle("Calculadora");
		janela.getContentPane().setLayout(new GridLayout(2,2));
		lb_val1 = new JLabel("Valor 1:");
		lb_val2 = new JLabel("Valor 2:");
		lb_Result = new JLabel("Resultado:");
		tx_val1 = new JTextField(15);
		tx_val2 = new JTextField(15);
		tx_resultado = new JTextField("Resultado");
		tx_resultado.setEditable(false);
		bt_Soma = new JButton("Somar");
		bt_Subtrair = new JButton("Subtrair");
		bt_Multiplicar = new JButton("Multiplicar");
		bt_Dividir = new JButton("Dividir");
		bt_Limpar = new JButton("Limpar");

		pn_painel1 = new JPanel();
		pn_painelBotoes = new JPanel();
		pn_painelBotoes.setLayout(new FlowLayout());
		pn_painel1.setLayout(new GridLayout(3,2));

		bt_Soma.addActionListener(new Resultado());
		bt_Subtrair.addActionListener(new Resultado());
		bt_Multiplicar.addActionListener(new Resultado());
		bt_Dividir.addActionListener(new Resultado());
		bt_Limpar.addActionListener(new Resultado());

		pn_painel1.add(lb_val1);
		pn_painel1.add(tx_val1);
		pn_painel1.add(lb_val2);
		pn_painel1.add(tx_val2);
		pn_painel1.add(lb_Result);
		pn_painel1.add(tx_resultado);

		pn_painelBotoes.add(bt_Soma);
		pn_painelBotoes.add(bt_Subtrair);
		pn_painelBotoes.add(bt_Multiplicar);
		pn_painelBotoes.add(bt_Dividir);
		pn_painelBotoes.add(bt_Limpar);

		janela.add(pn_painel1);
		janela.add(pn_painelBotoes, new BorderLayout().SOUTH);

		janela.setSize(400, 160);
		janela.setVisible(true);

	}

	class Resultado implements ActionListener{
		Calculos calc = new Calculos();
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if(e.getSource()== bt_Soma){
				calc.soma(tx_val1.getText(), tx_val2.getText());
			}
			if(e.getSource()== bt_Subtrair){
				calc.subtrair(tx_val1.getText(), tx_val2.getText());
			}
			if(e.getSource()== bt_Multiplicar){
				calc.multiplicar(tx_val1.getText(), tx_val2.getText());
			}
			if(e.getSource()== bt_Dividir){
				calc.dividir(tx_val1.getText(), tx_val2.getText());
			}
			if(e.getSource() == bt_Limpar){
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

		new Calculadora_TextField();

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
	

