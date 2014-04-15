package CRUD;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.security.KeyStore;
import java.util.zip.CheckedInputStream;

import javax.swing.Box;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

public class CRUD extends JFrame{

	JFrame janela;
	JMenuBar barra;
	JMenu menuArquivo, menuAjuda;
	JMenuItem itemNovo, itemEditar, itemRemover, itemSair;
	JList<String> lista;
	JPanel painelBotoes;
	JButton btnNovo, btnRemover, btnSair;
	DefaultListModel<String> acoeslista;
	String nome, idade, aux;
	
	public static void main(String[] args) {
		new CRUD();
		
	}
	
	public CRUD(){
		instanciarComponentes(); //criação de todos os componentes do sistema
		
		janela.getContentPane().setLayout(new BorderLayout());
		
		acoesMenus(); //ActionListeners dos menus
		
		definirEventos(); //setMnemonic(KeyEvent) dos menus
		
		setItensMenuArquivo(); //seta todos os itens do menu arquivo
		
		setItensMenuBar(); //todos os menus do CRUD
		
		janela.add(barra, BorderLayout.NORTH);
		
		janela.add(lista);
		
		acionarBotoes(); //funções dos botões do CRUD
		
		painelBotoes.setLayout(new FlowLayout());
		setPainelBotoes();
				
		janela.add(painelBotoes, BorderLayout.SOUTH);
		
		setConfigFrame(); //configurações gerais do Frame		
	}
	
	private void setPainelBotoes() {
		painelBotoes.add(btnNovo);
		painelBotoes.add(btnRemover);
		painelBotoes.add(btnSair);
		
	}

	private void setConfigFrame() {
		janela.setDefaultCloseOperation(janela.EXIT_ON_CLOSE);
		janela.setVisible(true);
		janela.setSize(280, 250);
		janela.setResizable(false);
		
	}

	private void setItensMenuBar() {
		barra.add(menuArquivo);
		barra.add(Box.createHorizontalGlue());
		barra.add(menuAjuda);
		
	}

	private void setItensMenuArquivo() {
		menuArquivo.add(itemNovo);
		menuArquivo.add(itemEditar);
		menuArquivo.add(itemRemover);
		menuArquivo.addSeparator();
		menuArquivo.add(itemSair);
		
	}

	private void instanciarComponentes() {
		janela 			= new JFrame("CRUD");		
		barra 			= new JMenuBar();
		menuArquivo 	= new JMenu("Arquivo");
		menuAjuda 		= new JMenu("Ajuda");
		itemNovo 		= new JMenuItem("Novo");
		itemEditar 		= new JMenuItem("Editar");
		itemRemover 	= new JMenuItem("Remover");
		itemSair 		= new JMenuItem("Sair");
		acoeslista 		= new DefaultListModel<>();
		lista 			= new JList<String>(acoeslista);
		btnNovo 		= new JButton("Novo");
		btnRemover 		= new JButton("Remover");
		btnSair 		= new JButton("Sair");
		painelBotoes 	= new JPanel();
		
	}

	private void acionarBotoes() {
		//ao clicar no botão 'novo' do CRUD é solicitada 
		//a inserção de nome e idade de pessoas para o sistema
		
		btnNovo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				janela.setVisible(false);
				nome = JOptionPane.showInputDialog("Digite o nome: ");
				idade = JOptionPane.showInputDialog("Digite a idade: ");
				janela.setVisible(true);
				aux = nome + " " + idade;
				acoeslista.addElement(aux);
			}
		});
		
		//ao clicar no botão 'remover' do CRUD é removido
		//o registro previamente selecionado no sistema
		
		btnRemover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				acoeslista.remove(lista.getSelectedIndex());
			}
		});
		
		//ao clicar no botão 'cancelar' é encerrado o sistema
		
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
	}

	private void acoesMenus() {
		//ao clicar no item 'novo' do menu 'arquivo' é solicitada 
		//a inserção de nome e idade de pessoas para o sistema
		
		itemNovo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				janela.setVisible(false);
				nome = JOptionPane.showInputDialog("Digite o nome: ");
				idade = JOptionPane.showInputDialog("Digite a idade: ");
				janela.setVisible(true);
				aux = nome + " " + idade;
				acoeslista.addElement(aux);
			}
		});
		
		//ao clicar no item 'editar' no meu 'arquivo' é solicitada
		//a alteração do nome e idade da pessoa previamente selecionada no CRUD
		itemEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				janela.setVisible(false);
				String[] pessoa = lista.getSelectedValue().split(" ");
				
				nome = JOptionPane.showInputDialog("Edite o nome: ", pessoa[0]);
				idade = JOptionPane.showInputDialog("Edite o nome: ", pessoa[1]);
				aux = nome + " " + idade;

				acoeslista.setElementAt(aux, lista.getSelectedIndex());
				janela.setVisible(true);
			}
		});
		
		
		//ao clicar no item 'remover' do menu é removido
		//o registro previamente selecionado no sistema
		
		itemRemover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				acoeslista.remove(lista.getSelectedIndex());
			}
		});
		
		
		//ao clicar no item 'sair' do menu 'arquivo' o sistema é fechado
		
		itemSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		
	}
	
	private void definirEventos() {
		menuArquivo.setMnemonic(KeyEvent.VK_A);
		menuAjuda.setMnemonic(KeyEvent.VK_J);
		
		itemNovo.setMnemonic(KeyEvent.VK_N);
		itemEditar.setMnemonic(KeyEvent.VK_E);
		itemRemover.setMnemonic(KeyEvent.VK_R);
		itemSair.setMnemonic(KeyEvent.VK_S);
		itemSair.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_W, ActionEvent.CTRL_MASK));
		
		
		btnNovo.setMnemonic(KeyEvent.VK_N);
		btnRemover.setMnemonic(KeyEvent.VK_R);
		btnSair.setMnemonic(KeyEvent.VK_S);
	}
	
}
