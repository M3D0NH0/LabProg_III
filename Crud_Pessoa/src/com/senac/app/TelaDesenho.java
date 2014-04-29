package com.senac.app;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;


public class TelaDesenho extends JPanel{

	
	public TelaDesenho(){
		
	}
	
	
	
	@Override
	protected void paintComponent(Graphics g){
		super.paintComponent(g);
		g.drawLine(100, 100, 200, 200);
		g.setColor(Color.GREEN);
		
	}
	
	
	
	
}
