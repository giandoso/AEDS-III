/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tsp;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author giandoso
 */
public class Reader {

    File f;
    Scanner s;
    static int[][] m = new int[58][58];

    public Reader(String path) throws IOException {
        read(path);
    }

    public void read(String filename) throws FileNotFoundException, IOException {
        this.f = new File(filename);
        this.s = new Scanner(f);
        // itera o arquivo int a int adicionando na posição correta da diagonal superior
        for (int i = 0; i < 57; i++) {
            // k é auxiliar para iterar apenas a diagonal superior
            for (int k = 58 - (57 - i), j = i; k < 58; k++, j++) {
                m[i][j + 1] = this.s.nextInt();
            }
        }
        for (int i = 0; i < 58; i++) {
            for (int j = 0; j < 58; j++) {
                m[j][i] = m[i][j];
            }
        }
    }
}
