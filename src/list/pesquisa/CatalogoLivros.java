package list.pesquisa;

import java.util.ArrayList;
import java.util.List;

public class CatalogoLivros {

    private List<Livro> livroList;

    public CatalogoLivros() {
        this.livroList = new ArrayList<>();
    }

    public void adicionarLivro(String titulo, String autor, int anoPublicacao) {
        livroList.add(new Livro(titulo, autor, anoPublicacao));
    }

    public List<Livro> pesquisarPorAutor(String autor) {

        List<Livro> livrosPorAutor = new ArrayList<>();

        if (!livroList.isEmpty()) {
            for (Livro livro : livroList) {
                if (livro.getAutor().equalsIgnoreCase(autor)) {
                    livrosPorAutor.add(livro);
                }
            }
        }
        return livrosPorAutor;
    }

    public List<Livro> pesquisaPorIntervaloAnos(int anoInical, int anoFinal) {
        List<Livro> livrosPorIntervaloAnos = new ArrayList<>();
        if (!livroList.isEmpty()) {
            for (Livro livro : livroList) {
                if (livro.getAnoPulicacao() >= anoInical && livro.getAnoPulicacao() <= anoFinal) {
                    livrosPorIntervaloAnos.add(livro);
                }
            }
        }
        return livrosPorIntervaloAnos;
    }

    public List<Livro> pesquisarPorTitulo(String titulo) {
        List<Livro> livroPorTitulo = new ArrayList<>();
        if (!livroList.isEmpty()) {
            for (Livro livro : livroList) {
                if (livro.getTitulo().equalsIgnoreCase(titulo)) {
                    livroPorTitulo.add(livro);
                    break;
                }
            }
        }
        return livroPorTitulo;
    }

    public static void main(String[] args) {
        CatalogoLivros catalogoLivros = new CatalogoLivros();

        catalogoLivros.adicionarLivro("Livro 1", "Autor 1", 2020);
        catalogoLivros.adicionarLivro("Livro 1", "Autor 2", 2021);
        catalogoLivros.adicionarLivro("Livro 2", "Autor 2", 2022);
        catalogoLivros.adicionarLivro("Livro 3", "Autor 3", 2023);
        catalogoLivros.adicionarLivro("Livro 4", "Autor 4", 1994);

        for (Livro livro : catalogoLivros.pesquisaPorIntervaloAnos(2020, 2021)) {
            System.out.printf("Titulo: %s\n", livro.getTitulo());
            System.out.printf("Autor: %s\n", livro.getAutor());
            System.out.printf("Ano: %d\n", livro.getAnoPulicacao());
            System.out.println("------------------------------------");
        }

        //Pesquisa por Autor
        for (Livro livro : catalogoLivros.pesquisarPorAutor("Autor 2")) {
            System.out.printf("Titulo: %s\n", livro.getTitulo());
            System.out.printf("Autor: %s\n", livro.getAutor());
            System.out.printf("Ano: %d\n", livro.getAnoPulicacao());
            System.out.println("------------------------------------");
        }

        // Pesquisa por titulo
        for (Livro livro : catalogoLivros.pesquisarPorTitulo("Livro 1")) {
            System.out.printf("Titulo: %s\n", livro.getTitulo());
            System.out.printf("Autor: %s\n", livro.getAutor());
            System.out.printf("Ano: %d\n", livro.getAnoPulicacao());
            System.out.println("------------------------------------");
        }
    }
}
