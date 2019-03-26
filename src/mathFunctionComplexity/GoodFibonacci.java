// Implementar utilizando a formula de binet
/* Essa é uma fórmula fechada, tornando possível o cálculo de
 * um termo específico na sequência sem o conhecimento dos anteriores. 
 */
package mathFunctionComplexity;

/**
 *
 * @author 2015.1.08.029
 */
public class GoodFibonacci {

    public static long iterations = 0;
    public static double GR = 1.61803398875;

    public static long fibonacci(int n) {
        return (long) Math.round((Math.pow(GR, n) + Math.pow(1 - GR, n)) / Math.sqrt(5));
    }

    public static long iterationsCount(int n) {
        long f = fibonacci(n);
        return f * 2 - 1;
    }

    public static void main(String[] args) {
        System.out.println("Complexidade O(1)");
        int n = 3;
        iterations = iterationsCount(n);
        System.out.println("n = " + n);
        System.out.println("R: " + fibonacci(n) + ", com " + iterations + " iterações");
    }
}
