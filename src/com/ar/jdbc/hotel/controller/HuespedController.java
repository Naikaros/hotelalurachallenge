package com.ar.jdbc.hotel.controller;

import java.sql.Date;
import java.util.List;

import com.ar.jdbc.hotel.dao.HuespedDAO;
import com.ar.jdbc.hotel.factory.ConnectionFactory;
import com.ar.jdbc.hotel.modelo.Huesped;
import com.ar.jdbc.hotel.modelo.Reserva;

public class HuespedController {
	
	private HuespedDAO huespedDAO;

	public HuespedController() {
		this.huespedDAO = new HuespedDAO(new ConnectionFactory().recuperaConexion());
	}
	
	public void guardar(Huesped huesped) {
		huespedDAO.guardar(huesped);

	}
	
	public List<Huesped> listar() {
		return this.huespedDAO.listar();
	}
	public List<Huesped> buscarIdR(String idR) {
		return this.huespedDAO.buscarIdR(idR);
	}
	
	public int modificar(String nombre, String apellido, Date fechaN, String nacionalidad, String telefono, Integer id, Integer idR) {
		return this.huespedDAO.modificar(nombre, apellido, fechaN, nacionalidad, telefono, id, idR);
	}
	
	public int eliminar(Integer id) {
		return this.huespedDAO.eliminar(id);
	}
}
