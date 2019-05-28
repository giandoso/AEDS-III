package AGM;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author giandoso
 */
public class Reader {

    FileReader scanner;
    BufferedReader file;
    static ArrayList<double[]> tuplas = new ArrayList<>();

    public Reader(String fileName) throws FileNotFoundException, IOException {
        this.scanner = new FileReader(fileName);
        BufferedReader file = new BufferedReader(scanner);
        file.readLine();
        while (file.ready()) {
            String line = file.readLine();
            if ("".equals(line)) {
                break;
            }
            double[] aux = new double[2];//tamanho eh a qtd de colunas
            String[] s = line.split(",");
            //popula vet aux com conteudo do arquivo
            aux[0] = Double.parseDouble(s[0].trim());
            aux[1] = Double.parseDouble(s[1].trim());
            //adiciona aux em tuplas
            tuplas.add(aux);
        }
    }

    public void printaTuplas() {
        for (int i = 0; i < this.tuplas.size(); i++) {
            System.out.println("(" + tuplas.get(i)[0] + "," + tuplas.get(i)[1] + ") " + i);
        }
    }

    public double getDistancia(double[] v1, double[] v2) {
        double distancia;
        distancia = java.lang.Math.pow((v2[0] - v1[0]), 2) + java.lang.Math.pow((v2[1] - v1[1]), 2);
        distancia = java.lang.Math.pow(distancia, 0.5);
        return distancia;
    }

    public Graph buildGrafo() {
        System.out.println("Adicionando arestas");
        Graph grafo = new Graph(this.tuplas);
        for (int i = 0; i < this.tuplas.size(); i++) {
            for (int j = 0; j < this.tuplas.size(); j++) {
                grafo.addAresta(i, j, getDistancia(tuplas.get(i), tuplas.get(j)));
            }
        }
        return grafo;
    }
}
