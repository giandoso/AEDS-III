/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myStack;

/**
 *
 * @author 2015.1.08.029
 */
public class MyStack {

    Node top;

    /* Apenas deixa a possibilidade do construtor ser acessivel através 
     * de um construtor vazio, a pilha é inicializada obrigatoriamente vazia.
     */
    public MyStack() {
        this.top = null;
    }

    /* Empilhar
     * @param int value : valor a ser inserido na pilha
     */
    public void push(int value) {
        Node n = new Node(value, null);
        n.next = this.top;
        this.top = n;        
    }

    /* Desempilhar
     * @return int result: valor contido no Node top.
     */
    public int pop() {
        int result = this.top.value;
        this.top = this.top.next;        
        return result;
    }

    /* É vazio?
     */
    public boolean isEmpty(){
        return this.top == null;       
    }
}
