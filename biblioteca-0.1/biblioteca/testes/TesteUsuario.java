/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biblioteca.testes;

import biblioteca.escola.Livro;
import biblioteca.escola.Usuario;

/**
 *
 * @author guilherme
 */
public class TesteUsuario {

    public static void main(String[] args) {
        Usuario u1 = new Usuario("Aluno1", "123456789123", "Rua Azul", "0800-1234");
        String[] autores = {"a1", "a2", "a3"};
        Livro l1 = new Livro("Livro1", "Editora1", "123457890123", autores, 100),
                l2 = new Livro("Livro2", "Editora2", "1234567890124", autores, 200),
                l3 = new Livro("Livro3", "Editora3", "1234567890125", autores, 300),
                l4 = new Livro("Livro4", "Editora4", "1234567890126", autores, 400);

    }
}
