package com.ar.jdbc.hotel.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ar.jdbc.hotel.factory.ConnectionFactory;

public class UsuarioDAO {
    private final Connection con;

    public UsuarioDAO(Connection con) {
        this.con = con;
    }

    public boolean validarUsuario(String nombre, String passwrd) {
        try{
        	final PreparedStatement statement = con.prepareStatement(
                "SELECT * FROM usuarios WHERE usuario=? AND contraseña =?");
        	try(statement) {
        		statement.setString(1, nombre);
        		statement.setString(2, passwrd);
        		final ResultSet rSet = statement.executeQuery();
        		try(rSet) {
        			return rSet.next();
        		}
        	}
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } 
    }
}

