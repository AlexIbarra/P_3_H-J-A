package gui;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import controlador.Controller;


public class PanelEste extends JPanel {
	
	private static final long serialVersionUID = 1L;
	
	
	
	public PanelEste(Controller controller){
		
		this.setSize(500, 700);
		
		this.setLayout(new BorderLayout());
		
		PanelGrid ps = new PanelGrid(controller);
		ps.setBorder(new TitledBorder("Grid"));
		
		this.add(ps, BorderLayout.NORTH);
		this.add(new PanelSliders(controller), BorderLayout.CENTER);
	}
}
