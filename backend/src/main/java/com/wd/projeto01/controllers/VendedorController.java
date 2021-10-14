package com.wd.projeto01.controllers;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.wd.projeto01.dto.VendedorDTO;
import com.wd.projeto01.dto.VendedorNewDTO;
import com.wd.projeto01.entities.Vendedor;
import com.wd.projeto01.services.VendedorService;

@RestController
@RequestMapping(value="/vendedores")
public class VendedorController {

	@Autowired
	private VendedorService servVendedor;
	
	@GetMapping
	public ResponseEntity<List<VendedorDTO>> listarVendedores() {
		List<VendedorDTO> listaVendedores = servVendedor
		.findAll().stream()
		.map(x -> new VendedorDTO(x.getNome()))
		.collect(Collectors.toList());
		return ResponseEntity.ok(listaVendedores);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<VendedorDTO> findById(@RequestParam(value = "value") Integer id) {
		Vendedor vendedor = servVendedor.findById(id);		
		if(vendedor == null) {
			return ResponseEntity.notFound().build();
		}
		VendedorDTO vendedorDto = new VendedorDTO(vendedor.getNome());
		
		return ResponseEntity.ok(vendedorDto);
	}
	
	
	
	
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> findById(@RequestBody VendedorNewDTO vendedorNewDTO){
		Vendedor vendr = new Vendedor(vendedorNewDTO.getNome(), vendedorNewDTO.getId());
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/id").buildAndExpand(vend.getId())toUri();
	}
}