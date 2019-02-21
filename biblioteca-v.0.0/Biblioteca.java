import java.util.Arrays;

public class Biblioteca
{
  // Atributos
  private Usuario[] usuarios;
  private Livro[] livros;

  // Método construtor da classe.
  public Biblioteca()
  {
    this.usuarios = new Usuario [30];
    this.livros = new Livro [50];
  }

  // Método para cadastrar um livro na biblioteca.
  /*
  Pré-condição: recebe três variáveis do tipo String, um vetor do tipo String e uma variável do tipo inteiro como parâmetro.
  Pós-condição: retorna um boolean. True caso a operação tenha sido realizada com sucesso e false caso contrário.
  */
  public boolean cadastrarLivro(String nome, String editora, String codigo, String[] autores, int paginas)
  {
    boolean temEspaco = false, temIgual = false, livroValido;
    int posicaoCadastro = 0, cont = 0;
    
    Livro cadastroNovoLivro = new Livro(nome, editora, codigo, autores, paginas);
    if(cadastroNovoLivro.getCodigoLivro() == null)
      livroValido = false;
    else
      livroValido = true;
    
    for(int i = 0; i < this.livros.length && !temEspaco && !temIgual && livroValido; i++) {
      if(this.livros[i] == null) {
        posicaoCadastro = i;
        temEspaco = true;
      }
      else if(this.livros[i] != null){
         cont++;
         if(this.livros[i].getCodigoLivro().equals(cadastroNovoLivro.getCodigoLivro()))
            temIgual = true;
      }        
    }

    if(temEspaco && !temIgual && livroValido) {
      this.livros[posicaoCadastro] = cadastroNovoLivro;
      this.livros[posicaoCadastro].setDisponivelParaEmprestimo(true);
      System.out.printf("Livro \'%s\' Cod.ISBN: \'%s\' cadastrado com sucesso!\n", this.livros[posicaoCadastro].getNomeLivro(), this.livros[posicaoCadastro].getCodigoLivro());
      return true;
    } 
    else {
      System.out.print("Não foi possível realizar o cadastro do livro. ");
      if(!livroValido)
        System.out.println("Código ISBN inválido.");
      else if(cont == this.livros.length)
        System.out.println("Biblioteca atingiu o limite máximo de livros cadastrados.");
      else if(temIgual)
        System.out.println("Código ISBN: \'" + cadastroNovoLivro.getCodigoLivro() + "\' já cadastrado.");
   		return false;
    }
  }

  //Método para emprestar um livro.
  /*
  Pré-condição: recebe duas variáveis do tipo String como parâmetro.
  Pós-condição: retorna um boolean. True caso a operação tenha sido realizada com sucesso e false caso contrário.
  */
  public boolean emprestarLivro(String codigoLivro, String cpfUsuario)
  {
    boolean usuarioEncontrado = false, livroEncontrado = false;
    int posicaoUsuario = 0, posicaoLivro = 0;

    if(livroEstaCadastrado(codigoLivro) && usuarioEstaCadastrado(cpfUsuario)) {
      
      for(int i = 0; i < this.usuarios.length && !usuarioEncontrado; i++) {
        if(this.usuarios[i] != null)
          if(cpfUsuario.equals(this.usuarios[i].getCpf())) {
            posicaoUsuario = i;
            usuarioEncontrado = true;
        }
      }
      
      for(int j = 0; j < this.livros.length && !livroEncontrado; j++) {
        if(this.livros[j] != null)
          if(codigoLivro.equals(this.livros[j].getCodigoLivro())) {
            posicaoLivro = j;
            livroEncontrado = true;
        }
      }
    } else {
        System.out.println("Não foi possível realizar o empréstimo.");
        if(!livroEstaCadastrado(codigoLivro))
          System.out.printf("Livro não cadastrado.\n");
        if(!usuarioEstaCadastrado(cpfUsuario))
          System.out.printf("Usuário não cadastrado.\n");
        return false;
    }

    if(this.usuarios[posicaoUsuario].getAtivo() && this.livros[posicaoLivro].getDisponivelParaEmprestimo() && this.usuarios[posicaoUsuario].emprestaLivro(this.livros[posicaoLivro])) {
      this.livros[posicaoLivro].setDisponivelParaEmprestimo(false);
      System.out.printf("Livro \'%s\' Cod.ISBN: \'%s\' emprestado com sucesso!\n", this.livros[posicaoLivro].getNomeLivro(), this.livros[posicaoLivro].getCodigoLivro());
      return true;
    }
    else {
      System.out.print("Livro não emprestado. ");
      if(this.usuarios[posicaoUsuario].getAtivo() == false)
        System.out.printf("Usuário %s não está ativo.\n", this.usuarios[posicaoUsuario].getNome());
      else if(this.livros[posicaoLivro].getDisponivelParaEmprestimo() == false)
        System.out.printf("\'%s\' Cod.ISBN: \'%s\' não está diponível para empréstimo.\n", this.livros[posicaoLivro].getNomeLivro(), this.livros[posicaoLivro].getCodigoLivro());
      else if(this.usuarios[posicaoUsuario].emprestaLivro(this.livros[posicaoLivro]) == false)
        System.out.printf("Usuário %s atingiu a capacidade máxima de livros emprestados.\n", this.usuarios[posicaoUsuario].getNome());
      return false;
    }
  }

