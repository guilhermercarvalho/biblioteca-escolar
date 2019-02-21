public class Livro
{
  // Atributos
  private String nomeLivro, editoraLivro, codigoLivro;
  private String[] autoresLivro;
  private int numeroPaginas;
  private boolean disponivelParaEmprestimo;

  // Método construtor da classe Livro.
  /*
	Pré-condição: recebe como parâmetro três variáveis do tipo String, um vetor do tipo String e uma variável do tipo inteiro (todos os atributos).
	Pós-condição: instancia todos os atributos.
	*/
  public Livro(String nome, String editora, String codigo, String[] autores, int paginas) {
    this.setNomeLivro(nome);
    this.setEditoraLivro(editora);
    this.setCodigoLivro(codigo);
    this.setAutoresLivro(autores);
    this.setNumeroPaginas(paginas);
    this.setDisponivelParaEmprestimo(false);
  }

  // Método para retornar o atributo disponivelParaEmprestimo.
  /*
	Pré-condição: não recebe parâmetro.
	Pós-condição: retorna atributo do tipo boolean.
	*/
  public boolean getDisponivelParaEmprestimo(){
    return this.disponivelParaEmprestimo;
  }

  // Método para alterar o atributo disponivelParaEmprestimo.
  /*
	Pré-condição: recebe uma variável do tipo boolean como parâmetro.
	Pós-condição: altera valor do atributo disponivelParaEmprestimo e não retorna nada.
	*/
  public void setDisponivelParaEmprestimo(boolean disponibilidade) {
    this.disponivelParaEmprestimo = disponibilidade;
  }

  // Método para retornar o atributo nomeLivro.
  /*
	Pré-condição: não recebe parâmetro.
	Pós-condição: retorna atributo do tipo String.
	*/
  public String getNomeLivro() {
    return this.nomeLivro;
  }

  // Método para alterar o atributo nomeLivro.
  /*
	Pré-condição: recebe uma variável do tipo String como parâmetro.
	Pós-condição: altera valor do atributo nomeLivro e não retorna nada.
	*/
  public void setNomeLivro(String nome) {
      this.nomeLivro = nome;
  }

  // Método para retornar o atributo editoraLivro.
  /*
	Pré-condição: não recebe parâmetro.
	Pós-condição: retorna atributo do tipo String.
	*/
  public String getEditoraLivro(){
    return this.editoraLivro;
  }

  // Método para alterar o atributo editoraLivro.
  /*
	Pré-condição: recebe uma variável do tipo String como parâmetro.
	Pós-condição: altera valor do atributo editoraLivro e não retorna nada.
	*/
  public void setEditoraLivro(String editora) {
    this.editoraLivro = editora;
  }

  // Método para retornar o atributo codigoLivro.
  /*
	Pré-condição: não recebe parâmetro.
	Pós-condição: retorna atributo do tipo String.
	*/
  public String getCodigoLivro(){
    return this.codigoLivro;
  }

  // Método para alterar o atributo codigoLivro.
  /*
	Pré-condição: recebe uma variável do tipo String como parâmetro.
	Pós-condição: altera valor do atributo codigoLivro e não retorna nada.
	*/
  public void setCodigoLivro(String codigo) {
    if(codigo.length() == 13)
      this.codigoLivro = codigo;
  }

  // Método para retornar o atributo autoresLivro.
  /*
	Pré-condição: não recebe parâmetro.
	Pós-condição: retorna atributo vetor do tipo String.
	*/
  public String[] getAutoresLivro(){
    return this.autoresLivro;
  }

  // Método para alterar o atributo autoresLivro.
  /*
	Pré-condição: recebe um vetor do tipo String como parâmetro.
	Pós-condição: altera valor do atributo autoresLivro e não retorna nada.
	*/
  public void setAutoresLivro(String[] autores) {
    if(autores.length > 0 && autores.length <= 3)
      this.autoresLivro = autores;
  }

  // Método para retornar o atributo numeroPaginas.
  /*
	Pré-condição: não recebe parâmetro.
	Pós-condição: retorna atributo do tipo inteiro.
	*/
  public int getNumeroPaginas(){
    return this.numeroPaginas;
  }

  // Método para alterar o atributo numeroPaginas.
  /*
	Pré-condição: recebe uma variável do tipo inteiro como parâmetro.
	Pós-condição: altera valor do atributo numeroPaginas e não retorna nada.
	*/
  public void setNumeroPaginas(int paginas) {
    if(paginas > 0)
      this.numeroPaginas = paginas;
  }

  // Método para imprimir na tela informações sobre o livro.
  /*
	Pré-condição: não recebe parâmetro.
	Pós-condição: imprime todos os atributos e não retorna nada.
	*/
  public void imprimeInformacoesLivro () {
    System.out.println("--------------------------------------------------");
    System.out.println("Nome Livro: " + getNomeLivro() + ".");
    System.out.println("Editora: " + getEditoraLivro() + ".");
    System.out.println("Código ISBN: " + getCodigoLivro() + ".");
    System.out.print("Autor(es): ");
    if(getAutoresLivro() != null){
      for(int i = 0; i < getAutoresLivro().length; i++) {
        System.out.print(getAutoresLivro()[i]);
        if((i + 1) < getAutoresLivro().length)
        System.out.print(", ");
        else
        System.out.println(".");
      }
    }

    System.out.printf("Número de páginas: %03d.\n", getNumeroPaginas());

    System.out.print("Disponibilidade: ");
    if(getDisponivelParaEmprestimo())
      System.out.println("Disponível.\n");
    else
      System.out.println("Indisponível.\n");
  }
}
