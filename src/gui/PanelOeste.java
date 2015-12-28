package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
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
	private JButton[] random;
	private JTextField[] orPlayer;
	private JTextField[] rangopls;
	private JTextField board;
	private JTextField deads;
	private JButton selBrd;
	private JButton selDed;
	private String rango;
	private JTextArea salida;
	private String out;
	private Controller controller;
	private JComboBox<String> comboBoxRanking;
	private JButton calcularRanking;
	private String[] ops = {"Sklansky-Chubukov", "Janda", "Ma", "Rock", "Tight"};
	private JPanel panel;
	private String[] nombres = {"Player 1", "Player 2", "Player 3", "Player 4", "Player 5", "Player 6"
								, "Player 7", "Player 8", "Player 9", "Player 10"};
	private boolean[] pulsados = {false, false, false, false, false, false, false, false, false, false};
	
	public PanelOeste(Controller contr) {
		

			
		this.panel = this;
		this.controller = contr;
		
		JButton player;
		JButton rand;
		JTextField rango;
		JTextField orPlayer;
		JLabel hand;
		JLabel equity;
		StringBuilder namePlayer = new StringBuilder();
		int tam=0;
		
		this.out = new String();		
		this.players = new JButton[10];
		this.random = new JButton[10];
		this.orPlayer = new JTextField[10];
		this.rangopls = new JTextField[10];
		this.rango = new String();
		this.comboBoxRanking = new JComboBox<String>(ops);
		this.comboBoxRanking.setSelectedIndex(0);
		
		this.setLayout(new GridLayout(2, 0));
		
		JPanel norte = new JPanel();
		norte.setLayout(null);
		
		Font font = new Font("RD", 11, 11);
		
		hand = new JLabel("<html><strong>Hand Distribution</strong></html>");
		hand.setBounds(7, 7, 150, 20);
		hand.setFont(font);
		
		equity = new JLabel("<html><strong>Equity</strong></html>");
		equity.setBounds(279, 7, 70, 20);
		equity.setFont(font);
		
		
		font = new Font("RD", 8, 8);
		
		for(int i=0; i < 10; i++) {
			
			namePlayer.append(this.nombres[i]);
			
			if(i==0){
				tam = 30;
				player = new JButton(namePlayer.toString());
				player.setBounds(7, tam, 75, 25);
				player.setMargin(new Insets(1,1,1,1));
				player.setHorizontalTextPosition(SwingConstants.LEFT);
				
				rand = new JButton("<html>R<br>D</html>");
				rand.setFont(font);
				rand.setBounds(85, tam, 17, 25);
				rand.setMargin(new Insets(1,1,1,1));
				
				rango = new JTextField();
				rango.getPreferredSize();
				rango.setBounds(104, tam, 170, 26);
				
				orPlayer = new JTextField();
				orPlayer.setBounds(279, tam, 40, 25);
				orPlayer.setMargin(new Insets(1,1,1,1));
			}
			else {
				tam+= 30;
				player = new JButton(namePlayer.toString());
				player.setBounds(7, tam, 75, 25);
				player.setMargin(new Insets(1,1,1,1));
				player.setHorizontalTextPosition(SwingConstants.LEFT);
				
				rand = new JButton("<html>R<br>D</html>");
				rand.setFont(font);
				rand.setBounds(85, tam, 17, 25);
				rand.setMargin(new Insets(1,1,1,1));
				
				rango = new JTextField();
				rango.getPreferredSize();
				rango.setBounds(104, tam, 170, 26);
				
				orPlayer = new JTextField();
				orPlayer.setBounds(279, tam, 40, 25);
				orPlayer.setMargin(new Insets(1,1,1,1));
				
			}
			
			this.players[i] = player;
			this.random[i] = rand;
			this.rangopls[i] = rango;
			this.orPlayer[i] = orPlayer;
			
			this.players[i].addActionListener(this);
			
			norte.add(hand);
			norte.add(equity);
			norte.add(player);
			norte.add(rand);
			norte.add(rango);
			norte.add(orPlayer);
			
			namePlayer.delete(0, namePlayer.length());
			
		}
		
		font = new Font("select", 10, 10);
		
		JLabel lbBoard = new JLabel("Board:");
		lbBoard.setText("Board:");
		lbBoard.setBounds(340, 110, 70, 20); // x, y, width, height
		this.board = new JTextField();
		this.board.setBounds(340, 130, 100, 30);
		this.board.setMargin(new Insets(1,1,1,1));
		this.selBrd = new JButton("<html><strong>select</strong></html>");
		this.selBrd.setHorizontalTextPosition(SwingConstants.CENTER);
		this.selBrd.setFont(font);
		this.selBrd.setBounds(442, 130, 40, 29);
		this.selBrd.setMargin(new Insets(1,1,1,1));
		
		JLabel lbDead = new JLabel("Dead Cards:");
		lbDead.setText("Dead Cards:");
		lbDead.setBounds(340, 170, 90, 20);
		this.deads = new JTextField();
		this.deads.setBounds(340, 190, 100, 30);
		this.deads.setMargin(new Insets(1,1,1,1));
		this.selDed = new JButton("<html><strong>select</strong></html>");
		this.selDed.setHorizontalTextPosition(SwingConstants.CENTER);
		this.selDed.setFont(font);
		this.selDed.setBounds(442, 190, 40, 29);
		this.selDed.setMargin(new Insets(1,1,1,1));
		
		
		this.evaluate = new JButton("Evaluate");
		this.evaluate.setBounds(350, 260, 100, 30);
		this.evaluate.setMargin(new Insets(1,1,1,1));
		
		this.calcularRanking = new JButton("Ranking");
		this.calcularRanking.setBounds(350, 295, 100, 30);
		this.evaluate.setMargin(new Insets(1,1,1,1));
		
		this.comboBoxRanking.setBounds(332, 30, 150, 30);
		
		this.selBrd.addActionListener(this);
		this.selDed.addActionListener(this);
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
		
		
		
		norte.add(lbBoard);
		norte.add(this.board);
		norte.add(this.selBrd);
		norte.add(lbDead);
		norte.add(this.deads);
		norte.add(this.selDed);
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
						this.pulsados[i] = true;
					}
					else {
						this.pulsados[i] = false;
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

		StringBuilder cad = new StringBuilder();
		
		for (int j = 0; j < 6; j++) {
			if(this.pulsados[j] == true) {
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