  //Método para devolver um livro.
  /*
  Pré-condição: recebe duas variáveis do tipo String como parâmetro.
  Pós-condição: retorna um boolean. True caso a operação tenha sido realizada com sucesso e false caso contrário.
  */
  public boolean devolverLivro(String codigoLivro, String cpfUsuario)
  {
    boolean usuarioEncontrado = false, livroEncontrado = false;
    int posicaoUsuario = 0, posicaoLivro = 0;
    
    if(livroEstaCadastrado(codigoLivro) && usuarioEstaCadastrado(cpfUsuario)) {
      for(int i = 0; i < this.usuarios.length && !usuarioEncontrado; i++) {
        if(this.usuarios[i] != null)
          if(cpfUsuario.equals(this.usuarios[i].getCpf())){
            posicaoUsuario = i;
            usuarioEncontrado = true;
        }
      }
      for(int j = 0; j < this.livros.length && !livroEncontrado; j++) {
        if(this.livros[j] != null)
          if(codigoLivro.equals(this.livros[j].getCodigoLivro())) {
            posicaoLivro = j;
            livroEncontrado = true;
        }
      }
    } else {
        System.out.print("Não foi possível realizar a devolução. ");
        if(!livroEstaCadastrado(codigoLivro)) {
          System.out.printf("Livro não cadastrado.\n");
        }
        if(!usuarioEstaCadastrado(cpfUsuario)) {
          System.out.printf("Usuário não cadastrado.\n");
        }
        return false;
      }

    if(this.usuarios[posicaoUsuario].getAtivo() && !this.livros[posicaoLivro].getDisponivelParaEmprestimo() && this.usuarios[posicaoUsuario].devolveLivro(this.livros[posicaoLivro])) {
      this.livros[posicaoLivro].setDisponivelParaEmprestimo(true);
      System.out.printf("Livro \'%s\' Cod.ISBN: \'%s\' devolvido com sucesso!\n", this.livros[posicaoLivro].getNomeLivro(), this.livros[posicaoLivro].getCodigoLivro());
      return true;
    }
    else{
      System.out.print("Livro não devolvido. ");
      if(this.usuarios[posicaoUsuario].getAtivo() == false)
        System.out.printf("Usuário %s não está ativo.\n", this.usuarios[posicaoUsuario].getNome());
      else if(!this.usuarios[posicaoUsuario].devolveLivro(this.livros[posicaoLivro]))
        System.out.printf("Livro \'%s\' Cod.ISBN: \'%s\' não foi emprestado a este usuário.\n", this.livros[posicaoLivro].getNomeLivro(), this.livros[posicaoLivro].getCodigoLivro());
      else if(this.livros[posicaoLivro].getDisponivelParaEmprestimo() == true)
        System.out.printf("Livro \'%s\' Cod.ISBN: %s não pode ser devolvido por este usuário.\n", this.livros[posicaoLivro].getNomeLivro(), this.livros[posicaoLivro].getCodigoLivro());
      return false;
    }
  }

