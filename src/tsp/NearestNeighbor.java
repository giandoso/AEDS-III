/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tsp;

import java.io.IOException;
import java.util.Arrays;

/**
 *
 * @author giandoso
 */
public class NearestNeighbor {

    public static void main(String[] args) throws IOException {
        Reader r = new Reader("src/tsp/brazil58.tsp");
        /*
            Para implementação da sequencia usar array ou linked list?
        
            Para computar a resposta tanto faz, como é sequencial não difere,
            teremos complexidade O(n) para array e linked list.
        
            Para computar o vizinho mais proximo estaremos iterando toda a sequencia
            a cada iteração , essa caracterisca nos gera complexidade O(n²) para
            array e para LinkedList.
            
            Escolherei utilizar um array pela simplicidade de implementação           
            
         */
        int[] sequence = new int[58];
        /*
            Como controlar um elemento que já foi visitado?
            Podemos implementar um array[58] auxiliar de booleanos
         */
        boolean[] visited = new boolean[58];
        // nenhum visitado
        for (int i = 0; i < 58; i++) {
            visited[i] = false;
        }
        /*
            Para 'diminuir o problema' podemos fixar a cidade 0 na posição 0            
         */
        sequence[0] = 0;
        visited[0] = true;
        /*
                            A cada iteração devemos comparar o elemento atual com o elemento
                            mais proximo não visitado
         */
        int total = 0;
        for (int i = 1; i < 58; i++) {
            int bestScore = 9999;
            int bestIndex = 0;
            for (int j = 0; j < 58; j++) {
                int local = r.pesos[sequence[i - 1]][j];
                System.out.println(sequence[i - 1] + "\t\t" + j + "\t\t" + r.pesos[sequence[i - 1]][j]);
                if (visited[j] == false && i - 1 != j) {
                    if (local < bestScore) {
                        bestIndex = j;
                        bestScore = local;
                    }
                }
            }
            visited[bestIndex] = true;
            sequence[i] = bestIndex;
        }
        System.out.println(evaluate(sequence, r.pesos));

        System.out.println(Arrays.toString(sequence));
        System.out.println(r.pesos[29][12]);

//        for (int i = 0; i < 58; i++) {
//            System.out.println(Arrays.toString(Reader.pesos[i]));
//        }
        
    }

    public static int evaluate(int[] arr, int[][] m) {
        int total = 0;
        for (int i = 1; i < 58; i++) {
            total += m[arr[i-1]][arr[i]];
        }
        total += m[57][0];
        return total;
    }
}
// [0, 29, 12, 39, 24, 8, 31, 19, 52, 49, 3, 17, 43, 23, 57, 4, 26, 42, 11, 56, 22, 53, 54, 1, 40, 34, 9, 51, 50, 46, 48, 2, 47, 38, 28, 35, 16, 25, 5, 18, 27, 13, 36, 33, 45, 55, 44, 32, 14, 20, 10, 15, 21, 7, 37, 41, 30, 6]