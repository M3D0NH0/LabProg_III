/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pacote1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author lhries
 */
public class TratadorBotoes implements ActionListener{
    TelaPrincipal tela;
    public TratadorBotoes(TelaPrincipal tela)
    {
        this.tela = tela;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
       FormularioCadastro formulario = new FormularioCadastro();
       tela.setVisible(false);
    }
    
}