  // Método para verificar o cadastro do livro.
  /*
  Pré-condição: recebe uma variável do tipo String como parâmetro.
  Pós-condição: retorna um boolean. True caso a operação tenha sido realizada com sucesso e false caso contrário.
  */
  public boolean livroEstaCadastrado(String codigo)
  {
    boolean livroCadastrado = false;
    for(int i = 0; i < this.livros.length && !livroCadastrado; i++) {
      if(this.livros[i] != null)
        if(codigo.equals(this.livros[i].getCodigoLivro()))
            livroCadastrado = true;
    }
    return livroCadastrado;
  }

  // Método para imprimir informações dos livros cadastrados na biblioteca.
  /*
  Pré-condição: não recebe nenhum parâmetro.
  Pós-condição: imprime na tela todos os livros cadastrados na biblioteca e não retorna nada.
  */
  public void imprimeInformacoesLivros(){
    System.out.println("--------------------------------------------------");
    if(this.livros[0] != null){
      System.out.println("Livros cadastrados na Biblioteca:");
      
      String[] ordenaAlfa;
      int cont = 0;
      for(int p = 0; p < this.livros.length; p++)
        if(this.livros[p] != null)
          cont++;
      
      ordenaAlfa = new String [cont];
      for(int k = 0; k < ordenaAlfa.length; k++)
        ordenaAlfa[k] = this.livros[k].getNomeLivro();
      Arrays.sort(ordenaAlfa);

      boolean temIgual;
      int posicaoLivro = 0;
      for(int i = 0; i < ordenaAlfa.length; i++){
        temIgual = false;
        for(int j = 0; j < this.livros.length && !temIgual; j++){
          if(this.livros[j] != null){
            if(this.livros[j].getNomeLivro().equals(ordenaAlfa[i])){
              posicaoLivro = j;
              temIgual = true;
            }
          }
        }
        if(temIgual){
          this.livros[posicaoLivro].imprimeInformacoesLivro();
        }
      }
    } else
        System.out.println("Não há livros cadastrados na Biblioteca.");
  }

  // Método para cadastrar um usuário.
  /*
  Pré-condição: recebe quatro variáveis do tipo String como parâmetro.
  Pós-condição: retorna um boolean. True caso a operação tenha sido realizada com sucesso e false caso contrário.
  */
  public boolean cadastrarUsuario(String nome, String cpf, String endereco, String telefone)
  {
    boolean temEspaco = false, temIgual = false;
    int posicaoCadastro = 0, cont = 0;
    Usuario cadastroNovoUsuario = new Usuario(nome, cpf, endereco, telefone);
    
    for(int i = 0; i < this.usuarios.length && !temIgual && !temEspaco; i++) {
      if(this.usuarios[i] == null) {
        posicaoCadastro = i;
        temEspaco = true;
      }
      else if(this.usuarios[i] != null){
        cont++;
        if(this.usuarios[i].getCpf().equals(cadastroNovoUsuario.getCpf())) {
          posicaoCadastro = i;
          temIgual = true;
        }
      }
    }

    if(temEspaco && !temIgual) {
      this.usuarios[posicaoCadastro] = cadastroNovoUsuario;
      System.out.printf("Usuário %s cadastrado com sucesso!\n", this.usuarios[posicaoCadastro].getNome());
      return true;
    }
    else {
      System.out.print("Não foi possível realizar o cadastro do usuário. ");
      if(cont == this.usuarios.length)
        System.out.println("Biblioteca atingiu o limite máximo de usuários cadastrados.");
      else if(temIgual)
        System.out.printf("Usuário %s já está cadastrado.\n", this.usuarios[posicaoCadastro].getNome());
      return false;
    }
  }

  // Método para ativar usuário.
  /*
  Pré-condição: recebe uma variável do tipo String como parâmetro.
  Pós-condição: caso a variável recebia seja igual ao atributo cpf de um usuário cadastrado este usuário é ativado.
  */
  public void ativarUsuario(String cpf)
  {
    boolean usuarioEncontrado = false;
    int posicaoUsuario = 0;
    
    for(int i = 0; i < this.usuarios.length && !usuarioEncontrado; i++) {
      if(this.usuarios[i] != null)
        if(cpf.equals(this.usuarios[i].getCpf())){
          posicaoUsuario = i;
          usuarioEncontrado = true;
      }
    }
    if(usuarioEncontrado){
      this.usuarios[posicaoUsuario].setAtivo(true);
      System.out.printf("Usuário %s Ativado!\n", this.usuarios[posicaoUsuario].getNome());
    }
    else
      System.out.printf("Usuário com CPF: \'%s\' não encontrado. Não foi possível ativá-lo.\n", cpf);
  }

