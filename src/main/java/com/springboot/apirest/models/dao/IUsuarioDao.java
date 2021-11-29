package com.springboot.apirest.models.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.springboot.apirest.models.entity.Usuario;

public interface IUsuarioDao extends CrudRepository<Usuario, Long> {
	
	/** Primera versión para buscar un usuario por su username */
	public Usuario findByUsername(String username);
	
	/** Segunda versión para buscar un usuario por su username mediante la anotación @Query */
	@Query("select u from Usuario u where u.username=?1")
	public Usuario findByUsernameWithQuery(String username);
	
}
