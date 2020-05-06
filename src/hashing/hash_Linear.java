package hashing;

import java.util.Scanner;

public class hash_Linear {

	public static class hash {

		int chave;
		char livre; // L = Livre, O = Ocupado, R = Removido

	}

	static int tam = 8; // tamanho da funcao de hashing
	static hash tabela[] = new hash[tam];
	static Scanner entrada = new Scanner(System.in);

	public static void inserir(int pos, int n) {
		int i = 0;
		while (i < tam && tabela[(pos + i) % tam].livre != 'L' && tabela[(pos + i) % tam].livre != 'R')
			;
		i = i + 1;

		if (i < tam) {
			tabela[(pos + i) % tam].chave = n;
			tabela[(pos + i) % tam].livre = 'O';

		} else {
			System.out.println("Tabela cheia");
		}
	}

	public static void remover(int n) {
		int posicao = buscar(n);

		if (posicao < tam)
			tabela[posicao].livre = 'R';
		else
			System.out.println("Elemento nao esta presente.");

	}

	public static int buscar(int n) {
		int i = 0;
		int pos = funcao_hashing(n);
		while (i < tam && tabela[(pos + i) % tam].livre != 'L' && tabela[(pos + i) % tam].chave != n)
			i = i + 1;
		if (tabela[(pos + i) % tam].chave == n && tabela[(pos + i) % tam].livre != 'R')
			return (pos + i) % tam;
		else
			return tam; // nao encontrado
	}

	static int funcao_hashing(int num) {
		return num % tam;
	}

	static void mostrar_hash() {

		for(int i = 0; i < tam; i++) {
			if (tabela[i].livre == 'O')
				System.out.println("Entrada "+i+ ":" +tabela[i].chave+ " " + tabela[i].livre);
			
		}
	}
	
	public static void main(String[] args) {
		int op, pos;
		int num, i;
		
		// inicializacao da tabela

		for(i = 0; i < tam; i++) {
			tabela[i] = new hash();
			tabela[i].livre='L';
			
		}
		
		do 
		{
			System.out.println("/n MENU DE OPCOES/n");
			
			System.out.println("1 - Inserir elementos");
			System.out.println("2 - Mostrar tabela hashing");
			System.out.println("3 - Excluir elementos");
			System.out.println("4 - Sair");
			
			System.out.println("Digite a sua opcao: ");
			op = entrada.nextInt();
		
			
			if (op < 1 || op > 4) {
				System.out.println("opcao invalida");
			}
				else
					{
					switch(op) 
					{
					case 1: 
						System.out.println("Digite um numero: ");
						num = entrada.nextInt();
						pos = funcao_hashing(num);
						inserir(pos, num);
						break;
						
					case 2: 
						mostrar_hash();
						break;
						
					case 3:
						System.out.println("Digite um numero: ");
						num = entrada.nextInt();
						remover(num);
						break;
					}
					
					}
			}
			while(op!=4);
			
	
	}
}			