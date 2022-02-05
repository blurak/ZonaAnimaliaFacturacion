package com.bolsadeideas.springboot.backend.apirest.models.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.bolsadeideas.springboot.backend.apirest.models.entity.Usuario;

public interface IUsuarioRepository extends JpaRepository<Usuario, Long> {
	
	 public Usuario findByUsername(String username);
	 //@Query("select u from Usuario u where u.username=?1")
	 //public Usuario findByUsernameQuery(String username);
}
