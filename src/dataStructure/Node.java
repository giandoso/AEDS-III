/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataStructure;

/**
 *
 * @author 2015.1.08.029
 */
public class Node {
    
    public int value;
    public Node next;

    /* Construtor padrão que atribui os parametros corretamente ao java
     */    
    public Node(int value, Node next) {
        this.value = value;
        this.next = next;
    }
    
    /* Ao tornar o construtor private ele é inacessivel, bloqueando o programador
     * de chamar o metodo definido por padrão no java que não executa nada;
     */
    private Node(){}
    
}
