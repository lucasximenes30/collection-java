package map.pesquisa;

import java.util.HashMap;
import java.util.Map;

public class EstoqueProdutos {

    private Map<Long, Produto> estoqueMap;

    public EstoqueProdutos() {
        this.estoqueMap = new HashMap<>();
    }

    public void adicionarProduto(long cod, String nome, int quantidade, double preco){
        estoqueMap.put(cod, new Produto(nome, preco, quantidade));
    }
    public void exibirProduto(){
        System.out.println(estoqueMap);
    }
    public double calculaValorTotalEstoque(){
        double valorTotalEstoque = 0;
        if(!estoqueMap.isEmpty()){
            for (Produto p: estoqueMap.values()){
                valorTotalEstoque += p.getQuantidade() * p.getPreco();
            }
        }
        return valorTotalEstoque;
    }
    public Produto obterProdutoMaisCaro(){
        Produto produtoMaisCaro = null;
        double maiorPreco = Double.MIN_VALUE;
        for(Produto p : estoqueMap.values()){
            if(p.getPreco() > maiorPreco){
                produtoMaisCaro = p;
            }
        }
        return produtoMaisCaro;
    }
    public Produto obterProdutoMaisBarato(){
        Produto produtoMaisBarato = null;
        double menorPreco = Double.MAX_VALUE;
        for(Produto p : estoqueMap.values()){
            if(p.getPreco() < menorPreco){
                produtoMaisBarato = p;
            }
        }
        return produtoMaisBarato;
    }
}
