import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JToolBar;

public class Tela {

	JFrame janela;
	JToolBar barraFerramentas;
	ImageIcon iconeAbrir, iconeAtor, iconeNovo, iconeSalvar, iconeUseCase;
	JButton btnIconeAbrir, btnIconeAtor, btnIconeNovo, btnIconeSalvar, btnIconeUseCase;
	JList<String> listaProjeto;
	DefaultListModel<String> acoesProjeto;
	JPanel painelArvore, painelDesenho;
	JSplitPane painelSplit;
	
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
		btnIconeAbrir.setName("btnInoceAbrir");
		btnIconeAbrir.addActionListener(new tratadorBotoes());
		
		btnIconeAtor = new JButton(iconeAtor);
		btnIconeAtor.setName("btnInoceAtor");
		btnIconeAtor.addActionListener(new tratadorBotoes());
		
		btnIconeNovo = new JButton(iconeNovo);
		btnIconeNovo.setName("btnInoceNovo");
		btnIconeNovo.addActionListener(new tratadorBotoes());
		
		btnIconeSalvar = new JButton(iconeSalvar);
		btnIconeSalvar.setName("btnInoceSalvar");
		btnIconeSalvar.addActionListener(new tratadorBotoes());
		
		btnIconeUseCase = new JButton(iconeUseCase);
		btnIconeUseCase.setName("btnInoceUseCase");
		btnIconeUseCase.addActionListener(new tratadorBotoes());
		
		acoesProjeto = new DefaultListModel<>();
		
		listaProjeto = new JList<String>(acoesProjeto);
		
		painelArvore = new JPanel();
		painelDesenho = new JPanel();
		
		painelSplit = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, painelArvore, painelDesenho);
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
		painelArvore.add(listaProjeto);
		
		//painelDesenho.setBackground(Color.BLUE);
		painelSplit.setDividerLocation(250);
		janela.add(painelSplit);
	}
	
	private void setConfigFrame(){		
		janela.setDefaultCloseOperation(janela.EXIT_ON_CLOSE);
		janela.setSize(800, 600);
		janela.setVisible(true);
	}
	
	public static void main(String[] args) {
		new Tela();	
	}

	
	
	private class tratadorBotoes implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() instanceof JButton){
				String nomeBotao = ((JButton) e.getSource()).getName();
				
				
			}
			
		}
		
	}
	
}
