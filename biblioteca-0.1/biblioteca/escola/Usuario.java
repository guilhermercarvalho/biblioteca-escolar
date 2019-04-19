package biblioteca.escola;

import biblioteca.utilidades.Ordenacao;

/**
 *
 * @author Guilherme R. de Carvalho <guilhermercarvalho512 at gmail.com>
 * @version 0.1
 */
public class Usuario {

    private String nome;
    private String cpf;
    private String endereco;
    private String telefone;
    private boolean ativo;
    private Livro[] livrosEmprestados;

    private int contLivrosUsuario = 0;

    // Construtor de Usuario que recebe quatro parâmetros
    public Usuario(String nome, String cpf, String endereco, String telefone) {
        this.nome = nome;
        this.cpf = cpf;
        this.endereco = endereco;
        this.telefone = telefone;
        this.ativo = true;
        this.livrosEmprestados = new Livro[3];
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public Livro[] getLivrosEmprestados() {
        return livrosEmprestados;
    }

    public void setLivrosEmprestados(Livro[] livrosEmprestados) {
        this.livrosEmprestados = livrosEmprestados;
    }

    // método adiciona livro ao vetor de livros do usuário
    public boolean emprestaLivro(Livro livroEmprestado) {
        for (int i = 0; i < livrosEmprestados.length; i++) {
            if (livrosEmprestados[i] == null) { // caso posição seja nula, livro é adicionado
                livrosEmprestados[i] = livroEmprestado;
                contLivrosUsuario++;
                Ordenacao.ordena(livrosEmprestados, contLivrosUsuario); // ordena livros após adicição
                return true;
            }
        }
        return false;
    } // fim método emprestaLivro

    public boolean devolveLivro(Livro livroDevolvido) {
        boolean encontrado = false; // indica se o livro esta com o aluno
        int removido = 0; // indica a posicao do livro removido

        for (int i = 0; !encontrado && i < contLivrosUsuario; i++) {
            if (livrosEmprestados[i].ehIgual(livroDevolvido)) {
                livrosEmprestados[i] = null;
                removido = i;
                encontrado = true;
            }
        }

        // caso livro é encontrado, vetor é reordenado
        if (encontrado) {
            for (int j = livrosEmprestados.length - 1; removido != 2 && j >= 0; j--) { // se o livro na última posição é removido,
                // não há necessidade de reorganizar o vetor
                if (livrosEmprestados[j] != null) {
                    livrosEmprestados[removido] = livrosEmprestados[j];
                    livrosEmprestados[j] = null;
                    contLivrosUsuario--;
                    Ordenacao.ordena(livrosEmprestados, contLivrosUsuario); // ordena livros após adicição
                    return true;
                }
            }
            return true; // caso livro seja encontrado e não haja troca de posição
        }
        return false;
    } // fim método devolveLivro

    public void imprimeInformacoesUsuario() {
        System.out.println("Nome: " + this.nome);
        System.out.println("CPF: " + this.cpf);
        System.out.println("Endereço: " + this.endereco );
        System.out.println("Telefone: " + this.telefone);

        System.out.print("Estatus do usuário: ");
        if (ativo) {
            System.out.println("Ativo");
        } else {
            System.out.println("Inativo");
        }
        
        listaLivrosEmprestados();
    } // fim método imprimeInformacoesUsuario
    
    // método imprime livros emprestados ao usuário
    public void listaLivrosEmprestados() {
        System.out.print("Livros emprestados ao usuário: ");
        // verifica se usuário possui algum livro emprestado
        if (this.livrosEmprestados[0] != null) {
            System.out.println("\n");
            for (Livro livroEmprestado : livrosEmprestados) {
                if (livroEmprestado != null) {
                    livroEmprestado.imprimeInformacoesLivro();
                }
            }
        } else {
            System.out.println("Usuário não possui livros emprestados");
        }
    }
    
    public boolean ehIgual(String cpfUsuario) {
        // compara CPF dos usuários
        return cpfUsuario.equals(this.cpf);
    } // fim método ehIgual
    
    public boolean ehIgual(Usuario usuario) {
        // compara CPF dos usuários
        return usuario.equals(this.cpf);
    } // fim método ehIgual
    
    @Override
    public String toString() { // converte objeto usuário em uma string para realizar comparação
        return this.nome;
    } // fim método toString
}
