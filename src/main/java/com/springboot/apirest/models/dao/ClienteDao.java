package com.springboot.apirest.models.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.springboot.apirest.models.entity.Cliente;
import com.springboot.apirest.models.entity.Region;

public interface ClienteDao extends JpaRepository<Cliente, Long> {

	@Query("from Region")
	public List<Region> findAllRegions();
}
