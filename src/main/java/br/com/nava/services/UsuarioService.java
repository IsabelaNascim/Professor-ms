package br.com.nava.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.nava.entities.ProfessorEntity;
import br.com.nava.entities.UsuarioEntity;
import br.com.nava.repositories.ProfessorRepository;
import br.com.nava.repositories.UsuarioRepository;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	public List<UsuarioEntity> getAllUsuarios(){
		return usuarioRepository.findAll();
	}

	public UsuarioEntity getOneUsuario(int id) {
		
		Optional<UsuarioEntity> optional = usuarioRepository.findById(id);
		
		UsuarioEntity usuario = optional.orElse(new UsuarioEntity());
		
		return usuario;
	}

	public UsuarioEntity save(UsuarioEntity usuario) {
		return usuarioRepository.save(usuario);
	}
	
	public UsuarioEntity update(int id, UsuarioEntity usuario) {
		Optional<UsuarioEntity> optional= usuarioRepository.findById(id);
		
		if(optional.isPresent()==true) {
			UsuarioEntity usuarioDb = optional.get();
			usuarioDb.setNome(usuario.getNome());
			usuarioDb.setEmail(usuario.getEmail());
			
			return usuarioRepository.save(usuarioDb);
		}
		else {
			return new UsuarioEntity();
		}
	}
	
	public void delete(int id) {
		usuarioRepository.deleteById(id);
	}
}
