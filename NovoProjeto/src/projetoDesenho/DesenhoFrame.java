package projetoDesenho;

import java.awt.BorderLayout;

import javax.swing.Action;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JToggleButton;
import javax.swing.JToolBar;

public class DesenhoFrame {
	
	JFrame janela;
	JToolBar barraFerramentas;
	JToggleButton jtbAtor, jtbUseCase;
	ButtonGroup grupoBotoes;
	PainelDesenho painelDesenho;
	int x, y;
	
	
	private void iniciarComponentes(){
		janela = new JFrame("UCDiagram");
		barraFerramentas = new JToolBar();
		jtbAtor = new JToggleButton("Ator");
		jtbUseCase = new JToggleButton("Caso");
		grupoBotoes = new ButtonGroup();
		
		grupoBotoes.add(jtbAtor);
		grupoBotoes.add(jtbUseCase);
		barraFerramentas.add(jtbAtor);
		barraFerramentas.add(jtbUseCase);
		janela.getContentPane().add(barraFerramentas, BorderLayout.NORTH);
	}
	
	public DesenhoFrame(){
		iniciarComponentes();
		
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		janela.setResizable(true);
		janela.setSize(700, 500);
        janela.setVisible(true);
	}
	
	
}
