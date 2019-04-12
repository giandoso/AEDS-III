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
public class unionFindPathCompression {
    
    public static int[] pai = new int[12]; // DEFINIR QUANTIDADE DE ELEMENTOS

    public static void union(int p, int q) { // Realiza a união entre p e q
        System.out.println("Union(" + p + "," + q + ")");
        int countP = count(p);
        int countQ = count(q);
        //com path compression
        if (countP > countQ) {
            int aux = pai[q];
            for (int i = 0; i < pai.length; i++) {
                if (pai[i] == aux) { // Itera sobre id e encontra o grupo de q
                    pai[i] = pai[p]; // seta o grupo de q com o id de p
                }
            }
        } else {
            int aux = pai[p];
            for (int i = 0; i < pai.length; i++) {
                if (pai[i] == aux) { // Itera sobre id e encontra o grupo de q
                    pai[i] = pai[q]; // seta o grupo de p com o id de q
                }
            }
        }
    }

    public static int findFather(int n) {
        while (n != pai[n]) {
            n = pai[n];
        }
        return n;

    }

    public static int find(int p) { // Grupo de 'p' dentro de id
        return pai[p];
    }

    public static boolean connected(int p, int q) { // Verifica se p e q estão no mesmo grupo
        if (pai[p] == pai[q]) {
            return true;
        } else {
            return false;
        }
    }

    public static int count(int p) { // checa quantos elementos existem no grupo de p
        int count = 0;
        for (int i = 0; i < pai.length; i++) {
            if (pai[p] == pai[i]) {
                count++;
            }
        }
        return count;
    }

    public static void printId() {
        System.out.print("Pai  : ");
        for (int i = 0; i < pai.length; i++) {
            System.out.print(pai[i] + "|");
        }
        System.out.println("");
        System.out.print("index: ");
        for (int i = 0; i < pai.length; i++) {
            System.out.print(i + "|");
        }
        System.out.println("");
        System.out.println("");

    }

    public static void main(String[] args) {
        for (int i = 0; i < pai.length; i++) {
            pai[i] = i;
        }

        union(4, 9);
        printId();
        union(1, 0);
        printId();
        union(5, 6);
        printId();
        union(5, 10);
        printId();
        union(4, 3);
        printId();
        union(3, 2);
        printId();
        union(7, 1);
        printId();
        union(4, 5);
        printId();
        union(5, 10);
        printId();
        union(11, 8);
        printId();
        union(11, 1);
        printId();
        union(11, 10);
        printId();

    }
}
