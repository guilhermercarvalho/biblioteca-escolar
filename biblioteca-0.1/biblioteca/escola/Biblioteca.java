/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biblioteca.escola;

import biblioteca.utilidades.Ordenacao;

/**
 * Classe gerenciadora da Biblioteca
 * @author Guilherme R. de Carvalho <guilhermercarvalho512 at gmail.com>
 * @version 0.1
 */
public class Biblioteca {

    private final Usuario[] usuarios;
    private final Livro[] livros;

    private int contUsuarios = 0; // indica número total de usuários na biblioteca
    private int contLivros = 0; // indica número total de livros na biblioteca

    private int posLivro = 0; // indica a posição do livro encontrado no método 'livroCadastrado'
    private int posUsuario = 0; // indica a posição do usuário encontrado no método 'usuarioCadastrado'

    public Biblioteca() {
        usuarios = new Usuario[30];
        livros = new Livro[50];
    }

    public boolean cadastrarLivro(String nome, String editora, String codigo, String[] autores, int paginas) {
        if (!verificaEspacoLivro()) { // verifica se há livros cadastrados na biblioteca
            livroMessagens('b');
            return false;
        }

        boolean livroCadastrado = false; // variável de controle para finalizar for encontrar posição nula no vetor 'livros'
        boolean temIgual = false; // variável indica se foi encontrado livro já cadastrado

        Livro novoLivro = new Livro(nome, editora, codigo, autores, paginas); // instancia novo livro

        int i;
        for (i = contLivros; !livroCadastrado && !temIgual && i < livros.length; i++) {
            if (livros[i] == null) {
                posLivro = i;
                livroCadastrado = true;
            } else if (livros[i] != null) {
                temIgual = livros[i].ehIgual(novoLivro);
            }
        }
        if (livroCadastrado) {
            livros[posLivro] = novoLivro; // adiciona livro em posição nula encontrada
            contLivros++; // incrementa número de livros cadastrados
            Ordenacao.ordena(livros, contLivros); // ordena livros sempre que novo livro é cadastrado
            livroMessagens('z');
            return true;
        }
        if (temIgual) {
            livroMessagens('a');
        }
        return false;
    }

    private void livroMessagens(char x) {
        switch (x) {
            case 'a':
                System.err.println("Livro já está cadastrado!");
                break;
            case 'b':
                System.err.println("Biblioteca sem espaço!");
                break;
            case 'c':
                System.err.println("Não há livros cadastrados na biblioteca!");
                break;
            default:
                System.out.println("Livro cadastrado!");
                break;
        }
    }

    private boolean verificaEspacoLivro() {
        return contLivros < this.livros.length;
    }

    public boolean emprestarLivro(String codigoLivro, String cpfUsuario) {
        if (!livroEstaCadastrado(codigoLivro) && !usuarioEstaCadastrado(cpfUsuario)) { // verifica se livro e usuário estão cadastrados
            return false;
        }

        boolean livroEmprestado = false;

        if (this.usuarios[this.posUsuario].isAtivo() && this.livros[posLivro].isDisponivelParaEmprestimo()) {
            livroEmprestado = this.usuarios[this.posUsuario].emprestaLivro(this.livros[this.posLivro]);
        }
            
        if (livroEmprestado) {
            this.livros[this.posLivro].setDisponivelParaEmprestimo(false);
            return true;
        }
        return false;
    }

    public boolean devolverLivro(String codigoLivro, String cpfUsuario) {
        if (!livroEstaCadastrado(codigoLivro) && !usuarioEstaCadastrado(cpfUsuario)) {
            return false;
        }

        boolean livroDevolvido = false;

        if (this.usuarios[this.posUsuario].isAtivo() && !this.livros[this.posLivro].isDisponivelParaEmprestimo()) {
            livroDevolvido = this.usuarios[this.posUsuario].devolveLivro(this.livros[this.posLivro]);
        }

        return livroDevolvido;
    }

