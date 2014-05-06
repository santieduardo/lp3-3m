import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.Box;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class Tela {

	JFrame janela;
	JMenuBar barraMenu;
	JMenu menuArquivo, menuAjuda;
	JMenuItem itemNovo, itemAbrir, itemCarregar, itemSair;
	JList<String> listaProjeto;
	DefaultListModel<String> acoesProjeto;
	JPanel painelProjeto;
	
	public Tela(){
		instanciarComponentes();
		janela.getContentPane().setLayout(new BorderLayout());
		
		iniciarBarraMenus();
		iniciarListaProjetos();
		
		
		setConfigFrame();
	}
	
	private void instanciarComponentes(){
		janela = new JFrame("UCDiagram - Sistema Casos de Uso");
		barraMenu = new JMenuBar();
		menuAjuda = new JMenu("Ajuda");
		menuArquivo = new JMenu("Arquivo");
		itemNovo = new JMenuItem("Novo");
		itemAbrir = new JMenuItem("Abrir");
		itemCarregar = new JMenuItem("Carregar");
		itemSair = new JMenuItem("Sair");
		acoesProjeto = new DefaultListModel<>();
		listaProjeto = new JList<String>(acoesProjeto);
		painelProjeto = new JPanel();
	}
	
	private void iniciarBarraMenus(){
		menuArquivo.add(itemNovo);
		menuArquivo.add(itemAbrir);
		menuArquivo.add(itemCarregar);
		menuArquivo.addSeparator();
		menuArquivo.add(itemSair);
		barraMenu.add(menuArquivo);
		barraMenu.add(Box.createHorizontalGlue());
		barraMenu.add(menuAjuda);
		janela.add(barraMenu, BorderLayout.NORTH);
	}
	
	private void iniciarListaProjetos(){
		janela.add(listaProjeto, BorderLayout.WEST);
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
