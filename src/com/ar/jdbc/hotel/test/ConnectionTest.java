package com.ar.jdbc.hotel.test;

import java.sql.Connection;
import java.sql.SQLException;

import com.ar.jdbc.hotel.factory.ConnectionFactory;

public class ConnectionTest {
	public static void main(String[] args) throws SQLException {
		ConnectionFactory con = new ConnectionFactory();
		Connection cone =  con.recuperaConexion();
		System.out.println("Conecto Bien");
		
		cone.close();
		System.out.println("Cerro bien perryx");
	}
	
	
}
