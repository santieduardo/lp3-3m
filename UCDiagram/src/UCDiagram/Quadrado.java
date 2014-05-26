package UCDiagram;



import java.awt.Graphics;

public class Quadrado extends Figura {
	private int x, y, tam;

	public Quadrado(int x, int y) {
		this.x = x;
		this.y = y;
		this.tam = 10;
	}

	public Quadrado(int x, int y, int tam) {
		this.x = x;
		this.y = y;
		this.tam = tam;
	}

	@Override
	public void desenhar(Graphics desenho) {
		desenho.fillRect(x, y, tam, tam);

	}

}
