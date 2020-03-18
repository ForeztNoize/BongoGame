package bongo;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Main {
	public static JFrame frame = new JFrame("BongoGame");
	public static JPanel panel = new JPanel();
	public static JLabel lblNewLabel = new JLabel("");

	public static void main(String[] args) {
		
		panel.setBounds(0, 5, 571, 33);
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
		frame.setVisible(true);
		panel.setLayout(null);
	
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		lblNewLabel.setBounds(30, 9, 150, 14);
		panel.add(lblNewLabel);	
		JButton logodeck = new JButton("Bongo");
		logodeck.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			RemainingCards.pull(Hand.getPpdeck(), panel);
		}	
		});
		logodeck.setBounds(810,240,80,100);
		panel.add(logodeck);
		
		int buttons = 8;
		Identifiers[] btns = new Identifiers[buttons];
		int by = 0;
		for (int j = 0; j < btns.length; j++) {
		  btns[j] = new Identifiers(by, j, panel);
		  by += 90;
		}
		
		Hand.bonk();
		Hand.donk();
		int x = 0;
		int y = 0;
		for (int i = 0; i < Hand.getP2deck().size(); i++) {
			y = 40;
			Hand AIhands = new Hand(Hand.getP2deck(), panel, x, y, i);
			x += 90;
		}
		int x2 = 0;
		for (int i = 0; i < Hand.getPpdeck().size(); i++) {
			y = 440;
			Hand AIhands = new Hand(Hand.getPpdeck(), panel, x2, y, i);
			x2 += 90;
		}
	}
	
}


