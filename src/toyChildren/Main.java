/*
 * The MIT License
 *
 * Copyright 2019 2015.1.08.029.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package toyChildren;

import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author 2015.1.08.029
 */
public class Main {
    public static void main(String[] args) throws IOException {
        Reader r = new Reader("src/toyChildren/data.input");
        
        ArrayList<Tuple> l = r.getTuplasOrdenadas();
        
        int qtd_criancas = 10;
        int qtd_presentes = 10;
        
        ArrayList<Tuple> presentes = new ArrayList<>();
        
        boolean[] criancas_visitadas = new boolean[qtd_criancas];
        boolean[] presentes_visitados = new boolean[qtd_presentes];
        
        for(Tuple t : l){
            // verifica se a criança já não tem um presente
            if(criancas_visitadas[t.getId_crianca()] == false){
                // caso não tenha, atribui o presente a criança
                if(presentes_visitados[t.getId_presente()] == false){
                    presentes.add(t);
                    criancas_visitadas[t.getId_crianca()] = true;
                    presentes_visitados[t.getId_presente()] = true;                    
                }
            }
        }
        double total = 0;
        for(Tuple t : presentes){
            total += t.value;
            System.out.println("Criança: " + t.id_crianca + " "
                    + "-> Presente " + t.getId_presente());
        }
        System.out.println("Total: " + total);
         
    }
}
