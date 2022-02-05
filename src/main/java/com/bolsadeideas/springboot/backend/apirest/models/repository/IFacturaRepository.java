package com.bolsadeideas.springboot.backend.apirest.models.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.bolsadeideas.springboot.backend.apirest.models.entity.Factura;

public interface IFacturaRepository extends JpaRepository<Factura, Long> {
	
	
	
	 public List<Factura> findByCreateAtBetween(Date fecha, Date fecha2);

}
