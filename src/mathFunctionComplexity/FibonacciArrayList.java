/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mathFunctionComplexity;

import java.math.BigInteger;
import java.util.ArrayList;

/**
 *
 * @author 2015.1.08.029
 */
public class FibonacciArrayList {
    public static ArrayList<BigInteger> arr = new ArrayList<>();

    public static BigInteger fibonacci(Integer n) {

        if (n < arr.size()) {
            return arr.get(n);
        } else {
            arr.add(n, fibonacci(n-1).add(fibonacci(n-2)));
            return arr.get(n);
        }
    }

    public static void main(String[] args) {
        arr.add(0, new BigInteger("1"));
        arr.add(1, new BigInteger("1"));
        arr.add(2, new BigInteger("1"));
        System.out.println(fibonacci(250000));
    }
}
