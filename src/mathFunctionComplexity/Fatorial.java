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
public class Fatorial {
    public static int fatorial(int n){
        if(n == 0){
            return 1;
        }
        else{
            return n*fatorial(n-1);
        }
    }
    
    
    public static void main(String[] args) {
        System.out.println(fatorial(300));
    }
}
