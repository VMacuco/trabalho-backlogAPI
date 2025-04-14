package Carvalhaes.Leite.Macuco.Vinicius.backlogAPI;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.List;

import org.apache.tomcat.util.http.parser.MediaType;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import Carvalhaes.Leite.Macuco.Vinicius.backlogAPI.Model.BacklogItem;
import Carvalhaes.Leite.Macuco.Vinicius.backlogAPI.Model.Jogo;

@SpringBootTest
class BacklogApiApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@Test
void adicionarJogo_DeveRetornar201() throws Exception {
    Jogo jogo = new Jogo("Cyberpunk 2077", "RPG futurista", "RPG", "PC", "CD Projekt", "2020");
    
    // Configura o mock
    when(backlogRepo.addBacklogItem(any(Jogo.class))).thenReturn(jogo);

    // Faz a requisição POST com JSON
    mockMvc.perform(post("/backlog/adicionar-jogo")
           .contentType(MediaType.APPLICATION_JSON)
           .content("""
               {
                   "nome": "Cyberpunk 2077",
                   "descricao": "RPG futurista",
                   "tag": "RPG",
                   "plataforma": "PC",
                   "desenvolvedora": "CD Projekt",
                   "anoLancamento": "2020"
               }
           """))
           .andExpect(status().isCreated())  // Espera HTTP 201
           .andExpect(jsonPath("$.nome").value("Cyberpunk 2077"));
}

}
