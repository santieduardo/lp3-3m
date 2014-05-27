package Desenhos;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;


public class Ator extends Desenho {
	int x, y;
	int tam = 10;
	String texto;
	
	
	public Ator(int x, int y) {
		this.x = x;
		this.y = y;
		
	}
	
	public void setTexto(String texto){
		this.texto = texto;
	}

	@Override
	public void desenha(Graphics grafico) {
		ImageIcon img = new ImageIcon("imagens/ator.gif");
		Image icon = img.getImage();
		grafico.drawImage(icon, x, y, null);
		grafico.drawString(texto, x, y + 25);
	}
}