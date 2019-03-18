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
public class Node {
    public int value;
    public Node next;
    public Node previous;

    public Node(int value, Node next, Node previous) {
        this.value = value;
        this.next = next;
        this.previous = previous;
    }
    
    private Node(){}
    
}
