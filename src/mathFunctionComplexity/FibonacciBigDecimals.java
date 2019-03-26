/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mathFunctionComplexity;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

/**
 *
 * @author giandoso
 */
public class FibonacciBigDecimals {

    public static String fibonacci(int n) {

        // BINET = GR^n + (1-GR)^n / sqrt(5)
        //GR
        BigDecimal GR = new BigDecimal(1.61803398875);
        GR = GR.pow(n);
        // aux = 1-GR
        BigDecimal aux = new BigDecimal(0.61803398875);
        aux = aux.pow(n);
        
        // GR = GR^n + (1-GR)^n
        GR = GR.add(aux);        
        
        //sqrt(5)
        BigDecimal sqrt5 = new BigDecimal(2.2360679775);
        
        // aux = GR^n + (1-GR)^n / sqrt(5)
        aux = GR.divide(sqrt5, RoundingMode.CEILING);

        return aux.toString();
    }

    public static void main(String[] args) {
        System.out.println(fibonacci(10000));
    }
}
