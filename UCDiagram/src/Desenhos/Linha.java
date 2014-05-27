package Desenhos;

import java.awt.Graphics;


public class Linha extends Desenho{
	
	int x1, x2, y1, y2;
	
	public Linha(int x1, int x2, int y1, int y2){
		this.x1 = x1;
		this.x2 = x2;
		this.y1 = y1;
		this.y2 = y2;
	}

	@Override
	public void desenha(Graphics grafico) {
		grafico.drawLine(x1, y1, x2, y2);
	}
	
	
}
