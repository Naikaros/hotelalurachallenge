package com.ar.jdbc.hotel.modelo;

import java.sql.Date;

public class Huesped {

	private Integer id;
	private String nombre;
	private String apellido;
	private Date fechaN;
	private String nacionalidad;
	private String telefono;
	private Integer idR;
	
	public Huesped(String nombre, String apellido, Date fechaN, String nacionalidad, String telefono, Integer idR) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.fechaN = fechaN;
		this.nacionalidad = nacionalidad;
		this.telefono = telefono;
		this.idR = idR;
	}
	

	public Huesped(Integer id, String nombre, String apellido, Date fechaN, String nacionalidad, String telefono,
			Integer idR) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.fechaN = fechaN;
		this.nacionalidad = nacionalidad;
		this.telefono = telefono;
		this.idR = idR;
	}


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public Date getFechaN() {
		return fechaN;
	}

	public void setFechaN(Date fechaN) {
		this.fechaN = fechaN;
	}

	public String getNacionalidad() {
		return nacionalidad;
	}

	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public Integer getIdR() {
		return idR;
	}

	public void setIdR(Integer idR) {
		this.idR = idR;
	}
	
	
}
