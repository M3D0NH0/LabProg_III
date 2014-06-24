/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package projetodesenho;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;

import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.DefaultButtonModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JToggleButton;
import javax.swing.JToolBar;
import javax.swing.JTree;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;



class DesenhoFrame extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	TelaDesenho telaDesenho;
	//JToolBar pn_barraFerramentas;
	JButton bt_limpar;
	JToggleButton btg_ator, btg_entidade, btg_editar;
	JPanel pn_arvore, pn_barraFerramentas, pn_menu;
	JTree tree;
	ButtonModel bm_toggleButton;
	ButtonGroup bg_toggleButton;
	JMenuBar mnb_menu;
	JMenu mn_Arquivo;
	JMenuItem mni_Salvar,mni_Carregar,mni_Novo,mni_Sair;
	JFileChooser jf_chooser;
	TratadorMenu tr_menu;
	TratadorBotoes tr_botoes;
	TrataMouse tr_mouseListener;
	TrataMouseMotion tr_mouseMotion;
	int x,y, jf_retorno;
	int xDrag,yDrag,curXdrag,curYdrag;
	boolean Drag;
	String caminho;
	File file;


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

		bg_toggleButton = new ButtonGroup();

		jf_chooser = new JFileChooser();
		caminho="";
		file = null;
		
		
		
		mnb_menu = new JMenuBar();
		mn_Arquivo = new JMenu("Arquivo");

		pn_arvore = new JPanel();
		pn_barraFerramentas = new JPanel();
		pn_menu = new JPanel();

		mni_Novo = new JMenuItem("Novo");
		mni_Salvar = new JMenuItem("Salvar");
		mni_Sair = new JMenuItem("Sair");
		mni_Carregar = new JMenuItem("Carregar");

		tr_menu = new TratadorMenu();
		tr_botoes = new TratadorBotoes();
		tr_mouseListener = new TrataMouse();

		tree = new JTree();

		mn_Arquivo.add(mni_Novo);
		mn_Arquivo.add(mni_Salvar);
		mn_Arquivo.add(mni_Carregar);
		mn_Arquivo.add(mni_Sair);

		mni_Novo.addActionListener(tr_menu);
		mni_Salvar.addActionListener(tr_menu);
		mni_Carregar.addActionListener(tr_menu);
		mni_Sair.addActionListener(tr_menu);

		mnb_menu.add(mn_Arquivo);


		//tree.setCellRenderer();
		//getContentPane().add(new JScrollPane(tree));

		pn_arvore.add(new JScrollPane(tree));

		pn_menu.add(mnb_menu);


		btg_ator = new JToggleButton(createImageIcon("imagem/AtorBarra.jpg" , "Ator"));
		bg_toggleButton.add(btg_ator);        
		pn_barraFerramentas.add(btg_ator);
		//pn_barraFerramentas.add(Box.createHorizontalStrut(10));

		btg_entidade = new JToggleButton(createImageIcon("imagem/EntidadeBarra.jpg" , "Entidade"));
		bg_toggleButton.add(btg_entidade);
		pn_barraFerramentas.add(btg_entidade);
		//pn_barraFerramentas.add(Box.createHorizontalStrut(10));

		btg_editar = new JToggleButton("Editar");
		bg_toggleButton.add(btg_editar);
		btg_editar.addActionListener(tr_botoes);
		pn_barraFerramentas.add(btg_editar);


		bt_limpar = new JButton("Limpar");
		bt_limpar.addActionListener(tr_botoes);
		pn_barraFerramentas.add(bt_limpar);


		//pn_barraFerramentas.add(Box.createHorizontalStrut(10));


		getContentPane().add(pn_menu,BorderLayout.WEST);
		getContentPane().add(pn_barraFerramentas, BorderLayout.NORTH);
		//getContentPane().add(pn_barraFerramentas,BorderLayout.NORTH);
		
		//new BorderLayout();
		//telaDesenho.add(pn_arvore, BorderLayout.EAST);

		telaDesenho.addMouseListener(tr_mouseListener);
		telaDesenho.addMouseMotionListener(tr_mouseMotion);



	}


	protected static ImageIcon createImageIcon(String path,
			String description) {
		java.net.URL imgURL = TelaDesenho.class.getResource(path);

		if (imgURL != null) {
			return new ImageIcon(imgURL, description);
		} else {
			System.err.println("Couldn't find file: " + path);
			return null;
		}
	}


	private class TratadorBotoes implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {

			if(e.getSource().equals(bt_limpar))
			{
				bg_toggleButton.clearSelection();
				telaDesenho.limpar();
				telaDesenho.repaint();
			}
		}

	}  

	private class TratadorMenu implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {

			if(arg0.getSource().equals(mni_Novo)){
				bg_toggleButton.clearSelection();
				telaDesenho.limpar();
				telaDesenho.repaint();
			}
			if(arg0.getSource().equals(mni_Salvar)){
				jf_retorno = jf_chooser.showSaveDialog(telaDesenho);
				
				if(jf_retorno == JFileChooser.APPROVE_OPTION){
					file = jf_chooser.getSelectedFile();
				}
				try{
					telaDesenho.salvarTela(file);
				}catch(IOException ex){
					 JOptionPane.showMessageDialog(DesenhoFrame.this, "Erro ao salvar no arquivo");
				}

			}
			if(arg0.getSource().equals(mni_Carregar)){	
				jf_retorno = jf_chooser.showOpenDialog(telaDesenho);

				if(jf_retorno == JFileChooser.APPROVE_OPTION){
					file = jf_chooser.getSelectedFile();
				}try {
					telaDesenho.carregaTela(file);
					repaint();
					JOptionPane.showMessageDialog(DesenhoFrame.this, "Arquivo carregado com sucesso!");
				} catch (Exception exc) {
					JOptionPane.showMessageDialog(DesenhoFrame.this, "Erro ao ler do arquivo");
				}
			}
			if(arg0.getSource().equals(mni_Sair)){
				System.exit(0);
			}

		}

		/*private void salvarTela(File file) throws FileNotFoundException, IOException{
			FileOutputStream fo_salvar = new FileOutputStream(file);
			ObjectOutputStream oo_salvar = new ObjectOutputStream(fo_salvar);
			oo_salvar.reset();
			oo_salvar.writeObject(telaDesenho.listaFiguras);
			oo_salvar.close();
			fo_salvar.close();
		}
		*/
	}

	private class TrataMouse implements MouseListener{

		@Override
		public void mouseClicked(MouseEvent e) {
			x=e.getX();
			System.out.println(e.getX());
			y=e.getY();
			System.out.println(e.getY());
			String nome = "";

			if(btg_ator.isSelected()){
				Ator at = new Ator(x, y);

				at.setNome(JOptionPane.showInputDialog(nome));


				telaDesenho.addFigura(at);
				telaDesenho.repaint();
				bg_toggleButton.clearSelection();
			}
			else if(btg_entidade.isSelected()){
				Entidade ent = new Entidade(x, y);

				ent.setNome(JOptionPane.showInputDialog(nome));

				telaDesenho.addFigura(ent);
				telaDesenho.repaint();
				bg_toggleButton.clearSelection();
			}
			else if(btg_editar.isSelected()){
				int x,y;
				x = e.getX();
				y = e.getY();
				for (int i = 0; i < telaDesenho.listaFiguras.size(); i++) {
					telaDesenho.listaFiguras.get(i);
					for (int j = 0; j < 40; j++) {

					}
				}

			}
		}
		@Override
		public void mouseEntered(MouseEvent e) {

		}
		@Override
		public void mouseExited(MouseEvent e) {

		}
		@Override
		public void mousePressed(MouseEvent e) {

		}
		@Override
		public void mouseReleased(MouseEvent e) {

		}

	}

	private class TrataMouseMotion implements MouseMotionListener{
		@Override
		public void mouseDragged(MouseEvent e) {
			if((x == e.getX()) || (y == e.getY())){
				seleciona(x,y);
			}
		}
		@Override
		public void mouseMoved(MouseEvent e) {

		}
	}

	public int seleciona(int x, int y){
		int index = 0;

		for (int i = 0; i < telaDesenho.listaFiguras.size(); i++) {



		}   	

		return index;
	}

	/*public void carregaTela(File file) throws FileNotFoundException, IOException, ClassNotFoundException {
		FileInputStream fi_carregar = new FileInputStream(file);
        ObjectInputStream oi_carregar = new ObjectInputStream(fi_carregar);
        telaDesenho.listaFiguras = (List<Figura>) oi_carregar.readObject();
        
        oi_carregar.close();
        fi_carregar.close();
	}
*/



}
