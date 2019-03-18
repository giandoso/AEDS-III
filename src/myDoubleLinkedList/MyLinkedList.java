/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myDoubleLinkedList;

/**
 *
 * @author jpgiandoso
 */
public class MyLinkedList {

    Node head;

    public MyLinkedList() {
    }

    /* add
     */
    public void add(int value) {
        Node n = new Node(value, null, null);
        n.next = head;
        n.previous = null;
        if (this.head != null) {
            this.head.previous = n;
        }
        this.head = n;
    }

    /* remove
     */
    public void remove(int v) {        
        if (head != null) {
            Node n = head;
            while (n.value != v) {
                n = n.next;
            }
            if(n.next != null){
                n.next.previous = n.previous;
            }
            if(n.previous != null){
                n.previous.next = n.next;
            }         
        }
    }

    /* print
     */
    public void print() {
        Node n = this.head;
        while (n != null) {
            System.out.print("< " + n.value + " >");
            n = n.next;
        }

    }
}
