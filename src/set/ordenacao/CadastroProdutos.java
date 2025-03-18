package set.ordenacao;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class CadastroProdutos {

    private Set<Produto> produtoSet;

    public CadastroProdutos() {
        this.produtoSet = new HashSet<>();
    }

    public void adicionarProduto(Long id, String nome, double preco, int quantidade) {
        produtoSet.add(new Produto(id, nome, preco, quantidade));
    }

    public Set<Produto> exibirProdutosPorNome() {
        Set<Produto> produtosPorNome = new TreeSet<>(produtoSet);
        return produtosPorNome;
    }

    public Set<Produto> exibirProdutoPorPreco() {
        Set<Produto> produtosPorPreco = new TreeSet<>(new ComparatorPorPreco());
        produtosPorPreco.addAll(produtoSet);
        return produtosPorPreco;
    }

    public static void main(String[] args) {
        CadastroProdutos cadastroProdutos = new CadastroProdutos();
        cadastroProdutos.adicionarProduto(1l, "Produto 5", 15d, 5);
        cadastroProdutos.adicionarProduto(2l, "Produto 0", 20d, 10);
        cadastroProdutos.adicionarProduto(1l, "Produto 3", 10d, 2);
        cadastroProdutos.adicionarProduto(9l, "Produto 9", 2d, 2);

        System.out.println("========= Exibi o Set =========");
        for (Produto produto : cadastroProdutos.produtoSet) {
            System.out.printf("Id: %d - Nome: %s - Preco: %.2f - Qtde: %d\n", produto.getId(), produto.getNome(), produto.getPreco(), produto.getQuantidade());
        }

        //Exibir por nome
        System.out.println("========= Exibi ordenado por nome =========");
        for (Produto produto : cadastroProdutos.exibirProdutosPorNome()) {
            System.out.printf("Id: %d - Nome: %s - Preco: %.2f - Qtde: %d\n", produto.getId(), produto.getNome(), produto.getPreco(), produto.getQuantidade());
        }

        //Exibir produto por preco
        System.out.println("========= Exibi ordenado por preco =========");
        for (Produto produto : cadastroProdutos.exibirProdutoPorPreco()) {
            System.out.printf("Id: %d - Nome: %s - Preco: %.2f - Qtde: %d\n", produto.getId(), produto.getNome(), produto.getPreco(), produto.getQuantidade());
        }
    }
}
