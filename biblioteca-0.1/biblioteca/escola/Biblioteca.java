/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biblioteca.escola;

import biblioteca.utilidades.Ordenacao;

/**
 *
 * @author guilherme
 */
public class Biblioteca {

    private final Usuario[] usuarios;
    private final Livro[] livros;

    private int contUsuarios = 0;
    private int contLivros = 0;

    private int posLivro = 0;
    private int posUsuario = 0;

    public Biblioteca() {
        usuarios = new Usuario[30];
        livros = new Livro[50];
    }

    public boolean cadastrarLivro(String nome, String editora, String codigo, String[] autores, int paginas) {
        if (!verificaEspacoLivro()) {
            livroMessagens('b');
            return false;
        }

        boolean livroCadastrado = false;
        boolean temIgual = false;

        Livro novoLivro = new Livro(nome, editora, codigo, autores, paginas);

        int i;
        for (i = contLivros; !livroCadastrado && !temIgual && i < livros.length; i++) {
            if (livros[i] == null) {
                posLivro = i;
                livroCadastrado = true;
            } else if (livros[i] != null) {
                temIgual = livros[i].equals(novoLivro);
            }
        }
        if (livroCadastrado) {
            livros[posLivro] = novoLivro;
            livroMessagens('c');
            contLivros++;
            Ordenacao.ordena(livros, contLivros);
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
            case 'd':
                System.out.println("Não há livros cadastrados na biblioteca!");
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
        if (!livroEstaCadastrado(codigoLivro) && !usuarioEstaCadastrado(cpfUsuario)) {
            return false;
        }

        boolean livroEmprestado = false;

        if (this.usuarios[this.posUsuario].isAtivo() && this.livros[posLivro].isDisponivelParaEmprestimo()) {
            livroEmprestado = this.usuarios[this.posUsuario].emprestaLivro(this.livros[this.posLivro]);
        }

        return livroEmprestado;
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
            livroMessagens('d'); // "Não há livros cadastrados na biblioteca!"
            return false;
        }

        for (int i = 0; i < contLivros; i++) {
            if (this.livros[i] != null && codigo.equals(this.livros[i].getCodigoLivro())) {
                this.posLivro = i;
                return true;
            }
        }

        return false;
    }

    public void imprimeInformacoesLivros() {
        System.out.println(String.format("%20s", "").replace(" ", "-----"));
        System.out.println("\tLivros Cadastrados na Biblioteca\t");

        if (contLivros == 0) {
            livroMessagens('d'); // "Não há livros cadastrados na biblioteca!"
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
                temIgual = usuarios[i].equals(novoUsuario);
            }
        }
        if (usuarioCadastrado) {
            usuarios[posUsuario] = novoUsuario;
            livroMessagens('c');
            contUsuarios++;
            Ordenacao.ordena(usuarios, contUsuarios);
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
            case 'd':
                System.out.println("Não há livros cadastrados na biblioteca!");
                break;
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
            //exibe msg;
        }
    }

    public void desativarUsuario(String cpf) {
        if (usuarioEstaCadastrado(cpf)) {
            usuarios[posUsuario].setAtivo(false);
            //exibe msg;
        }
    }

    public boolean usuarioEstaCadastrado(String cpf) {
        if (contUsuarios == 0) {
            livroMessagens('d'); // "Não há usuários cadastrados na biblioteca!"
            return false;
        }

        for (int i = 0; i < contUsuarios; i++) {
            if (this.usuarios[i] != null && cpf.equals(this.usuarios[i].getCpf())) {
                this.posUsuario = i;
                return true;
            }
        }

        return false;
    }

    public void imprimeInformacoesUsuarios() {
        System.out.println(String.format("%20s", "").replace(" ", "-----"));
        System.out.println("\tUsuários Cadastrados na Biblioteca\t");

        if (contUsuarios == 0) {
            usuarioMessagens('d'); // "Não há livros cadastrados na biblioteca!"
        } else {
            for (int i = 0; i < contUsuarios; i++) {
                usuarios[i].imprimeInformacoesUsuario();
                System.out.println(String.format("%20s", "").replace(" ", "-----"));
            }
        }
    }
}
