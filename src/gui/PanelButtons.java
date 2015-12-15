package gui;

import java.awt.BorderLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controlador.Controller;

public class PanelButtons extends JPanel {
	
	
	public PanelButtons(Controller controller) {
		
		this.setLayout(null);
		
		JButton all = new JButton("All");
		JPanel jpAll = new JPanel(new BorderLayout());
		jpAll.add(all);
//		jpAll.setBounds(20, 500, 60, 30);
//		all.setMargin(new Insets(1,1,1,1));
		
//		JButton anySuited = new JButton("Any Suited");
//		JButton anyBroadway = new JButton("Any Broarway");
//		JButton anyPair = new JButton("Any Pair");
//		JButton clear = new JButton("Clear");
//		
//		JLabel jlSelected = new JLabel("Slected");
//		JTextField tfSlected = new JTextField();
		
		this.add(jpAll);
//		this.add(anySuited);
//		this.add(anyBroadway);
//		this.add(anyPair);
//		this.add(clear);
//		this.add(jlSelected);
//		this.add(tfSlected);
	}

}
