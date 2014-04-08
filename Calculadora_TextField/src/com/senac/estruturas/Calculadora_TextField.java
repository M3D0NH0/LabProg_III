package com.senac.estruturas;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


public class Calculadora_TextField {
	JFrame janela;
	JLabel lb_val1;
	JLabel lb_val2;
	JTextField tx_val1;
	JTextField tx_val2;
	JTextField tx_resultado;
	JButton bt_Soma;
	JButton bt_Subtrair;
	JButton bt_Multiplicar;
	JButton bt_Dividir;
	JPanel pn_painel1;
	JPanel pn_painelBotoes;

	public Calculadora_TextField(){
		janela =new JFrame();
		janela.setVisible(true);
		janela.setSize(250, 250);
		janela.setResizable(false);
		janela.setLocationRelativeTo(null);
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		janela.setTitle("Calculadora");
		janela.getContentPane().setLayout(new GridLayout(2,2));


		lb_val1 = new JLabel("Valor 1:");
		lb_val2 = new JLabel("Valor 2:");
		tx_val1 = new JTextField(15);
		tx_val2 = new JTextField(15);
		tx_resultado = new JTextField("Resultado");
		//tx_resultado.setEditable(false);
		bt_Soma = new JButton("Somar");
		bt_Subtrair = new JButton("Subtrair");
		bt_Multiplicar = new JButton("Multiplicar");
		bt_Dividir = new JButton("Dividir");
		
		pn_painel1 = new JPanel();
		pn_painelBotoes = new JPanel();

		bt_Soma.addActionListener(new Resultado());
		bt_Subtrair.addActionListener(new Resultado());
		bt_Multiplicar.addActionListener(new Resultado());
		bt_Dividir.addActionListener(new Resultado());

		pn_painel1.add(lb_val1);
		pn_painel1.add(tx_val1);
		pn_painel1.add(lb_val2);
		pn_painel1.add(tx_val2);
		pn_painel1.add(tx_resultado);
		pn_painel1.add(bt_Soma);
		pn_painel1.add(bt_Subtrair);
		pn_painel1.add(bt_Multiplicar);
		pn_painel1.add(bt_Dividir);
		janela.getContentPane().add(pn_painel1,new GridLayout(2,2));




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
		}
	}

	public static void main(String[] args) {

		new Calculadora_TextField();

	}

	public class Calculos{

		public void soma(String val1, String val2) {
			int soma = Integer.parseInt(val1) + Integer.parseInt(val2);
			String a = ""+soma;
			tx_resultado.setText((a));
		}
		
		public void subtrair(String val1, String val2){
			int subtrair = Integer.parseInt(val1) - Integer.parseInt(val2);
			String a = ""+subtrair;
			tx_resultado.setText((a));
		}
		
		public void multiplicar(String val1, String val2){
			int multiplicar = Integer.parseInt(val1) * Integer.parseInt(val2);
			String a = ""+multiplicar;
			tx_resultado.setText((a));
		}
		
		public void dividir(String val1, String val2){
			int dividir = Integer.parseInt(val1) / Integer.parseInt(val2);
			String a = ""+dividir;
			tx_resultado.setText((a));
		}

	}

}
