package br.com.nava.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.nava.entities.ProdutosEntity;
import br.com.nava.entities.UsuarioEntity;
import br.com.nava.entities.VendasEntity;
import br.com.nava.repositories.ProdutoRepository;
import br.com.nava.repositories.UsuarioRepository;
import br.com.nava.repositories.VendasRepository;

@Service
public class DbService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	@Autowired
	private ProdutoRepository produtoRepository;
	@Autowired
	private VendasRepository vendaRepository;
	
	//Exemplo de inserção para relacionamento Many-to-Many 
	public void inserirVendas() {
		
		//buscar uma lista de usuarios para pegar um deles
		List<UsuarioEntity> usuarios= usuarioRepository.findAll();
		
		//buscar uma lista de produtos para pegar um deles
		List<ProdutosEntity> produtos = produtoRepository.findAll();
				
		
		VendasEntity venda = new VendasEntity();
		venda.setValorTotal(120);
		//peguei o primeiro elemento da lista de usuarios
		venda.setUsuario(usuarios.get(0));
		//alterei a lista de produtos em vendas
		venda.setProdutos(produtos);
		
		
		VendasEntity vendaSalva = vendaRepository.save(venda);
		
		List<VendasEntity> listaVendas = new ArrayList<VendasEntity>();
		listaVendas.add(vendaSalva);
		
		//para cada produto,alterar a lista de vendas
		for(int i=0; i<produtos.size(); i++) {
			produtos.get(i).setVendas(listaVendas);
			//atualizar o produto de acordo com  sua venda
			produtoRepository.save(produtos.get(i));
			
		}
		
	}
}
