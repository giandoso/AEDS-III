/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GroupSet;

import java.util.Arrays;

/**
 *
 * @author giandoso
 */
public class testshit {

    static int[][] m = new int[7][5];
    
    

    public static void main(String[] args) {
        for (int i = 0; i < 34; i++) {
            m[i/5][i%5] = i;
        }
        
   
        System.out.println(Arrays.toString(m[6]));
//        for (int i = 0; i < 34; i++) {
//            System.out.print(" " + i % 5);
//            System.out.println(" " + i / 5 + " |");
//        }
    }
}
