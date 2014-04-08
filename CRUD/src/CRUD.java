import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class CRUD extends JFrame{

	JFrame janela;
	JMenuBar barra;
	JMenu menuArquivo, menuAjuda;
	JMenuItem itemNovo, itemEditar, itemRemover, itemSair;
	JList<String> lista;
	JPanel painelBotoes;
	JButton btnNovo, btnRemover, btnCancelar;
	DefaultListModel<String> acoeslista;
	
	public static void main(String[] args) {
		new CRUD();
		
	}
	
	public CRUD(){		
		janela = new JFrame("CRUD");		
		barra = new JMenuBar();
		menuArquivo = new JMenu("Arquivo");
		menuAjuda = new JMenu("Ajuda");
		itemNovo = new JMenuItem("Novo");
		itemEditar = new JMenuItem("Editar");
		itemRemover = new JMenuItem("Remover");
		itemSair = new JMenuItem("Sair");
		acoeslista = new DefaultListModel<>();
		lista = new JList<String>(acoeslista);
		btnNovo = new JButton("Novo");
		btnRemover = new JButton("Remover");
		btnCancelar = new JButton("Cancelar");
		painelBotoes = new JPanel();
		
		
		janela.getContentPane().setLayout(new BorderLayout());
		
		
		acoesMenus();
		
		eventosMenus();
		
		
		menuArquivo.add(itemNovo);
		menuArquivo.add(itemEditar);
		menuArquivo.add(itemRemover);
		menuArquivo.addSeparator();
		menuArquivo.add(itemSair);
		
		barra.add(menuArquivo);
		barra.add(menuAjuda);
		janela.add(barra, BorderLayout.NORTH);
		
		janela.add(lista);
		
		acoesBotoes();
		
		painelBotoes.setLayout(new FlowLayout());
		painelBotoes.add(btnNovo);
		painelBotoes.add(btnRemover);
		painelBotoes.add(btnCancelar);
		
		janela.add(painelBotoes, BorderLayout.SOUTH);
				
		janela.setDefaultCloseOperation(janela.EXIT_ON_CLOSE);
		janela.setVisible(true);
		janela.setSize(280, 250);
		janela.setResizable(false);
		
	}

	
	private void acoesBotoes() {
		btnNovo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String nome, idade, aux;
				nome = JOptionPane.showInputDialog("Digite o nome: ");
				idade = JOptionPane.showInputDialog("Digite a idade: ");
				aux = nome + " " + idade;
				acoeslista.addElement(aux);
			}
		});
		
		btnRemover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				acoeslista.remove(lista.getSelectedIndex());
			}
		});
		
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
	}

	private void acoesMenus() {
		itemSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		
	}
	
	private void eventosMenus() {
		menuArquivo.setMnemonic(KeyEvent.VK_A);
		menuAjuda.setMnemonic(KeyEvent.VK_J);
		
		itemSair.setMnemonic(KeyEvent.VK_S);
		
	}
	
	
}
