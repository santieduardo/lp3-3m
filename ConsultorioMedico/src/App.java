import java.io.ObjectInputStream.GetField;
import java.util.Scanner;

import javax.xml.bind.ParseConversionEvent;

public class App {

	private static String cmd;
	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		System.out.println(imprimirMenu());
		rodarApp();
	}
	
	private static void lerCMD(String cmd){
		entrarMenu(cmd = sc.next());
	}

	private static boolean avaliarCMD(String cmd){
		if(cmd == "9"){
			System.exit(0);
		}
		return true;
	}
	
	private static void entrarMenu(String cmd) {
		switch (cmd) {
		case "1":
			System.out.println("Opções disponíveis:");
			System.out.println("1 - Cadastro de Pacientes");
			System.out.println("2 - Cadastro de Remédios");
			System.out.println("9 - Voltar");
			System.out.println("Insira o número da opção desejada: ");
			lerCMD(cmd);
			
			//TODO fazer a entrada do submenu
			switch (cmd) {
			case "1":
				System.out.println("+++ CADASTRO DE PACIENTES +++");
				break;
			case "2":
				System.out.println("+++ CADASTRO DE REMÉDIOS +++");
				break;
			case "9":
				rodarApp();
			default:
				System.out.println("Opção Inválida !");
				break;
			}
			
			
			//break;
		case "2":
			System.out.println("Opções disponíveis:");
			break;
		case "3":
			System.out.println("Opções disponíveis:");
			break;
		case "4":
			System.out.println("Opções disponíveis:");
			break;
		case "9":
			System.out.println("+++ SISTEMA ENCERRADO +++");
			System.exit(0);
			break;
		default:
			System.out.println("Opção Inválida !");
			System.out.println(imprimirMenu());
		}
	}

	public static String getCMD(){
		return cmd;
	}
	
	private static void rodarApp(){
		while (avaliarCMD(cmd)) {
			System.out.println("\n\nInsira o número da opção desejada: ");
			lerCMD(cmd);
		}
	}
	
	public static String imprimirMenu() {
		return "--- Consultório Médico ---\n\n" + "1 - Cadastros\n"
				+ "2 - Agenda\n" + "3 - Consultas\n" + "4 - Histórico\n"
				+ "9 - Sair";
	}
	
}