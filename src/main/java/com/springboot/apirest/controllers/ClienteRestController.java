package com.springboot.apirest.controllers;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

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
	public ResponseEntity<?> read(@PathVariable Long id){
		Cliente cliente;
		HashMap<String,Object> response = new HashMap<>();

		try {
			cliente = clienteService.findById(id);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar la consulta en base de datos.");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<HashMap<String,Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		if(cliente == null) {
			response.put("mensaje", "El cliente ID: ".concat(id.toString().concat(" no existe en la base de datos.")));
			return new ResponseEntity<HashMap<String,Object>>(response, HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<Cliente>(cliente, HttpStatus.OK);
	}

	@PostMapping("/clientes")
	public ResponseEntity<?> create(@RequestBody Cliente cliente) {
		HashMap<String,Object> response = new HashMap<>();

		try {
			clienteService.save(cliente);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al insertar en base de datos.");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<HashMap<String,Object>>(response, HttpStatus.BAD_REQUEST);
		}

		response.put("mensaje", "Usuario creado con éxito.");
		response.put("cliente", cliente);
		return new ResponseEntity<HashMap<String,Object>>(response, HttpStatus.CREATED);
	}

	@PutMapping("/clientes/{id}")
	public ResponseEntity<?> update(@RequestBody Cliente cliente, @PathVariable Long id) {
		HashMap<String,Object> response = new HashMap<>();

		Cliente clienteUpdated = clienteService.findById(id);
		if (clienteUpdated == null) {
			response.put("mensaje", "El cliente ID: ".concat(id.toString().concat(" no existe en la base de datos.")));
			return new ResponseEntity<HashMap<String,Object>>(response, HttpStatus.NOT_FOUND);
		}

		try {
			clienteUpdated.setNombre(cliente.getNombre());
			clienteUpdated.setApellido(cliente.getApellido());
			clienteUpdated.setEmail(cliente.getEmail());
			clienteUpdated.setTelefono(cliente.getTelefono());
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al actualizar en base de datos.");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<HashMap<String,Object>>(response, HttpStatus.BAD_REQUEST);
		}
		clienteService.save(clienteUpdated);
		
		response.put("mensaje", "El cliente se ha actualizado con éxito.");
		response.put("cliente", clienteUpdated);
		return new ResponseEntity<HashMap<String,Object>>(response, HttpStatus.OK);
	}

	@DeleteMapping("/clientes/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) {
		HashMap<String,Object> response = new HashMap<>();

		if (clienteService.findById(id) == null) {
			response.put("mensaje", "El cliente ID: ".concat(id.toString().concat(" no existe en la base de datos.")));
			return new ResponseEntity<HashMap<String,Object>>(response, HttpStatus.NOT_FOUND);
		}

		try {
			clienteService.deleteById(id);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al eliminar cliente en base de datos.");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<HashMap<String,Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		response.put("mensaje", "El cliente se ha eliminado con éxito.");
		return new ResponseEntity<HashMap<String,Object>>(response, HttpStatus.NO_CONTENT);
	}

	@PostMapping("/clientes/upload")
	public ResponseEntity<?> upload(@RequestParam("archivo") MultipartFile archivo, @RequestParam("id") Long id) {
		HashMap<String,Object> response = new HashMap<>();
		Cliente cliente = clienteService.findById(id);
		
		if (cliente == null) {
			response.put("mensaje", "El cliente ID: ".concat(id.toString().concat(" no existe en la base de datos.")));
			return new ResponseEntity<HashMap<String,Object>>(response, HttpStatus.NOT_FOUND);
		}
		
		if (archivo != null && !archivo.isEmpty()) {
			String name = UUID.randomUUID().toString()+"_"+archivo.getOriginalFilename().replace(" ", "");
			Path path = Paths.get("uploads").resolve(name).toAbsolutePath();
			
			try {
				Files.copy(archivo.getInputStream(), path);
				
				String oldName = cliente.getImagen();
				if (oldName != null && oldName.length() > 0) {
					Path oldPath = Paths.get("uploads").resolve(oldName).toAbsolutePath();
					File oldImage = oldPath.toFile();
					
					if (oldImage.exists() && oldImage.canRead()) {
						oldImage.delete();
					}
				}
				
				cliente.setImagen(name);
				clienteService.save(cliente);
			} catch (IOException e) {
				response.put("mensaje", "Error al subir la imagen del cliente.");
				response.put("error", e.getMessage().concat(": ").concat(e.getCause().getMessage()));
				return new ResponseEntity<HashMap<String,Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
			}
			
			response.put("cliente", cliente);
			response.put("mensaje", "Has subido correctamente la imagen: ".concat(name));
		}
		return new ResponseEntity<HashMap<String,Object>>(response, HttpStatus.CREATED);
	}
}
