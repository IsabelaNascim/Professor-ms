package br.com.nava;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.nava.entities.ProfessorEntity;
import br.com.nava.entities.UsuarioEntity;
import br.com.nava.repositories.ProfessorRepository;
import br.com.nava.repositories.UsuarioRepository;
import br.com.nava.services.DbService;

@SpringBootApplication
public class PrimeiroMsApplication implements CommandLineRunner{
	
//	@Autowired
//	private ProfessorRepository professorRepository; 
//	@Autowired
//	private UsuarioRepository usuarioRepository; 
//	@Autowired
//	private DbService dbService; // --> comentado por causa do dbService

	public static void main(String[] args) {
		SpringApplication.run(PrimeiroMsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
//		dbService.inserirVendas();
		
//		List<ProfessorEntity> listaProfessor = professorRepository.findAll();
//		
//		//percorrer a listaProfessores
//		for (int i = 0; i < listaProfessor.size(); i++) {
//			System.out.println(listaProfessor.get(i));
//		}
//		
//		//  para retornar todos os usuarios do banco de dados
//		// -- SELECT * FROM USUARIOS
//		List<UsuarioEntity> listaUsuarios = usuarioRepository.findAll();
//		//percorrer a listaUsuarios 
//		for(int i = 0; i < listaUsuarios.size(); i++) {
//			System.out.println(listaUsuarios.get(i));
//		}
//		
////		UsuarioEntity usuario = new UsuarioEntity();
////		usuario.setEmail("user@gmail.com");
////		usuario.setNome("User");
////		
////		usuarioRepository.save(usuario);
		
		
	}

}
