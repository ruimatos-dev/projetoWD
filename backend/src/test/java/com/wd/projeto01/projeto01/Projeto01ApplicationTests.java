package com.wd.projeto01.projeto01;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.wd.projeto01.controllers.VendedorController;
import com.wd.projeto01.entities.Vendas;
import com.wd.projeto01.entities.Vendedor;
import com.wd.projeto01.services.VendasService;
import com.wd.projeto01.services.VendedorService;

@SpringBootTest
class Projeto01ApplicationTests {

	@Autowired
	private VendasService vendasService;
	
	@Autowired
	private VendedorService vendedorService;
	
	@Autowired
	private VendedorController vendedorController;
	
	
	@Test
	void testTamanhoLista() {
		List<Vendas> listaDeVendas = vendasService.findAll();
		Assertions.assertEquals(listaDeVendas.size(), 7);
	}
	
    @Test
    void testVendedor() {
    	
    	Vendedor vendedor = new Vendedor();
    	
    	vendedor.setId(null);
    	vendedor.setNome("Rogério Ceni");
    	
    	Vendas vendas = new Vendas();
    	
    	vendas.setId(null);
    	vendas.setData(LocalDate.now());
    	vendas.setQtdVendas(30);
    	vendas.setValor(1500.0);
    	vendas.setVisitas(10);
    	vendas.setVendedor(vendedor);
    	
    	vendasService.insert(vendas);
		Assertions.assertEquals(vendas.getVendedor().getId(), vendedor.getId());

    }
    
	@Test
	void testController() {
		Assertions.assertEquals(vendedorService.findById(3).getNome(),
				vendedorController.findById(3).getBody().getNome());
	}
}
