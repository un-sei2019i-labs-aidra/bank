/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package primoalgo;

/**
 *
 * @author Valeria
 */
public class PrimoAlgo {

    /**
     * @param n
     */
    public static void esPrimo(int numero) {
        int contador = 0;
    
        for (int i = 1; i <= numero; i++) {
            if ((numero % i) == 0) {
                contador++;
            }
        }

        if (contador <= 2) {
            System.out.println("El numero es primo");
        } else {
            System.out.println("El numero no es primo");
        }
    }

    public static void main(String[] args) {
        esPrimo(4);
    }

}
