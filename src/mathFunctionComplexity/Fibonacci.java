/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mathFunctionComplexity;

/**
 *
 * @author 2015.1.08.029
 */
public class Fibonacci {

    public static int iterations = 0;

    public static int fibonacci(int n) {
        iterations++;
        if (n < 3) {
            return 1;
        } else {
            return (fibonacci(n - 1) + fibonacci(n - 2));
        }
    }

    public static void main(String[] args) {
        System.out.println("Complexidade O(n) + recursividade");
        int n = 3;
        System.out.println("n = " + n);
        System.out.println("R: " + fibonacci(n) + ", com " + iterations + " iterações");
    }

}
