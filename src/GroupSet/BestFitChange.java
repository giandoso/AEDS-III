/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GroupSet;

import static GroupSet.RandomChange.generator;
import java.io.IOException;
import java.util.Random;

/**
 *
 * @author giandoso
 */
public class BestFitChange {

    static int iterations = 10000;
    static Random generator = new Random();

    public static void main(String[] args) throws IOException, CloneNotSupportedException {
        Reader r = new Reader("src/GroupSet/tp01_instancia.paa");
        int[][] groups = new int[Reader.total_groups][];
        initGroups(groups); // inicializa sequencial
        initRandom(groups); // init random ( depende do sequencial )

        for (int i = 0; i < iterations; i++) {
            groups = bestFitChange(groups, i % 34);
        }

        System.out.println(evaluate(groups) + "\n");
        see(groups);

    }

    /* Deve receber uma 'matriz', trocar o elemento recebido com 
     * cada grupo vizinho e encontrar a melhor posição
     * reverte caso a nova posição testada tenha score menor.
     * retorna o elemento na melhor posição
     *
     * @ ESSA PORRA TEM VARIOS HARD CODED VALUE
     */
    static int[][] bestFitChange(int[][] m, int e) {
        int[][] holder = new int[Reader.total_groups][];
        // inicializa holder
        for (int i = 0; i < Reader.group_sizes.length; i++) {
            int[] aux = new int[Reader.group_sizes[i]];
            holder[i] = aux;
        }
        // copia m para holder, sem copiar a referencia
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++) {
                holder[i][j] = m[i][j];
            }
        }
        int best = 0;
        /* para cada posição checa o score da troca, se melhor salva index
         * em best, ao final troca por best e retorna
         */
        for (int i = 0; i < Reader.people_count; i++) {
            int before = evaluate(holder);
            holder = exchangeElement(holder, e / 5, i / 5, e % 5, i % 5);
            int after = evaluate(holder);
            if (before > after) { //reverte a troca
                holder = exchangeElement(holder, e / 5, i / 5, e % 5, i % 5);
            } else { // salva melhor atual e reverte
                best = i;
                holder = exchangeElement(holder, e / 5, i / 5, e % 5, i % 5);
            }
        }
        holder = exchangeElement(holder, e / 5, best / 5, e % 5, best % 5);

        return holder;

    }

    static int[][] initGroups(int[][] m) {
        for (int i = 0; i < Reader.group_sizes.length; i++) {
            int[] aux = new int[Reader.group_sizes[i]];
            for (int j = 0; j < Reader.group_sizes[i]; j++) {
                aux[j] = (i * 5) + j; // HARD CODED VALUE
            }
            m[i] = aux;
        }
        return m;
    }

    static int[][] initRandom(int[][] m) {
        for (int i = 0; i < 10; i++) {
            randomChange(m);
        }
        return m;
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

    static int[][] exchangeElement(int m[][], int g1, int g2, int g1Elem, int g2eElem) {
        int[][] holder = new int[Reader.total_groups][];
        // inicializa holder
        for (int i = 0; i < Reader.group_sizes.length; i++) {
            int[] aux = new int[Reader.group_sizes[i]];
            holder[i] = aux;
        }

        int[] group1 = m[g1];
        int[] group2 = m[g2];

        int aux = group2[g2eElem];
        group2[g2eElem] = group1[g1Elem];
        group1[g1Elem] = aux;

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
