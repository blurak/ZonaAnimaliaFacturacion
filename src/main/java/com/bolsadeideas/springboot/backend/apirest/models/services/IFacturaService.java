package com.bolsadeideas.springboot.backend.apirest.models.services;

import java.util.Date;
import java.util.List;

import com.bolsadeideas.springboot.backend.apirest.models.entity.Factura;

public interface IFacturaService {
	
	public Factura findFacturaByid (Long id);
	
	public Factura saveFactura(Factura factura);
	
	public void deleteFacturaByID(Long id);
	
	public List<Factura> findByCreateAtBetween(Date fecha, Date fecha2);
}
