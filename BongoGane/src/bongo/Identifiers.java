package bongo;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class Identifiers {
	
	public Identifiers(int y, int id, JPanel panel) {
		JButton balonk = new JButton("Kort" + id);
		balonk.setBounds(y, 590, 80, 100);
		panel.add(balonk);
		balonk.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			JButton card = new JButton();
			Color activeColor = Hand.getPpdeck().get(id).getColor();
			card = new JButton(Hand.getPpdeck().get(id).CardTotalValue());
			card.setBounds(315,240,80,100);
			card.setBackground(activeColor);
			panel.add(card);
			RemainingCards.setRemoved(id);
		}	
		});
	}
}
