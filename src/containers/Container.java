package containers;

import java.util.*;

public class Container {

    private double cc;
    private double cv;

    private double peso_atual;
    private double volume_atual;
    private double valor_total;
    private List<Produto> listaProduto;

    public Container(double cc, double cv) {
        this.cc = cc;
        this.cv = cv;
        this.listaProduto = new ArrayList<>();
    }

    public boolean inserirProduto(Produto produto) {
        if (this.peso_atual + produto.getPeso() > this.cc
                || this.volume_atual + produto.getVolume() > this.cv) {
            return false; // Estorou
        }
        // atualiza capacidade do container
        this.volume_atual += produto.getVolume();
        this.peso_atual += produto.getPeso();
        this.valor_total += produto.getLucro();
        
        // insere produto
        this.listaProduto.add(produto);        
        return true;
    }

    public double getPesoMaximo() {
        return cc;
    }

    public double getVolumeMaximo() {
        return cv;
    }

    public double getPesoAtual() {
        return peso_atual;
    }

    public double getVolumeAtual() {
        return volume_atual;
    }

    public double getValorTotal() {
        return valor_total;
    }

    public List<Produto> getListaProduto() {
        return listaProduto;
    }
}
