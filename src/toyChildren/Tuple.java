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

import AGM.Aresta;

/**
 *
 * @author 2015.1.08.029
 */
public class Tuple implements Comparable<Tuple>{

    int id_crianca;
    int id_presente;
    double value;

    public Tuple(int origin, int destiny, double value) {
        this.id_crianca = origin;
        this.id_presente = destiny;
        this.value = value;
    }

    public int getId_crianca() {
        return id_crianca;
    }

    public void setId_crianca(int id_crianca) {
        this.id_crianca = id_crianca;
    }

    public int getId_presente() {
        return id_presente;
    }

    public void setId_presente(int id_presente) {
        this.id_presente = id_presente;
    }    

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }
    
    @Override
    public int compareTo(Tuple o) {
        if (this.value < o.getValue()) {
            return 1;
        }
        if (this.value > o.getValue()) {
            return -1;
        }
        return 0;
    }

}
