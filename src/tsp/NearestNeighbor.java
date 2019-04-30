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
            int bestIndex = 0;
            int bestScore = 9999;
            for (int j = 0; j < 58; j++) {
                int local = r.pesos[i][j];
                if (visited[j] == false) {
                    if (local < bestScore && local != 0) {
                        bestIndex = j;
                        bestScore = local;
                    }
                }
            }
            System.out.println(i + "\t\t" + bestScore + "\t\t" + bestIndex);
            sequence[i] = bestIndex;
            visited[bestIndex] = true;
            total += bestScore;
        }
        total += r.pesos[0][57];
        System.out.println(r.pesos[0][40]);        
    }
    
    public static int evaluate(int[] arr, int[][] m){
        int total = 0;
//        System.out.println(Arrays.toString(arr));
        for (int i = 0; i < 57; i++) {
//            System.out.println(m[40][0]);
//            System.out.println(m[arr[i]][arr[i+1]]);
            total += m[arr[i]][arr[i+1]];           
        }
        total += m[57][0];
        return total;
    }
}
