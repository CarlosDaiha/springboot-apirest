package com.springboot.apirest.models.services;

import java.util.List;

import com.springboot.apirest.models.entity.Cliente;

public interface ClienteService {

	public List<Cliente> findAll();
	
	public Cliente findById(Long id);
	
	public Cliente save(Cliente cliente);
	
	public void deleteById(Long id);
	
}
