/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GroupSet;

import java.io.IOException;
import java.util.Arrays;

/**
 *
 * @author 2015.1.08.029
 */
public class Backtracking {

    static int[] best = new int[Reader.people_count];
    static int best_score = 0;

    public static void main(String[] args) throws IOException {
        Reader r = new Reader("src/GroupSet/tp02_instancia.paa");

        int[] arr = new int[Reader.people_count];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }
        backtrack(arr, 0, arr.length);

        System.out.println(Arrays.toString(best) + " \t\t" + best_score);
    }

    static void exchange(int[] arr, int i, int j) {
        int aux = arr[i];
        arr[i] = arr[j];
        arr[j] = aux;
    }

    static void backtrack(int[] arr, int inf, int sup) {
        if (inf == sup) {
//            for (int i = 0; i < sup; i++) {
//                System.out.print(" " + arr[i]);
//            }
//            System.out.println("");
            int curr = evaluate(arr);
            if (curr > best_score) {
                best_score = curr;
                best = get(arr);
//                System.out.println(Arrays.toString(best) + " " + best_score);

            }

        } else {
            for (int i = 0; i < sup; i++) {
                exchange(arr, inf, i);
                backtrack(arr, inf + 1, sup);
                exchange(arr, inf, i);
            }
        }
    }

    static int[] get(int[] arr){
        int[] holder = new int[Reader.people_count];
        
        for (int i = 0; i < Reader.people_count; i++) {
            holder[i] = arr[i];            
        }
        
        return holder;
    }
    
    static int evaluate(int[] v) {
        int group1, group2;
        int[] aux = new int[Reader.people_count / 2];
        for (int i = 0; i < Reader.people_count / 2; i++) {
            aux[i] = v[i];
        }
        group1 = evaluateGroup(aux);
        for (int i = Reader.people_count / 2; i < Reader.people_count; i++) {
            aux[i - Reader.people_count / 2] = v[i];
        }
        group2 = evaluateGroup(aux);
        return group1 + group2;
    }

    static int evaluateGroup(int[] v) {
        int total = 0;
        for (int i = 0; i < v.length; i++) {
            for (int j = 0; j < v.length; j++) {
                total += Reader.m[v[i]][v[j]];
            }
        }
        return total;
    }
}
