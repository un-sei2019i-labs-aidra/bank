/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se_lab3;

/**
 *
 * @author Diana
 */
public class FibonacciAlgo {

    /**
     *
     * @param n 
     */
    public static void fibonacci(int n) {
        if (n > 0) {
            //The first and second number of fibonacci
            /*a and b will save the i-1 and i-2 numbers 
            of fibonacci respectively for each i
            */
            int a = 0;// (Second Number initially)
            int b = 1;// (First Number initially)
            int fib = 0;
            //The first and second numbers are already saved so no cycle required
            if (n == 2) {
                System.out.println(b);
                return;
            }else if (n==1){
                System.out.println(a);
                return;
            }
            //From the third onwards calculate the ith number as follows:
            //fibonaci(i) = fibonacci(i-1) + fibonacci(i-2)
            for (int i = 2; i <= n; i++) {

                fib = a + b;//fibonacci(i-1) + fibonacci(i-2)
                //Update number values for next iteration
                b = a;//fibonacci(i-2) will be now fibonacci(i-1)
                a = fib;//fibonacci(i-1)will be now the number we just calculate

            }
            //Print the final result
            System.out.println(fib);
        }else{
        //Fibonacci numbers are a succession so begins with the ith positive number
        System.out.println("The fibo number does not exist!");
        }
    }
    public static void main(String[] args) {
        fibonacci(72);
    }
}
