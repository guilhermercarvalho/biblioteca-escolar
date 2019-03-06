import java.util.Arrays;

public class Usuario
{
  // Atributos
  private String nome, cpf, endereco, telefone;
  private boolean ativo;
  private Livro[] livrosEmprestados;

  // Método construtor da classe Usuario.
  /*
	Pré-condição: recebe como parâmetro quatro variáveis do tipo String.
	Pós-condição: instancia todos os atributos.
	*/
  public Usuario(String nome, String cpf, String endereco, String telefone) {
    this.setNome(nome);
    this.setCpf(cpf);
    this.setEndereco(endereco);
    this.setTelefone(telefone);
    this.setAtivo(false);
    this.livrosEmprestados = new Livro[3];
  }

  // Método para retornar o atributo nome.
  /*
  Pré-condição: não recebe nenhum parâmetro.
  Pós-condição: retorna atributo do tipo String.
  */
  public String getNome() {
    return this.nome;
  }

  // Método para alterar o atributo nome.
  /*
  Pré-condição: recebe uma variável do tipo String como parâmetro .
  Pós-condição: altera valor do atributo e não retorna nada.
  */
  public void setNome(String nome) {
      this.nome = nome;
  }

  // Método para retornar o atributo cpf.
  /*
  Pré-condição: não recebe nenhum parâmetro.
  Pós-condição: retorna atributo do tipo String.
  */
  public String getCpf() {
    return this.cpf;
  }

  // Método para alterar o atributo cpf.
  /*
  Pré-condição: recebe uma variável do tipo String como parâmetro .
  Pós-condição: altera valor do atributo e não retorna nada.
  */
  public void setCpf(String cpf) {
      this.cpf = cpf;
  }

  // Método para retornar o atributo endereco.
  /*
  Pré-condição: não recebe nenhum parâmetro.
  Pós-condição: retorna atributo do tipo String.
  */
  public String getEndereco() {
    return this.endereco;
  }

  // Método para alterar o atributo endereco.
  /*
  Pré-condição: recebe uma variável do tipo String como parâmetro .
  Pós-condição: altera valor do atributo e não retorna nada.
  */
  public void setEndereco(String endereco) {
      this.endereco = endereco;
  }

  // Método para retornar o atributo telefone.
  /*
  Pré-condição: não recebe nenhum parâmetro.
  Pós-condição: retorna atributo do tipo String.
  */
  public String getTelefone() {
    return this.telefone;
  }

  // Método para alterar o atributo telefone.
  /*
  Pré-condição: recebe uma variável do tipo String como parâmetro .
  Pós-condição: altera valor do atributo e não retorna nada.
  */
  public void setTelefone(String telefone) {
    this.telefone = telefone;
  }

  // Método para retornar o atributo ativo.
  /*
  Pré-condição: não recebe nenhum parâmetro.
  Pós-condição: retorna atributo do tipo boolean.
  */
  public boolean getAtivo() {
    return this.ativo;
  }

  // Método para alterar o atributo ativo.
  /*
  Pré-condição: recebe uma variável do tipo boolean como parâmetro .
  Pós-condição: altera valor do atributo e não retorna nada.
  */
  public void setAtivo(boolean estaAtivo) {
    this.ativo = estaAtivo;
  }

  // Método para imprimir informações sobre o usuário.
  /*
  Pré-condição: não recebe nenhum parâmetro.
  Pós-condição: imprime todos os atributos da classe na tela e não retorna nada.
  */
  public void imprimeInformacoesUsuario() {
    System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++");
    System.out.println("Nome Usuário: " + getNome());
    System.out.println("CPF: " + getCpf());
    System.out.println("Endereço: " + getEndereco());
    System.out.println("Telefone: " + getTelefone());
    System.out.print("Situação do usuário: ");
    if(getAtivo())
      System.out.println("Ativo.");
    else
      System.out.println("Inativo.");
  }

  // Método para emprestar um livro para um usuário.
  /*
  Pré-condição: recebe uma variável do tipo Livro como parâmetro.
  Pós-condição: retorna um boolean. True caso a operação tenha sido realizada com sucesso e false caso contrário.
  */
  public boolean emprestaLivro(Livro livro)
  {
    boolean temEspaco = false, temIgual = false;
    int posicaoEmprestar = 0;
    for(int i = 0; i < this.livrosEmprestados.length && !temIgual && !temEspaco; i++) {
      if(this.livrosEmprestados[i] == null){
        posicaoEmprestar = i;
        temEspaco = true;
      }
      else if(this.livrosEmprestados[i] != null)
        if(this.livrosEmprestados[i].getCodigoLivro().equals(livro.getCodigoLivro()))
          temIgual = true;
    }

    if(temEspaco && !temIgual){
    	this.livrosEmprestados[posicaoEmprestar] = livro;
      return true;
    }
    else{
      return false;
    }
  }

  // Método para devolver o livro de um usuário.
  /*
  Pré-condição: recebe uma variável do tipo Livro como parâmetro.
  Pós-condição: retorna um boolean. True caso a operação tenha sido realizada com sucesso e false caso contrário.
  */
  public boolean devolveLivro(Livro livro) {
    boolean temIgual = false;
    int posicaoDevolve = 0;

    for(int i = 0; i < this.livrosEmprestados.length && !temIgual; i++)
      if(this.livrosEmprestados[i] != null)
        if(this.livrosEmprestados[i].getCodigoLivro().equals(livro.getCodigoLivro())) {
          posicaoDevolve = i;
          temIgual = true;
        }

      if(temIgual) {
        for(int j = (this.livrosEmprestados.length - 1); j >= 0 && temIgual; j--){
          if(this.livrosEmprestados[j] != null){
            this.livrosEmprestados[posicaoDevolve] = this.livrosEmprestados[j];
            this.livrosEmprestados[j] = null;
            temIgual = false;
          }
        }
        return true;
      }
    	else
    		return false;
  }

  // Método para imprimir livros emprestados ao usuário.
  /*
  Pré-condição: não recebe nenhum parâmetro.
  Pós-condição: imprime todos os livros contidos no atributo vetor livrosEmprestados e não retorna nada.
  */
  public void listaLivrosEmprestados() {
    System.out.println("--------------------------------------------------");
    int cont = 0;
    for(int p = 0; p < this.livrosEmprestados.length; p++)
      if(this.livrosEmprestados[p] != null)
        cont++;

    if(cont != 0){
      System.out.println("Livros emprestados ao usuário " + getNome());
      String[] ordenaAlfa;
      ordenaAlfa = new String [cont];
      for(int j = 0; j < ordenaAlfa.length; j++){
        if(this.livrosEmprestados[j] != null)
          ordenaAlfa[j] = this.livrosEmprestados[j].getNomeLivro();
      }
      Arrays.sort(ordenaAlfa);

      int posicaoLivro = 0;
      boolean temIgual;
      for(int i = 0; i < ordenaAlfa.length; i++) {
        temIgual = false;
        for(int k = 0; k < this.livrosEmprestados.length && !temIgual; k++){
          if(this.livrosEmprestados[k] != null)
            if(this.livrosEmprestados[k].getNomeLivro().equals(ordenaAlfa[i])){
            posicaoLivro = k;
            temIgual = true;
          }
        }
        if(temIgual){
          this.livrosEmprestados[posicaoLivro].imprimeInformacoesLivro();
        }
      }
    }
    else
      System.out.println("Este usuário não possui livros emprestados.\n");
  }
}
