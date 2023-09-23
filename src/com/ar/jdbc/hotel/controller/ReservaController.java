package com.ar.jdbc.hotel.controller;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import com.ar.jdbc.hotel.dao.ReservaDAO;
import com.ar.jdbc.hotel.factory.ConnectionFactory;
import com.ar.jdbc.hotel.modelo.Reserva;

public class ReservaController {

	private ReservaDAO reservaDAO;

	public ReservaController() {
		this.reservaDAO = new ReservaDAO(new ConnectionFactory().recuperaConexion());
	}
	
	public void guardar(Reserva reserva) {
		this.reservaDAO.guardar(reserva);
	}

	public List<Reserva> listar() {
		return this.reservaDAO.listar();
	}
	public List<Reserva> buscarIdR(String id) {
		return this.reservaDAO.buscarId(id);
	}

	
	public int modificar(Date fechaE, Date fechaS, String precio, String formaPago, Integer id) {
		return this.reservaDAO.modificar(fechaE, fechaS, precio, formaPago, id);
	}
	
	public int eliminar(Integer id) {
		return this.reservaDAO.eliminar(id);
	}

	
	
	
}
