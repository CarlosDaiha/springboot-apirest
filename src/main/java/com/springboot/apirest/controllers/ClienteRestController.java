package com.springboot.apirest.controllers;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.apirest.models.entity.Cliente;
import com.springboot.apirest.models.services.ClienteService;

@RestController
@RequestMapping("/api")
public class ClienteRestController {
	
	@Autowired
	private ClienteService clienteService;
	
	@GetMapping("/clientes")
	public List<Cliente> readAll() {
		return clienteService.findAll();
	}
	
	@GetMapping("/clientes/{id}")
	public Cliente read(@PathVariable Long id, HttpServletResponse response) {
		if (clienteService.findById(id) != null) {
			response.setStatus(HttpServletResponse.SC_OK);
		} else response.setStatus(HttpServletResponse.SC_NOT_FOUND);
		return clienteService.findById(id);
	}
	
	@PostMapping("/clientes")
	@ResponseStatus(HttpStatus.CREATED)
	public Cliente create(@RequestBody Cliente cliente) {
		return clienteService.save(cliente);
	}
	
	@PutMapping("/clientes/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Cliente update(@RequestBody Cliente cliente, @PathVariable Long id) {
		Cliente clienteUpdate = clienteService.findById(id);
		
		if (cliente.getNombre() != null && !cliente.getNombre().isEmpty()) {
			clienteUpdate.setNombre(cliente.getNombre());
		}
		if (cliente.getApellido() != null && !cliente.getApellido().isEmpty()) {
			clienteUpdate.setApellido(cliente.getApellido());			
		}
		if (cliente.getEmail() != null && !cliente.getEmail().isEmpty()) {
			clienteUpdate.setEmail(cliente.getEmail());
		}
		String telefono = Integer.toString(cliente.getTelefono());
		if (telefono.length() == 9) {
			clienteUpdate.setTelefono(cliente.getTelefono());		
		}
		
		return clienteService.save(clienteUpdate);
	}
	
	@DeleteMapping("/clientes/{id}")
	public void delete(@PathVariable Long id, HttpServletResponse response) {
		if (clienteService.findById(id) == null) {
			response.setStatus(HttpServletResponse.SC_NO_CONTENT);
		} else {
			clienteService.deleteById(id);
			response.setStatus(HttpServletResponse.SC_OK);
		}
	}

}
