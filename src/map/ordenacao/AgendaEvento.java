package map.ordenacao;

import map.pesquisa.Produto;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class AgendaEvento {

    private Map<LocalDate, Evento> eventoMap;

    public AgendaEvento() {
        this.eventoMap = new HashMap<>();
    }

    public void adicionarEvento(LocalDate data, String nome, String atracao) {
        eventoMap.put(data, new Evento(nome, atracao));
    }

    public void exibirAgenda() {
        Map<LocalDate, Evento> eventosTreeMap = new TreeMap<>(eventoMap);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        if (eventoMap.isEmpty()) {
            System.out.println("Não existe evento agendado.");
        } else {
            for (Map.Entry<LocalDate, Evento> entry : eventosTreeMap.entrySet()) {
                LocalDate data = entry.getKey();
                Evento evento = entry.getValue();
                System.out.printf("Data: %s- evento: %s\n", data.format(formatter), evento.getAtracao());
            }
        }
    }

    public void obterProximoEvento() {
        LocalDate dataAtual = LocalDate.now();
        LocalDate proximaData = null;
        Evento proximoEvento = null;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        Map<LocalDate, Evento> eventosTreeMap = new TreeMap<>(eventoMap);

        for (Map.Entry<LocalDate, Evento> entry : eventosTreeMap.entrySet()) {
            if (!entry.getKey().isBefore(dataAtual)) { // Verifica se a data é hoje ou futura
                proximaData = entry.getKey();
                proximoEvento = entry.getValue();
                System.out.printf("Próximo evento - Data: %s - Evento: %s%n",
                        proximaData.format(formatter),
                        proximoEvento.getNome()); // Supondo que Evento tenha getNome()
                break;
            }
        }

        // Caso não haja eventos futuros
        if (proximoEvento == null) {
            System.out.println("Nenhum evento futuro encontrado.");
        }
    }


    public static void main(String[] args) {
        AgendaEvento agendaEvento = new AgendaEvento();

        agendaEvento.adicionarEvento(LocalDate.of(2025, 03, 18), "Evento 1", "Atração 1");
        agendaEvento.adicionarEvento(LocalDate.of(2025, 07, 9), "Evento 2", "Atração 2");
        agendaEvento.adicionarEvento(LocalDate.of(2025, 01, 10), "Evento 3", "Atração 3");
        agendaEvento.adicionarEvento(LocalDate.of(2025, 03, 19), "Evento 4", "Atração 4");

        agendaEvento.exibirAgenda();

        agendaEvento.obterProximoEvento();
    }
}
