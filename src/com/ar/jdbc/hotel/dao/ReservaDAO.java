package com.ar.jdbc.hotel.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.ar.jdbc.hotel.factory.ConnectionFactory;
import com.ar.jdbc.hotel.modelo.Reserva;

public class ReservaDAO {
	
	 private final Connection con;

	public ReservaDAO(Connection con) {
		this.con = con;
	}
	
	public void guardar(Reserva reserva) {
		try(con) {
			final PreparedStatement statement = con.prepareStatement(
					"INSERT INTO reservas"
					+"(fecha_entrada, fecha_salida, precio, forma_de_pago)"
					+ "VALUES (?,?,?,?)",
					Statement.RETURN_GENERATED_KEYS);
			try(statement) {
				statement.setDate(1, reserva.getFechaE());
				statement.setDate(2, reserva.getFechaS());
				statement.setString(3, reserva.getPrecio());
				statement.setString(4, reserva.getFormaPago());
				statement.executeUpdate();
				final ResultSet rSet = statement.getGeneratedKeys();
				try(rSet) {
					while(rSet.next()) {
						reserva.setId(rSet.getInt(1));
					}
				}
			}
		} catch(SQLException e) {
			throw new RuntimeException();
		} 

	}
	
	public List<Reserva> listar() {
		List<Reserva> resultado = new ArrayList();
		
		
		try{
			final PreparedStatement statement = con
					.prepareStatement("SELECT ID, FECHA_ENTRADA, FECHA_SALIDA, PRECIO, FORMA_DE_PAGO FROM RESERVAS");
			
			try(statement) {
				statement.execute();
				
				transformarResultado(resultado, statement);}
				return resultado;
			} catch(SQLException e) {
				throw new RuntimeException(e);
		} 
			
	}
	
	public int modificar(Date fechaE, Date fechaS, String valor, String formaPago, Integer id) {
		try{
	        final PreparedStatement statement = con.prepareStatement(
	                "UPDATE reservas SET "
	                + " fecha_entrada = ?, "
	                + " fecha_salida = ?,"
	                + " precio = ?,"
	                + " forma_de_pago = ?"
	                + " WHERE id=?");

	        try (statement) {
	            statement.setDate(1, fechaE);
	            statement.setDate(2, fechaS);
	            statement.setString(3, valor);
	            statement.setString(4, formaPago);
	            statement.setInt(5, id);
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
				final PreparedStatement statement = con.prepareStatement("DELETE FROM reservas WHERE id = ?");
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
	
	public List<Reserva> buscarId(String id){
		List<Reserva> reservas = new ArrayList<Reserva>();
		try {
			final PreparedStatement statement = con.prepareStatement(
					"SELECT id,"
					+ " fecha_entrada,"
					+ " fecha_salida,"
					+ " precio,"
					+ " forma_de_pago"
					+ " FROM reservas"
					+ " WHERE id=?");
			try(statement) {
				statement.setString(1, id);
				statement.execute();
				
				transformarResultado(reservas, statement);
			}
			return reservas;
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	private void transformarResultado(List<Reserva> reservas, PreparedStatement statement) {
		try(ResultSet rSet = statement.getResultSet()){
			while(rSet.next()) {
				Reserva fila = new Reserva(
						rSet.getInt("ID"),
						rSet.getDate("FECHA_ENTRADA"),
						rSet.getDate("FECHA_SALIDA"),
						rSet.getString("PRECIO"),
						rSet.getString("FORMA_DE_PAGO"));
				reservas.add(fila);
			}
			
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}

	}
	 
	
}
