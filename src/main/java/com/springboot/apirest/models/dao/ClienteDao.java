package com.springboot.apirest.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.springboot.apirest.models.entity.Cliente;

public interface ClienteDao extends CrudRepository<Cliente, Long> {

}
