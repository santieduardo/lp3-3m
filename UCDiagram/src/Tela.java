import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class Tela {

	JFrame janela;
	JMenuBar barraMenu;
	JMenu menuArquivo;
	JMenuItem itemNovo;
	
	public Tela(){
		instanciarComponentes();
		
		setConfigFrame();
	}
	
	private void instanciarComponentes(){
		janela = new JFrame("UCDiagram - Sistema de Cadastros");
		barraMenu = new JMenuBar();
		menuArquivo = new JMenu("Arquivo");
		itemNovo = new JMenuItem("Novo");
	}
	
	private void setConfigFrame(){
		janela.setDefaultCloseOperation(janela.EXIT_ON_CLOSE);
		janela.setSize(800, 600);
		janela.setVisible(true);
	}
	
	public static void main(String[] args) {
		new Tela();	
	}

}
