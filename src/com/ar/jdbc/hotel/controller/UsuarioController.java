package com.ar.jdbc.hotel.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import com.ar.jdbc.hotel.dao.UsuarioDAO;
import com.ar.jdbc.hotel.factory.ConnectionFactory;

import views.Login;
import views.MenuUsuario;

public class UsuarioController implements ActionListener {
	private Login vista;
	private UsuarioDAO usuarioDAO;
	
	public UsuarioController(Login vista) {
		this.usuarioDAO = new UsuarioDAO(new ConnectionFactory().recuperaConexion());
		this.vista = vista;
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String nombre = vista.getNombre();
		String passwrd = vista.getPasswrd();
		
		if(usuarioDAO.validarUsuario(nombre, passwrd)) {
			MenuUsuario menu = new MenuUsuario();
			menu.setVisible(true);
			vista.dispose();
		} else {
			JOptionPane.showMessageDialog(vista, "Usuario o contraseña incorrectos");
		}
	}
}