  // Método para desativar usuário.
  /*
  Pré-condição: recebe uma variável do tipo String como parâmetro.
  Pós-condição: caso a variável recebia seja igual ao atributo cpf de um usuário cadastrado este usuário é desativado.
  */
  public void desativarUsuario(String cpf)
  {
    boolean usuarioEncontrado = false;
    int posicaoUsuario = 0;
    for(int i = 0; i < this.usuarios.length && !usuarioEncontrado; i++) {
      if(this.usuarios[i] != null)
        if(cpf.equals(this.usuarios[i].getCpf())){
          posicaoUsuario = i;
          usuarioEncontrado = true;
      }
    }
    if(usuarioEncontrado){
      this.usuarios[posicaoUsuario].setAtivo(false);
      System.out.printf("Usuário %s Destivado!\n", this.usuarios[posicaoUsuario].getNome());
    }
    else
      System.out.printf("Usuário com CPF \'%s\' não encontrado. Não foi possível desativá-lo.\n", cpf);
  }

  //Método para verificar cadastro do usuário.
  /*
  Pré-condição: recebe uma variável do tipo String como parâmetro.
  Pós-condição: retorna um boolean. True caso o usuário esteja cadastrado e false caso contrário.
  */
  public boolean usuarioEstaCadastrado(String cpf){
    boolean usuarioCadastrado = false;
    for(int i = 0; i < this.usuarios.length && !usuarioCadastrado; i++) {
      if(this.usuarios[i] != null)
        if(cpf.equals(this.usuarios[i].getCpf()))
          usuarioCadastrado = true;

    }
    return usuarioCadastrado;
  }

  //Método para imprimir informações do usuário.
  /*
  Pré-condição: não recebe nenhum parâmetro.
  Pós-condição: imprime na tela as informações de todos os usuários cadastrados e não retorna nada
  */
  public void imprimeInformacoesUsuarios(){
    System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++");
    if(this.usuarios[0] != null){
      System.out.println("Usuários cadastrados na Biblioteca:");
      
      String[] ordenaAlfa;
      int cont = 0;
      for(int p = 0; p < this.usuarios.length; p++)
        if(this.usuarios[p] != null)
          cont++;
      
      ordenaAlfa = new String [cont];
      for(int k = 0; k < ordenaAlfa.length; k++)
        ordenaAlfa[k] = this.usuarios[k].getNome();
      Arrays.sort(ordenaAlfa);

      boolean temIgual;
      int posicaoUsuario = 0;
      for(int i = 0; i < ordenaAlfa.length; i++){
        temIgual = false;
        for(int j = 0; j < this.usuarios.length && !temIgual; j++){
          if(this.usuarios[j] != null){
            if(this.usuarios[j].getNome().equals(ordenaAlfa[i])){
              posicaoUsuario = j;
              temIgual = true;
            }
          }
        }
        if(temIgual){
          this.usuarios[posicaoUsuario].imprimeInformacoesUsuario();
          this.usuarios[posicaoUsuario].listaLivrosEmprestados();
        }
      }
    } else
        System.out.println("Não há usuários cadastrados na Biblioteca.");
  }

  // Método para validar código ISBN.
  /*
  Pré-condição: recebe uma variável do tipo String como parâmetro.
  Pós-condição: retorna um boolean. True caso o código seja válido e false caso contrário.
  */
  public boolean validaCodigoISBN(String codigo){
    if(codigo.length() == 13)
      return true;
    else
      return false;
  }

  // Método para validar tamnho do vetor autoresLivros.
  /*
  Pré-condição: recebe uma variável do tipo int como parâmetro.
  Pós-condição: retorna um boolean. True caso o valor seja válido e false caso contrário.
  */
  public boolean validaAutorLivro(int tamanho){
    if(tamanho > 0 && tamanho <= 3)
      return true;
    else
      return false;
  }

  // Método para validar número de páginas.
  /*
  Pré-condição: recebe uma variável do tipo int como parâmetro.
  Pós-condição: retorna um boolean. True caso o valor seja válido e false caso contrário.
  */
  public boolean validaPagina(int numPagina){
    if(numPagina > 0)
      return true;
    else
      return false;
  }
}
