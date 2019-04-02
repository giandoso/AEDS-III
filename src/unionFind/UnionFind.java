/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unionFind;

/**
 *
 * @author 2015.1.08.029
 */
// SEM PATH COMPRESSION
public class UnionFind {

    public static int[] id = new int[10]; // DEFINIR QUANTIDADE DE ELEMENTOS

    public static void union(int p, int q) { // Realiza a união entre p e q
        // Checa a quantidade de elementos maior, atribui o valor de id do
        // maior grupo a todos elementos do grupo menor
        System.out.println("Union(" + p + "," + q + ")");
        int countP = count(p);
        int countQ = count(q);
        if (countP > countQ) {
            int aux = id[q];
            for (int i = 0; i < id.length; i++) {
                if (id[i] == aux) { // Itera sobre id e encontra o grupo de q
                    id[i] = id[p]; // seta o grupo de q com o id de p
                }
            }
        } else {
            int aux = id[p];
            for (int i = 0; i < id.length; i++) {
                if (id[i] == aux) { // Itera sobre id e encontra o grupo de q
                    id[i] = id[q]; // seta o grupo de q com o id de p
                }
            }
        }
    }

    public static int find(int p) { // Grupo de 'p' dentro de id
        return id[p];
    }

    public static boolean connected(int p, int q) { // Verifica se p e q estão no mesmo grupo
        if (id[p] == id[q]) {
            return true;
        } else {
            return false;
        }
    }

    public static int count(int p) { // checa quantos elementos existem no grupo de p
        int count = 0;
        for (int i = 0; i < id.length; i++) {
            if (id[p] == id[i]) {
                count++;
            }
        }
        return count;
    }

    public static void printId() {
        System.out.print("index: ");
        for (int i = 0; i < id.length; i++) {
            System.out.print(i + "|");
        }
        System.out.println("");
        System.out.print("ID's : ");
        for (int i = 0; i < id.length; i++) {
            System.out.print(id[i] + "|");
        }
        System.out.println("");
        System.out.println("");

    }

    public static void main(String[] args) {
        for (int i = 0; i < id.length; i++) {
            id[i] = i;
        }

        union(1, 9);
        printId();
        union(1, 3);
        printId();
        union(7, 3);
        printId();

        union(6, 8);
        printId();
        union(0, 2);
        printId();
        union(0, 8);
        printId();

        union(4, 5);
        printId();
        union(1, 2);
        printId();
        union(3, 4);
        printId();

//        System.out.println(find(5));
    }
}
