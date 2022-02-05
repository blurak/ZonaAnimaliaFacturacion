package com.bolsadeideas.springboot.backend.apirest.models.services.implement;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bolsadeideas.springboot.backend.apirest.models.entity.Usuario;
import com.bolsadeideas.springboot.backend.apirest.models.repository.IUsuarioRepository;
import com.bolsadeideas.springboot.backend.apirest.models.services.IUsuarioService;
@Service
public class IUsuarioServiceImp implements IUsuarioService{
	
	private Logger logger = LoggerFactory.getLogger(IUsuarioServiceImp.class ) ;
	@Autowired
	private IUsuarioRepository repo;
	
	
	@Override
	@Transactional(readOnly = true)
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuario usuario = repo.findByUsername(username); 
		if(usuario == null){
			logger.error("Error en el login : no existe el usuario '"+username+"'en el sistema");
			throw new UsernameNotFoundException("Error en el login : no existe el usuario '"+username+"'en el sistema");	
		}
		List<GrantedAuthority> authorities = usuario.getRoles()
				.stream()
				.map(role -> new SimpleGrantedAuthority(role.getNombre()))
				.peek(authority-> logger.info("role:"+authority.getAuthority()))
				.collect(Collectors.toList());
		
		return new User(usuario.getUsername(), usuario.getPassword(), usuario.getEnable(), true, true, true, authorities);
	}


	@Override
	public Usuario finByUsername(String username) {
		// TODO Auto-generated method stub
		return repo.findByUsername(username);
	}
	

}
