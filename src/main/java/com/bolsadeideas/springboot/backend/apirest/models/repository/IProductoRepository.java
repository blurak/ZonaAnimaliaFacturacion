package com.bolsadeideas.springboot.backend.apirest.models.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.bolsadeideas.springboot.backend.apirest.models.entity.Producto;

public interface IProductoRepository extends JpaRepository<Producto, Long>{
	
	@Query("select p from Producto p where p.nombre like %?1%")
	public List<Producto> findBynombre(String ter);
	
	
	public List<Producto> findByNombreContainingIgnoreCase(String ter);
	
}
