package com.bolsadeideas.springboot.backend.apirest.models.services;

import java.util.List;


import com.bolsadeideas.springboot.backend.apirest.models.entity.Producto;

public interface IProductoService {
	
	public  List<Producto> findByNombreContainingIgnoreCase(String ter);
	
	public List<Producto> ProductosAll();
	
	public Producto crear(Producto persona);
	
	public Producto findById(Long id);
	
	public Producto editar(Producto entidad);
	
	public void eliminar (Long id);
	
	
	
}
