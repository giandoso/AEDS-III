
import myDoubleLinkedList.MyLinkedList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jpgiandoso
 */
public class MyLinkedListTest {
    
    public static void main(String[] args) {
        MyLinkedList l = new MyLinkedList();
        l.add(5);
        l.add(4);
        l.add(3);
        l.add(2);
        l.remove(3);
        
        l.print();
        

    }
    
            
    
    
}
