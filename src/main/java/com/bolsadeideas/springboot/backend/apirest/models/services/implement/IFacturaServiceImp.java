package com.bolsadeideas.springboot.backend.apirest.models.services.implement;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bolsadeideas.springboot.backend.apirest.models.entity.Factura;
import com.bolsadeideas.springboot.backend.apirest.models.repository.IFacturaRepository;
import com.bolsadeideas.springboot.backend.apirest.models.services.IFacturaService;

@Service
public class IFacturaServiceImp implements IFacturaService {

	@Autowired
	private IFacturaRepository repo;
	
	@Override
	public Factura findFacturaByid(Long id) {
		
		return repo.findById(id).orElse(null);
	}

	@Override
	public Factura saveFactura(Factura factura) {
		
		return repo.save(factura);
	}

	@Override
	public void deleteFacturaByID(Long id) {
		repo.deleteById(id);
		
	}

	@Override
	public List<Factura> findByCreateAtBetween(Date fecha, Date fecha2) {
		
		return repo.findByCreateAtBetween(fecha, fecha2) ;
	}

}
