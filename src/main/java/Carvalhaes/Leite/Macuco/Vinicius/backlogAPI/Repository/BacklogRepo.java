package Carvalhaes.Leite.Macuco.Vinicius.backlogAPI.Repository;


import Carvalhaes.Leite.Macuco.Vinicius.backlogAPI.Model.BacklogItem;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;



@Repository
public class BacklogRepo {
    private final List<BacklogItem> backlog = new ArrayList<>();
    private final List<String> tags = new ArrayList<>();

    
    //Mostra todos os itens do backlog, independente do status
    public List<BacklogItem> getAllBacklog() {
        if (backlog.isEmpty()) {
            return null;
        }
        return backlog;
    }

    //Adiciona um item ao backlog
    public BacklogItem addBacklogItem(BacklogItem item) {
        backlog.add(item);
        return item;
    }

    //Mostra todos os itens do backlog que não foram lidos ou jogados
    public List<BacklogItem> getBacklog() {
        List<BacklogItem> backlogVerdadeiro = new ArrayList<>();
        for (BacklogItem item : backlog) {
            if (!item.getStatus()) {
                backlogVerdadeiro.add(item);
            }
        }
        if (backlogVerdadeiro.isEmpty()) {
            return null;
        }
        return backlogVerdadeiro;
    } 

    //Mostra todos os itens do backlog que foram lidos ou jogados
    public List<BacklogItem> getBacklogLido() {
        List<BacklogItem> backlogLido = new ArrayList<>();
        for (BacklogItem item : backlog) {
            if (item.getStatus()) {
                backlogLido.add(item);
            }
        }
        if (backlogLido.isEmpty()) {
            return null;
        }
        return backlogLido;
    }

    //Muda o status de um item do backlog ao passar seu nome
    public BacklogItem mudarStatusDoItem(String nome) {
        for (BacklogItem item : backlog) {
            if (item.getNome().equals(nome)) {
                item.changeStatus();
                return item;
            }
        }
        return null;
    }

    //Remove um item do backlog ao passar seu nome
    public BacklogItem removeBacklogItem(String nome) {
        for (BacklogItem item : backlog) {
            if (item.getNome().equals(nome)) {
                backlog.remove(item);
                return item;
            }
        }
        return null;
    }

    //Remove todos os itens concluidos do backlog
    public List<BacklogItem> removeBacklogConcluidos() {
        List<BacklogItem> backlogConcluidos = new ArrayList<>();
        for (BacklogItem item : backlog) {
            if (item.getStatus()) {
                backlogConcluidos.add(item);
                backlog.remove(item);
            }
        }
        return backlogConcluidos;
    }

    //Retorna uma sublista do backlog com os itens que possuem o tipo passada como parâmetro, ou seja, retorna somente os livros ou somente os jogos
    //O tipo pode ser "Livro" ou "Jogo"
    public List<BacklogItem> getBacklogPorTipo(String tipo) {
        List<BacklogItem> backlogPorTipo = new ArrayList<>();
        for (BacklogItem item : backlog) {
            if (item.getTipo().equals(tipo)) {
                backlogPorTipo.add(item);
            }
        }
        return backlogPorTipo;
    }
    //Retorna uma sublista do backlog com todos os itens que possuem as tags passadas como parâmetro
    public List<BacklogItem> getBacklogPorTag(List<String> tags) {
        List<BacklogItem> backlogPorTag = new ArrayList<>();
        for (BacklogItem item : backlog) {
            for (String tag : tags) {
                if (item.getTags().contains(tag)) {
                    backlogPorTag.add(item);
                }
            }
        }
        return backlogPorTag;
    }

}
