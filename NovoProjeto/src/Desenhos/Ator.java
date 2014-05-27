package Desenhos;

import java.awt.Graphics;


public class Ator extends Desenho {
	int x, y;
	int tam = 10;

	public Ator(int x, int y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public void desenha(Graphics grafico) {
		grafico.fillOval(x, y, tam, tam);
	}
}
