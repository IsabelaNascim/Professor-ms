package br.com.nava.services;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.nava.entities.ProdutosEntity;
import br.com.nava.entities.VendasEntity;
import br.com.nava.repositories.ProdutoRepository;
import br.com.nava.repositories.VendasRepository;

@Service
public class VendasService {
	
	@Autowired
	private VendasRepository vendasRepository;
	@Autowired
	private ProdutoRepository produtoRepository;
	
	public List<VendasEntity> getAllVendas(){
		return vendasRepository.findAll();
	}

	public VendasEntity getOneVenda(int id) {
		
		Optional<VendasEntity> optional = vendasRepository.findById(id);
		
		VendasEntity vendas = optional.orElse(new VendasEntity());
		
		return vendas;
	}

	public VendasEntity save(VendasEntity vendas) {
		//primeiro teremos que salvar a venda (para preencher a lista para cada produto)
		VendasEntity vendaSalva = vendasRepository.save(vendas);
		
		//depois teremos que alterar alista de vendas para cada produto
		//para cada produdo da venda do body, temos que atualizar a venda salva no banco
		List<ProdutosEntity>listaProdutos = vendas.getProdutos();
		
//		List<VendasEntity>listaVendas = new ArraysList<VendasEntity>();
//		listaVendas.add(vendasSalvas);
		
		//atualizando as vendas para cada produto acima
		
		for(int i =0;i < listaProdutos.size(); i++) {
			//Arrays.asList converte um conjunto de objetos em uma lista
			listaProdutos.get(i).setVendas(Arrays.asList(vendaSalva));
//			listaProdutos.get(i).setVendas(listaVendas);
		}
		
		//salvando as atualizações no banco de dados
		produtoRepository.saveAll(listaProdutos);
		
		return this.vendasRepository.save(vendas);
	}
	
	public VendasEntity update(int id, VendasEntity vendas) {
		Optional<VendasEntity> optional= vendasRepository.findById(id);
		
		if(optional.isPresent()==true) {
			VendasEntity vendasDb = optional.get();
			vendasDb.setValorTotal(vendas.getValorTotal());
			
			return vendasRepository.save(vendasDb);
		}
		else {
			return new VendasEntity();
		}
	}
	
	public void delete(int id) {
		vendasRepository.deleteById(id);
	}
}
