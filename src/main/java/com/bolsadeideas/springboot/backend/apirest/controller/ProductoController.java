package com.bolsadeideas.springboot.backend.apirest.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.transaction.TransactionSystemException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.bolsadeideas.springboot.backend.apirest.models.entity.Cliente;
import com.bolsadeideas.springboot.backend.apirest.models.entity.Producto;
import com.bolsadeideas.springboot.backend.apirest.models.services.IProductoService;

@RestController
@CrossOrigin(origins = {"*"})
@RequestMapping("/facturas")
public class ProductoController {

	@Autowired
	private IProductoService service;
	@Secured({"ROLE_ADMIN"})
	@GetMapping("factura/filtrar-producto/{term}")
	@ResponseStatus(code = HttpStatus.OK)
	public List<Producto> facturas(@PathVariable String term) {
		System.out.print(term);
		if(term == null || term.isEmpty() || term == "Vacio" ) {
			term = " ";
		}
		return service.findByNombreContainingIgnoreCase(term);
	}
	
	@GetMapping("/consultarProductos")
	public ResponseEntity<List<Producto>> consultarTodasPoductos() {
		return new ResponseEntity<List<Producto>>(service.ProductosAll(), HttpStatus.OK);
	}
	
	
	@GetMapping("/producto/{id}")
	public ResponseEntity<?> productoId(@PathVariable Long id) {
		Producto producto = null;
		Map<String, Object> response = new HashMap<>();
		try {
			producto = service.findById(id);
		} catch (DataAccessException e) {
			response.put("Mensaje", "Error al realizar la consulta");
			response.put("error", e.getMessage().concat(" : ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		if (producto == null) {
			response.put("Mensaje", "el Producto ID: ".concat(id.toString().concat(" No existe en la base de datos")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Producto>(producto, HttpStatus.OK);
	}
	@PostMapping("/crearProducto")
	public ResponseEntity<?> crearProducto(@Valid @RequestBody Producto producto, BindingResult result) {
		Map<String, Object> response = new HashMap<>();
		if (result.hasErrors()) {
			List<String> errors = result.getFieldErrors().stream().map(err -> {
				return "El Campo " + err.getField() + " " + err.getDefaultMessage();
			}).collect(Collectors.toList());

			response.put("error", errors);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);

		}

		try {
			Producto p = service.crear(producto);
			if (p != null) {
				response.put("Mensaje", "El Producto fue creado con exito");
				response.put("Producto", p);
				return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);

			} else {
				response.put("Mensaje", "Error al crear El Producto");
				return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
			}
		} catch (Exception e) {
			response.put("Mensaje", "Compruebe Datos no diligenciados");
			response.put("error", e.getMessage());
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
	
	@PutMapping("/editarProducto")
	public ResponseEntity<?> editarPst(@Valid @RequestBody Producto producto, BindingResult result) {
		Producto p = null;
		
		Map<String, Object> response = new HashMap<>();
		if (result.hasErrors()) {
			List<String> errors = result.getFieldErrors().stream().map(err -> {
				return "El Campo " + err.getField() + " " + err.getDefaultMessage();
			}).collect(Collectors.toList());

			response.put("error", errors);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);

		}
		
		p = service.findById(producto.getId());
		if (p == null) {
			response.put("Mensaje", "El Producto no existe");
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
		try {

			p = service.editar(producto);
			return new ResponseEntity<Producto>(p, HttpStatus.OK);

		} catch (TransactionSystemException e) {
			response.put("Mensaje", "Error al actualizar");
			response.put("error", e.getMostSpecificCause().getMessage());
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
	@DeleteMapping("/eliminarProducto/{id}")
	public ResponseEntity<?> eliminarProducto(@PathVariable Long id) {
		Map<String, Object> response = new HashMap<>();
		try {
			Producto producto = service.findById(id);
			if (producto == null) {
				response.put("Mensaje", "Error al realizar la consulta");
				response.put("error", "El producto No Existe");
				return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
			} else {
				/*String Fotoanterior = cliente.getFoto();
				UpService.eliminar(Fotoanterior);*/
				service.eliminar(id);
			}
		} catch (Exception e) {
			response.put("Mensaje", "Error al realizar la consulta");
			response.put("error", e.getMessage());
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("Mensaje", "El Producto Fue eliminado con exito");
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}
}
