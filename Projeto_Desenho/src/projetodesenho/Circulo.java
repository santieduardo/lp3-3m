package projetodesenho;

import java.awt.Graphics;

public class Circulo extends Figura {
	int x, y;
	int tam = 10;

	public Circulo(int x, int y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public void desenhar(Graphics desenho) {
		desenho.fillOval(x, y, tam, tam);

	}

}
