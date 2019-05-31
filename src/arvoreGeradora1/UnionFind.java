package arvoreGeradora1;

import java.io.FileNotFoundException;

public class UnionFind {
	private NodePathCompression[] conjuntos;
	
	public UnionFind() throws FileNotFoundException {
		this.conjuntos = new NodePathCompression[Matrizes.getMatrizAdjacencia().length];
		this.construir();
	}
	public NodePathCompression[] getConjuntos() {
		return this.conjuntos;
	}
	private void construir() {
		for (int i = 0; i < conjuntos.length; i++) {
			this.conjuntos[i] = new NodePathCompression();
			this.conjuntos[i].valor = i;
			this.conjuntos[i].pai = this.conjuntos[i];
		}
	}

	private NodePathCompression buscaRaiz(int indice) {
		NodePathCompression aux = this.conjuntos[indice];
		while (aux.valor != aux.pai.valor) {
			aux = aux.pai;
		}
		return aux;
	}

	public void juntar(int a, int b) {
		NodePathCompression raizA = this.buscaRaiz(a);
		NodePathCompression raizB = this.buscaRaiz(b);

		raizA.pai = raizB;
		this.conjuntos[a].pai = raizB;
		this.conjuntos[b].pai = raizB;
	}

	public boolean buscar(int a, int b) {
		NodePathCompression raizA = buscaRaiz(a);
		NodePathCompression raizB = buscaRaiz(b);
		return raizB.valor == raizA.valor;
	}
}