package com.ar.jdbc.hotel.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.ar.jdbc.hotel.modelo.Huesped;
import com.ar.jdbc.hotel.modelo.Reserva;

public class HuespedDAO {
	
	private final Connection con;

	public HuespedDAO(Connection con) {
		this.con = con;
	}
	
	public void guardar(Huesped huesped) {
		try(con) {
			final PreparedStatement statement = con.prepareStatement(
					"INSERT INTO huespedes"
					+ "(nombre,"
					+ " apellido,"
					+ " fecha_nacimiento,"
					+ " nacionalidad,"
					+ " telefono,"
					+ " id_reserva)"
					+ " VALUES (?,?,?,?,?,?)",
					Statement.RETURN_GENERATED_KEYS);
					
			try(statement) {
				statement.setString(1, huesped.getNombre());
				statement.setString(2, huesped.getApellido());
				statement.setDate(3, huesped.getFechaN()); 
				statement.setString(4, huesped.getNacionalidad());
				statement.setString(5, huesped.getTelefono());
				statement.setInt(6, huesped.getIdR());
				statement.executeUpdate();
				final ResultSet rSet = statement.getGeneratedKeys();
				try(rSet) {
					while(rSet.next()) {
						huesped.setId(rSet.getInt(1));
					}
				}
			}
		} catch(SQLException e) {
			throw new RuntimeException(e.getMessage());
		}

	}
	
	public List<Huesped> listar() {
		List<Huesped> resultado = new ArrayList();
		
		
		try {
			final PreparedStatement statement = con
					.prepareStatement("SELECT id, nombre, apellido, fecha_nacimiento,"
							+ "nacionalidad, telefono, id_reserva FROM huespedes");
			
			try(statement) {
				statement.execute();
				
				transformarResultado(resultado, statement);
				
			}	
				return resultado;
			}catch (SQLException e) {
				throw new RuntimeException(e);
			}
		} 
		
	
	public int modificar(String nombre, String apellido, Date fechaN, String nacionalidad, String telefono, Integer id, Integer idR) {
		try{
	        final PreparedStatement statement = con.prepareStatement(
	                "UPDATE huespedes SET "
	                + " nombre = ?, "
	                + " apellido = ?,"
	                + " fecha_nacimiento = ?,"
	                + " nacionalidad = ?,"
	                + " telefono = ?,"
	                + " id_reserva =?"
	                + " WHERE id=?");

	        try (statement) {
	            statement.setString(1, nombre);
	            statement.setString(2, apellido);
	            statement.setDate(3, fechaN);
	            statement.setString(4, nacionalidad);
	            statement.setString(5, telefono);
	            statement.setInt(6, idR);
	            statement.setInt(7, id);
	            statement.execute();

	            int updateCount = statement.getUpdateCount();

	            return updateCount;
	        }
	    } catch (SQLException e) {
	        throw new RuntimeException(e);
	    }
	}
	
	public int eliminar(Integer id) {
			
			try{
				final PreparedStatement statement = con.prepareStatement("DELETE FROM huespedes WHERE id = ?");
				try(statement) {
					statement.setInt(1, id);
					statement.execute();
					
					int updateCount = statement.getUpdateCount();
					
					return updateCount;
				}
			} catch(SQLException e) {
				throw new RuntimeException(e);
			}
			
	}
	
	public List<Huesped> buscarIdR(String idR) {
		List<Huesped> huespedes = new ArrayList();
		try {
			final PreparedStatement statement = con.prepareStatement(
					"SELECT id,"
					+ " nombre,"
					+ " apellido,"
					+ " fecha_nacimiento,"
					+ " nacionalidad,"
					+ " telefono,"
					+ " id_reserva"
					+ " FROM huespedes"
					+ " WHERE id_reserva=?");
			try(statement) {
				statement.setString(1, idR);
				statement.execute();
				
				transformarResultado(huespedes, statement);
			}
			return huespedes;
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
			
	
	private void transformarResultado(List<Huesped> huespedes, PreparedStatement statement) {
		try(ResultSet rSet = statement.getResultSet()){
			while (rSet.next()) {
				Huesped fila = new Huesped(
						rSet.getInt("ID"),
						rSet.getString("NOMBRE"),
						rSet.getString("APELLIDO"),
						rSet.getDate("FECHA_NACIMIENTO"),
						rSet.getString("NACIONALIDAD"),
						rSet.getString("TELEFONO"),
						rSet.getInt("ID_RESERVA"));
				huespedes.add(fila);
			}
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}

	}
}
