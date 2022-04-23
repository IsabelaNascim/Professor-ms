package br.com.nava.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.nava.entities.ProfessorEntity;

@Repository
public interface ProfessorRepository extends JpaRepository<ProfessorEntity, Integer> {
	
	/* [ COMO FAZER CONSULTAS ESPECÍFICAS ] */
	
	//SELECT * FROM PROFESSORES WHERE NOME LIKE '%nome%'
	public List<ProfessorEntity> findByNomeContains(String nome);
	
	//JPQL -> JAVA PERSISTENCE QUERY LANGUAGE
//	@Query(value = "SELECT p FROM ProfessorEntity p WHERE p.nome LIKE %:nome% ")
//	public List<ProfessorEntity> searchByNome(@Param("nome") String nome);
	
//	@Query(value = "SELECT p FROM ProfessorEntity p WHERE p.nome LIKE %?1% ") //[-> '?1' ordem do elemento dos parâmetros]
//	public List<ProfessorEntity> searchByNome2(String nome);
	
	@Query(value = "SELECT * FROM PROFESSORES p WHERE p.nome LIKE %?1% ", nativeQuery = true)//utiliz. sql puro
	public List<ProfessorEntity> searchByNome3(String nome);

	
}
