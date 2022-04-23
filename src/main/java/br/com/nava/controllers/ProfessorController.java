	
/*aqui serão declaradas as endpoints da aplicação
	 * Para começar é necessário descrever todas as ações que se pretende 
	 * realizar com os dados. Sabe-se que há uma formula simples para isso 
	 * o CRUD 
 */

package br.com.nava.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.nava.dtos.ProfessorDTO;
import br.com.nava.entities.ProfessorEntity;
import br.com.nava.repositories.ProfessorRepository;
import br.com.nava.services.ProfessorService;

@RestController
@RequestMapping("professores")
public class ProfessorController {
	
	private ArrayList<ProfessorEntity> listaProfessor 
									= new ArrayList<ProfessorEntity>();
	
	private int contador = 1;
	
	//ProfessorService professorService = new ProfessorService(); // instanciando na unha
	@Autowired
	private ProfessorService professorService;
	
	
	@GetMapping("")
	public ResponseEntity<List<ProfessorDTO>> getAllProfessores() {
//		professorService.mostrar();
//		return listaProfessor;
		return ResponseEntity.status(HttpStatus.OK).body(professorService.getAll());
	}
	
	@GetMapping("{id}")
	public ResponseEntity<ProfessorDTO> getOneProfessor(@PathVariable Integer id) {
//		//é necessário fazer uma varredura dentro do array utilizando um método for
//		for(int i = 0; i<listaProfessor.size(); i++) {
//			if (listaProfessor.get(i).getId() == id) {
//				return listaProfessor.get(i);
//			}
//		}
//		
//		
//		 int indice = findIndex(id); return (indice >= 0 ? listaProfessor.get(indice)
//		 : null);
//		 
//		
//		if(indice >=0) {
//			return listaProfessor.get(indice);
//		}
//		return null;
		
//		return professorService.getOneProfessor(id,  listaProfessor);
//		return professorService.getOneProfessor(id);
		return ResponseEntity.status(HttpStatus.OK).body(professorService.getOneProfessor(id));
		

		
	}
	@PostMapping("")
	public ResponseEntity<ProfessorDTO> save(@Valid @RequestBody ProfessorDTO professor) {
//		professor.setId(contador);
//		listaProfessor.add(professor);
//		contador++;
//		return professorService.save(professor.toEntity());
		return ResponseEntity.status(HttpStatus.OK).body(professorService.save(professor.toEntity()));
	}
	
	@PutMapping("{id}")
	public ResponseEntity<ProfessorDTO> update(
							@PathVariable int id,
							@RequestBody ProfessorDTO professor
							) {
		/*for(int i = 0; i <listaProfessor.size(); i++) {
			if(listaProfessor.get(i).getId()== id) {
				listaProfessor.get(i).setNome(professor.getNome());
				listaProfessor.get(i).setCpf(professor.getCpf());
				listaProfessor.get(i).setRua(professor.getRua());
				listaProfessor.get(i).setNumero(professor.getNumero());
				listaProfessor.get(i).setCep(professor.getCep());
				
				return listaProfessor.get(i);
			}
		}*/
		/*
		 * int indice = findIndex(id);
		 * 
		 * if (indice>=0) { listaProfessor.get(indice).setNome(professor.getNome());
		 * listaProfessor.get(indice).setCpf(professor.getCpf());
		 * listaProfessor.get(indice).setRua(professor.getRua());
		 * listaProfessor.get(indice).setNumero(professor.getNumero());
		 * listaProfessor.get(indice).setCep(professor.getCep());
		 * 
		 * return listaProfessor.get(indice); }
		 * 
		 * return null;
		 */
		
		return ResponseEntity.status(HttpStatus.OK).body(professorService.update(id, professor.toEntity()));

	}
	@DeleteMapping("{id}")
	public ResponseEntity<Void> delete(@PathVariable int id) {
		/*
		 * for (int i = 0; i < listaProfessor.size(); i++) {
		 * if(listaProfessor.get(i).getId() == id) { listaProfessor.remove(i); } }
		 */
		/*
		 * int indice = findIndex(id); if (indice >=0 ) listaProfessor.remove(indice);
		 */	
		//professorService.delete(id, listaProfessor);
		professorService.delete(id);
		
		return ResponseEntity.ok().build();
	}
	// hhtps://localhost:8080/professores/search-by-name/prof
	@GetMapping (value= "search-by-name/{name}")
	public ResponseEntity<List<ProfessorDTO>> searchByName(@PathVariable String name){
		
		List<ProfessorDTO> lista = professorService.searchByName(name);
		
		return ResponseEntity.ok().body( lista );
		
		//return ResponseEntity.ok().body( professorService.searchByName(name); );
	}
	

}
