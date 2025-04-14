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
    void contextLoads() {}


}
