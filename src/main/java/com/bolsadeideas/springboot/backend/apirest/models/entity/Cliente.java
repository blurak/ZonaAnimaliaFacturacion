package com.bolsadeideas.springboot.backend.apirest.models.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@Entity
@Table(name="clientes")
public class Cliente implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotNull(message = "nombre es campo obligatorio")	
	@Size(min = 4,  max = 12, message = "direccion entre 4 y 12 carácteres")
	private String nombre;	
	private String direccion;
	private String telefono;	
 	@Column(name="creat_at")
 	@NotNull(message = "fecha es campo obligatorio")
 	@Temporal(TemporalType.DATE)
	private Date creatAt;
	private String foto;	
	
	@JsonIgnoreProperties({"cliente","hibernateLazyInitializer","handler"})
	@OneToMany(fetch =FetchType.LAZY, mappedBy = "cliente",cascade = CascadeType.ALL)
	private List<Factura> facturas;
	
	
	
 	public Cliente() {
		this.facturas = new ArrayList<>();
	}

	@PrePersist
 	public void prePresist(){
 		creatAt = new Date();
 	}
 	
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public Date getCreatAt() {
		return creatAt;
	}

	public void setCreatAt(Date creatAt) {
		this.creatAt = creatAt;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public List<Factura> getFacturas() {
		return facturas;
	}

	public void setFacturas(List<Factura> facturas) {
		this.facturas = facturas;
	}



	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
