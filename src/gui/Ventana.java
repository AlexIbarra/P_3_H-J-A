package gui;

import java.awt.BorderLayout;

import javax.swing.JFrame;

import controlador.Controller;

public class Ventana extends JFrame{
	
	private Controller controller;
	
	public Ventana (Controller controller) {
		
		this.controller = controller;
		
		this.setSize(1000, 700);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(new java.awt.GridLayout(0, 2));
		
		getContentPane().add(new PanelOeste(controller));
		getContentPane().add(new PanelEste(controller));
		this.setResizable(false);
		this.setVisible(true);		
	}

}
