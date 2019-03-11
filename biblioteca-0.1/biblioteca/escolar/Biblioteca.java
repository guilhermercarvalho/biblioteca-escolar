/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biblioteca.escolar;

/**
 *
 * @author guilherme
 */
public class Biblioteca {
    private Usuario[] usuarios;
    private Livro[] livros;
    
    private static int contUsuarios = 0;
    private static int contLivros = 0;

    public Biblioteca() {
        usuarios = new Usuario[30];
        livros = new Livro[50];
    }
    
    public boolean cadastrarLivro(String nome, String editora, String codigo, String[] autores, int paginas) {
        boolean livroCadastrado = false,
                temEspaco = false;
        
        Livro novoLivro = new Livro(nome, editora, codigo, autores, paginas);
        
        int i;
        for(i = 0; !livroCadastrado && !temIgual && i < livros.length; i++) {
            if(livros[i] != null)
                if(livros[i].equals(novoLivro));
                    temIgual = true;
        }
        
        return false;
    }
    
    public boolean emprestarLivro(String codigoLivro, String cpfUsuario) {
        return false;
    }
    
    public boolean devolverLivro(String codigoLivro, String cpfUsuario) {
        return false;
    }
    
    public boolean livroEstaCadastrado(int codigo) {
        return false;
    }
    
    public void imprimeInformacoesLivros() {
        
    }
    
    public boolean cadastrarUsuario(String nome, String cpf, String endereco, String telefone) {
        return false;
    }
    
    public void ativarUsuario(String cpf) {
        
    }
    
    public void desativarUsuario(String cpf) {
        
    }
    
    public boolean usuarioEstaCadastrado(String cpf) {
        return false;
    }
    
    public void imprimeInformacoesUsuarios() {
    
    }
}
