package br.com.nava.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.nava.dtos.EnderecoDTO;
import br.com.nava.dtos.ProfessorDTO;
import br.com.nava.entities.EnderecoEntity;
import br.com.nava.entities.ProfessorEntity;
import br.com.nava.repositories.EnderecoRepository;
import br.com.nava.repositories.ProfessorRepository;

@Service
public class EnderecoService {
	
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	public List<EnderecoDTO> getAllEnderecos(){
		List<EnderecoEntity> lista = enderecoRepository.findAll();
		
		List<EnderecoDTO> listaDTO = new ArrayList<>();
		
		for (EnderecoEntity enderecoEntity : lista) {
			listaDTO.add(enderecoEntity.toDTO());
		}
//		return enderecoRepository.findAll();
		return listaDTO;
	}

	public EnderecoDTO getOneEndereco(int id) {
		
		Optional<EnderecoEntity> optional = enderecoRepository.findById(id);
		
		EnderecoEntity endereco = optional.orElse(new EnderecoEntity());
		
		return endereco.toDTO();
	}

	public EnderecoDTO save(EnderecoEntity endereco) {
		return enderecoRepository.save(endereco).toDTO();
	}
	
	public EnderecoDTO update(int id, EnderecoEntity novoEndereco) {
		Optional<EnderecoEntity> optional= enderecoRepository.findById(id);
		
		if(optional.isPresent()==true) {
			EnderecoEntity enderecoDb = optional.get();
			enderecoDb.setRua(novoEndereco.getRua());
			enderecoDb.setNumero(novoEndereco.getNumero());
			enderecoDb.setCep(novoEndereco.getCep());
			enderecoDb.setCidade(novoEndereco.getCidade());
			enderecoDb.setEstado(novoEndereco.getEstado());
			
			return enderecoRepository.save(enderecoDb).toDTO();
		}
		else {
			return new EnderecoEntity().toDTO();
		}
	}
	
	public void delete(int id) {
		enderecoRepository.deleteById(id);
	}
}
