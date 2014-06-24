/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package projetodesenho;

import java.awt.Graphics;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;


public class TelaDesenho extends JPanel implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	List<Figura> listaFiguras;
    
    public TelaDesenho(){     
        listaFiguras = new ArrayList<Figura>();
    }
    
    public void addFigura(Figura figura)
    {
        listaFiguras.add(figura);
    }
    
    public int getListaTam(){
    	return listaFiguras.size();
    }
    
    public void limpar()
    {
        listaFiguras.clear();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.clearRect(0, 0, 500, 500);
        for(Figura f:listaFiguras)
            f.desenha(g);
    }
    
	public void carregaTela(File file) throws FileNotFoundException, IOException, ClassNotFoundException {
		FileInputStream fi_carregar = new FileInputStream(file);
        ObjectInputStream oi_carregar = new ObjectInputStream(fi_carregar);
        listaFiguras = (List<Figura>) oi_carregar.readObject();
        oi_carregar.close();
        fi_carregar.close();
	}

	public void salvarTela(File file) throws FileNotFoundException, IOException{
		FileOutputStream fo_salvar = new FileOutputStream(file);
		ObjectOutputStream oo_salvar = new ObjectOutputStream(fo_salvar);
		oo_salvar.reset();
		oo_salvar.writeObject(listaFiguras);
		oo_salvar.close();
		fo_salvar.close();
	}
    
}
