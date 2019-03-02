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

    public Biblioteca() {
        usuarios = new Usuario[30];
        livros = new Livro[50];
    }
    
    public boolean cadastrarLivro(String nome, String editora, String codigo, String[] autores, int paginas) {
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
