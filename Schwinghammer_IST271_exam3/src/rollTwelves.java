

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.*;

public class rollTwelves extends JFrame{
	
	private final int WINDOW_HEIGHT = 400;
	private final int WINDOW_WIDTH = 900;
	
	private Container contentPane;
	
	private JPanel dieUserPanel;
	private JPanel dieComputerPanel;
	
	private ImageIcon die1Image;
	private JLabel die1Label;
	
	private ImageIcon die2Image;
	private JLabel die2Label;
	
	private ImageIcon die3Image;
	private JLabel die3Label;
	
	private ImageIcon die4Image;
	private JLabel die4Label;
	
	private ImageIcon die5Image;
	private JLabel die5Label;
	
	private ImageIcon die6Image;
	private JLabel die6Label;
	
	private ImageIcon die7Image;
	private JLabel die7Label;
	
	private ImageIcon die8Image;
	private JLabel die8Label;
	
	private ImageIcon die9Image;
	private JLabel die9Label;
	
	private ImageIcon die10Image;
	private JLabel die10Label;
	
	private ImageIcon die11Image;
	private JLabel die11Label;
	
	private ImageIcon die12Image;
	private JLabel die12Label;
	
	private JLabel userTotalLabel;
	private JLabel computerTotalLabel;
	
	private JPanel userPanel;
	private JPanel computerPanel;
	
	private JLabel winnerLabel;
	private JButton button;
	private JPanel buttonPanel;
	
	
	private ArrayList<ImageIcon> dieImageList;
	
	public rollTwelves() {
		
		setTitle("Dice Simulator");
		setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		setLayout(new GridLayout(3, 1));
		
		buildDieImageList();
		
		buildDie1Panel();
		buildDie2Panel();
		buildDie3Panel();
		buildDie4Panel();
		buildDie5Panel();
		buildDie6Panel();
		buildDie7Panel();
		buildDie8Panel();
		buildDie9Panel();
		buildDie10Panel();
		buildDie11Panel();
		buildDie12Panel();
		
		buildButtonPanel();
		buildUserPanel();
		buildComputerPanel();
		
		add(userPanel);
		add(computerPanel);
		add(buttonPanel);
		
		rollDice();
		
		setVisible(true);
		
	}
	
	private void buildUserPanel() {
		userTotalLabel = new JLabel();
		userPanel = new JPanel();
		userPanel.setLayout(new BorderLayout());
		userPanel.add(new JLabel("User:"), BorderLayout.WEST);
		userPanel.add(dieUserPanel, BorderLayout.CENTER);
		userPanel.add(userTotalLabel, BorderLayout.EAST);
		
	}
	
	private void buildComputerPanel() {
		computerTotalLabel = new JLabel();
		computerPanel = new JPanel();
		computerPanel.setLayout(new BorderLayout());
		computerPanel.add(new JLabel("Computer:"), BorderLayout.WEST);
		computerPanel.add(dieComputerPanel, BorderLayout.CENTER);
		computerPanel.add(computerTotalLabel, BorderLayout.EAST);
		
	}
	
	private void buildButtonPanel() {
		winnerLabel = new JLabel();
		buttonPanel = new JPanel();
		
		button = new JButton("Play Again");
		button.setToolTipText("Press here to play again.");
		
		button.addActionListener(new ButtonListener());
		
		buttonPanel.add(winnerLabel);
		buttonPanel.add(button);
		
	}
	
	
	private void buildDie1Panel() {
	
		dieUserPanel = new JPanel();
		
		die1Label = new JLabel();
		
		dieUserPanel.add(die1Label);
		
	}
	
	private void buildDie2Panel() {
		
		die2Label = new JLabel();
		
		dieUserPanel.add(die2Label);
		
	}
	
	private void buildDie3Panel() {
		
		die3Label = new JLabel();
		
		dieUserPanel.add(die3Label);
		
	}
	
	private void buildDie4Panel() {
		
		die4Label = new JLabel();
		
		dieUserPanel.add(die4Label);
		
	}
	
	private void buildDie5Panel() {
		
		die5Label = new JLabel();
		
		dieUserPanel.add(die5Label);
		
	}
	
	private void buildDie6Panel() {
		
		die6Label = new JLabel();
		
		dieUserPanel.add(die6Label);
		
	}
	
	private void buildDie7Panel() {
		
		dieComputerPanel = new JPanel();
		
		die7Label = new JLabel();
		
		dieComputerPanel.add(die7Label);
		
	}
	
	private void buildDie8Panel() {
		
		die8Label = new JLabel();
		
		dieComputerPanel.add(die8Label);
		
	}
	
