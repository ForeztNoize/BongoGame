package bongo;

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class AIHand {
	
	private static ArrayList<Cards> p2deck = new ArrayList<Cards>();
	private static ArrayList<JButton> kno = new ArrayList<JButton>();
	private static int aicards = 10;
	private static JButton[] crds = new JButton[aicards];
	private static int Score = 0;
	private static JLabel playerEvent = new JLabel("Your card & bonus: ");
	private static JLabel computerEvent = new JLabel("Ai card & bonus: ");
	private static JLabel filler = new JLabel("");
	
	public static ArrayList<Cards> getP2deck() {
		return p2deck;
	}
	
	public AIHand(JPanel panel,int i) {
		JButton card = new JButton("Bongo");
		int id = i;
		p2deck.add(Hand.getDongle().get(0));
		Hand.getDongle().remove(0);
		panel.add(card);
		crds[id] = card;
		panel.add(playerEvent);
		panel.add(computerEvent);
		panel.add(filler);
	}

	public static void ComputerTurn(JPanel panel, int id, Cards player) {
		JButton computerChoice = new JButton();
		kno.add(computerChoice);
		computerChoice.setVisible(false);
		Color activeColor = getP2deck().get(id).getColor();
		computerChoice = new JButton(getP2deck().get(id).CardTotalValue());
		computerChoice.setBackground(activeColor);
		panel.add(computerChoice);
		panel.remove(kno.get(0));
		kno.set(0, computerChoice);
		crds[id].setVisible(false);
		panel.add(kno.get(0));
		
		int playerdamage = Analyzer(player, activeColor);
		playerEvent.setText("Your card & bonus: " + Elements.getElementEvent());
		
		int computerdamage = Analyzer(getP2deck().get(id), player.getColor());
		computerEvent.setText("Ai card & bonus: " + Elements.getElementEvent());
		
		int playernumber = Integer.parseInt(player.CardTotalValue());
		int computernumber = Integer.parseInt(getP2deck().get(id).CardTotalValue());
		int playerTotal = playerdamage + playernumber;
		int computerTotal = computerdamage + computernumber;
		Game(playerTotal, computerTotal);
	}
	
	public static int Analyzer(Cards subject, Color activeColor) {
		int damage = 1;
		if(subject.getColor() == Color.RED) {
			Fire playerFire = new Fire();
			damage = playerFire.Force(activeColor);
		}
		if(subject.getColor() == Color.GREEN) {
			Grass playerGrass = new Grass();
			damage = playerGrass.Force(activeColor);
		}
		if(subject.getColor() == Color.BLUE) {
			Water playerWater = new Water();
			damage = playerWater.Force(activeColor);
		}
		if(subject.getColor() == Color.YELLOW) {
			Poison playerPoison = new Poison();
			damage = playerPoison.Force(activeColor);
		}
		return damage;
	}
	
	public static void Game(int player, int computer){
		if(player > computer) {
			Score++;
			JOptionPane.showMessageDialog(null, "You Win\n Current Score: " + Score);
		}
		if(player < computer) {
			Score--;
			JOptionPane.showMessageDialog(null, "You Lose\n Current Score: " + Score);
		}
		if(player == computer) {
			JOptionPane.showMessageDialog(null, "Draw\n Current Score: " + Score);
		}
	}
}

