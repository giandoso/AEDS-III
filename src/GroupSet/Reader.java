/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GroupSet;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author 2015.1.08.029
 */
public final class Reader {

    File f;
    Scanner s;

    static int people_count;
    static int total_groups;
    static int[] group_sizes;
    static int[][] m;

    public Reader() throws FileNotFoundException, IOException {
        read("/home/giandoso/NetBeansProjects/AEDS-III/src/GroupSet/tp01_instancia.paa");
    }

    public void read(String filename) throws FileNotFoundException, IOException {
        this.f = new File(filename);
        this.s = new Scanner(f);

        this.s.next();
        Reader.people_count = this.s.nextInt();
        Reader.m = new int[people_count][people_count];
        
        this.s.next();
        Reader.total_groups = this.s.nextInt();

        Reader.group_sizes = new int[total_groups];

        for (int i = 0; i < group_sizes.length; i++) {
            this.s.next();
            group_sizes[i] = this.s.nextInt();
        }
        
        for (int i = 0; i < people_count; i++) {
            for (int j = 0; j < people_count; j++) {
                m[i][j] = this.s.nextInt();
            }
        }
    }
}
