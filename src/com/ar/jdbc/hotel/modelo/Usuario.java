package com.ar.jdbc.hotel.modelo;

public class Usuario {
	
	private String nombre;
	private String passwrd;
	
	public Usuario(String nombre, String passwrd) {
		this.nombre = nombre;
		this.passwrd = passwrd;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPasswrd() {
		return passwrd;
	}

	public void setPasswrd(String passwrd) {
		this.passwrd = passwrd;
	}
}
