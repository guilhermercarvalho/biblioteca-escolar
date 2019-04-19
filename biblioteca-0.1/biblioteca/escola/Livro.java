package biblioteca.escola;

import biblioteca.utilidades.Ordenacao;

/**
 * 
 * @author Guilherme R. de Carvalho <guilhermercarvalho512 at gmail.com>
 * @version 0.1
 */
public class Livro {

    private String nomeLivro; // variável de instância
    private String editoraLivro; // variável de instância
    private String codigoLivro; // variável de instância
    private String[] autoresLivro; // variável de instância
    private int numeroPaginas; // variável de instância
    private boolean disponivelParaEmprestimo; // variável de instância

    // Construtor de Livro que recebe cinco parâmetros
    public Livro(String nome, String editora, String codigo, String[] autores, int paginas) {
        this.nomeLivro = nome;
        this.editoraLivro = editora;

        if (codigo.length() == 13) { // verifica se código ISBN de treze dígitos é válido
            this.codigoLivro = codigo;
        }

        this.autoresLivro = autores;
        Ordenacao.ordena(autoresLivro, autoresLivro.length); // ordena vetor de autores em ordem alfabética

        if (paginas > 0) { // verifica se o número de páginas é maior que zero
            this.numeroPaginas = paginas;
        }

        // atribui true à disponível para empréstimo, indicando que
        // sempre um novo livro cadastrado estará inicialmente disponível
        this.disponivelParaEmprestimo = true;
    } // fim do método construtor

    public String getNomeLivro() {
        return nomeLivro;
    }

    public void setNomeLivro(String nomeLivro) {
        this.nomeLivro = nomeLivro;
    }

    public String getEditoraLivro() {
        return editoraLivro;
    }

    public void setEditoraLivro(String editoraLivro) {
        this.editoraLivro = editoraLivro;
    }

    public String getCodigoLivro() {
        return codigoLivro;
    }

    public void setCodigoLivro(String codigoLivro) {
        this.codigoLivro = codigoLivro;
    }

    public String[] getAutoresLivro() {
        return autoresLivro;
    }

    public void setAutoresLivro(String[] autoresLivro) {
        this.autoresLivro = autoresLivro;
    }

    public int getNumeroPaginas() {
        return numeroPaginas;
    }

    public void setNumeroPaginas(int numeroPaginas) {
        this.numeroPaginas = numeroPaginas;
    }

    public boolean isDisponivelParaEmprestimo() {
        return disponivelParaEmprestimo;
    }

    public void setDisponivelParaEmprestimo(boolean disponivelParaEmprestimo) {
        this.disponivelParaEmprestimo = disponivelParaEmprestimo;
    }

    // método para valida código ISBN de treze dígitos
    private boolean validaISBN(String isbn) {
        if (isbn == null) {
            return false;
        }

        try {
            int tot = 0;
            for (int i = 0; i < 12; i++) {
                int digito = Integer.parseInt(isbn.substring(i, i + 1));

                if (i % 2 == 0) {
                    tot += digito * 1;
                } else {
                    tot += digito * 3;
                }
            }

            int verificador = 10 - (tot % 10);
            if (verificador == 10) {
                verificador = 0;
            }

            return verificador == Integer.parseInt(isbn.substring(12));
        } catch (NumberFormatException msg) {
            return false;
        }
    } // fim método validaISBN

    // método para imprimir todos os atributos de um livro
    public void imprimeInformacoesLivro() {
        System.out.println("Nome: " + this.nomeLivro);
        System.out.println("Editora: " + this.editoraLivro);
        System.out.println("Código ISBN13: " + this.codigoLivro);

        // imprime autores do livro
        System.out.print("Autor(es): ");
        String autores = autoresLivro[0] + ", "; // variável String que armazena autores
        // caso haja mais de um, inicia-se um for para adicionar os demais
        // autores na String 'autores'

        if (this.autoresLivro.length > 1) {
            for (int i = 1; i < autoresLivro.length; i++) {
                if (autoresLivro[i] != null) {
                    autores += autoresLivro[i] + ", ";
                }
            }
        }
        autores = autores.substring(0, autores.length()-2); // remove última vírgula da String

        System.out.println(autores); // exibe nome dos autores
        autores = null; // após exibida String é explicitamente apagada

        System.out.printf("Páginas: %03d%n", numeroPaginas);

        System.out.print("Disponível para empréstimo: ");
        if (disponivelParaEmprestimo) {
            System.out.println("Sim");
        } else {
            System.out.println("Não");
        }
    } // fim método imprimeInformacoesLivro

    public boolean ehIgual(Livro livro) {
        // compara atributos específicos dos livros
        return this.codigoLivro.equals(livro.getCodigoLivro())
                && this.nomeLivro.equalsIgnoreCase(livro.getNomeLivro());
    } // fim método ehIgual
    
    public boolean ehIgual(String codigo) {
        // compara atributos específicos dos livros
        return this.codigoLivro.equals(codigo);
    } // fim método ehIgual

    @Override
    public String toString() { // converte objeto livro em uma string para realizar comparação
        return this.nomeLivro;
    } // fim método toString
}
