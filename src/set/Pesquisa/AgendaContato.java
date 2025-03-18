package set.Pesquisa;

import java.io.FilterOutputStream;
import java.util.HashSet;
import java.util.Set;

public class AgendaContato {

    private Set<Contato> contatoSet;

    public AgendaContato() {
        this.contatoSet = new HashSet<>();
    }

    public void adicionarContato(String nome, int numero) {
        contatoSet.add(new Contato(nome, numero));
    }

    public void exibirContato() {
        for(Contato contato: contatoSet){
            System.out.printf("Nome: %s - numero: %d\n", contato.getNome(), contato.getNumero());
        }
    }

    public Set<Contato> pesquisarPorNome(String nome) {
        Set<Contato> contatosPorNome = new HashSet<>();
        for (Contato contato : contatoSet) {
            if (contato.getNome().startsWith(nome)) {
                contatosPorNome.add(contato);
            }
        }
        return contatosPorNome;
    }

    public Contato atualizarNumeroContato(String nome, int novoNumero) {
        Contato contatoAtualizado = null;
        for (Contato contato : contatoSet) {
            if (contato.getNome().equalsIgnoreCase(nome)) {
                contato.setNumero(novoNumero);
                contatoAtualizado = contato;
                break;
            }
        }
        return contatoAtualizado;
    }

    public static void main(String[] args) {
        AgendaContato agendaContato = new AgendaContato();
        agendaContato.exibirContato();

        agendaContato.adicionarContato("camila", 123456);
        agendaContato.adicionarContato("camila", 5665);
        agendaContato.adicionarContato("Rafael", 1111111);
        agendaContato.adicionarContato("Rafael DIO", 654987);
        agendaContato.adicionarContato("Maria Silva", 1111111);

        // Exibir
        agendaContato.exibirContato();

        System.out.println(agendaContato.pesquisarPorNome("Rafael"));
        System.out.println("Contato Atualizado " + agendaContato.atualizarNumeroContato("Maria Silva",5555555));


        agendaContato.exibirContato();
    }
}
