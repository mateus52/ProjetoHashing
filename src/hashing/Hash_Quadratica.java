package hashing;

import java.util.Scanner;
public class Hash_Quadratica {

	public static class hash {
		int chave;
		char livre;
	}

	static int tam = 10; // tamanho da função de hashing
	static hash tabela[] = new hash[tam];
	static Scanner entrada = new Scanner(System.in);

	public static void inserir(int n) {
		int pos = funcao_hashing(n);
		int k = 1;
		while (k <= tam && tabela[pos].livre != 'L' && tabela[pos].livre != 'R') {

			pos = (pos + k) % tam;
			k = k + 1;
		}
		if (k <= tam) {
			tabela[pos].chave = n;
			tabela[pos].livre = 'O';
		} else
			System.out.println("Tabela cheia ou em loop!");
	}

	public static void remover(int n) {
		int posicao = buscar(n);
		if (posicao < tam)
			tabela[posicao].livre = 'R';
		else
			System.out.println("Elemento nao esta presente.");
	}

	public static int buscar(int n) {
		int pos = funcao_hashing(n);
		int k = 1;
		while (k <= tam && tabela[pos].livre != 'L' && tabela[pos].chave != n) {
			pos = (pos + k) % tam;
			k = k + 1;
		}
		if (tabela[pos].chave == n && tabela[pos].livre != 'R')
			return pos;
		else
			return tam;
	}

	static int funcao_hashing(int num) {
		return num % tam;
	}

	static void mostrar_hash() {
		for (int i = 0; i < tam; i++)
			if (tabela[i].livre == 'O')
				System.out.println("Entrada" + i + ": " + tabela[i].chave);
	}

	public static void main(String[] args) {
		int op;
		int num, i;

		// inicializacao da tabela
		for (i = 0; i < tam; i++) {
			tabela[i] = new hash();
			tabela[i].livre = 'L';

		}

		do {
			System.out.println("\n MENU DE OPCOES\n");
			System.out.println("1 - Inserir elemento");
			System.out.println("2 - Mostrar tabele hashing");
			System.out.println("3 - Excluir elemento");
			System.out.println("4 - Sair");
			System.out.println("Digite sua opcao: ");
			op = entrada.nextInt();

			if (op < 1 || op > 4)
				System.out.println("opcao invalida");
			else {
				switch (op) {
				case 1:
					System.out.println("Digite um numero: ");
					num = entrada.nextInt();
					inserir(num);
					break;
				case 2:
					mostrar_hash();
					break;
				case 3:
					System.out.println("digite um numero: ");
					num = entrada.nextInt();
					remover(num);
					break;
				}
			}

		} while (op != 4);
	}

}