/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package projetodesenho;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;

/**
 *
 * @author lhries
 */
public class TelaDesenho extends JPanel{
    List<Figura> listaFiguras;
    
    public TelaDesenho(){     
        listaFiguras = new ArrayList<Figura>();
    }
    
    public void addFigura(Figura figura)
    {
        listaFiguras.add(figura);
    }
    
    public void limpar()
    {
        listaFiguras.clear();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.clearRect(0, 0, 500, 500);
//        g.setColor(Color.WHITE);
//        g.fillRect(0, 0, 500,500);
//        g.setColor(Color.BLACK);
        for(Figura f:listaFiguras)
            f.desenha(g);
    }
    
    
    
}
