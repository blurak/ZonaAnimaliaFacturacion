package com.bolsadeideas.springboot.backend.apirest.models.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
@Entity
@Table(name="productos")
public class Producto implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@NotNull(message = "nombre es campo obligatorio")	
	@Size(min = 4,  max = 30, message = "direccion entre 4 y 12 carácteres")
	private String nombre;
	@NotNull(message = "el precio es obligatorio")	
	private Double precio;
	@NotNull(message = "La cantidad es campo obligatorio")	
	@Min(value = 0)
	private Integer Cantidad;
	@Column(name="create_at")
	@Temporal(TemporalType.DATE)
	private Date createAt;
	
	@PrePersist
	public void prePresist() {
		this.createAt = new Date();
	}
	
	
	public Integer getCantidad() {
		return Cantidad;
	}


	public void setCantidad(Integer cantidad) {
		Cantidad = cantidad;
	}


	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Double getPrecio() {
		return precio;
	}
	public void setPrecio(Double precio) {
		this.precio = precio;
	}
	public Date getCreateAt() {
		return createAt;
	}
	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
}
