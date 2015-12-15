package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import controlador.Controller;
import jugadores.Jugador;
import main.PilaPosiciones;
import observers.RangoObserver;
import observers.RankingObserver;

public class PanelOeste extends JPanel implements ActionListener, RankingObserver {
	
	private static final long serialVersionUID = 1L;
	
	private JButton evaluate;
	private JButton[] players;
	private JTextField[] orPlayer;
	private JTextField[] rangopls;
	private String rango;
	private JTextArea salida;
	private String out;
	private Controller controller;
	private JComboBox<String> comboBoxRanking;
	private JButton calcularRanking;
	private String[] ops = {"Sklansky-Chubukov", "Janda", "Ma", "Rock", "Tight"};
	private JPanel panel;
	private String[] nombres = {"UTG", "MP", "CO", "BTN", "SB", "BB"};
	private boolean[] pulsados = {false, false, false, false, false, false};
	
	public PanelOeste(Controller contr) {
		

			
		this.panel = this;
		this.controller = contr;
		
		JButton player;
		JTextField rango;
		JTextField orPlayer;
		StringBuilder namePlayer = new StringBuilder();
		int tam=0;
		
		this.out = new String();
		this.calcularRanking = new JButton("Ranking");
		this.players = new JButton[6];
		this.orPlayer = new JTextField[6];
		this.rangopls = new JTextField[6];
		this.rango = new String();
		this.comboBoxRanking = new JComboBox<String>(ops);
		this.comboBoxRanking.setSelectedIndex(0);
		
		this.setLayout(new GridLayout(2, 0));
		
		JPanel norte = new JPanel();
		norte.setLayout(null);
		
		for(int i=0; i < 6; i++) {
			
			namePlayer.append(this.nombres[i]);
			
			if(i==0){
				tam = 10;
				player = new JButton(namePlayer.toString());
				player.setBounds(7, tam, 90, 30);
				player.setMargin(new Insets(1,1,1,1));
				
				rango = new JTextField();
				rango.getPreferredSize();
				rango.setBounds(104, tam, 170, 32);
				
				orPlayer = new JTextField("fold");
				orPlayer.setBounds(279, tam, 40, 30);
				orPlayer.setMargin(new Insets(1,1,1,1));
			}
			else {
				tam+= 35;
				player = new JButton(namePlayer.toString());
				player.setBounds(7, tam, 90, 30);
				player.setMargin(new Insets(1,1,1,1));
				
				rango = new JTextField();
				rango.getPreferredSize();
				rango.setBounds(104, tam, 170, 32);
				
				orPlayer = new JTextField("fold");
				orPlayer.setBounds(279, tam, 40, 30);
				orPlayer.setMargin(new Insets(1,1,1,1));
				
			}
			
			this.players[i] = player;
			this.rangopls[i] = rango;
			this.orPlayer[i] = orPlayer;
			
			this.players[i].addActionListener(this);
			
			norte.add(player);
			norte.add(rango);
			norte.add(orPlayer);
			
			namePlayer.delete(0, namePlayer.length());
			
		}
		
		
		
		this.evaluate = new JButton("Evaluate");
		this.evaluate.setBounds(350, 200, 100, 30);
		this.evaluate.setMargin(new Insets(1,1,1,1));
		
		this.calcularRanking.setBounds(350, 250, 100, 30);
		this.evaluate.setMargin(new Insets(1,1,1,1));
		
		this.comboBoxRanking.setBounds(332, 10, 150, 30);
		
		this.evaluate.addActionListener(this);	
		this.calcularRanking.addActionListener(this);
		this.comboBoxRanking.addActionListener (new ActionListener () {
		    public void actionPerformed(ActionEvent e) {
		    	
		    	JComboBox<String> aux;
				
				if((aux = (JComboBox<String>)e.getSource()) == comboBoxRanking) {
					
					String selectedRanking = (String)aux.getSelectedItem();
					
					System.out.println(selectedRanking);
				
					if("Sklansky-Chubukov".equalsIgnoreCase(selectedRanking)){
						controller.setRanking(1);
					}
					else if ("Janda".equalsIgnoreCase(selectedRanking)){
						controller.setRanking(2);
					}
					else if("Ma".equalsIgnoreCase(selectedRanking)) {
						controller.setRanking(3);
					}
					else if("Rock".equalsIgnoreCase(selectedRanking)) {
						controller.setRanking(4);
					}
					else if("Tight".equalsIgnoreCase(selectedRanking)) {
						controller.setRanking(5);
					}
					controller.cleanGrid();
				}
		        
		    }
		});
		
		
		norte.add(this.evaluate);
		norte.add(this.calcularRanking);
		norte.add(this.comboBoxRanking);
		
		
		this.add(norte);
		
		JPanel sur = new JPanel();
		JPanel vacio = new JPanel();
		JPanel vacio2 = new JPanel();
		sur.setLayout(new BorderLayout());
		this.salida = new JTextArea(15,50);
		JScrollPane scroll = new JScrollPane(this.salida);
		vacio2.setLayout(new BorderLayout());
		vacio2.add(scroll);
		vacio2.setBorder(new TitledBorder("Salida"));
		sur.add(vacio2, BorderLayout.SOUTH);
		sur.add(vacio, BorderLayout.CENTER);
		this.add(sur);
		
		
		
		this.controller.addRankingObserver(this);
		
	}

	
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == this.evaluate) {
			
			this.out = "";
			
			for (int i = 0; i < players.length; i++) {
				
				
				if (!this.rangopls[i].getText().equals("")) {
					this.controller.evaluaRango(this.rangopls[i].getText(),this.players[i].getText(), this.orPlayer[i].getText().toUpperCase());//mano, pos, accion
				}

				this.rangopls[i].setText("");
				this.orPlayer[i].setText("fold");
				this.players[i].setEnabled(true);
				this.pulsados[i] = false;
			}
			
			this.controller.cleanGrid();
		}
		else if(e.getSource() == this.calcularRanking) {
			for (int i = 0; i < players.length; i++) {
				try {
					this.rango = this.rangopls[i].getText();
					this.controller.nuevoRango(this.rango);
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
		}

		
		for (int i = 0; i < players.length; i++) {
			if(this.players[i] == e.getSource()) {
				try {
					if(this.pulsados[i] == false) {
						this.players[i].setBackground(Color.GREEN);
						this.players[i].setForeground(Color.BLACK);
//						this.players[i].setEnabled(false);
						this.pulsados[i] = true;
					}
					else {
						this.pulsados[i] = false;
//						this.players[i].setEnabled(true);
						this.players[i].setBackground(Color.gray);
						this.players[i].setForeground(Color.WHITE);
					}
				} catch (Exception e2) {
					// TODO: handle exception
				}
				
			}
		}
		
		
		
		
		
	}





	@Override
	public void hayRanking(PilaPosiciones pila) {
		// TODO Auto-generated method stub
		
	}





	@Override
	public void addObserver(RankingObserver obs) {
		// TODO Auto-generated method stub
		
	}





	@Override
	public void jugadaEvaluada(String[] salida, boolean res) {
		// TODO Auto-generated method stub
				
		this.out += "Rango: " + salida[0] + "\n";
		this.out += "Mano: " + salida[1] + "\n";
		this.out += "Posición: " + salida[2] + "\n";
		this.out += "Acción: " + salida[3] + "\n";
		if(res)
			this.out += "Resultado: " + "CORRECTO" + "\n\n";
		else
			this.out += "Resultado: " + "ERRONEO" + "\n\n";
		
		this.salida.setText(this.out);
	}





	@Override
	public void haySeleccionado(Vector<String> select) {
		// TODO Auto-generated method stub
//		boolean pintado = false;
//		int i=0;
//		while(i<6 && !pintado) {
//			if(this.rangopls[i].getText().equals("")) {
//				this.rangopls[i].setText(select.lastElement());
//				pintado = true;
//			}
//			i++;
//		}
//		String cadena = new String();
		StringBuilder cad = new StringBuilder();
		
		for (int j = 0; j < 6; j++) {
			if(this.pulsados[j] == true) {
//				cadena += select.lastElement();
				cad.append(this.rangopls[j].getText());
				if(cad.toString().equals("")) {
					cad.append(select.lastElement());
				}
				else {
					cad.append(",");
					cad.append(select.lastElement());
				}
				this.rangopls[j].setText(cad.toString());
			}
		}
	}

}
