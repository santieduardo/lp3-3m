/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package projetodesenho;

import javax.swing.JFrame;

/**
 *
 * @author lhries
 */
class DesenhoFrame extends JFrame{
    TelaDesenho telaDesenho;
    
    
    public DesenhoFrame() {
        super("Tela de Desenho");
        iniciaComponentes();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 500);
        setVisible(true);    
    }

    private void iniciaComponentes() {
        telaDesenho = new TelaDesenho();
        getContentPane().add(telaDesenho);
    }
    
}
