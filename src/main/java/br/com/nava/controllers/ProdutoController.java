package br.com.nava.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.nava.entities.ProdutosEntity;
import br.com.nava.services.ProdutoService;

@RestController
@RequestMapping("produtos")
public class ProdutoController {
	private ArrayList<ProdutosEntity> listaProduto = new ArrayList<ProdutosEntity>();
	private int contador = 1;
	
	@Autowired
	private ProdutoService produtoService;
	
	@GetMapping("")
	public List<ProdutosEntity> getAllProdutos(){
		return produtoService.getAllProdutos();
	}
	
	@GetMapping("{id}")
	public ProdutosEntity getOneProduto(@PathVariable int id){
		return produtoService.getOneProduto(id);
	}
	
	@PostMapping({""})
	public ProdutosEntity save(@RequestBody ProdutosEntity usuario) {
		
		return produtoService.save(usuario);
	}
	
	@PutMapping("{id}")
	public ProdutosEntity update(@PathVariable Integer id,
								@RequestBody ProdutosEntity produto) {
		return produtoService.update(id, produto);
	}
	
	@DeleteMapping("{id}")
	public void delete(@PathVariable Integer id) {
							produtoService.delete(id);
	}

}
