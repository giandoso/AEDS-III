package AGM;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author jpgiandoso
 */
public class Kruskal {

    List<Aresta> X;

    ArrayList<ArrayList<Integer>> c = new ArrayList<ArrayList<Integer>>();
    public Graph grafo;

    public Kruskal() {
        X = new ArrayList<>();
        System.out.println("Kruskal criado!");
    }

    public void run(List<Aresta> A) {
        this.grafo = DAO.g;
        System.out.println("Executando kruskal");
        for (int i = 0; i < grafo.getNumVertices(); i++) {
            criarConjunto(i);
        }
//        System.out.println("Arestas kruskal");
//        for (Aresta aresta : DAO.g.getArestasOrdenadas()) {
//            System.out.println(aresta.getPeso() + "\t\t" + aresta.getOrigem() + "\t\t" + aresta.getDestino());
//        }
        for (Aresta a : A) {
            //  O seguinte trecho é responsavel por encontrar os index
            // de origem e destino dentro da lista de conjuntos c
            int origem = a.getOrigem();
            int destino = a.getDestino();
            int origemIndex = 0;
            int destinoIndex = 0;
            int cont = 0;
            for (ArrayList<Integer> l : c) {
                if (l.contains(origem)) {
                    origemIndex = cont;
                }
                if (l.contains(destino)) {
                    destinoIndex = cont;
                }
                cont++;
            }
            if (origemIndex != destinoIndex && X.size() < grafo.getNumVertices()) {
                X.add(a);
                //aplica uniao nos dois index da lista de conjuntos
                aplicarUniao(origemIndex, destinoIndex);
            }
        }
    }

    private void criarConjunto(int e) {
        ArrayList<Integer> l = new ArrayList<>();
        l.add(e);
        c.add(l);
    }

    private void aplicarUniao(int u, int v) {
        ArrayList<Integer> l = c.get(u);
        for (Integer elementOfV : c.get(v)) {
            if (l.contains(elementOfV) == false) {
                l.add(elementOfV);
            }
        }
        c.set(u, l);
        c.remove(v);
    }

    public void getResults() {
        double totalPeso = 0;
        System.out.println(X.size());
        for (int i = 0; i < X.size(); i++) {
            System.out.println(X.get(i).getOrigem() + "\t\t " + X.get(i).getDestino() + "\t\t" + X.get(i).getPeso());
            totalPeso += X.get(i).getPeso();
        }
        System.out.println("Peso: " + totalPeso);
    }

    public void escreveCSV(String fileName) throws IOException {
        FileWriter file;
        file = new FileWriter(new File(fileName + ".csv"));
        file.write("Origem, Destino, Peso\n");
        file.flush();
        for (Aresta a : X) {
            file.write(a.getOrigem() + "," + a.getDestino() + "," + a.getPeso() + "\n");
            file.flush();
        }
        System.out.println("Arquivo de saida '" + fileName + ".csv' criado com sucesso!");
    }

    public List<Aresta> getX() {
        return X;
    }

}
