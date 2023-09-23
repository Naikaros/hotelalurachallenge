package com.ar.jdbc.hotelmain;

import java.awt.EventQueue;

import javax.swing.JFrame;

import views.MenuPrincipal;

public class App {
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuPrincipal frame = new MenuPrincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
