/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package projetodesenho;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.awt.event.MouseWheelEvent;

import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JToggleButton;
import javax.swing.JToolBar;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


/**
 *
 * @author lhries
 */
class DesenhoFrame extends JFrame{
    TelaDesenho telaDesenho;
    JToolBar barraFerramentas;
    JButton ferramentaLimpar;
    JToggleButton ferramentaCirculo, ferramentaQuadrado;
    ButtonGroup bg_tougleButton;
    int x;
    int y;
    
    
    public DesenhoFrame() {
        super("Tela de Desenho");
        iniciaComponentes();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setSize(500, 500);
        setVisible(true);
    }

    private void iniciaComponentes() {
        telaDesenho = new TelaDesenho();
        getContentPane().add(telaDesenho);
        bg_tougleButton = new ButtonGroup();
        
        TratadorBotoes tratadorBotoes = new TratadorBotoes();
        
        barraFerramentas = new JToolBar();
        
        ferramentaCirculo = new JToggleButton("Circulo");
        bg_tougleButton.add(ferramentaCirculo);
        //ferramentaCirculo.addActionListener(tratadorBotoes);
                
        barraFerramentas.add(ferramentaCirculo);
        barraFerramentas.add(Box.createHorizontalStrut(10));
        
        ferramentaQuadrado = new JToggleButton("Quadrado");
        bg_tougleButton.add(ferramentaQuadrado);
        //ferramentaQuadrado.addActionListener(tratadorBotoes);
        
        
        
        barraFerramentas.add(ferramentaQuadrado);
        barraFerramentas.add(Box.createHorizontalStrut(10));
        
        ferramentaLimpar = new JButton("Limpar");
        ferramentaLimpar.addActionListener(tratadorBotoes);
        barraFerramentas.add(ferramentaLimpar);
        barraFerramentas.add(Box.createHorizontalStrut(10));
        
        
        getContentPane().add(barraFerramentas,BorderLayout.NORTH);
        
        telaDesenho.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				x=e.getX();
				System.out.println(e.getX());
				y=e.getY();
				System.out.println(e.getY());
				if(ferramentaCirculo.isSelected()){
					Circulo circ = new Circulo(x, y);
					telaDesenho.addFigura(circ);
					telaDesenho.repaint();
					
				}
				else if(ferramentaQuadrado.isSelected()){
					Quadrado quad = new Quadrado(x, y);
	                telaDesenho.addFigura(quad);
	                telaDesenho.repaint();
	                
				}
			}
		});
        
    }
    
    
    
    
    
    private class TratadorBotoes implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
        	
            if(e.getSource().equals(ferramentaCirculo))
            {
            	
                Circulo circ = new Circulo(x, y);
                
                telaDesenho.addFigura(circ);
                telaDesenho.repaint();
            }
            else if(e.getSource().equals(ferramentaQuadrado))
            {
                int x = Integer.parseInt(JOptionPane.showInputDialog("X: "));
                int y = Integer.parseInt(JOptionPane.showInputDialog("Y: "));
                int tam = Integer.parseInt(JOptionPane.showInputDialog("Tamanho: "));
                
            }
            else if(e.getSource().equals(ferramentaLimpar))
            {
            	ferramentaQuadrado.setSelected(false);
            	ferramentaCirculo.setSelected(false);
                telaDesenho.limpar();
                telaDesenho.repaint();
            }
        }
        
    }
}
