package CRUD;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.util.zip.CheckedInputStream;

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
	JButton btnNovo, btnRemover, btnSair;
	DefaultListModel<String> acoeslista;
	String nome, idade, aux;
	
	public static void main(String[] args) {
		new CRUD();
		
	}
	
	public CRUD(){
		instanciarComponentes(); //cria��o de todos os componentes do sistema
		
		janela.getContentPane().setLayout(new BorderLayout());
		
		acoesMenus(); //ActionListeners dos menus
		
		eventosMenus(); //setMnemonic(KeyEvent) dos menus
		
		setItensMenuArquivo(); //seta todos os itens do menu arquivo
		
		setItensMenuBar(); //todos os menus do CRUD
		
		janela.add(barra, BorderLayout.NORTH);
		
		janela.add(lista);
		
		acionarBotoes(); //fun��es dos bot�es do CRUD
		
		painelBotoes.setLayout(new FlowLayout());
		painelBotoes.add(btnNovo);
		painelBotoes.add(btnRemover);
		painelBotoes.add(btnSair);
		
		janela.add(painelBotoes, BorderLayout.SOUTH);
				
		janela.setDefaultCloseOperation(janela.EXIT_ON_CLOSE);
		janela.setVisible(true);
		janela.setSize(280, 250);
		janela.setResizable(false);
		
	}

	
	private void setItensMenuBar() {
		barra.add(menuArquivo);
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
		btnSair 	= new JButton("Sair");
		painelBotoes 	= new JPanel();
		
	}

	private void acionarBotoes() {
		//ao clicar no bot�o 'novo' do CRUD � solicitada 
		//a inser��o de nome e idade de pessoas para o sistema
		
		btnNovo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				nome = JOptionPane.showInputDialog("Digite o nome: ");
				idade = JOptionPane.showInputDialog("Digite a idade: ");
				aux = nome + " " + idade;
				acoeslista.addElement(aux);
			}
		});
		
		//ao clicar no bot�o 'remover' do CRUD � removido
		//o registro previamente selecionado no sistema
		
		btnRemover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				acoeslista.remove(lista.getSelectedIndex());
			}
		});
		
		//ao clicar no bot�o 'cancelar' � encerrado o sistema
		
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
	}

	private void acoesMenus() {
		//ao clicar no item 'novo' do menu 'arquivo' � solicitada 
		//a inser��o de nome e idade de pessoas para o sistema
		
		itemNovo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				nome = JOptionPane.showInputDialog("Digite o nome: ");
				idade = JOptionPane.showInputDialog("Digite a idade: ");
				aux = nome + " " + idade;
				acoeslista.addElement(aux);
			}
		});
		
		//ao clicar no item 'remover' do menu � removido
		//o registro previamente selecionado no sistema
		
		itemRemover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				acoeslista.remove(lista.getSelectedIndex());
			}
		});
		
		
		//ao clicar no item 'sair' do menu 'arquivo' o sistema � fechado
		
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
