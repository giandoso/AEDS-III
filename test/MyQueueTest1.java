
import myQueue.MyQueue;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jpgiandoso
 */
public class MyQueueTest1 {
    public static void main(String[] args) {
        MyQueue q = new MyQueue();
        
        for (int i = 0; i < 3; i++) {
            q.add(i);
        }
        
        for (int i = 0; i < 3; i++) {
            System.out.println(q.remove());
        }    
        
        
        
    }
    
    
}
