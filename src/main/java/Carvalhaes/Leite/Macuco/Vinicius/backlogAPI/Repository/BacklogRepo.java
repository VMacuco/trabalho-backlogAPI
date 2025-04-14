package Carvalhaes.Leite.Macuco.Vinicius.backlogAPI.Repository;


import Carvalhaes.Leite.Macuco.Vinicius.backlogAPI.Model.BacklogItem;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;



@Repository
public class BacklogRepo {
    private final List<BacklogItem> backlog = new ArrayList<>();

    
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

    //Remove um item do backlog ao passar seu nome
    public void deletarPorNome(String nome) {
        for (BacklogItem item : backlog) {
            if (item.getNome().equals(nome)) {
                backlog.remove(item);
                return;
            }
        }
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
    public List<BacklogItem> getBacklogConcluido() {
        List<BacklogItem> backlogConcluido = new ArrayList<>();
        for (BacklogItem item : backlog) {
            if (item.getStatus()) {
                backlogConcluido.add(item);
            }
        }
        if (backlogConcluido.isEmpty()) {
            return null;
        }
        return backlogConcluido;
    }

    //Muda o status de um item do backlog ao passar seu nome
    public BacklogItem mudarStatusDoItem(String nome) {
        for (BacklogItem item : backlog) {
            if (item.getNome().equalsIgnoreCase(nome)) {
                item.changeStatus();
                return item;
            }
        }
        return null;
    }

    //Remove um item do backlog ao passar seu nome
    public BacklogItem removeBacklogItem(String nome) {
        for (BacklogItem item : backlog) {
            if (item.getNome().equalsIgnoreCase(nome)) {
                backlog.remove(item);
                return item;
            }
        }
        return null;
    }

    //Remove todos os itens concluidos do backlog
    public List<BacklogItem> removeBacklogConcluidos() {
    List<BacklogItem> concluidos = backlog.stream()
            .filter(BacklogItem::getStatus)
            .collect(Collectors.toList());
            
    backlog.removeAll(concluidos);
    return concluidos;
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
            if (item.getTags().containsAll(tags)) {
                backlogPorTag.add(item);
            }
        }
        return backlogPorTag;
    }

    //Retorna uma sublista do backlog com todos os itens que possuem o tipo e as tags passadas como parâmetro
    public List<BacklogItem> getBacklogPorTipoETag(String tipo, List<String> tags) {
        List<BacklogItem> backlogPorTipoETag = new ArrayList<>();
        for (BacklogItem item : backlog) {
            if (item.getTipo().equals(tipo)) {
                if (item.getTags().containsAll(tags)) {
                    backlogPorTipoETag.add(item);
                }
            }
        }
        return backlogPorTipoETag;
    }

    //Retorna um item do backlog ao passar seu nome
    public BacklogItem getNome(String nome) {
        for (BacklogItem item : backlog) {
            if (item.getNome().equalsIgnoreCase(nome)) {
                return item;
            }
        }
        return null;
    }

    //Adiociona tags a um item do backlog ao passar seu nome
    public BacklogItem addTag(String nome, String tag) {
        for (BacklogItem item : backlog) {
            if (item.getNome().equalsIgnoreCase(nome)) {
                item.addTag(tag);
                return item;
            }
        }
        return null;
    }

    public BacklogItem findAndRemoveItem(String nome) {
        BacklogItem itemParaRemover = null;
        
        // Encontra o item
        for (BacklogItem item : backlog) {
            if (item.getNome().equals(nome)) {
                itemParaRemover = item;
                break;
            }
        }
        
        // Se encontrou, remove
        if (itemParaRemover != null) {
            backlog.remove(itemParaRemover);
        }
        
        return itemParaRemover;
    }

}
