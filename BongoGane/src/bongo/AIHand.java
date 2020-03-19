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
	private static JLabel computerEvents = new JLabel();
	private static JLabel playerEvents = new JLabel();
	
	public static ArrayList<Cards> getP2deck() {
		return p2deck;
	}
	
	public AIHand(JPanel panel,int x, int y, int i) {
		panel.add(computerEvents);
		panel.add(playerEvents);
		JButton card = new JButton("Bongo");
		int id = i;
		card.setBounds(x, y, 80, 100);
		p2deck.add(Hand.getDongle().get(0));
		Hand.getDongle().remove(0);
		panel.add(card);
		crds[id] = card;
	}

	public static void ComputerTurn(JPanel panel, int id, Cards player) {
		computerEvents.setText("Ai Bonus: ");
		playerEvents.setText("Your Bonus: ");
		playerEvents.setBounds(620, 200, 440, 40);
		computerEvents.setBounds(620, 300, 440, 40);
		JButton computerChoice = new JButton();
		kno.add(computerChoice);
		computerChoice.setVisible(false);
		Color activeColor = getP2deck().get(id).getColor();
		computerChoice = new JButton(getP2deck().get(id).CardTotalValue());
		computerChoice.setBounds(415,240,80,100);
		computerChoice.setBackground(activeColor);
		panel.add(computerChoice);
		panel.remove(kno.get(0));
		kno.set(0, computerChoice);
		crds[id].setVisible(false);
		panel.add(kno.get(0));
		
		int playerdamage = Analyzer(player, activeColor);
		
		playerEvents.setText("Your Bonus: " + Elements.getEvents());
		
		int computerdamage = Analyzer(getP2deck().get(id), player.getColor());
		
		computerEvents.setText("Ai Bonus: " + Elements.getEvents());
		
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
			playerFire.Action();
			damage = playerFire.Force(activeColor);
		}
		if(subject.getColor() == Color.GREEN) {
			Grass playerGrass = new Grass();
			playerGrass.Action();
			damage = playerGrass.Force(activeColor);
		}
		if(subject.getColor() == Color.BLUE) {
			Water playerWater = new Water();
			playerWater.Action();
			damage = playerWater.Force(activeColor);
		}
		if(subject.getColor() == Color.YELLOW) {
			Poison playerPoison = new Poison();
			playerPoison.Action();
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

