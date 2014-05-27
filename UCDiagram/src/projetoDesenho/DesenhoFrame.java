package projetoDesenho;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.Action;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JRootPane;
import javax.swing.JToggleButton;
import javax.swing.JToolBar;

import Desenhos.Ator;
import Desenhos.Linha;
import Desenhos.UseCase;

public class DesenhoFrame {
	
	JFrame janela;
	JToolBar barraFerramentas;
	JToggleButton jtbAtor, jtbUseCase, jtbLinha;
	ButtonGroup grupoBotoes;
	PainelDesenho painelDesenho;
	ImageIcon imageAtor, imageUseCase, imageLinha, imageLimpar, imageNovo, imageAbrir, imageSalvar;
	JButton btnNovo, btnAbrir, btnSalvar, btnLimpar;
	int x, y;
	int x1, x2, y1, y2;
	int presX, presY;
	
	
	private void iniciarComponentes(){
		janela = new JFrame("UCDiagram");
		
		TratadorBotoes tratadorBotoes = new TratadorBotoes();
		
		painelDesenho = new PainelDesenho();
		janela.getContentPane().add(painelDesenho);
		
		barraFerramentas = new JToolBar();
		
		imageAtor = new ImageIcon("imagens/ator.gif");
		imageUseCase = new ImageIcon("imagens/useCase.gif");
		imageLinha = new ImageIcon("imagens/linha.png");
		imageLimpar = new ImageIcon("imagens/limpar.png");
		imageNovo = new ImageIcon("imagens/novo.jpg");
		imageAbrir = new ImageIcon("imagens/abrir.gif");
		imageSalvar = new ImageIcon("imagens/salvar.png");
		
		btnAbrir = new JButton(imageAbrir);
		btnAbrir.setToolTipText("Carrega um documento");
		
		btnNovo = new JButton(imageNovo);
		btnNovo.setToolTipText("Cria um novo documento");
		
		btnSalvar = new JButton(imageSalvar);
		btnSalvar.setToolTipText("Salva as alterações do documento");
		
		btnLimpar = new JButton(imageLimpar);
		btnLimpar.setToolTipText("Limpa toda a áera do painel");
		btnLimpar.addActionListener(tratadorBotoes);
		
		jtbAtor = new JToggleButton(imageAtor);
		jtbAtor.setToolTipText("Desenha um ator no painel");
		
		jtbUseCase = new JToggleButton(imageUseCase);
		jtbUseCase.setToolTipText("Desenha um caso de uso no painel");
		
		jtbLinha = new JToggleButton(imageLinha);
		jtbLinha.setToolTipText("Desenha uma linha/ligação no painel");
		
		grupoBotoes = new ButtonGroup();
		
		grupoBotoes.add(jtbAtor);
		grupoBotoes.add(jtbUseCase);
		grupoBotoes.add(jtbLinha);
		
		barraFerramentas.add(btnNovo);
		barraFerramentas.add(btnAbrir);
		barraFerramentas.add(btnSalvar);
		barraFerramentas.addSeparator();
		barraFerramentas.add(jtbAtor);
		barraFerramentas.add(jtbUseCase);
		barraFerramentas.add(jtbLinha);
		barraFerramentas.addSeparator();
		barraFerramentas.add(btnLimpar);
		janela.getContentPane().add(barraFerramentas, BorderLayout.NORTH);
		
		painelDesenho.addMouseListener(new MouseAdapter() {
			@Override  
            public void mousePressed(MouseEvent e) {  
                presX = e.getX();  
                presY = e.getY();  
            } 
		});
		
		painelDesenho.addMouseMotionListener(new MouseMotionListener() {
			
			@Override
			public void mouseMoved(MouseEvent e) {
				
			}
			
			@Override
			public void mouseDragged(MouseEvent e) {
				int x = e.getX();
				int y = e.getY();
				
				
				int dX = e.getX() - presX;
                int dY = e.getY() - presY;
                int newX = painelDesenho.getX() + dX;
                int newY = painelDesenho.getY() + dY;
                painelDesenho.setLocation(newX, newY);
                
			}
		});
		
		painelDesenho.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				x2 = e.getX();
				y2 = e.getY();
				
				if(jtbLinha.isSelected()){
					Linha linha = new Linha(x1, x2, y1, y2);
					painelDesenho.adicionarDesenho(linha);
					painelDesenho.repaint();
				}
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				x1 = e.getX();
				y1 = e.getY();				
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
				
				if(jtbAtor.isSelected()){
					Ator ator = new Ator(x, y);
					Linha linha = new Linha(x + 10, x + 100, y + 10, y + 10);
					painelDesenho.adicionarDesenho(ator);
					ator.setTexto(JOptionPane.showInputDialog("Digite o ator"));
					painelDesenho.adicionarDesenho(linha);
					painelDesenho.repaint();
				}
				
				if(jtbUseCase.isSelected()){
					UseCase useCase = new UseCase(x, y);
					painelDesenho.adicionarDesenho(useCase);
					useCase.setTexto(JOptionPane.showInputDialog("Digite o Caso de Uso"));
					painelDesenho.repaint();
				}
								
			}
		});
	}
		
	public DesenhoFrame(){
		iniciarComponentes();
		
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		janela.setResizable(false);
		janela.setSize(700, 500);
        janela.setVisible(true);
	}
	
	
	private class TratadorBotoes implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource().equals(btnLimpar)){
				jtbAtor.setSelected(false);
				jtbLinha.setSelected(false);
				jtbUseCase.setSelected(false);
				
				painelDesenho.limpar();
				painelDesenho.repaint();
			}
			
		}
		
	}
	
}
