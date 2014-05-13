import java.awt.BorderLayout;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JToolBar;

public class Tela {

	JFrame janela;
	JToolBar barraFerramentas;
	ImageIcon iconeAbrir, iconeAtor, iconeNovo, iconeSalvar, iconeUseCase;
	JButton btnIconeAbrir, btnIconeAtor, btnIconeNovo, btnIconeSalvar, btnIconeUseCase;
	JList<String> listaProjeto;
	DefaultListModel<String> acoesProjeto;
	JPanel painelProjeto;
	
	public Tela(){
		instanciarComponentes();
		janela.getContentPane().setLayout(new BorderLayout());
		
		iniciarBarraFerramentas();
		iniciarListaProjetos();
		
		
		setConfigFrame();
	}
	
	private void instanciarComponentes(){
		janela = new JFrame("UCDiagram - Sistema Casos de Uso");
		
		barraFerramentas = new JToolBar();
		
		iconeAbrir = new ImageIcon("imagens/abrir.gif");
		iconeAtor = new ImageIcon("imagens/ator.gif");
		iconeNovo = new ImageIcon("imagens/novo.jpg");
		iconeSalvar = new ImageIcon("imagens/salvar.png");
		iconeUseCase = new ImageIcon("imagens/useCase.gif");
		
		btnIconeAbrir = new JButton(iconeAbrir);
		btnIconeAtor = new JButton(iconeAtor);
		btnIconeNovo = new JButton(iconeNovo);
		btnIconeSalvar = new JButton(iconeSalvar);
		btnIconeUseCase = new JButton(iconeUseCase);
		
		acoesProjeto = new DefaultListModel<>();
		
		listaProjeto = new JList<String>(acoesProjeto);
		
		painelProjeto = new JPanel();
	}
	
	private void iniciarBarraFerramentas(){
		barraFerramentas.add(btnIconeNovo);
		barraFerramentas.add(btnIconeAbrir);
		barraFerramentas.add(btnIconeSalvar);
		barraFerramentas.addSeparator();
		barraFerramentas.add(btnIconeAtor);
		barraFerramentas.add(btnIconeUseCase);
		janela.add(barraFerramentas, BorderLayout.NORTH);
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
