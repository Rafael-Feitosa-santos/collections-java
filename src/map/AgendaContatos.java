package map;

import set.Pesquisa.Contato;

import java.util.HashMap;
import java.util.Map;

public class AgendaContatos {

    private Map<String, Integer> agendaContatoMap;

    public AgendaContatos() {
        this.agendaContatoMap = new HashMap<>();
    }

    public void adicionarContato(String nome, Integer telefone) {
        agendaContatoMap.put(nome, telefone);
    }

    public void removerContato(String nome) {
        if (!agendaContatoMap.isEmpty()) {
            agendaContatoMap.remove(nome);
        }
    }

    public void exibirContato() {
        System.out.println(agendaContatoMap);
    }

    public Integer pesquisarPorNome(String nome) {
        Integer numeroPorNome = null;
        if (!agendaContatoMap.isEmpty()) {
            numeroPorNome = agendaContatoMap.get(nome);
        }
        return numeroPorNome;
    }

    public static void main(String[] args) {
        AgendaContatos agendaContatos = new AgendaContatos();

        agendaContatos.adicionarContato("Camila", 123456);
        agendaContatos.adicionarContato("Camila", 5665);
        agendaContatos.adicionarContato("Camila Cavalcante", 1111111);
        agendaContatos.adicionarContato("Camila DIO", 654987);
        agendaContatos.adicionarContato("Maria Silva", 11111111);
        agendaContatos.adicionarContato("Camila", 44444);

        if (agendaContatos.agendaContatoMap.isEmpty()) {
            System.out.println("A agenda de contatos está vazia.");
        } else {
            for (Map.Entry<String, Integer> entry : agendaContatos.agendaContatoMap.entrySet()) {
                System.out.printf("Nome: %s - número: %d%n", entry.getKey(), entry.getValue());
            }
        }

        System.out.println("=============================");

        agendaContatos.removerContato("Maria Silva");

        if (agendaContatos.agendaContatoMap.isEmpty()) {
            System.out.println("A agenda de contatos está vazia.");
        } else {
            for (Map.Entry<String, Integer> entry : agendaContatos.agendaContatoMap.entrySet()) {
                System.out.printf("Nome: %s - número: %d%n", entry.getKey(), entry.getValue());
            }
        }

        System.out.println("=============================");

        System.out.printf("O número é: %d", agendaContatos.pesquisarPorNome("Camila DIO"));
    }
}
