package biblioteca.escolar;

public class Usuario {

	private String nome;
	private String cpf;
	private String endereco;
	private String telefone;
	private boolean ativo;
	private Livro[] livrosEmprestados;

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

	public boolean emprestraLivro(Livro livroEmprestado) {
		for (int i = 0; i < livrosEmprestados.length; i++) {
			if (livrosEmprestados[i] == null) {
				livrosEmprestados[i] = livroEmprestado;
				return true;
			}
		}
		return false;
	}

	public boolean devolveLivro(Livro livroDevolvido) {
		boolean encontrado = false; // indica se o livro esta com o aluno
		int removido = 0; // indica a posicao do livro removido

		for (int i = 0; !encontrado && i < livrosEmprestados.length; i++) {
			if (livrosEmprestados[i].equals(livroDevolvido)) {
				livrosEmprestados[i] = null;
				removido = i;
				encontrado = true;
			}
		}

		if (encontrado) {
			for (int j = livrosEmprestados.length - 1; j >= 0; j--) {
				if (livrosEmprestados[j] != null) {
					livrosEmprestados[removido] = livrosEmprestados[j];
                                        livrosEmprestados[j] = null;
					return true;
				}
			}
			return true;
		}
		return false;
	}

	public void imprimeInformacoesUsuario() {
		System.out.println("\tINFORMAÇÕES DO ALUNO\t\n");

		System.out.printf("Nome: %s%n" + "CPF: %s%n" + "Endereço: %s%n" + "Telefone: %s%n", this.nome, this.cpf,
				this.endereco, this.telefone);

		System.out.print("Estatus do usuário: ");
		if (ativo) {
			System.out.println("Ativo");
		} else {
			System.out.println("Inativo");
		}

		// imprime livros emprestados ao usuário
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
}