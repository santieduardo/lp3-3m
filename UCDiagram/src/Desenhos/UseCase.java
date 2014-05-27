package Desenhos;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;


public class UseCase extends Desenho {
	int x, y, tam;
	String texto;

	public UseCase(int x, int y) {
		this.x = x;
		this.y = y;
		this.tam = 10;
	}
	
	/*public UseCase(int x, int y, String texto) {
		this.x = x;
		this.y = y;
		this.tam = 10;
		this.texto = texto;
	}*/

	public UseCase(int x, int y, int tam) {
		this.x = x;
		this.y = y;
		this.tam = tam;
	}
	
	public void setTexto(String texto){
		this.texto = texto;
	}
	
	@Override
	public void desenha(Graphics grafico) {
		ImageIcon img = new ImageIcon("imagens/useCase.gif");
		Image icon = img.getImage();
		grafico.drawImage(icon, x, y, null);
		grafico.drawString(texto, x, y + 25);
	}
}
