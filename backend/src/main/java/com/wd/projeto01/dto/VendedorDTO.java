package com.wd.projeto01.dto;

public class VendedorDTO {
       
    private String nome;
       
    public VendedorDTO() {}
    
    public VendedorDTO(String nome) {
    	super();
    	this.nome = nome;
    }
    
    public String getNome() {
    	return nome;
    }
    
    public void setNome(String nome) {
    	this.nome = nome;
    }
}
