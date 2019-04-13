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
public class RandomChange {

    static int iterations = 10000;
    static Random generator = new Random();

    public static void main(String[] args) throws IOException, CloneNotSupportedException {
        Reader r = new Reader();
        int[][] groups = new int[Reader.total_groups][];
        int[][] backup = new int[Reader.total_groups][];

        for (int i = 0; i < Reader.group_sizes.length; i++) {
            int[] aux = new int[Reader.group_sizes[i]];
            for (int j = 0; j < Reader.group_sizes[i]; j++) {
                aux[j] = (i * 5) + j; // HARD CODED VALUE
            }
            groups[i] = aux;
        }

        backup = get(groups);
        for (int i = 0; i < iterations; i++) {
            randomChange(groups);
            if (evaluate(groups) > evaluate(backup)) {
                backup = get(groups);
            } else {
                groups = get(backup);
            }

        }

        System.out.println(evaluate(groups));
        see(groups);
    }

    static int[][] randomChange(int[][] m) {
        int[][] holder = new int[Reader.total_groups][];
        // inicializa holder
        for (int i = 0; i < Reader.group_sizes.length; i++) {
            int[] aux = new int[Reader.group_sizes[i]];
            holder[i] = aux;
        }
        //troca 2 elementos de grupos diferentes de lugar
        int[] group1 = m[generator.nextInt(m.length)];
        int[] group2 = m[generator.nextInt(m.length)];
        int group1Element = generator.nextInt(group1.length);
        int group2Element = generator.nextInt(group2.length);
        int aux = group2[group2Element];
        group2[group2Element] = group1[group1Element];
        group1[group1Element] = aux;

        // copia m para holder e retorna, sem copiar a referencia
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++) {
                holder[i][j] = m[i][j];
            }
        }
        return holder;

    }

    static void see(int[][] m) {
        // Exibe m no terminal
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++) {
                if (m[i][j] < 10) {
                    System.out.print(m[i][j] + " |");
                } else {
                    System.out.print(m[i][j] + "|");
                }
            }
            System.out.println("");
        }
        System.out.println("");
    }

    static int[][] get(int[][] m) {
        int[][] holder = new int[Reader.total_groups][];
        // inicializa holder
        for (int i = 0; i < Reader.group_sizes.length; i++) {
            int[] aux = new int[Reader.group_sizes[i]];
            holder[i] = aux;
        }
        // copia m para holder e retorna, sem copiar a referencia
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++) {
                holder[i][j] = m[i][j];
            }
        }
        return holder;
    }

    static int evaluate(int[][] m) {
        //calcula total, possui metodo auxiliar(evaluateGroup);
        int total = 0;
        for (int i = 0; i < m.length; i++) {
            total += evaluateGroup(m[i]);
        }
        return total;
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
