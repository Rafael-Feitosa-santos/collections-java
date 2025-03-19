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
            for (Map.Entry<LocalDate, Evento> entry : eventoMap.entrySet()) {
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
        Map<LocalDate, Evento> eventosTreeMap = new TreeMap<>(eventoMap);
        for (Map.Entry<LocalDate, Evento> entry : eventoMap.entrySet()) {
            if (entry.getKey().isEqual(dataAtual) || entry.getKey().isAfter(dataAtual)) {
                proximaData = entry.getKey();
                proximoEvento = entry.getValue();
                System.out.printf("O próximo evento: %s acontecerá na data: %s", proximoEvento, proximaData);
                break;
            }
        }
    }


    public static void main(String[] args) {
        AgendaEvento agendaEvento = new AgendaEvento();

        agendaEvento.exibirAgenda();
    }
}
