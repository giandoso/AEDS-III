package AGM;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author giandoso
 */
public class Graph {

    public List<Aresta>[] lista_arestas;
    public List<Vertice> lista_vertices;

    public Graph(ArrayList<double[]> tuplas) {
        lista_arestas = new List[tuplas.size()];
        lista_vertices = new ArrayList<>();
        for (int i = 0; i < tuplas.size(); i++) {
            lista_arestas[i] = new LinkedList<>();
            Vertice v = new Vertice(i, tuplas.get(i)[0], tuplas.get(i)[1]);
            lista_vertices.add(v);
        }
        System.out.println("Grafo criado!");

    }

    public void setPesoAresta(int origem, int destino, double peso) {
        for (int i = 0; i < lista_arestas[origem].size(); i++) {
            if (lista_arestas[origem].get(i).getDestino() == destino) {
                Aresta a = new Aresta(destino, peso);
                lista_arestas[origem].set(i, a);
            }
        }
    }

    public void addAresta(int origem, int destino, double peso) {
        Aresta a = new Aresta(destino, peso);
        lista_arestas[origem].add(a);
    }

    public double getPesoAresta(int origem, int destino) {
        for (int i = 0; i < lista_arestas[origem].size(); i++) {
            if (lista_arestas[origem].get(i).getDestino() == destino) {
                return lista_arestas[origem].get(i).getPeso();
            }

        }
        return Double.POSITIVE_INFINITY;
    }

    public void removeAresta(int origem, int destino) {
        for (int i = 0; i < lista_arestas[origem].size(); i++) {
            if (lista_arestas[origem].get(i).getDestino() == destino) {
                System.out.println("Aresta "+ origem +"->" + destino + " removida");
                lista_arestas[origem].remove(i);
            }

        }
    }

    public int getNumArestas() {
        int cont = 0;
        for (int i = 0; i < lista_arestas.length; i++) {
            cont += lista_arestas[i].size();
        }
        return cont;
    }

    public List<Aresta> getArestasOrdenadas() {
        List<Aresta> l = new LinkedList<>();
        for (int i = 0; i < lista_arestas.length; i++) {
            for (int j = i + 1; j < lista_arestas[i].size(); j++) {
                if (i != j) {
                    Aresta a = new Aresta(i, lista_arestas[i].get(j).getDestino(), lista_arestas[i].get(j).getPeso());
                    l.add(a);
                }
            }
        }
        Collections.sort(l);
        return l;
    }

    public boolean existeAresta(int origem, int destino) {
        for (int i = 0; i < lista_arestas[origem].size(); i++) {
            if (lista_arestas[origem].get(i).getDestino() == destino) {
                return true;
            }

        }
        return false;
    }

    public List<Integer> getAdjacentes(int vertice) {
        List<Integer> l = new ArrayList();
        for (int i = 0; i < lista_arestas[vertice].size(); i++) {
            l.add(lista_arestas[vertice].get(i).getDestino());
        }
        return l;
    }

    public int getNumVertices() {
        return lista_arestas.length;
    }
}