	private void buildDie9Panel() {
		
		die9Label = new JLabel();
		
		dieComputerPanel.add(die9Label);
		
	}
	
	private void buildDie10Panel() {
		
		die10Label = new JLabel();
		
		dieComputerPanel.add(die10Label);
		
	}
	
	private void buildDie11Panel() {
		
		die11Label = new JLabel();
		
		dieComputerPanel.add(die11Label);
		
	}
	
	private void buildDie12Panel() {
		
		die12Label = new JLabel();
		
		dieComputerPanel.add(die12Label);
		
	}
	
	
	
	private void buildDieImageList() {
		
		dieImageList = new ArrayList<>();
		
		dieImageList.add(new ImageIcon("Dice\\d12_1.jpg"));
		dieImageList.add(new ImageIcon("Dice\\d12_2.jpg"));
		dieImageList.add(new ImageIcon("Dice\\d12_3.jpg"));
		dieImageList.add(new ImageIcon("Dice\\d12_4.jpg"));
		dieImageList.add(new ImageIcon("Dice\\d12_5.jpg"));
		dieImageList.add(new ImageIcon("Dice\\d12_6.jpg"));
		dieImageList.add(new ImageIcon("Dice\\d12_7.jpg"));
		dieImageList.add(new ImageIcon("Dice\\d12_8.jpg"));
		dieImageList.add(new ImageIcon("Dice\\d12_9.jpg"));
		dieImageList.add(new ImageIcon("Dice\\d12_10.jpg"));
		dieImageList.add(new ImageIcon("Dice\\d12_11.jpg"));
		dieImageList.add(new ImageIcon("Dice\\d12_12.jpg"));
		
	}
	
	private void rollDice() {
		
		Random rand = new Random();
		int userTotal = 0;
		int compTotal = 0;
		
		int index1 = rand.nextInt(dieImageList.size());
			
		die1Image = dieImageList.get(index1);
		
		die1Label.setIcon(die1Image);
		
		
		int index2 = rand.nextInt(dieImageList.size());
		
		die2Image = dieImageList.get(index2);
		
		die2Label.setIcon(die2Image);
		
		
		int index3 = rand.nextInt(dieImageList.size());
		
		die3Image = dieImageList.get(index3);
		
		die3Label.setIcon(die3Image);
		
		
		int index4 = rand.nextInt(dieImageList.size());
		
		die4Image = dieImageList.get(index4);
		
		die4Label.setIcon(die4Image);
		
		
		int index5= rand.nextInt(dieImageList.size());
		
		die5Image = dieImageList.get(index5);
		
		die5Label.setIcon(die5Image);
		
		
		int index6 = rand.nextInt(dieImageList.size());
		
		die6Image = dieImageList.get(index6);
		
		die6Label.setIcon(die6Image);
		
		
		int index7 = rand.nextInt(dieImageList.size());
		
		die7Image = dieImageList.get(index7);
		
		die7Label.setIcon(die7Image);
		
		
		int index8 = rand.nextInt(dieImageList.size());
		
		die8Image = dieImageList.get(index8);
		
		die8Label.setIcon(die8Image);
		
		
		int index9 = rand.nextInt(dieImageList.size());
		
		die9Image = dieImageList.get(index9);
		
		die9Label.setIcon(die9Image);
		
		
		int index10 = rand.nextInt(dieImageList.size());
		
		die10Image = dieImageList.get(index10);
		
		die10Label.setIcon(die10Image);
		
		
		int index11 = rand.nextInt(dieImageList.size());
		
		die11Image = dieImageList.get(index11);
		
		die11Label.setIcon(die11Image);
		
		
		int index12 = rand.nextInt(dieImageList.size());
		
		die12Image = dieImageList.get(index12);
		
		die12Label.setIcon(die12Image);
		
		userTotal = index1 + index2 + index3 + index4 + index5 + index6 + 6;
		compTotal = index7 + index8 + index9 + index10 + index11 + index12 + 6;
		
		userTotalLabel.setText("Total: " + userTotal);
		computerTotalLabel.setText("Total: " + compTotal);
		
		if (userTotal > compTotal) {
			winnerLabel.setText("You are the winner!");
		} else if (compTotal > userTotal) {
			winnerLabel.setText("The computer is the winner!");
		} else {
			winnerLabel.setText("A Tie! Try again!");
		}
		
	}
	
	private class ButtonListener implements ActionListener {
		
		public void actionPerformed(ActionEvent e) {
			rollDice();
		}
		
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		rollTwelves rT = new rollTwelves();
		
	}

}
