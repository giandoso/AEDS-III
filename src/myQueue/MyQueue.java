/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myQueue;

/**
 *
 * @author jpgiandoso
 */
public class MyQueue {

    Node front; // First element
    Node back;

    public MyQueue() {
//        this.front = null;
//        this.back = null;
    }

    /* add
     */
    public void add(int value){
        Node n = new Node(value, null, null);
        n.next = this.back;
        n.previous = null;
        this.back = n;
    }
    
    /* peek
     */
    public int peek(){
        if(this.front == null){
            this.front = this.back.next;
            this.front.previous = this.back;
            while(this.front.next != null){
                Node previous = this.front;
                this.front = this.front.next;
                this.front.previous = previous;
            }
        }
        int d =this.front.value;
        return d;
    }
    
    /* remove
     */
    public int remove(){        
        if(this.front == null){
            this.front = this.back.next;
            this.front.previous = this.back;
            while(this.front.next != null){
                Node previous = this.front;
                this.front = this.front.next;
                this.front.previous = previous;
            }
        }
        int d = this.front.value;
        Node previous = this.front.previous;
        this.front = previous;
        return d ;
    }
    
    
    
    
    
}
