/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package projetodesenho;

import java.awt.Graphics;

/**
 *
 * @author lhries
 */
public class Circulo extends Figura{
    int xIni, yIni;
    int tam=10;
   
    public Circulo(int x, int y)
    {
        this.xIni = x;
        this.yIni = y;
    }
    
    @Override
    public void desenha(Graphics g) {
        g.fillOval(xIni, yIni, tam, tam);
        
    }
    
    
}
