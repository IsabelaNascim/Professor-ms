package br.com.nava.controllers;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;

import java.nio.charset.StandardCharsets;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.nava.dtos.ProfessorDTO;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ProfessorControllerTest {
	
	//temos que fazer as quisições para os endpoints do controller que queremos testar
	
	//responsável por criar as requisições REST para  a camada de Controller
	@Autowired
	private MockMvc mockMvc;
	
	@Test
	void getAllTest() throws Exception{
		
		//armazena o objeto que fará o teste e colhe o resultado 
		ResultActions response = mockMvc.perform(
											get("/professores")
											.contentType("application/json")
										);
		//pegando o resultado via MvcResult
		MvcResult result = response.andReturn();
		//pegando o resultado no formato String
		String responseStr = result.getResponse().getContentAsString(StandardCharsets.UTF_8);		
		System.out.println(responseStr);
		
		ObjectMapper mapper = new ObjectMapper();
		//converter oresultado de String em uma Array de Objetos de Professor DTO
		ProfessorDTO[] lista = mapper.readValue(responseStr, ProfessorDTO[].class);
		//verificando se a lista de retorno não é vazia
		assertThat(lista).isNotEmpty();
	}
	
	@Test
	void getOneTest() throws Exception{
		
		ResultActions response = mockMvc.perform( 
												get("/professores/3")
												.contentType("application/json")
											);
		
		MvcResult result = response.andReturn();
		String responseStr = result.getResponse().getContentAsString(StandardCharsets.UTF_8);
		
		ObjectMapper mapper = new ObjectMapper();
		ProfessorDTO professor = mapper.readValue(responseStr, ProfessorDTO.class);
		
		assertThat(professor.getId()).isEqualTo(3);
		assertThat(result.getResponse().getStatus()).isEqualTo(200);
	}
	
	@Test
	void saveTeste() throws Exception{
		
		ObjectMapper mapper = new ObjectMapper();
		
		//criamos um objeto do tipo ProfessorDTO para enviarmos junto com a requisição
		ProfessorDTO professor = new ProfessorDTO();
		professor.setCep("07151-020");
		professor.setNome("Professor Teste");
		professor.setNumero(03);
		professor.setRua("Rua de Teste");
		
		ResultActions response = mockMvc.perform( 
											post("/professores")
											.content(mapper.writeValueAsString(professor))
											.contentType("application/json")
										);

		MvcResult result = response.andReturn();
		String responseStr = result.getResponse().getContentAsString(StandardCharsets.UTF_8);
		
		System.out.println(responseStr);
		ProfessorDTO professorSalvo = mapper.readValue(responseStr, ProfessorDTO.class);

		assertThat(professorSalvo.getId()).isPositive();
		assertThat(professorSalvo.getCep()).isEqualTo(professor.getCep());
		assertThat(professorSalvo.getNome()).isEqualTo(professor.getNome());
		assertThat(professorSalvo.getNumero()).isEqualTo(professor.getNumero());
		assertThat(professorSalvo.getRua()).isEqualTo(professor.getRua());		
		assertThat(result.getResponse().getStatus()).isEqualTo(200);
	}
	
	@Test
	void updateTeste() throws Exception{
		
		ObjectMapper mapper = new ObjectMapper();
		
		//criamos um objeto do tipo ProfessorDTO para enviarmos junto com a requisição
		ProfessorDTO professor = new ProfessorDTO();
		professor.setCep("07151-023");
		professor.setNome("Professor Teste 0");
		professor.setNumero(3);
		professor.setRua("Rua de Testes");
		
		ResultActions response = mockMvc.perform( 
											put("/professores/3")
											.content(mapper.writeValueAsString(professor))
											.contentType("application/json")
										);

		MvcResult result = response.andReturn();
		String responseStr = result.getResponse().getContentAsString(StandardCharsets.UTF_8);
		
		System.out.println(responseStr);
		ProfessorDTO professorAtual = mapper.readValue(responseStr, ProfessorDTO.class);

		assertThat(professorAtual.getId()).isPositive();
		assertThat(professorAtual.getCep()).isEqualTo(professor.getCep());
		assertThat(professorAtual.getNome()).isEqualTo(professor.getNome());
		assertThat(professorAtual.getNumero()).isEqualTo(professor.getNumero());
		assertThat(professorAtual.getRua()).isEqualTo(professor.getRua());		
		assertThat(result.getResponse().getStatus()).isEqualTo(200);
	}
	
	@Test
	void deleteTest() throws Exception {
		
		ResultActions response = mockMvc.perform( 
											delete("/professores/110")
											.contentType("application/json")
										);
		
		MvcResult result = response.andReturn();
		
		assertThat(result.getResponse().getStatus()).isEqualTo(200);
	}

}
