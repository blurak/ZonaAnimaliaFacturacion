package com.bolsadeideas.springboot.backend.apirest.models.services;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.bolsadeideas.springboot.backend.apirest.models.entity.Usuario;

public interface IUsuarioService extends UserDetailsService{
	
	public Usuario finByUsername(String username);
}