    public boolean livroEstaCadastrado(String codigo) {
        if (contLivros == 0) {
            livroMessagens('c'); // "Não há livros cadastrados na biblioteca!"
            return false;
        }

        for (int i = 0; i < contLivros; i++) {
            if (this.livros[i] != null && this.livros[i].ehIgual(codigo)) {
                this.posLivro = i;
                return true;
            }
        }
        return false;
    }

    public void imprimeInformacoesLivros() {
        System.out.println(String.format("%20s", "").replace(" ", "-----"));
        System.out.println("\t\tLivros Cadastrados na Biblioteca\t\t");

        if (contLivros == 0) {
            livroMessagens('c'); // "Não há livros cadastrados na biblioteca!"
        } else {
            for (int i = 0; i < contLivros; i++) {
                livros[i].imprimeInformacoesLivro();
                System.out.println(String.format("%20s", "").replace(" ", "-----"));
            }
        }
    }

    public boolean cadastrarUsuario(String nome, String cpf, String endereco, String telefone) {
        if (!verificaEspacoUsuario()) {
            usuarioMessagens('b');
            return false;
        }

        boolean usuarioCadastrado = false;
        boolean temIgual = false;

        Usuario novoUsuario = new Usuario(nome, cpf, endereco, telefone);

        int i;
        for (i = contUsuarios; !usuarioCadastrado && !temIgual && i < usuarios.length; i++) {
            if (usuarios[i] == null) {
                posUsuario = i;
                usuarioCadastrado = true;
            } else {
                temIgual = usuarios[i].ehIgual(novoUsuario);
            }
        }
        if (usuarioCadastrado) {
            usuarios[posUsuario] = novoUsuario;
            contUsuarios++;
            Ordenacao.ordena(usuarios, contUsuarios);
            livroMessagens('z');
            return true;
        }
        if (temIgual) {
            usuarioMessagens('a');
        }
        return false;
    }

    private void usuarioMessagens(char x) {
        switch (x) {
            case 'a':
                System.err.println("Usuário já está cadastrado!");
                break;
            case 'b':
                System.err.println("Biblioteca sem espaço!");
                break;
            case 'c':
                System.out.println("Não há usuários cadastrados na biblioteca!");
                break;
            case 'd':
                System.out.println("Usuário ativado!");
            case 'e':
                System.out.println("Usuário desativado!");
            case 'f':
                System.err.println("Usuário não encontrado!");
            default:
                System.out.println("Usuário cadastrado!");
                break;
        }
    }

    private boolean verificaEspacoUsuario() {
        return contUsuarios < this.usuarios.length;
    }

    public void ativarUsuario(String cpf) {
        // Validar CPF
        if (usuarioEstaCadastrado(cpf)) {
            usuarios[posUsuario].setAtivo(true);
            usuarioMessagens('d');
        }
    }

    public void desativarUsuario(String cpf) {
        if (usuarioEstaCadastrado(cpf)) {
            usuarios[posUsuario].setAtivo(false);
            usuarioMessagens('e');
        }
    }

    public boolean usuarioEstaCadastrado(String cpf) {
        if (contUsuarios == 0) { // não há usuários cadastrados na biblioteca
//            livroMessagens('c');
            return false;
        }

        for (int i = 0; i < contUsuarios; i++) {
            if (this.usuarios[i] != null && usuarios[i].ehIgual(cpf)) {
                this.posUsuario = i;
                return true;
            }
        }
        return false;
    } // fim do usuarioEstaCadastrado

    public void imprimeInformacoesUsuarios() {
        System.out.println(String.format("%20s", "").replace(" ", "-----"));
        System.out.println("\t\tUsuários Cadastrados na Biblioteca\t\t");

        if (contUsuarios == 0) { // não há livros cadastrados na biblioteca
            usuarioMessagens('c');
        } else {
            for (int i = 0; i < contUsuarios; i++) {
                usuarios[i].imprimeInformacoesUsuario();
                System.out.println(String.format("%20s", "").replace(" ", "-----"));
            }
        }
    } // fim método imprimeInformacoesUsuarios
}
