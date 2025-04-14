
package Carvalhaes.Leite.Macuco.Vinicius.backlogAPI.Model;

import java.util.List;

// Representa um livro no backlog, herda os atributos de backlogItem

public class Livros extends BacklogItem {
    private String autor; //autor do livro. Os autores podem ser: Rick Riordan, George R.R. Martin, etc.
    private String editora; //editora do livro. As editoras podem ser: Editora Abril, Editora Globo, etc.
    private String lingua; //lingua do livro. As linguas podem ser: português, inglês, espanhol, etc.
    private String anoLancamento; //ano de lançamento do livro. O ano de lançamento pode ser: 2020, 2021, 2022, etc.

    public Livros() {
        super();
        this.setTipo("Livro");
    }
    
    public Livros(String nome, String descricao, String tag, String autor, String editora, String lingua, String anoLancamento) {
        super(nome, descricao, tag);
        this.autor = autor;
        this.editora = editora;
        setLingua(lingua);
        this.anoLancamento = anoLancamento;
        this.setTipo("Livro");
    }

    //gets e sets para os atributos
    public String getAutor() {
        return autor;
    }

    public String getEditora() {
        return editora;
    }

    public String getAnoLancamento() {
        return anoLancamento;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }

    public void setAnoLancamento(String anoLancamento) {
        if (anoLancamento == null || !anoLancamento.matches("\\d{4}")) {
            throw new IllegalArgumentException("Ano deve estar no formato YYYY");
        }
        this.anoLancamento = anoLancamento;
    }

    public void setLingua(String lingua) {
        if (lingua == null || lingua.trim().isEmpty()) {
            throw new IllegalArgumentException("Língua não pode ser vazia");
        }
        this.lingua = lingua;
    }

    public String getLingua() {
        return lingua;
    }
}
