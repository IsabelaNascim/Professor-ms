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

import br.com.nava.entities.VendasEntity;
import br.com.nava.services.VendasService;

@RestController
@RequestMapping("vendas")
public class VendasController {
	private ArrayList<VendasEntity> listaVendas = new ArrayList<VendasEntity>();
	private int contador = 1;

	@Autowired
	private VendasService vendasService;

	@GetMapping("")
	public List<VendasEntity> getAllVendas() {
		return vendasService.getAllVendas();
	}

	@GetMapping("{id}")
	public VendasEntity getOneVenda(@PathVariable Integer id) {
		return vendasService.getOneVenda(id);
	}

	@PostMapping("")
	public VendasEntity save(@RequestBody VendasEntity vendas) {

		return vendasService.save(vendas);
	}

	@PutMapping("{id}")
	public VendasEntity update(@PathVariable Integer id, @RequestBody VendasEntity vendas) {
		return vendasService.update(id, vendas);
	}

	@DeleteMapping("{id}")
	public void delete(@PathVariable Integer id) {
		vendasService.delete(id);
	}
}
