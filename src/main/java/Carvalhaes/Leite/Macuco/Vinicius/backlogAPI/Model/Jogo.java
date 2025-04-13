package Carvalhaes.Leite.Macuco.Vinicius.backlogAPI.Model;

import java.util.List;
import Carvalhaes.Leite.Macuco.Vinicius.backlogAPI.Model.BacklogItem;



public class Jogo extends BacklogItem {
    private String plataforma; //plataforma do jogo. As plataformas podem ser: PS4, PS5, Xbox One, Xbox Series X, Nintendo Switch, PC, etc.
    private String desenvolvedora; //desenvolvedora do jogo. As desenvolvedoras podem ser: Ubisoft, EA, Activision, etc.
    private String anoLancamento; //ano de lançamento do jogo. O ano de lançamento pode ser: 2020, 2021, 2022, etc.

    public Jogo(String nome, String descricao, String tag, String plataforma, String desenvolvedora, String anoLancamento) {
        super(nome, descricao, tag);
        this.plataforma = plataforma;
        this.desenvolvedora = desenvolvedora;
        this.anoLancamento = anoLancamento;
        this.setTipo("Jogo");
    }
    public Jogo(String nome, String descricao, List<String> tags, String plataforma, String desenvolvedora, String anoLancamento) {
        super(nome, descricao, tags);
        this.plataforma = plataforma;
        this.desenvolvedora = desenvolvedora;
        this.anoLancamento = anoLancamento;
        this.setTipo("Jogo");
    }
    //gets e sets para os atributos
    public String getPlataforma() {
        return plataforma;
    }
    public String getDesenvolvedora() {
        return desenvolvedora;
    }
    public String getAnoLancamento() {
        return anoLancamento;
    }
    public void setPlataforma(String plataforma) {
        this.plataforma = plataforma;
    }
    public void setDesenvolvedora(String desenvolvedora) {
        this.desenvolvedora = desenvolvedora;
    }
    public void setAnoLancamento(String anoLancamento) {
        this.anoLancamento = anoLancamento;
    }

}
