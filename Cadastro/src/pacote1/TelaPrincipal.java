/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pacote1;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;

/**
 *
 * @author lhries
 */
public class TelaPrincipal extends JFrame{
    JList listaPessoas;
    JButton botaoNovo, botaoEditar, botaoRemover;
    JPanel painelBotoes;
    
    
    public TelaPrincipal()
    {
        super("CRUD de Pessoas");
        iniciaComponentes();
        
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300,300);
        setVisible(true);
        
        
    }

    private void iniciaComponentes() {
        listaPessoas = new JList();
        
        botaoNovo = new JButton("Novo");
        TratadorBotoes tratadorBotoes = new TratadorBotoes(this);
        botaoNovo.addActionListener(tratadorBotoes);
        botaoEditar = new JButton("Editar");
        botaoRemover = new JButton("Remover");
        
        painelBotoes = new JPanel();
        painelBotoes.setLayout(new FlowLayout());
        painelBotoes.add(botaoNovo);
        painelBotoes.add(botaoEditar);
        painelBotoes.add(botaoRemover);
        
        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(listaPessoas,BorderLayout.CENTER);
        getContentPane().add(painelBotoes,BorderLayout.SOUTH);
    }
    
    
    
}
