
import myBTree.myBTree;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author giandoso
 */
public class myBTreeTest {

    public static void main(String[] args) {
        myBTree bt = new myBTree();

        bt.add(6);
        bt.add(4);
        bt.add(8);
        bt.add(3);
        bt.add(5);
        bt.add(7);
        bt.add(9);

        bt.traverseInOrder(bt.root);
    }
}
