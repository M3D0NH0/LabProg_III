/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package projetodesenho;

import java.awt.Graphics;
import java.awt.Image;
import java.io.Serializable;

import javax.swing.ImageIcon;


public class Ator extends Figura implements Serializable{
    int xIni, yIni;
    int tam=40;
    String nome = "";
   
    public Ator(int x, int y)
    {
        this.xIni = x;
        this.yIni = y;
    }
    
    public void setNome(String nome){
    	this.nome=nome;
    }
    
    public String getNome(){
    	return this.nome;
    }
    
    @Override
    public void desenha(Graphics g) {
        //g.fillOval(xIni, yIni, tam, tam);
    	
        ImageIcon img = new ImageIcon(getClass().getResource("imagem/Ator.jpg"));
        Image icon = img.getImage();
        g.drawImage(icon, xIni-20, yIni-20, tam, tam, null);
        g.drawString(nome, xIni-20, yIni+30);
        
    }
    
    
}
