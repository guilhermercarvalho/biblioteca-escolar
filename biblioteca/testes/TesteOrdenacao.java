/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biblioteca.testes;

import biblioteca.utilidades.Ordenacao;

/**
 *
 * @author guilherme
 */
public class TesteOrdenacao {
    public static void main(String[] args) {
//        Object vetor[] = {6, null, 2, 3, null, 1, 5};
        Object vetor[] = {"d", "a", "c", null, "b", "e", "g", "h", "f"};
//        Object vetor[] = {'d', 'a', 'c', 'b', 'e', 'g', 'h', 'f'};
//        Object vetor[] = {true, false};
//        Object vetor[] = {'6', '2', '3', '1', '5'};
        
        for(Object v : vetor) {
            System.out.println(v);
        }

        Ordenacao.mergesort(vetor, 0, vetor.length-1);
        
        System.out.println("");
        
        for(Object v : vetor) {
            System.out.println(v);
        }
    }
}
