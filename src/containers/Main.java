package containers;

import java.io.IOException;
import java.util.*;

public class Main {

    static List<Produto> produtos_por_peso;
    static List<Produto> produto_visitado;
    static Container[] containers;

    public static void main(String[] args) throws IOException {
        containers = Reader.ler_env("src/containers/env3.csv");
        produtos_por_peso = Reader.ler_products("src/containers/env1.csv", "src/containers/products.csv");
        Collections.sort(produtos_por_peso);
        produto_visitado = new ArrayList<Produto>();

        Produto melhor_produto = null;
        double melhor_valor = 0;
        
        // popula os conteiners
        int i = 0;
        while (i < containers.length -1) {
            for (Produto produto : produtos_por_peso) {
                double valor_atual = produto.getLucro();
                if (valor_atual > melhor_valor && produto_visitado.contains(produto) == false) {
                    melhor_produto = produto;
                    melhor_valor = valor_atual;
                }
            }
            if (containers[i].inserirProduto(melhor_produto) == false) { //Container cheio
                i++;
                containers[i].inserirProduto(melhor_produto); //insere no proximo
            }
            produto_visitado.add(melhor_produto);
        }

        // preenche os conteiners
        for (Produto produto : produtos_por_peso) {
            if (produto_visitado.contains(produto) == false) {
                for (int j = 0; j < containers.length; j++) {
                    if (containers[j].inserirProduto(produto)) {
                        produto_visitado.add(produto);
                        break;
                    }
                }
            }
        }

        // apresenta os resulutados
        double total = 0;
        for (i = 0; i < containers.length; i++) {
            total += containers[i].getValorTotal();
            if (i < 10) {
                System.out.println("C" + i + " : " + containers[i].getValorTotal());
            } else {
                System.out.println("C" + i + ": " + containers[i].getValorTotal());

            }
        }
        System.out.println("");
        System.out.println("Total: " + total);
    }
}
