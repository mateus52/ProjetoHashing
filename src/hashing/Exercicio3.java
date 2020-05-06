package hashing;

import java.util.Scanner;

public class Exercicio3 {

	public static class hash {

		int chave; // codigo
		char livre; // L = Livre, O = Ocupado, R = Removido
		String nome;
		double notaFinal;
		

	}

	static int tam = 15; // tamanho da funcao de hashing
	static hash tabela[] = new hash[tam];
	static Scanner entrada = new Scanner(System.in);

	public static void inserir(int pos, int n, String nome, double notaFinal) {
		int i = 0;
		while (i < tam && tabela[(pos + i) % tam].livre != 'L' && tabela[(pos + i) % tam].livre != 'R')
			;
		i = i + 1;

		if (i < tam) {
			hash aluno = new hash();
			tabela[(pos + i) % tam].chave = n;
			aluno.nome = nome;
			aluno.notaFinal = notaFinal;
			tabela[(pos + i) % tam].livre = 'O';

		} else {
			System.out.println("Tabela cheia");
		}
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
		int i = 0;
		hash aux;
		aux = tabela[i];
		for( i = 0; i < tam; i++) {
			if (tabela[i].livre == 'O')
				System.out.println("Entrada "+i+ ":" +tabela[i].chave+ " " + tabela[i].livre + aux.nome + aux.notaFinal );
			
		}
	}
	
	public static void main(String[] args) {
		int op, pos;
		int num, i;
		double nota;
		String name;
		
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
						System.out.println("Digite um codigo: ");
						num = entrada.nextInt();
						System.out.println("Digite nome: ");
						name = entrada.next();
						System.out.println("Digite nota: ");
						nota = entrada.nextDouble();
						pos = funcao_hashing(num);
						inserir(pos, num, name, nota);
						break;
						
					case 2: 
						mostrar_hash();
						break;
						
					case 3:
						
					}
					
					}
			}
			while(op!=4);
			
	
	}
}			