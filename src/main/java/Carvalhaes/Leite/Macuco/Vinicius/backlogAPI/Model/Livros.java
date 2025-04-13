
package Carvalhaes.Leite.Macuco.Vinicius.backlogAPI.Model;

import java.util.List;

public class Livros extends BacklogItem {
    private String autor; //autor do livro. Os autores podem ser: Rick Riordan, George R.R. Martin, etc.
    private String editora; //editora do livro. As editoras podem ser: Editora Abril, Editora Globo, etc.
    private String lingua; //lingua do livro. As linguas podem ser: português, inglês, espanhol, etc.
    private String anoLancamento; //ano de lançamento do livro. O ano de lançamento pode ser: 2020, 2021, 2022, etc.

    public Livros(String nome, String descricao, String tag, String autor, String editora, String lingua, String anoLancamento) {
        super(nome, descricao, tag);
        this.autor = autor;
        this.editora = editora;
        this.lingua = lingua;
        this.anoLancamento = anoLancamento;
        this.setTipo("Livro");
    }

    public Livros(String nome, String descricao, List<String> tags, String autor, String editora, String lingua, String anoLancamento) {
        super(nome, descricao, tags);
        this.autor = autor;
        this.editora = editora;
        this.lingua = lingua;
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
        this.anoLancamento = anoLancamento;
    }
}
