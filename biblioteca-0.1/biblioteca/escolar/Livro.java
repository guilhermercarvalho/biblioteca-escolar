package biblioteca.escolar;

public class Livro {

    private String nomeLivro; // variável de instância
    private String editoraLivro; // variável de instância
    private String codigoLivro; // variável de instância
    private String[] autoresLivro; // variável de instância
    private int numeroPaginas; // variável de instância
    private boolean disponivelParaEmprestimo; // variável de instância

    // Construtor de Livro que recebe cinco parâmetros
    public Livro(String nome, String editora, String codigo, String[] autores, int paginas) {
        this.nomeLivro = nome; // atribui nome à atributo nomeLivro
        this.editoraLivro = editora; // atribui editora à atributo editoraLivro

        if (validaISBN(codigo)) { // verifica se código ISBN de treze dígitos é válido
            this.codigoLivro = codigo;
        }

        if (autores.length <= 3) { // verifica de se o número de autores do livro é menor que três
            this.autoresLivro = autores;
        }

        if (paginas > 0) { // verifica se o número de páginas é maior que zero
            this.numeroPaginas = paginas;
        }

        // atribui true à disponível para empréstimo, indicando que
        // sempre que um livro for cadastrado eles estará inicialmente disponível
        this.disponivelParaEmprestimo = true;
    }

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
    }

    public static void main(String[] args) {
        String[] aut = {"augusto", "gil", "mike"};

        Livro t1 = new Livro("A", "editora", "978 - 85 - 333 - 0227 - 3", aut, 2);

        System.out.println(t1.validateIsbn13("978-85-8057-014-S"));
    }

    public boolean validateIsbn13(String isbn) {
        if (isbn == null) {
            return false;
        }

        // remove any hyphens
        isbn = isbn.replaceAll("-", "");

        // must be a 13 digit ISBN
        if (isbn.length() != 13) {
            return false;
        }

        try {
            int tot = 0;
            for (int i = 0; i < 12; i++) {
                int digit = Integer.parseInt(isbn.substring(i, i + 1));
                tot += (i % 2 == 0) ? digit * 1 : digit * 3;
            }

            // checksum must be 0-9. If calculated as 10 then = 0
            int checksum = 10 - (tot % 10);
            if (checksum == 10) {
                checksum = 0;
            }

            return checksum == Integer.parseInt(isbn.substring(12));
        } catch (NumberFormatException nfe) {
            // to catch invalid ISBNs that have non-numeric characters in them
            return false;
        }
    }

    // método para imprimir todos os atributos de um livro
    public void imprimeInformacoesLivro() {
//        System.out.println("\tINFORMAÇÕES SOBRE O LIVRO\t");

        System.out.printf("Nome: %s%n"
                + "Editora: %s%n"
                + "Código ISBN13: %s%n",
                this.nomeLivro, this.editoraLivro, this.codigoLivro);
        
        // imprime autores do livro
        System.out.print("Autor(es): ");
        String autores = autoresLivro[0] + ", "; // variável do String que armazena autores
        // caso haja mais de um, inicia-se um looping para adicionar os demais
        // autores na váriável 'autores'
        if (this.autoresLivro.length > 1) {
            for (int i = 1; i < autoresLivro.length; i++) {
                autores += autoresLivro[i] + ", ";
            }
        }
        System.out.print(autores + "\n"); // variável autores é exibida na tela.
        autores = null;

        System.out.printf("Páginas: %s%n", numeroPaginas);

        System.out.print("Disponível para empréstimo: ");
        if (disponivelParaEmprestimo) {
            System.out.println("Sim\n");
        } else {
            System.out.println("Não\n");
        }
    }
    
    public boolean equals(Livro livro) {
        if(this.nomeLivro.equals(livro.getNomeLivro()) &&
            this.codigoLivro.equals(livro.getCodigoLivro()))
            return true;
        
        return false;
    }

}
