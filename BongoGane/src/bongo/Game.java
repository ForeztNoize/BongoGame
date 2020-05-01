package bongo;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Game {
	
	private static ArrayList<Card> p2deck = new ArrayList<Card>();
	private static ArrayList<JButton> compActive = new ArrayList<JButton>();
	private static int aicards = 10;
	private static JButton[] crds = new JButton[aicards];
	private static int Score = 0;
	//Labels for writing out what happens in a round.
	private static JLabel playerEvent = new JLabel("Your card & bonus: ");
	private static JLabel computerEvent = new JLabel("Ai card & bonus: ");
	private static JLabel filler = new JLabel("");
	
	private static Deck deck = new Deck();
	private static ArrayList<Card> originDeck = deck.getDeck();
	private static ArrayList<Card> ppdeck = new ArrayList<Card>();
	private static int handcards = 10;
	private static JButton[] hnds = new JButton[handcards];
	private static ArrayList<JButton> pushCard = new ArrayList<JButton>();
	private static int turn = 0;
	
	public static ArrayList<Card> getP2deck() {
		return p2deck;
	}
	
	public static ArrayList<Card> getOriginDeck() {
		return originDeck;
	}
	public static ArrayList<Card> getPpdeck() {
		return ppdeck;
	}
 
	//Method for creation of the players hand.
	public static void Hand(ArrayList<Card> ppdeck, JPanel panel) {
		//Iterates 9 times for 9 cards.
		for (int i = 0; i < 9; i++) {
			String value = originDeck.get(0).CardTotalValue();
			//The cards should be pressable and still display som sats hence why they are made as buttons
			JButton card = new JButton(value);
			int id = i;
			//Visualization of the card with color and number.
			Color currentColor = originDeck.get(0).getColor();
			card.setBackground(currentColor);
			ppdeck.add(originDeck.get(0));
			originDeck.remove(0);
			panel.add(card);
			hnds[id] = card;
			//ActionListener for when a card i pressed.
			card.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					//A new button that is suppose to represent the card pressed is made.
					JButton middle = new JButton();
					pushCard.add(middle);
					//If there was a card in the middle already it gets hidden to make place for the new one.
					middle.setVisible(false);
					//Visualization of the card with color and number.
					Color activeColor = getPpdeck().get(id).getColor();
					middle = new JButton(getPpdeck().get(id).CardTotalValue());
					middle.setBackground(activeColor);
					panel.add(middle);
					panel.remove(pushCard.get(0));
					pushCard.set(0, middle);
					panel.add(pushCard.get(0));
					//The card is hidden from where it was before creating the illusion that it was moved.
					hnds[id].setVisible(false);
					Game.ComputerTurn(panel, id, getPpdeck().get(id));
					//Make the turn number go up.
					turn++;
					//If-statement to end the game if all cards have been played.
					if(turn == 9) {
						JOptionPane.showMessageDialog(null, "Game Over");
						System.exit(0);
					}
				}	
			});
		}
	}
	
	//Method for the computers cards. Since the cards are hidden the visual design of them is much simpler.
	public static void AIHand(JPanel panel) {
		for(int i = 0; i < 9; i++) {
			JButton card = new JButton("Bongo");
			int id = i;
			p2deck.add(getOriginDeck().get(0));
			getOriginDeck().remove(0);
			panel.add(card);
			crds[id] = card;
			//The Labels for the information during the round are added last so that they appear at the bottom.
			panel.add(playerEvent);
			panel.add(computerEvent);
			panel.add(filler);
		}
	}

	//Method for bringing forward the computers card and comparing the two battle cards.
	public static void ComputerTurn(JPanel panel, int id, Card player) {
		//To show the card the player is up against a new button is created.
		JButton computerChoice = new JButton();
		compActive.add(computerChoice);
		computerChoice.setVisible(false);
		//Visualization of the card with color and number.
		Color activeColor = getP2deck().get(id).getColor();
		computerChoice = new JButton(getP2deck().get(id).CardTotalValue());
		computerChoice.setBackground(activeColor);
		panel.add(computerChoice);
		panel.remove(compActive.get(0));
		compActive.set(0, computerChoice);
		crds[id].setVisible(false);
		panel.add(compActive.get(0));
		
		//Runs analyzer one time for the player card
		int playerdamage = Analyzer(player, activeColor);
		playerEvent.setText("Your card & bonus: " + Elements.getElementEvent());
		
		//Now that playerdamage is already assigned, analyzer can now be run for the computer.
		int computerdamage = Analyzer(getP2deck().get(id), player.getColor());
		computerEvent.setText("Ai card & bonus: " + Elements.getElementEvent());
		
		//To turn the string numbers into a value for calculation they need to get parsed.
		int playernumber = Integer.parseInt(player.CardTotalValue());
		int computernumber = Integer.parseInt(getP2deck().get(id).CardTotalValue());
		
		//The total for both the player and computer is calculated.
		int playerTotal = playerdamage + playernumber;
		int computerTotal = computerdamage + computernumber;
		
		//Game is ran to compare the total damages.
		GameResult(playerTotal, computerTotal);
	}
	
	//Method to check the elemental of the card and compare it to the opponents.
	public static int Analyzer(Card subject, Color activeColor) {
		//The standard is always 1
		int damage = 1;
		if(subject.getColor() == Color.RED) {
			Fire playerFire = new Fire();
			//If the card had a bonus it will add it to the damage by the method Force which returns an integer.
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
	
	//Method to compare the two battle cards and keep track of how the turns are going.
	public static void GameResult(int player, int computer){
		//Depending on who won a different message will show.
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

