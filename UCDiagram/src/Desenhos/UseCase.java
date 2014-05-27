package Desenhos;

import java.awt.Graphics;


public class UseCase extends Desenho {
	int x, y, tam;

	public UseCase(int x, int y) {
		this.x = x;
		this.y = y;
		this.tam = 10;
	}

	public UseCase(int x, int y, int tam) {
		this.x = x;
		this.y = y;
		this.tam = tam;
	}

	@Override
	public void desenha(Graphics grafico) {
		grafico.fillRect(x, y, tam, tam);
	}
}
