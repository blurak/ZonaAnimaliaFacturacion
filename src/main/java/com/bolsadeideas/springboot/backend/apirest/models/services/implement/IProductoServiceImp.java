package com.bolsadeideas.springboot.backend.apirest.models.services.implement;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bolsadeideas.springboot.backend.apirest.models.entity.Cliente;
import com.bolsadeideas.springboot.backend.apirest.models.entity.Producto;
import com.bolsadeideas.springboot.backend.apirest.models.repository.IProductoRepository;
import com.bolsadeideas.springboot.backend.apirest.models.services.IProductoService;

@Service
public class IProductoServiceImp implements IProductoService {
	
	@Autowired
	private IProductoRepository repo;

	@Override
	public List<Producto> findByNombreContainingIgnoreCase(String ter) {
		
		return repo.findByNombreContainingIgnoreCase(ter);
	}

	@Override
	public List<Producto> ProductosAll() {
		List<Producto> lista = new ArrayList<Producto>();
		lista = repo.findAll();
		return lista;
	}

	@Override
	public Producto crear(Producto persona) {
		return repo.save(persona);
	}

	@Override
	public Producto findById(Long id) {
		
		return repo.findById(id).get();
	}

	@Override
	public Producto editar(Producto entidad) {
		
		return repo.save(entidad);
	}

	@Override
	public void eliminar(Long id) {
		repo.deleteById(id);		
	}

	
}
