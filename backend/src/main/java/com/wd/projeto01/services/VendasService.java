package com.wd.projeto01.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.wd.projeto01.dto.VendasDto;
import com.wd.projeto01.entities.Vendas;
import com.wd.projeto01.repositories.VendasRepository;

@Service
public class VendasService {
	
	@Autowired
	private VendasRepository vendasRepository;
	
	public List<Vendas> findAll(){
		return vendasRepository.findAll();
	}
	
	public Page<VendasDto> findAllPage(Pageable pageable){
        Page<Vendas> listaVendas = vendasRepository.findAll(pageable);
        
        return listaVendas.map( venda -> new VendasDto(venda));
	}
	
	public void insert(Vendas vendas) {
		// TODO Auto-generated method stub
		
	}
}
