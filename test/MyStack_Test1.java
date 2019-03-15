
import dataStructure.MyStack;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 2015.1.08.029
 */
public class MyStack_Test1 {
    public static void main(String[] args) {
        MyStack s = new MyStack();
        
        s.push(0);
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);
        
        while(!s.isEmpty()){
            int current = s.pop();
            System.out.println("- " + current);
        }
        
    }
    
}
