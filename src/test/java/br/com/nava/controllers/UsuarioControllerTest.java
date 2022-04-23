package br.com.nava.controllers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public class UsuarioControllerTest {

		@Autowired
		private MockMvc mockMvc;
	
		@Test
		void getAllUsuarios() throws Exception {
			ResultActions response = mockMvc.perform(
												get("/usuarios")
												.contentType("application/json")
												);
			MvcResult result = response.andReturn();
			String responseStr = result.getResponse().getContentAsString();
			System.out.println(responseStr);
		}
		
		@Test
		void getOneUsuario() {
			
		}
		
		@Test
		void save() {
			
		}
		
		@Test
		void update() {
			
		}
		
		@Test
		void delete() {
			
		}
}
