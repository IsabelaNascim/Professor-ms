package br.com.nava.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.nava.entities.ProdutosEntity;
import br.com.nava.repositories.ProdutoRepository;

@Service
public class ProdutoService {
	@Autowired
	private ProdutoRepository produtoRepository;
	
	public List<ProdutosEntity> getAllProdutos(){
		return produtoRepository.findAll();
	}

	public ProdutosEntity getOneProduto(int id) {
		
		Optional<ProdutosEntity> optional = produtoRepository.findById(id);
		
		ProdutosEntity produto = optional.orElse(new ProdutosEntity());
		
		return produto;
	}

	public ProdutosEntity save(ProdutosEntity produto) {
		return produtoRepository.save(produto);
	}
	
	public ProdutosEntity update(int id, ProdutosEntity produto) {
		Optional<ProdutosEntity> optional= produtoRepository.findById(id);
		
		if(optional.isPresent()==true) {
			ProdutosEntity produtoDb = optional.get();
			produtoDb.setNome(produto.getNome());
			produtoDb.setDescricao(produto.getDescricao());
			produtoDb.setPreco(produto.getPreco());
			
			return produtoRepository.save(produtoDb);
		}
		else {
			return new ProdutosEntity();
		}
	}
	
	public void delete(int id) {
		produtoRepository.deleteById(id);
	}
}
