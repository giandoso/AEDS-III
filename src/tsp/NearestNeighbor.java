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
     
        System.out.println("test: " + r.m[13][23] +" "+ r.m[23][13]);


    }
}
