package br.com.nava.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.nava.entities.ProdutosEntity;

@Repository
public interface ProdutoRepository extends JpaRepository<ProdutosEntity, Integer>{

}
