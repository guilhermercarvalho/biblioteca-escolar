/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biblioteca.testes;

import biblioteca.escola.Biblioteca;
import java.util.Scanner;

/**
 *
 * @author guilherme
 */
public class BibliotecaTeste {

    private static Scanner teclado = new Scanner(System.in);
    private static Biblioteca biblioteca = new Biblioteca();

    public static void main(String[] args) {

        // Programa para testar funcionamento dos métodos.
        inicializaBiblioteca();

        // atributos para criação dos livros
        String nomeLivro = null, editoraLivro = null, codigoISBN = null;
        int numAutores, paginas = 0;
        String[] vetorAutores = null;

        // atributos para criação dos usuários
        String nomeUsuario = null, cpf = null, endereco = null, telefone = null;

        boolean continuar = true; // varável de execução do menu
        do {

            printMenu();

            switch (teclado.nextInt()) {
                case 1:
                    System.out.println("\tBciblioteca com capacidade máxima de 50 livros\t");

                    adicionaLivro(nomeLivro, editoraLivro, codigoISBN, vetorAutores, paginas);

                    System.out.println(String.format("%20s", "").replace(" ", "-----"));
                    biblioteca.cadastrarLivro(nomeLivro, editoraLivro, codigoISBN, vetorAutores, paginas);
                    System.out.println(String.format("%20s", "").replace(" ", "-----"));
                    break;
                case 2:
                    System.out.println("\tBciblioteca com capacidade máxima de 30 usuários\t");

                    adicionarUsuario(nomeUsuario, cpf, endereco, telefone);

                    System.out.println(String.format("%20s", "").replace(" ", "-----"));
                    biblioteca.cadastrarUsuario(nomeUsuario, cpf, endereco, telefone);
                    System.out.println(String.format("%20s", "").replace(" ", "-----"));
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
                    while (codigoISBN.length() != 13) {
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
                    while (codigoISBN.length() != 13) {
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
                    continuar = false;
                    break;
                default:
                    System.out.println("Valor inválido!");
                    break;
            }
        } while (continuar);
    }

    private static void printMenu() {
        System.out.println("Qual ação deseja realizar?");
        System.out.println("(1) Cadastrar livros na Biblioteca.");
        System.out.println("(2) Cadastrar usuários na Biblioteca.");
        System.out.println("(3) Exibir livros cadastrados na Biblioteca.");
        System.out.println("(4) Exibir usuários cadastrados na Biblioteca.");
        System.out.println("(5) Ativar usuário.");
        System.out.println("(6) Desativar usuário.");
        System.out.println("(7) Realizar empréstimo de um livro.");
        System.out.println("(8) Realizar a devolução de um livro.");
        System.out.println("(0) Sair do programa.");
    }

    private static boolean adicionaLivro(String nomeLivro, String editoraLivro, String codigoISBN, String[] vetorAutores, int paginas) {
        System.out.println("Por favor, cadastre os livros:");

        System.out.print("Digite o nome do livro: \n");
        nomeLivro = teclado.nextLine();

        System.out.print("Digite a editora do livro: \n");
        editoraLivro = teclado.nextLine();

        System.out.print("Digite o código ISBN do livro. Deve conter treze caracteres: \n");
        codigoISBN = teclado.next();
        teclado.nextLine();
        while (codigoISBN.length() != 13) {
            System.out.print("Por favor, digite um valor válido: ");
            codigoISBN = teclado.next();
            teclado.nextLine();
        }

        System.out.print("Digite o nome dos autores do livro: ");

        boolean adicionar = true;

        while (adicionar) {
            for (int i = 0; adicionar && i < vetorAutores.length; i++) {
                vetorAutores[i] = teclado.nextLine();
                teclado.nextLine();

                System.out.println("Deseja adicionar mais autores? TRUE/FALSE");
                adicionar = teclado.nextBoolean();
                teclado.nextLine();
            }

            if (adicionar) {
                System.out.println("Não é possível adicionar mais autores.");
            }
            adicionar = false;
        }

        System.out.print("Digite o número de páginas do livro. Deve ser maior do que zero: \n");
        paginas = teclado.nextInt();
        teclado.nextLine();
        while (paginas <= 0) {
            System.out.print("Por favor, digite um valor válido: ");
            paginas = teclado.nextInt();
            teclado.nextLine();
        }
        return true;
    }

    private static boolean adicionarUsuario(String nomeUsuario, String cpf, String endereco, String telefone) {
        System.out.println("Por favor, cadastre os usuários:");

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

        return true;
    }

    private static void inicializaBiblioteca() {

        String[] autores = {"Autor C", "Autor A", "Autor B"};

        biblioteca.cadastrarLivro("Livro C", "Editora XPTO", "1234567890123", autores, 1);
        biblioteca.cadastrarLivro("Livro A", "Editora XPTO", "1234567890111", autores, 100);
        biblioteca.cadastrarLivro("Livro B", "Editora XPTO", "1234567890222", autores, 10);
        biblioteca.cadastrarLivro("Livro H", "Editora XPTO", "1234567890333", autores, 10);
        biblioteca.cadastrarLivro("Livro D", "Editora XPTO", "1234567890444", autores, 1000);
        biblioteca.cadastrarLivro("Livro E", "Editora XPTO", "1234567890555", autores, 100);
        biblioteca.cadastrarLivro("Livro G", "Editora XPTO", "1234567890666", autores, 371);
        biblioteca.cadastrarLivro("Livro F", "Editora XPTO", "1234567890777", autores, 1);

        biblioteca.cadastrarUsuario("Carlos Nobrega", "123", "Endereço XPTO", "Telefone XPTO");
        biblioteca.cadastrarUsuario("Arthur César", "1234", "Endereço XPTO", "Telefone XPTO");
        biblioteca.cadastrarUsuario("Júliano Henrique", "12345", "Endereço XPTO", "Telefone XPTO");
        biblioteca.cadastrarUsuario("Alberto Marquês", "123456", "Endereço XPTO", "Telefone XPTO");
        biblioteca.cadastrarUsuario("Leandro Pereira", "1234567", "Endereço XPTO", "Telefone XPTO");
    }
}
