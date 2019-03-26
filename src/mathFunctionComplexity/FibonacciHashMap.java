/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mathFunctionComplexity;

import java.util.HashMap;
import java.math.BigInteger;

/**
 *
 * @author 2015.1.08.029
 */
public class FibonacciHashMap {

    public static HashMap<Integer, BigInteger> map = new HashMap<>();

    public static BigInteger fibonacci(Integer n) {

        if (map.get(n) != null) {
            return map.get(n);
        } else {
            map.put(n, fibonacci(n-1).add(fibonacci(n-2)));
            return map.get(n);
        }
    }

    public static void main(String[] args) {
        map.put(0, new BigInteger("1"));
        map.put(1, new BigInteger("1"));
        map.put(2, new BigInteger("1"));
        System.out.println(fibonacci(7000));

    }

}
