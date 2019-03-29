/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mathFunctionComplexity;

import java.math.BigInteger;

/**
 *
 * @author 2015.1.08.029
 */
public class FatorialBigInteger {

    public static BigInteger fatorial(BigInteger n) {
        if (n.equals(new BigInteger("0"))) {
            return new BigInteger("1");
        } else {
            return n.multiply(fatorial(n.subtract(new BigInteger("1"))));
        }
    }
    
    public static void main(String[] args) {
        BigInteger n = new BigInteger("30000");
        System.out.println(fatorial(n));
    }
}
