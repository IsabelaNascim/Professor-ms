package br.com.nava.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

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

import br.com.nava.dtos.EnderecoDTO;
import br.com.nava.entities.EnderecoEntity;
import br.com.nava.services.EnderecoService;

@RestController
@RequestMapping("enderecos")
public class EnderecoController {
	private ArrayList<EnderecoEntity> listaEndereco = new ArrayList<EnderecoEntity>();
	private int contador = 1;
	
	@Autowired
	private EnderecoService enderecoService;
	
	@GetMapping("")
	public ResponseEntity<List<EnderecoDTO>> getAllEnderecos(){

		return ResponseEntity.status(HttpStatus.OK).body(enderecoService.getAllEnderecos());

	}
	
	@GetMapping("{id}")
	public ResponseEntity<EnderecoDTO> getOneEndereco(@PathVariable Integer id){
		
		return ResponseEntity.status(HttpStatus.OK).body(enderecoService.getOneEndereco(id));

	}
	
	@PostMapping("")
	public ResponseEntity<EnderecoDTO> save(@Valid @RequestBody EnderecoDTO endereco) {
			
		return ResponseEntity.status(HttpStatus.OK).body(enderecoService.save(endereco.toEntity()));

	}
	
	@PutMapping("{id}")
	public ResponseEntity<EnderecoDTO> update(@PathVariable Integer id,
								@RequestBody EnderecoDTO endereco) {

		return ResponseEntity.status(HttpStatus.OK).body(enderecoService.update(id, endereco.toEntity()));

	}
	
	@DeleteMapping("{id}")
	public void delete(@PathVariable Integer id) {
				enderecoService.delete(id);
	}
}
