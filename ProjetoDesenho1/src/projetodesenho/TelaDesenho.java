/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package projetodesenho;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

/**
 *
 * @author lhries
 */
public class TelaDesenho extends JPanel{
    
    public TelaDesenho(){        
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawLine(100, 100, 200, 200);
        g.setColor(Color.GREEN);
        g.drawRect(100, 100, 200, 200);
    }
    
    
    
}
