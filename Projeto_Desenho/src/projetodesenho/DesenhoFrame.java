package projetodesenho;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.awt.event.MouseWheelEvent;

import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JToggleButton;
import javax.swing.JToolBar;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

class DesenhoFrame extends JFrame {

	TelaDesenho telaDesenho;
	JToolBar barraFerramentas;
	ImageIcon iconeAbrir, iconeAtor, iconeNovo, iconeSalvar, iconeUseCase;
	JButton btnLimpar, btnIconeAbrir, btnIconeAtor, btnIconeNovo, btnIconeSalvar, btnIconeUseCase;;
	JPanel painelArvore;
	JSplitPane painelSplit;
	int x;
	int y;

	public DesenhoFrame() {
		super("Tela de Desenho");
		iniciaComponentes();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setSize(500, 500);
		setVisible(true);
	}

	private void iniciaComponentes() {
		telaDesenho = new TelaDesenho();
		painelSplit = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, painelArvore, telaDesenho);
		//getContentPane().add(painelArvore);
		painelSplit.setDividerLocation(250);
		//painelArvore.setBackground(Color.BLUE);
		getContentPane().add(painelSplit);
		
		TratadorBotoes tratadorBotoes = new TratadorBotoes();

		barraFerramentas = new JToolBar();

		iconeAbrir = new ImageIcon("imagens/abrir.gif");
		iconeAtor = new ImageIcon("imagens/ator.gif");
		iconeNovo = new ImageIcon("imagens/novo.jpg");
		iconeSalvar = new ImageIcon("imagens/salvar.png");
		iconeUseCase = new ImageIcon("imagens/useCase.gif");

		btnIconeAbrir = new JButton(iconeAbrir);
		btnIconeAbrir.setName("btnInoceAbrir");
		

		btnIconeAtor = new JButton(iconeAtor);
		btnIconeAtor.setName("btnInoceAtor");
		

		btnIconeNovo = new JButton(iconeNovo);
		btnIconeNovo.setName("btnInoceNovo");

		btnIconeSalvar = new JButton(iconeSalvar);
		btnIconeSalvar.setName("btnInoceSalvar");
		
		
		btnIconeUseCase = new JButton(iconeUseCase);
		btnIconeUseCase.setName("btnInoceUseCase");

		btnLimpar = new JButton("Limpar");
		btnLimpar.addActionListener(tratadorBotoes);
		
		barraFerramentas.add(btnIconeNovo);
		barraFerramentas.add(btnIconeAbrir);
		barraFerramentas.add(btnIconeSalvar);
		barraFerramentas.addSeparator();
		barraFerramentas.add(btnIconeAtor);
		barraFerramentas.add(btnIconeUseCase);
		barraFerramentas.addSeparator();
		barraFerramentas.add(btnLimpar);

		getContentPane().add(barraFerramentas, BorderLayout.NORTH);
		
		telaDesenho.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				x = e.getX();
				y = e.getY();

				if(e.getSource() instanceof JButton){
					
					if (btnIconeAtor.isSelected()) {
					Circulo circulo = new Circulo(x, y);
					telaDesenho.adicionarFigura(circulo);
					telaDesenho.repaint();

				} else if (ferramentaQuadrado.isSelected()) {
					Quadrado quadrado = new Quadrado(x, y);
					telaDesenho.adicionarFigura(quadrado);
					telaDesenho.repaint();

				}
				}
				
				
			}
		});

	}

	private class TratadorBotoes implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			if (e.getSource().equals(ferramentaCirculo)) {

				Circulo circ = new Circulo(x, y);

				telaDesenho.adicionarFigura(circ);
				telaDesenho.repaint();
			} else if (e.getSource().equals(ferramentaQuadrado)) {
				int x = Integer.parseInt(JOptionPane.showInputDialog("X: "));
				int y = Integer.parseInt(JOptionPane.showInputDialog("Y: "));
				int tam = Integer.parseInt(JOptionPane
						.showInputDialog("Tamanho: "));

			} else if (e.getSource().equals(btnLimpar)) {
				ferramentaQuadrado.setSelected(false);
				ferramentaCirculo.setSelected(false);
				telaDesenho.limpar();
				telaDesenho.repaint();
			}
		}

	}
}
