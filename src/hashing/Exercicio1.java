package hashing;

import java.util.Scanner;
public class Exercicio1 {
	static int Alimentacao = 0;
	static int Higiene = 0;
	static int Limpeza = 0;
	static int Vestuario = 0;

	public static class produto {
		int chave;
		produto prox;
		String descricao;

	}

	static int tam = 4; // tamanho da função de hashing
	static produto tabela[] = new produto[tam];
	static Scanner entrada = new Scanner(System.in);

	public static void inserir(int pos, int n, String descricao) {
		produto novo;//
		novo = new produto();
		novo.chave = n;
		novo.descricao = descricao;
		novo.prox = tabela[pos];
		tabela[pos] = novo;
		cont(n);

	}

	static int funcao_hashing(int num) {
		return num % tam;
	}

	static void mostrar_hashPorTipo(char n) {
		produto aux;

		switch (n) {
		case 'A':
			aux = tabela[1];
			if (aux == null) {
				System.out.println("Nao existem produtos cadastrados.");
			} else {
				System.out.println("Produtos do tipo A - Alimentacao:");
				int i = 1;
				while (aux != null) {
					System.out.println(i + ": " + aux.descricao);
					aux = aux.prox;
					i++;
				}
			}
			break;
		case 'H':
			aux = tabela[2];
			if (aux == null) {
				System.out.println("Nao existem produtos cadastrados.");
			} else {
				System.out.println("Produtos do tipo H - Higiene:");
				int i = 1;
				while (aux != null) {

					System.out.println(i + ": " + aux.descricao);
					aux = aux.prox;
					i++;
				}
			}
			break;
		case 'L':
			aux = tabela[3];
			if (aux == null) {
				System.out.println("Nao existem produtos cadastrados.");
			} else {
				System.out.println("Produtos do tipo L - Limpeza:");
				int i = 1;
				while (aux != null) {

					System.out.println(i + ": " + aux.descricao);
					aux = aux.prox;
					i++;
				}
			}
			break;
		case 'V':
			aux = tabela[0];
			if (aux == null) {
				System.out.println("Nao existem produtos cadastrados.");
			} else {
				System.out.println("Produtos do tipo V - Vestuario:");
				int i = 1;
				while (aux != null) {
					System.out.println(i + ": " + aux.descricao);
					aux = aux.prox;
					i++;
				}

			}
			break;
		}
	}

	public static void cont(int chave) {
		char t = (char) chave;
		switch (t) {
		case 1:
			Alimentacao++;
			break;
		case 2:
			Higiene++;
			break;
		case 3:
			Limpeza++;
			break;
		case 4:
			Vestuario++;
			break;
		}

	}

	static void mostrar_hash() {
		System.out.println("Alimentacao - " + Alimentacao + " Produtos");
		System.out.println("Higiene - " + Higiene + " Produtos");
		System.out.println("Limpeza - " + Limpeza + " Produtos");
		System.out.println("Vestuario - " + Vestuario + " Produtos");

	}

	public static void main(String[] args) {
		int op, pos;
		int num;
		char escolha;
		String descricao;

		do {
			System.out.println("\n MENU DE OPCOES\n");
			System.out.println("1 - Inserir produto");
			System.out.println("2 - Consultar todos os produtos cadastrados de um tipo");
			System.out.println("3 - Consultar quantos produtos estao cadastrados em cada tipo");
			System.out.println("4 - Sair");
			System.out.println("Digite sua opcao: ");
			op = entrada.nextInt();

			if (op < 1 || op > 4)
				System.out.println("opcao invalida");
			else {
				switch (op) {
				case 1:
					System.out.println("\n 1 - Alimentacao, 2 - higiene, 3 - limpeza e 4 - vestuario\n");
					System.out.println("Digite o tipo do produto: ");
					num = entrada.nextInt();
					System.out.println("Digite a descricao do produto: ");
					descricao = entrada.next();
					pos = funcao_hashing(num);
					inserir(pos, num, descricao);
					break;
				case 2:
					System.out.println("\n A - Alimentacao, H - higiene, L - limpeza e V - vestuario\n");
					System.out.println("Digite o tipo do produto que deseja consultar: ");
					escolha = entrada.next().charAt(0);
					;
					mostrar_hashPorTipo(escolha);
					break;
				case 3:
					mostrar_hash();
					break;
				}
			}
		} while (op != 4);

	}
}