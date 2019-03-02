import java.util.Scanner;
public class BibliotecaTeste
{
	public static void main(String[] args)
	{
		Scanner teclado = new Scanner (System.in);
		Biblioteca biblioteca = new Biblioteca();

		System.out.println("Qual ação deseja realizar?");
		System.out.print("(1) Cadastrar livros na Biblioteca.\n(2) Cadastrar usuários na Biblioteca.\n(3) Exibir livros cadastrados na Biblioteca.\n(4) Exibir usuários cadastrados na Biblioteca.\n(5) Ativar usuário.\n(6) Desativar usuário.\n(7) Realizar empréstimo de um livro.\n(8) Realizar a devolução de um livro.\n(0) Sair do programa.\n ");
		int acao = teclado.nextInt();
		String repete = "";

		while(acao < 0 || acao > 8){
			System.out.print("Por favor, digite um valor válido: ");
			acao = teclado.nextInt();
		}

		do {
			System.out.println();
			switch(acao) {
				case 1:
					System.out.print("Quantos livros deseja cadastrar na biblioteca? Capacidade máxima para 50 livros: ");
					int numLivros = teclado.nextInt();
					while(numLivros < 1  || numLivros > 50) {
						System.out.print("Por favor, digite um valor válido: ");
						numLivros = teclado.nextInt();
					}
					teclado.nextLine();

					System.out.println("\nPor favor, cadastre os livros:");
					String nomeLivro, editoraLivro, codigoISBN;
					int numAutores, paginas;
					String[] vetorAutores;
					
					for(int i = 0; i < numLivros; i++) {
						System.out.print("Digite o nome do livro: \n");
						nomeLivro = teclado.nextLine();
						
						System.out.print("Digite a editora do livro: \n");
						editoraLivro = teclado.nextLine();
						
						System.out.print("Digite o código ISBN do livro. Deve conter treze caracteres: \n");
						codigoISBN = teclado.next();
						while(!biblioteca.validaCodigoISBN(codigoISBN)) {
							System.out.print("Por favor, digite um valor válido: ");
							codigoISBN = teclado.next();
						}
						
						System.out.print("Digite o número de autores que o livro possui. Deve ser maior que um e menor ou igual a três: \n");
						numAutores = teclado.nextInt();
						while(!biblioteca.validaAutorLivro(numAutores)){
							System.out.print("Por favor, digite um valor válido: ");
							numAutores = teclado.nextInt();
						}
						vetorAutores = new String [numAutores];

						System.out.print("Digite o nome dos autores do livro: ");
						teclado.nextLine();
						
						for(int j = 0; j < vetorAutores.length; j++) {
							vetorAutores[j] = teclado.nextLine();
						}
						
						System.out.print("Digite o número de páginas do livro. Deve ser maior do que zero: \n");
						paginas = teclado.nextInt();
						while(!biblioteca.validaPagina(paginas)){
							System.out.print("Por favor, digite um valor válido: ");
							paginas = teclado.nextInt();
						}
						teclado.nextLine();
						
						System.out.println("----------------------------------------------------------------------");
						biblioteca.cadastrarLivro(nomeLivro, editoraLivro, codigoISBN, vetorAutores, paginas);
						System.out.print("----------------------------------------------------------------------\n");
					}
					break;
				case 2:
					System.out.print("Quantos usuários deseja cadastrar na biblioteca? Capacidade máxima para 30 usuários: ");
					int numUsuarios = teclado.nextInt();
					while(numUsuarios < 1 || numUsuarios > 30) {
						System.out.print("Por favor, digite um valor válido: ");
						numUsuarios = teclado.nextInt();
					}
					teclado.nextLine();

					System.out.println("Por favor, cadastre os usuários:");
					String nomeUsuario, cpf, endereco, telefone;
					for(int i = 0; i < numUsuarios; i++) {
						System.out.print("Digite o nome do usuário: \n");
						nomeUsuario = teclado.nextLine();
						
						System.out.print("Digite o CPF do usuário: \n");
						cpf = teclado.next();
						teclado.nextLine();
						
						System.out.print("Digite o endereço do usuário: \n");
						endereco = teclado.nextLine();
						
						System.out.print("Digite o telefone do usuário: \n");
						telefone = teclado.next();
						teclado.nextLine();
						
						System.out.println("----------------------------------------------------------------------");
						biblioteca.cadastrarUsuario(nomeUsuario, cpf, endereco, telefone);
						System.out.println("----------------------------------------------------------------------\n");
					}
					break;
				case 3:
					biblioteca.imprimeInformacoesLivros();
					teclado.nextLine();
					break;
				case 4:
					biblioteca.imprimeInformacoesUsuarios();
					teclado.nextLine();
					break;
				case 5:
					System.out.print("CPF do usuário: ");
					cpf = teclado.next();
					biblioteca.ativarUsuario(cpf);
					teclado.nextLine();
					break;
				case 6:
					System.out.print("CPF do usuário: ");
					cpf = teclado.next();
					teclado.nextLine();
					biblioteca.desativarUsuario(cpf);
					break;
				case 7:
					System.out.print("Código ISBN do livro: ");
					codigoISBN = teclado.next();
					while(!biblioteca.validaCodigoISBN(codigoISBN)) {
						System.out.print("Por favor, digite um valor válido: ");
						codigoISBN = teclado.next();
					}
					System.out.print("CPF do usuário: ");
					cpf = teclado.next();
					teclado.nextLine();
					biblioteca.emprestarLivro(codigoISBN, cpf);
					break;
				case 8:
					System.out.print("Código ISBN do livro: ");
					codigoISBN = teclado.next();
					while(!biblioteca.validaCodigoISBN(codigoISBN)) {
						System.out.print("Por favor, digite um valor válido: ");
						codigoISBN = teclado.next();
					}
					System.out.print("CPF do usuário: ");
					cpf = teclado.next();
					teclado.nextLine();
					biblioteca.devolverLivro(codigoISBN, cpf);
					break;
				case 0:
					System.out.println("Fim do programa...");
					break;
				default:
					System.out.println("Valor inválido!");
					break;
			}
				if(acao != 0){
					System.out.print("\nDeseja executar novamente? [S/n] ");
		            repete = teclado.next();
		            if (repete.toLowerCase().equals("s") || repete.toLowerCase().equals("n")) {
		              	if (repete.toLowerCase().equals("n")) {
		       				acao = 0;
		       				System.out.println("Fim do programa...");
		               	}
		            	else {
			           		System.out.println("\nQual ação deseja realizar?");
							System.out.print("(1) Cadastrar livros na Biblioteca.\n(2) Cadastrar usuários na Biblioteca.\n(3) Exibir livros cadastrados na Biblioteca.\n(4) Exibir usuários cadastrados na Biblioteca.\n(5) Ativar usuário.\n(6) Desativar usuário.\n(7) Realizar empréstimo de um livro.\n(8) Realizar a devolução de um livro.\n(0) Sair do programa.\n ");
			            	acao = teclado.nextInt();
		               	} 
					}
		            else{
						System.out.println("Fim do programa...");
						acao = 0;
		            }
	            }
		} while(acao != 0);
	}
}
