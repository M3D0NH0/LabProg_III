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


public class Entidade extends Figura implements Serializable{
    private int x,y,tam;
    private String nome;
    
    
    
    public Entidade(int x, int y){
        this.x = x;
        this.y = y;
        this.tam = 80;
    }
    public Entidade(String nome,int x, int y, int tam){
        this.x = x;
        this.y = y;
        this.tam=tam;
        this.nome = nome;
    }
    
    public void setNome(String nome){
    	this.nome = nome;
    }
    
    public String getNome(){
    	return this.nome;
    }
    
    @Override
    public void desenha(Graphics g) {
    	
        ImageIcon img = new ImageIcon(getClass().getResource("imagem/Entidade.jpg"));
        Image icon = img.getImage();
        g.drawImage(icon, x-35, y-20, tam, 50, null);
        g.drawString(nome, x-20, y+8);
    }
    
}
