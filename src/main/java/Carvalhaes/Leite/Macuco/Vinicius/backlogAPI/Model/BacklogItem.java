package Carvalhaes.Leite.Macuco.Vinicius.backlogAPI.Model;

// A classe BacklogItem represeta um item do backlog, seja ele um jogo ou um livro
import java.util.ArrayList;
import java.util.List;

public class BacklogItem {
    private String nome; //nome do item
    private String descricao; //descricao do item
    private String tipo; //define se o item é um jogo ou um livro, para facilitar a pesquisa futura
    private List<String> tags; //tags do item, para facilitar a pesquisa futura. As tags podem ser: ficção, romance, aventura, sci-fi, fantasia, terror, ação, RPG, etc.
    private boolean status; //status do item, . Os status podem ser: lido, jogado (true) ou não lido, não jogado (false).

    //construtor para criar um item com nome, descricao e uma tag para começar
    public BacklogItem(String nome, String descricao, String tag) {
        this.nome = nome;
        this.descricao = descricao;
        this.tags = new ArrayList<>();
        tags.add(tag);
        this.status = false; //status padrão é false, ou seja, não lido, não jogado
    }
    //construtor para criar um item com nome, descricao e uma lista de tags
    public BacklogItem(String nome, String descricao, List<String> tags) {
        this.nome = nome;
        this.descricao = descricao;
        this.tags = new ArrayList<>(tags);
    }

    //gets e sets para os atributos

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    public String getNome() {
        return nome;
    }
    public String getDescricao() {
        return descricao;
    }
    public String getTipo() {
        return tipo;
    }
    public List<String> getTags() {
        return tags;
    }
    public void addTag(String tag) {
        for (String t : this.tags) {
            if (t.equals(tag)) {
                return; // Se a tag já existe, não adiciona novamente
            }
        }
        this.tags.add(tag);
    }
    public void removeTag(String tag) {
        this.tags.remove(tag);
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public boolean getStatus() {
        return status;
    }
    public void changeStatus() {
        if (this.status) {
            this.status = false; //se o status for true, muda para false
        } else {
            this.status = true; //se o status for false, muda para true
        }
    }
    
}
