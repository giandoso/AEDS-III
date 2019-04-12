/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GroupSet;

import java.io.IOException;
import java.util.Arrays;
import java.util.Random;

/**
 *
 * @author 2015.1.08.029
 */
public class Main {

    static int iterations = 10;
    static Random generator = new Random();

    public static void main(String[] args) throws IOException, CloneNotSupportedException {
        Reader r = new Reader();

        PeopleSet s = new PeopleSet();
        s.init();
        
        
        PeopleSet old = s;
//        old.set(s.get()); //backup
        old.see();
        
        s.randomChange();
        s.randomChange();
        s.randomChange();
               old.see();
 s.randomChange();
        s.randomChange();
        s.randomChange();
        old.see();
        

        for (int i = 0; i < iterations; i++) {
        }

//        old.see();
//        System.out.println(s.evaluate() + " with " + iterations + " iterations");
    }
}
