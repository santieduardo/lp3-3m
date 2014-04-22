import java.awt.BorderLayout;

import javax.swing.Box;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JToolBar;

public class App extends JFrame{
	
	JFrame janela;
	JToolBar barraTools;
	JPanel painelTools, painelDesenho;
	ImageIcon iconeCirculo, iconeQuadrado, iconeTexto, iconeLimpar;
	JButton btnCirculo, btnQuadrado, btnTexto, btnLimpar;
	
	public App(){
		instanciarComponentes();
		
		janela.getContentPane().setLayout(new BorderLayout());
		
		adicionarIcones();
		
		
		janela.add(painelDesenho, BorderLayout.CENTER);
		
		
		setConfigFrame();
	}
	
	private void instanciarComponentes(){
		janela = new JFrame("Desenhos");
		barraTools = new JToolBar();
		painelTools = new JPanel();
		painelDesenho = new JPanel();
		iconeCirculo = new ImageIcon("imagens/circulo.jpg");
		btnCirculo = new JButton(iconeCirculo);
		iconeQuadrado = new ImageIcon("imagens/quadrado.jpg");
		btnQuadrado = new JButton(iconeQuadrado);
		iconeTexto = new ImageIcon("imagens/texto.jpg");
		btnTexto = new JButton(iconeTexto);
		iconeLimpar = new ImageIcon("imagens/limpar.jpg");
		btnLimpar = new JButton(iconeLimpar);
		
	}
	
	private void adicionarIcones(){
		barraTools.add(btnCirculo);
		barraTools.add(Box.createHorizontalStrut(5));
		barraTools.add(btnQuadrado);
		barraTools.add(Box.createHorizontalStrut(5));
		barraTools.add(btnTexto);
		barraTools.add(Box.createHorizontalStrut(5));
		barraTools.add(btnLimpar);
		barraTools.add(Box.createHorizontalStrut(5));
		painelTools.add(barraTools);
		janela.add(painelTools, BorderLayout.NORTH);
	}
	
	private void setConfigFrame(){
		janela.setDefaultCloseOperation(janela.EXIT_ON_CLOSE);
		janela.setVisible(true);
		janela.setSize(300, 300);
		janela.setResizable(true);
	}
	
	
	public static void main(String[] args) {
		new App();
	}
	
	

}
