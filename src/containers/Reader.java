package containers;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Reader {

    public static Container[] ler_env(String env) throws FileNotFoundException, IOException {
        BufferedReader br = new BufferedReader(new FileReader(env));
        String linha = br.readLine();
        linha = br.readLine();
        String[] linha_split = linha.split(",");
        int k = Integer.parseInt(linha_split[1]);
        int cc = Integer.parseInt(linha_split[2]);
        int cv = Integer.parseInt(linha_split[3]);

        Container[] containers = new Container[k];
        for (int i = 0; i < containers.length; i++) {
            containers[i] = new Container(cc, cv);
        }
        return containers;
    }

    public static ArrayList<Produto> ler_products(String env, String products) throws FileNotFoundException, IOException {
        BufferedReader br = null;
        br = new BufferedReader(new FileReader(env));
        String linha = br.readLine(); // remoção do cabeçalho
        linha = br.readLine();
        String[] valores = linha.split(",");
        int quantProd = Integer.parseInt(valores[0]);
        ArrayList<Produto> produtos = new ArrayList<Produto>();
        br.close();
        br = new BufferedReader(new FileReader(products));
        linha = br.readLine(); // remoção do cabeçalho
        while (br.ready()) {
            linha = br.readLine();
            valores = linha.split(",");
            String numProduto = valores[0];
            double volume = Double.parseDouble(valores[1]);
            double peso = Double.parseDouble(valores[2]);
            double lucro = Double.parseDouble(valores[3]);
            Produto produto = new Produto(numProduto, volume, peso, lucro);
            produtos.add(produto);
        }
        return produtos;
    }
}
