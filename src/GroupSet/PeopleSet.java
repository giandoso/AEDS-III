/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GroupSet;

import java.io.IOException;
import java.io.Serializable;
import java.util.Random;

/**
 *
 * @author 2015.1.08.029
 */
public class PeopleSet implements Serializable{

//    List<int[]> l = new ArrayList();
    int[][] l = new int[Reader.total_groups][];
    Random generator = new Random();

    public PeopleSet() throws IOException {
        
    }

    public void init() {
        for (int i = 0; i < Reader.group_sizes.length; i++) {
            int[] aux = new int[Reader.group_sizes[i]];
            for (int j = 0; j < Reader.group_sizes[i]; j++) {
                aux[j] = (i * 5) + j; // HARD CODED VALUE
            }
            l[i] = aux;
        }
    }
    
    public void set(int[][] values){
        for (int i = 0; i < Reader.total_groups; i++) {
            this.l[i] = values[i];
        }
    }

    public int[][] get() {
        int[][] aux = new int[Reader.total_groups][];
        for (int i = 0; i < Reader.total_groups; i++) {
                aux[i] = l[i];
        }
        return aux;
    }

    public void randomChange() {
        int[] g1 = this.l[generator.nextInt(l.length)];
        int[] g2 = this.l[generator.nextInt(l.length)];

        int g1Elem = generator.nextInt(g1.length);
        int g2Elem = generator.nextInt(g2.length);

        int holder = g2[g2Elem];
        g2[g2Elem] = g1[g1Elem];
        g1[g1Elem] = holder;
    }

    public void see() {
        for (int i = 0; i < l.length; i++) {
            for (int j = 0; j < l[i].length; j++) {
                System.out.print(l[i][j] + "|");
            }
            System.out.println("");
        }
        System.out.println("\n\n");
    }

    public int evaluate() {
        int total = 0;
        for (int i = 0; i < l.length; i++) {
            total += evaluateGroup(l[i]);
        }
        System.out.println(total);
        return total;
    }

    private int evaluateGroup(int[] g) {
        int total = 0;
        for (int i = 0; i < g.length; i++) {
            for (int j = 0; j < g.length; j++) {
                total += Reader.m[g[i]][g[j]];
            }
        }
        return total;
    }

}
