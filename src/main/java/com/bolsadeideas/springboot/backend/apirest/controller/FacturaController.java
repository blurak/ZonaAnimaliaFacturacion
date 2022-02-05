package com.bolsadeideas.springboot.backend.apirest.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.bolsadeideas.springboot.backend.apirest.models.entity.Factura;
import com.bolsadeideas.springboot.backend.apirest.models.entity.ItemFactura;
import com.bolsadeideas.springboot.backend.apirest.models.entity.Producto;
import com.bolsadeideas.springboot.backend.apirest.models.services.IFacturaService;
import com.bolsadeideas.springboot.backend.apirest.models.services.IProductoService;

@RestController
@CrossOrigin(origins = { "*" })
@RequestMapping("/facturas")
public class FacturaController {

	@Autowired
	private IFacturaService service;

	@Autowired
	private IProductoService servicepro;

	@Secured({ "ROLE_USER", "ROLE_ADMIN" })
	@GetMapping("/factura/{id}")
	@ResponseStatus(code = HttpStatus.OK)
	public Factura facturas(@PathVariable Long id) {
		return service.findFacturaByid(id);
	}

	@Secured({ "ROLE_ADMIN" })
	@DeleteMapping("/factura/{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void eliminarFactura(@PathVariable Long id) {
		service.deleteFacturaByID(id);
	}

	@Secured({ "ROLE_ADMIN" })
	@PostMapping("/factura")
	@ResponseStatus(code = HttpStatus.CREATED)
	public ResponseEntity<?> crear(@RequestBody Factura factura ) {
		Map<String, Object> response = new HashMap<>();
		List<ItemFactura> items = new ArrayList<>();
		items = factura.getItems();
		Producto producto = new Producto();
		for (ItemFactura p : items) {
			producto = servicepro.findById(p.getProducto().getId());
			if(producto.getCantidad()<p.getCantidad()) {
				response.put("Mensaje", "La cantidad que desea ingresar No se encuentra disponible en el inventario");
				return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
			}
			
		}
		for (ItemFactura p : items) {
			producto = servicepro.findById(p.getProducto().getId());
			producto.setCantidad(producto.getCantidad()-p.getCantidad());
			servicepro.editar(producto);
			
		}
	
		service.saveFactura(factura);
		return new ResponseEntity<Factura>(factura, HttpStatus.OK);
	}

	@Secured({ "ROLE_ADMIN" })
	@GetMapping("/factura/fecha/{fecha}/{fecha2}")
	@ResponseStatus(code = HttpStatus.CREATED)
	public List<Factura> crear(@PathVariable Date fecha, @PathVariable Date fecha2) throws ParseException {
		/*
		 * SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd"); Date
		 * dataFormateada = formato.parse(fecha); Date dataFormateada2 =
		 * formato.parse(fecha2);
		 */
		return service.findByCreateAtBetween(fecha, fecha2);
	}
}
