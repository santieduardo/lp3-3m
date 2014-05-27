package projetoDesenho;

import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JPanel;

import Desenhos.Desenho;

public class PainelDesenho extends JPanel {
	ArrayList<Desenho> listaDesenhos;

	public PainelDesenho() {
		listaDesenhos = new ArrayList<Desenho>();
	}

	public void adicionarDesenho(Desenho desenho) {
		listaDesenhos.add(desenho);
	}

	public void limpar() {
		listaDesenhos.clear();
	}

	@Override
	protected void paintComponent(Graphics grafico) {
		super.paintComponent(grafico);
		grafico.clearRect(0, 0, 1000, 1000);

		for (Desenho d : listaDesenhos) {
			d.desenha(grafico);
		}
	}

}
