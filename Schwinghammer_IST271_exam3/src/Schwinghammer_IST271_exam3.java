import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Schwinghammer_IST271_exam3 extends JFrame{

	public static final int WIDTH = 300;
	public static final int HEIGHT = 100;
	
	private JPanel buttonPanel;
	private JButton diceButton;
	private JButton cardButton;
	private JButton closeButton;
	
	
	
	public Schwinghammer_IST271_exam3() {
		// Setting up default parameters for the window
		setTitle("Exam 3");
		setSize(WIDTH, HEIGHT);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// Building the button panel
		buildButtonPanel();
		
		// Adding the built panel
		add(buttonPanel);
		
		// Displaying the window.
		setVisible(true);
		
	}
	
	// This builds the panel that holds the buttons
	public void buildButtonPanel() {
		buttonPanel = new JPanel();
		
		// Making Buttons
		diceButton = new JButton("Dice Game");
		cardButton = new JButton("Card Game");
		closeButton = new JButton("Exit");
		
		// Adding event listeners
		diceButton.addActionListener(new DiceListener());
		cardButton.addActionListener(new cardListener());
		closeButton.addActionListener(new closeListener());
		
		// Adding the items
		buttonPanel.add(diceButton);
		buttonPanel.add(cardButton);
		buttonPanel.add(closeButton);
		
	}
	
	// Listener to open dice game
	private class DiceListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			rollTwelves rT = new rollTwelves();

		}
		
	}
	
	// Listener to open card game
	private class cardListener implements ActionListener {
		
		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			thirtyFive tF = new thirtyFive();
		}
	}
		
	// Listener for close button
	private class closeListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			dispose();
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
			Schwinghammer_IST271_exam3 se3 = new Schwinghammer_IST271_exam3();
	}

}
