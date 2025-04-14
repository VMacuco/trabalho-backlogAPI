package Carvalhaes.Leite.Macuco.Vinicius.backlogAPI.Controller;

import Carvalhaes.Leite.Macuco.Vinicius.backlogAPI.Model.BacklogItem;
import Carvalhaes.Leite.Macuco.Vinicius.backlogAPI.Model.Jogo;
import Carvalhaes.Leite.Macuco.Vinicius.backlogAPI.Model.Livros;
import Carvalhaes.Leite.Macuco.Vinicius.backlogAPI.Repository.BacklogRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;
import java.util.List; 



@RestController
@RequestMapping("/backlog")
public class BacklogController {
    
    @Autowired
    private BacklogRepo backlogRepo;

    // Adiciona um item ao backlog
    //Um jogo
    @PostMapping("/adicionar-jogo")
    public ResponseEntity<BacklogItem> addJogo(@RequestBody Jogo novoJogo) {
        BacklogItem jogo = backlogRepo.addBacklogItem(novoJogo);
        return new ResponseEntity<>(jogo, HttpStatus.CREATED);
    }
    //Um livro
    @PostMapping("/adicionar-livro")
    public ResponseEntity<BacklogItem> addLivro(@RequestBody Livros novoLivro) {
        BacklogItem livro = backlogRepo.addBacklogItem(novoLivro);
        return new ResponseEntity<>(livro, HttpStatus.CREATED);
    }
    
    //Pegar todos os itens cadastrados no backlog
    @GetMapping("/todos")
    public ResponseEntity<List<BacklogItem>> getALLBacklog() {
        List<BacklogItem> backlog = backlogRepo.getAllBacklog();
        if (backlog == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(backlog, HttpStatus.OK);
    }
    //Pegar todos os itens que não foram lidos ou jogados
    @GetMapping("/a-fazer")
    public ResponseEntity<List<BacklogItem>> getBacklog() {
        List<BacklogItem> backlog = backlogRepo.getBacklog();
        if (backlog == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(backlog, HttpStatus.OK);
    }
    //Pegar todos os itens que foram lidos ou jogados
    @GetMapping("/concluidos")
    public ResponseEntity<List<BacklogItem>> getBacklogConcluido() {
        List<BacklogItem> backlog = backlogRepo.getBacklogConcluido();
        if (backlog == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(backlog, HttpStatus.OK);
    }
    
    //Pegar todos os itens de um tipo específico
    @GetMapping("/tipo/jogo")
    public ResponseEntity<List<BacklogItem>> getBacklogJogo() {
        List<BacklogItem> backlog = backlogRepo.getBacklogPorTipo("Jogo");
        if (backlog == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(backlog, HttpStatus.OK);
    }
    @GetMapping("/tipo/livro")
    public ResponseEntity<List<BacklogItem>> getBacklogLivro() {
        List<BacklogItem> backlog = backlogRepo.getBacklogPorTipo("Livro");
        if (backlog == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(backlog, HttpStatus.OK);
    }
    //Pegar todos os itens que possuam uma lista de tags específica
    @GetMapping("/tags")
    public ResponseEntity<List<BacklogItem>> getBacklogTags(@RequestBody List<String> tags) {
        List<BacklogItem> backlog = backlogRepo.getBacklogPorTag(tags);
        if (backlog == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(backlog, HttpStatus.OK);
    }
    //Pegar todos os itens de um tipo que possuam uma lista de tags específica
    @GetMapping("/tipo/jogo/tags")
    public ResponseEntity<List<BacklogItem>> getBacklogJogoTags(@RequestBody List<String> tags) {
        List<BacklogItem> backlog = backlogRepo.getBacklogPorTipoETag("Jogo", tags);
        if (backlog == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(backlog, HttpStatus.OK);
    }
    @GetMapping("/tipo/livro/tags")
    public ResponseEntity<List<BacklogItem>> getBacklogLivroTags(@RequestBody List<String> tags) {
        List<BacklogItem> backlog = backlogRepo.getBacklogPorTipoETag("Livro", tags);
        if (backlog == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(backlog, HttpStatus.OK);
    }
    
    //Muda o status de um item do backlog
    @PatchMapping("/alterar-status")
    public ResponseEntity<BacklogItem> mudarStatus(@RequestBody String nome) {
        BacklogItem item = backlogRepo.getNome(nome);
        if (item == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        item.changeStatus();
        return new ResponseEntity<>(item, HttpStatus.OK);
    }
    
    //Deletar todos os itens marcados como concluidos do backlog
    @DeleteMapping("/deletar-concluidos")
    public ResponseEntity<List<BacklogItem>> deletarConcluidos() {
        List<BacklogItem> deletados = backlogRepo.removeBacklogConcluidos();
        return new ResponseEntity<>(deletados, HttpStatus.OK);
    }
    //Deletar um item do backlog por nome
    @DeleteMapping("/deletar")
    public ResponseEntity<BacklogItem> deletarPorNome(@RequestBody String nome) {
        BacklogItem item = backlogRepo.getNome(nome);
        if (item == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        backlogRepo.removeBacklogItem(nome);
        return new ResponseEntity<>(item, HttpStatus.OK);
    }

}
