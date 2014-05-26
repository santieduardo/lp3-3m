package projetodesenho;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;

public class TelaDesenho extends JPanel {
	List<Figura> listaFiguras;

	public TelaDesenho() {
		listaFiguras = new ArrayList<Figura>();
	}

	public void adicionarFigura(Figura figura) {
		listaFiguras.add(figura);
	}

	public void limpar() {
		listaFiguras.clear();
	}

	@Override
	protected void paintComponent(Graphics desenho) {
		super.paintComponent(desenho);
		
		desenho.clearRect(0, 0, 500, 500);
		
		for (Figura figura : listaFiguras) {
			figura.desenhar(desenho);
		}
	}

}
