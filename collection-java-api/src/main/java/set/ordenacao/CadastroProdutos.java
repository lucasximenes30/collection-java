package set.ordenacao;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class CadastroProdutos {
    private Set<Produto> produtoSet;

    public CadastroProdutos() {
        this.produtoSet = new HashSet<>();
    }
    public void adicionarProduto(long cod, String nome, double preco, int quantidade){
        produtoSet.add(new Produto(cod, nome, preco, quantidade));
    }
    public Set<Produto> exibirProdutoPorNome(){
        Set<Produto> produtoPorNome = new TreeSet<>(produtoSet);
        return produtoPorNome;
    }
    public Set<Produto> exibirPorPreco(){
        Set<Produto> produtoPorPreco = new TreeSet<>(new ComparatorPorPreco());
        produtoPorPreco.addAll(produtoSet);
        return produtoPorPreco;
    }
    public static void main(String[] args) {

        // Criando o cadastro
        CadastroProdutos cadastro = new CadastroProdutos();

        // Adicionando produtos
        cadastro.adicionarProduto(1, "Arroz", 25.0, 50);
        cadastro.adicionarProduto(2, "Feijão", 12.0, 30);
        cadastro.adicionarProduto(3, "Macarrão", 8.5, 80);
        cadastro.adicionarProduto(4, "Óleo", 7.0, 20);
        cadastro.adicionarProduto(5, "Café", 18.0, 60);

        System.out.println("=== Produtos SEM ORDEM (HashSet) ===");
        System.out.println(cadastro.produtoSet);

        System.out.println("\n=== Produtos ORDENADOS POR NOME (TreeSet) ===");
        System.out.println(cadastro.exibirProdutoPorNome());

        System.out.println("\n=== Produtos ORDENADOS POR PREÇO (TreeSet + Comparator) ===");
        System.out.println(cadastro.exibirPorPreco());
    }
}
