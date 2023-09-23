package com.ar.jdbc.hotel.factory;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class ConnectionFactory {
	public DataSource dataS;
	
	public ConnectionFactory() {
		ComboPooledDataSource comboPool = new ComboPooledDataSource();
		comboPool.setJdbcUrl("jdbc:mysql://localhost/hotel_alura_ar?useTimeZone=true&serverTimeZone=UTC");
		comboPool.setUser("root");
		comboPool.setPassword("1559");
		this.dataS = comboPool;
	}
	
	public Connection recuperaConexion() {
		try {
			return this.dataS.getConnection();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
