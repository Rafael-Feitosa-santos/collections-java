package list.ordenacao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class OrdenacaoPessoa {

    private List<Pessoa> pessoaList;

    public OrdenacaoPessoa() {
        this.pessoaList = new ArrayList<>();
    }

    public void adicionarPessoa(String nome, int idade, double altura) {
        pessoaList.add(new Pessoa(nome, idade, altura));
    }

    public List<Pessoa> ordenarPorIdade() {
        List<Pessoa> pessoasPorIdade = new ArrayList<>(pessoaList);
        Collections.sort(pessoasPorIdade);
        return pessoasPorIdade;
    }

    public List<Pessoa> ordenarPorAltura() {
        List<Pessoa> pessoasPorAltura = new ArrayList<>(pessoaList);
        Collections.sort(pessoasPorAltura, new ComparatorPorAltura());
        return pessoasPorAltura;
    }

    public static void main(String[] args) {
        OrdenacaoPessoa ordenacaoPessoa = new OrdenacaoPessoa();
        ordenacaoPessoa.adicionarPessoa("Nome 1", 20, 1.56);
        ordenacaoPessoa.adicionarPessoa("Nome 2", 30, 1.80);
        ordenacaoPessoa.adicionarPessoa("Nome 3", 25, 1.70);
        ordenacaoPessoa.adicionarPessoa("Nome 4", 17, 1.56);


        // Ordenação por idade
        for (Pessoa pessoa : ordenacaoPessoa.ordenarPorIdade()) {
            System.out.printf("Nome: %s\n", pessoa.getNome());
            System.out.printf("Idade: %d\n", pessoa.getIdade());
            System.out.printf("Nome: %.2f\n", pessoa.getAltura());
            System.out.println("====================");
        }

        // Ordenação por altura
        for (Pessoa pessoa : ordenacaoPessoa.ordenarPorAltura()) {
            System.out.printf("Nome: %s\n", pessoa.getNome());
            System.out.printf("Idade: %d\n", pessoa.getIdade());
            System.out.printf("Altura: %.2f\n", pessoa.getAltura());
            System.out.println("========================");
        }
    }
}
