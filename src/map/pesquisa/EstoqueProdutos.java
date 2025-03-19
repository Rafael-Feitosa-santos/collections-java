package map.pesquisa;

import java.util.HashMap;
import java.util.Map;

public class EstoqueProdutos {

    private Map<Long, Produto> estoqueProdutosMAp;

    public EstoqueProdutos() {
        this.estoqueProdutosMAp = new HashMap<>();
    }

    public void adicionarProduto(Long id, String nome, int quantidade, double preco) {
        estoqueProdutosMAp.put(id, new Produto(nome, preco, quantidade));
    }

    public void exibirProduto() {
        if (estoqueProdutosMAp.isEmpty()) {
            System.out.println("Estoque está vázio");
        } else {
            for (Map.Entry<Long, Produto> entry : estoqueProdutosMAp.entrySet()) {
                Long id = entry.getKey();
                Produto produto = entry.getValue();
                System.out.printf("ID: %d, Produto: %s, Quantidade: %d, Preço: %.2f\n", id, produto.getNome(), produto.getQuantidade(), produto.getPreco());
            }
        }
    }

    public double calculaValorTotalEstoque() {
        double valorTotalEstoque = 0;
        if (!estoqueProdutosMAp.isEmpty()) {
            for (Produto produto : estoqueProdutosMAp.values()) {
                valorTotalEstoque += produto.getQuantidade() * produto.getPreco();
            }
        }
        return valorTotalEstoque;
    }

    public Produto obterProdutoMaisCaro() {
        Produto produtoMaisCaro = null;
        double maiorPreco = Double.MIN_VALUE;
        if (!estoqueProdutosMAp.isEmpty()) {
            for (Produto produto : estoqueProdutosMAp.values()) {
                if (produto.getPreco() > maiorPreco) {
                    maiorPreco = produto.getPreco();
                    produtoMaisCaro = produto;
                }
            }
        }

        if (produtoMaisCaro != null) {
            System.out.printf("Produto mais caro:\nNome: %s - Quantidade: %d - Preço: R$ %.2f\n",
                    produtoMaisCaro.getNome(),
                    produtoMaisCaro.getQuantidade(),
                    produtoMaisCaro.getPreco());
        } else {
            System.out.println("Nenhum produto encontrado.");
        }
        return produtoMaisCaro;
    }

    public static void main(String[] args) {
        EstoqueProdutos estoque = new EstoqueProdutos();


        estoque.adicionarProduto(1l, "Produto A", 10, 5.0);
        estoque.adicionarProduto(2l, "Produto B", 5, 10.0);
        estoque.adicionarProduto(3l, "Produto C", 2, 15.0);
        estoque.adicionarProduto(8l, "Produto D", 2, 20.0);

        estoque.exibirProduto();
        System.out.println("=======================");
        System.out.printf("Valor total do estoque R$ %.2f\n", estoque.calculaValorTotalEstoque());
        System.out.println("=======================");
        estoque.obterProdutoMaisCaro();
    }
}
