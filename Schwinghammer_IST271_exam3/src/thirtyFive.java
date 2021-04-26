

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import java.util.ArrayList;
import java.util.Random;

/**
   This program demonstrates a solution to the
   Card Dealer programming challenge.
*/

public class thirtyFive extends JFrame
{
   private final int WINDOW_WIDTH = 1500;  // Window width
   private final int WINDOW_HEIGHT = 700; // Window height
   
   private JPanel deckPanel;		// A panel to hold a label
   
   private JPanel userCardPanel;        // A panel to hold a label
   private JPanel compCardPanel;
   
   private JPanel cardPanel;        // A panel to hold a label
   private JPanel cardPanel2;        // A panel to hold a label
   private JPanel cardPanel3;        // A panel to hold a label
   private JPanel cardPanel4;        // A panel to hold a label
   private JPanel cardPanel5;        // A panel to hold a label
   private JPanel cardPanel6;
   private JPanel cardPanel7;
   private JPanel cardPanel8;
   private JPanel cardPanel9;
   private JPanel cardPanel10;
   private JPanel cardPanel11;
   private JPanel cardPanel12;
   
   private JPanel buttonPanel;      // A panel to hold a button
   private JLabel deckLabel;        // A label to hold an image
   
   private JLabel cardLabel;        // A label to hold an image
   private JLabel cardLabel2;        // A label to hold an image
   private JLabel cardLabel3;        // A label to hold an image
   private JLabel cardLabel4;        // A label to hold an image
   private JLabel cardLabel5;        // A label to hold an image
   private JLabel cardLabel6;
   private JLabel cardLabel7;
   private JLabel cardLabel8;
   private JLabel cardLabel9;
   private JLabel cardLabel10;
   private JLabel cardLabel11;
   private JLabel cardLabel12;
   
   private ImageIcon deckImage;     // To hold a deck image
   
   private ImageIcon cardImage;     // To hold a card image
   private ImageIcon cardImage2;     // To hold a card image
   private ImageIcon cardImage3;     // To hold a card image
   private ImageIcon cardImage4;     // To hold a card image
   private ImageIcon cardImage5;     // To hold a card image
   private ImageIcon cardImage6;
   private ImageIcon cardImage7;
   private ImageIcon cardImage8;
   private ImageIcon cardImage9;
   private ImageIcon cardImage10;
   private ImageIcon cardImage11;
   private ImageIcon cardImage12;
   
   private ImageIcon placeholder;
   
   private JButton button;          // A button to get a card from the deck
   private JButton button2;          // A button to get a card from the deck
   private JButton button3;          // A button to get a card from the deck
   private Container contentPane;   // To reference the content pane
   private ArrayList<ImageIcon> cardImageList;  // To hold the card images.
   int location = 4;
   int compLocation = 9;
   
   int maxScore = 35;
   int standScore = 28;
   int userScore = 0;
   int compScore = 0;
   
   
   /**
      Constructor
   */
   
   public thirtyFive()
   {
      // Set the title.
      setTitle("Poker Game");
   
      // Set the size of the window.
      setSize(WINDOW_WIDTH, WINDOW_HEIGHT);

      // Specify what happens when the close button is clicked.
      setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
      
      // Create a BorderLayout manager for the content pane.
      setLayout(new BorderLayout());
       

      // Build the panels.
      buildDeckPanel();
      buildButtonPanel();
      buildCardPanel();
      buildCardPanel2();
      buildCardPanel3();
      buildCardPanel4();
      buildCardPanel5();
      buildCardPanel6();
      buildCardPanel7();
      buildCardPanel8();
      buildCardPanel9();
      buildCardPanel10();
      buildCardPanel11();
      buildCardPanel12();

      compCardPanel = new JPanel();
      userCardPanel = new JPanel();
      // Add the panels to the content pane.
      add(deckPanel, BorderLayout.WEST);
      userCardPanel.add(new JLabel("Your Hand: "));
      userCardPanel.add(cardPanel);
      userCardPanel.add(cardPanel2);
      userCardPanel.add(cardPanel3);
      userCardPanel.add(cardPanel4);
      userCardPanel.add(cardPanel5);
      userCardPanel.add(cardPanel6);
      
      compCardPanel.add(new JLabel("Computer's Hand: "));
      compCardPanel.add(cardPanel7);
      compCardPanel.add(cardPanel8);
      compCardPanel.add(cardPanel9);
      compCardPanel.add(cardPanel10);
      compCardPanel.add(cardPanel11);
      compCardPanel.add(cardPanel12);
      


	  placeholder = new ImageIcon("Cards\\Placeholder.jpg");
	   
      
      add(userCardPanel, BorderLayout.CENTER);
      add(compCardPanel, BorderLayout.NORTH);
      add(buttonPanel, BorderLayout.SOUTH);
      
      setupGame();

      // Display the window.
      setVisible(true);
   }
   
   private void compPlay() {
	   Random rand = new Random();
	   do {
		   if (compLocation == 9) {
	    		  int index9 = rand.nextInt(cardImageList.size());
	    		  cardImage9 = cardImageList.get(index9);
	    		  cardImageList.remove(index9);
	    		  cardLabel9.setIcon(cardImage9);
	    		  compScore += getScore(cardImage9.toString());
	    		  
	    	  } else if (compLocation == 10) {
	    		  int index10 = rand.nextInt(cardImageList.size());
	    		  cardImage10 = cardImageList.get(index10);
	    		  cardImageList.remove(index10);
	    		  cardLabel10.setIcon(cardImage10);
	    		  compScore += getScore(cardImage10.toString());
	    		  
	    	  } else if (compLocation == 11) {
	    		  int index11 = rand.nextInt(cardImageList.size());
	    		  cardImage11 = cardImageList.get(index11);
	    		  cardImageList.remove(index11);
	    		  cardLabel11.setIcon(cardImage11);
	    		  compScore += getScore(cardImage11.toString());
	    		  
	    	  } else if (compLocation == 12) {
	    		  int index12 = rand.nextInt(cardImageList.size());
	    		  cardImage12 = cardImageList.get(index12);
	    		  cardImageList.remove(index12);
	    		  cardLabel12.setIcon(cardImage12);
	    		  compScore += getScore(cardImage12.toString());
	    	  }   

		   compLocation++;
		   
	   } while (compScore < standScore && compLocation < 13);
	   
	   if (compScore > maxScore) {
		   JOptionPane.showMessageDialog(null, "Computer Busted! You Win!");
	   } else if (compScore >= userScore) {
		   JOptionPane.showMessageDialog(null, "Computer Won! Better luck next time!");
	   } else {
		   JOptionPane.showMessageDialog(null, "Congratulations! You've won!");
	   }
	   
   }

   private void setupGame() {
	   buildCardImageList();
	   Random rand = new Random();
	   userScore = 0;
	   compScore = 0;
	   location = 4;
	   compLocation = 9;
	   button.setEnabled(true);
	   button2.setEnabled(true);
		  
	   // The player cards being made place holders
	   cardLabel4.setIcon(placeholder);
	   cardLabel5.setIcon(placeholder);
	   cardLabel6.setIcon(placeholder);
	   
	   // All the computer cards being made place holders
	   cardLabel9.setIcon(deckImage);
	   cardLabel10.setIcon(placeholder);
	   cardLabel11.setIcon(placeholder);
	   cardLabel12.setIcon(placeholder);
	   
	   
	   // Generating random cards for the visible ones
	   int index1 = rand.nextInt(cardImageList.size());
	   cardImage = cardImageList.get(index1);
	   cardImageList.remove(index1);
	   cardLabel.setIcon(cardImage);
	   userScore += getScore(cardImage.toString());
	   
	   int index2 = rand.nextInt(cardImageList.size());
	   cardImage2 = cardImageList.get(index2);
	   cardImageList.remove(index2);
	   cardLabel2.setIcon(cardImage2);
	   userScore += getScore(cardImage2.toString());
	   
	   int index3 = rand.nextInt(cardImageList.size());
	   cardImage3 = cardImageList.get(index3);
	   cardImageList.remove(index3);
	   cardLabel3.setIcon(cardImage3);
	   userScore += getScore(cardImage3.toString());
	   
	   int index7 = rand.nextInt(cardImageList.size());
	   cardImage7 = cardImageList.get(index7);
	   cardImageList.remove(index7);
	   cardLabel7.setIcon(cardImage7);
	   compScore += getScore(cardImage7.toString());
	   
	   int index8 = rand.nextInt(cardImageList.size());
	   cardImage8 = cardImageList.get(index8);
	   cardImageList.remove(index8);
	   cardLabel8.setIcon(cardImage8);
	   compScore += getScore(cardImage8.toString());
	   
   }
   
   private int getScore(String cardString) {
	   int score = 0;
	   if (cardString.contains("Jack") || cardString.contains("Queen") ||
			   cardString.contains("King") || cardString.contains("10")) {
		   score = 10;
	   } else if (cardString.contains("Ace")) {
		   score = 11;
	   } else {
		   score = Integer.parseInt(String.valueOf(cardString.charAt(6)));
	   }
	   
	   return score;
   }
   
   /**
      The buildDeckPanel method adds a label
      to a panel that displays an image of 
      a deck of cards.
   */

   
   private void buildDeckPanel()
   {
      // Create a panel.
      deckPanel = new JPanel();

      // Create an image icon to represent the deck of cards.
      deckImage = new ImageIcon("Cards\\Backface_Blue.jpg");

      // Create a label using the image for the deck of cards.
      deckLabel = new JLabel(deckImage);

      // Add the label to the panel.
      deckPanel.add(deckLabel);
   }

   /**
      The buildCardPanel method adds an empty label
      to a panel initially, but this label will be
      used to display a card from the deck once the
      user clicks the button.
   */

   private void buildCardPanel()
   {
      // Create a panel.
      cardPanel = new JPanel();

      // Create a label.
      cardLabel = new JLabel();

      // Add the label to the panel.
      cardPanel.add(cardLabel);
   }
  
   private void buildCardPanel2()
   {
      // Create a panel.
      cardPanel2 = new JPanel();

      // Create a label.
      cardLabel2 = new JLabel();

      // Add the label to the panel.
      cardPanel2.add(cardLabel2);
   }
   
   private void buildCardPanel3()
   {
      // Create a panel.
      cardPanel3 = new JPanel();

      // Create a label.
      cardLabel3 = new JLabel();

      // Add the label to the panel.
      cardPanel3.add(cardLabel3);
   }
   
   private void buildCardPanel4()
   {
      // Create a panel.
      cardPanel4 = new JPanel();

      // Create a label.
      cardLabel4 = new JLabel();

      // Add the label to the panel.
      cardPanel4.add(cardLabel4);
   }
   
   private void buildCardPanel5()
   {
      // Create a panel.
      cardPanel5 = new JPanel();

      // Create a label.
      cardLabel5 = new JLabel();

      // Add the label to the panel.
      cardPanel5.add(cardLabel5);
   }

   private void buildCardPanel6()
   {
      // Create a panel.
      cardPanel6 = new JPanel();

      // Create a label.
      cardLabel6 = new JLabel();

      // Add the label to the panel.
      cardPanel6.add(cardLabel6);
   }

   private void buildCardPanel7()
   {
      // Create a panel.
      cardPanel7 = new JPanel();

      // Create a label.
      cardLabel7 = new JLabel();

      // Add the label to the panel.
      cardPanel7.add(cardLabel7);
   }
   
   private void buildCardPanel8()
   {
      // Create a panel.
      cardPanel8 = new JPanel();

      // Create a label.
      cardLabel8 = new JLabel();

      // Add the label to the panel.
      cardPanel8.add(cardLabel8);
   }
   
   private void buildCardPanel9()
   {
      // Create a panel.
      cardPanel9 = new JPanel();

      // Create a label.
      cardLabel9 = new JLabel();

      // Add the label to the panel.
      cardPanel9.add(cardLabel9);
   }
   
   private void buildCardPanel10()
   {
      // Create a panel.
      cardPanel10 = new JPanel();

      // Create a label.
      cardLabel10 = new JLabel();

      // Add the label to the panel.
      cardPanel10.add(cardLabel10);
   }
   
   private void buildCardPanel11()
   {
      // Create a panel.
      cardPanel11 = new JPanel();

      // Create a label.
      cardLabel11 = new JLabel();

      // Add the label to the panel.
      cardPanel11.add(cardLabel11);
   }
   
   private void buildCardPanel12()
   {
      // Create a panel.
      cardPanel12 = new JPanel();

      // Create a label.
      cardLabel12 = new JLabel();

      // Add the label to the panel.
      cardPanel12.add(cardLabel12);
   }
   
   /**
      The buildButtonPanel method adds a button
      to a panel.
   */

   private void buildButtonPanel()
   {
      // Create a panel.
      buttonPanel = new JPanel();
   
      // Create a button.
      button = new JButton("Hit");
      button.setMnemonic(KeyEvent.VK_D);
      button.setToolTipText("Click here to deal a card.");
      
      button2 = new JButton("Stand");
      button2.setMnemonic(KeyEvent.VK_S);
      button2.setToolTipText("Click here to stand.");
      
      button3 = new JButton("Play Again");
      button3.setMnemonic(KeyEvent.VK_P);
      button3.setToolTipText("Click here to play again.");
      
      // Register an action listener with the button.
      button.addActionListener(new ButtonListener());
      button2.addActionListener(new ButtonListener2());
      button3.addActionListener(new ButtonListener3());
      
      // Add the button to the panel.
      buttonPanel.add(button);
      buttonPanel.add(button2);
      buttonPanel.add(button3);
      
   }


   /**
      The buildCardImageList method fills the 
      ArrayList with images of a deck of 
      poker cards.
   */

   private void buildCardImageList()
   {
      // Create the cardImageList ArrayList 
      // to hold the ImageIcon objects.
      cardImageList = new ArrayList<>();
      
      // Add the ImageIcon objects to the cardImageList ArrayList
      cardImageList.add(new ImageIcon("Cards\\2_Clubs.jpg"));
      cardImageList.add(new ImageIcon("Cards\\2_Diamonds.jpg"));
      cardImageList.add(new ImageIcon("Cards\\2_Hearts.jpg"));
      cardImageList.add(new ImageIcon("Cards\\2_Spades.jpg"));
      
      cardImageList.add(new ImageIcon("Cards\\3_Clubs.jpg"));
      cardImageList.add(new ImageIcon("Cards\\3_Diamonds.jpg"));
      cardImageList.add(new ImageIcon("Cards\\3_Hearts.jpg"));
      cardImageList.add(new ImageIcon("Cards\\3_Spades.jpg"));
      
      cardImageList.add(new ImageIcon("Cards\\4_Clubs.jpg"));
      cardImageList.add(new ImageIcon("Cards\\4_Diamonds.jpg"));
      cardImageList.add(new ImageIcon("Cards\\4_Hearts.jpg"));
      cardImageList.add(new ImageIcon("Cards\\4_Spades.jpg"));
      
      cardImageList.add(new ImageIcon("Cards\\5_Clubs.jpg"));
      cardImageList.add(new ImageIcon("Cards\\5_Diamonds.jpg"));
      cardImageList.add(new ImageIcon("Cards\\5_Hearts.jpg"));
      cardImageList.add(new ImageIcon("Cards\\5_Spades.jpg"));
      
      cardImageList.add(new ImageIcon("Cards\\6_Clubs.jpg"));
      cardImageList.add(new ImageIcon("Cards\\6_Diamonds.jpg"));
      cardImageList.add(new ImageIcon("Cards\\6_Hearts.jpg"));
      cardImageList.add(new ImageIcon("Cards\\6_Spades.jpg"));
      
      cardImageList.add(new ImageIcon("Cards\\7_Clubs.jpg"));
      cardImageList.add(new ImageIcon("Cards\\7_Diamonds.jpg"));
      cardImageList.add(new ImageIcon("Cards\\7_Hearts.jpg"));
      cardImageList.add(new ImageIcon("Cards\\7_Spades.jpg"));
      
      cardImageList.add(new ImageIcon("Cards\\8_Clubs.jpg"));
      cardImageList.add(new ImageIcon("Cards\\8_Diamonds.jpg"));
      cardImageList.add(new ImageIcon("Cards\\8_Hearts.jpg"));
      cardImageList.add(new ImageIcon("Cards\\8_Spades.jpg"));
      
      cardImageList.add(new ImageIcon("Cards\\9_Clubs.jpg"));
      cardImageList.add(new ImageIcon("Cards\\9_Diamonds.jpg"));
      cardImageList.add(new ImageIcon("Cards\\9_Hearts.jpg"));
      cardImageList.add(new ImageIcon("Cards\\9_Spades.jpg"));
      
      cardImageList.add(new ImageIcon("Cards\\10_Clubs.jpg"));
      cardImageList.add(new ImageIcon("Cards\\10_Diamonds.jpg"));
      cardImageList.add(new ImageIcon("Cards\\10_Hearts.jpg"));
      cardImageList.add(new ImageIcon("Cards\\10_Spades.jpg"));
      
      cardImageList.add(new ImageIcon("Cards\\Jack_Clubs.jpg"));
      cardImageList.add(new ImageIcon("Cards\\Jack_Diamonds.jpg"));
      cardImageList.add(new ImageIcon("Cards\\Jack_Hearts.jpg"));
      cardImageList.add(new ImageIcon("Cards\\Jack_Spades.jpg"));
      
      cardImageList.add(new ImageIcon("Cards\\Queen_Clubs.jpg"));
      cardImageList.add(new ImageIcon("Cards\\Queen_Diamonds.jpg"));
      cardImageList.add(new ImageIcon("Cards\\Queen_Hearts.jpg"));
      cardImageList.add(new ImageIcon("Cards\\Queen_Spades.jpg"));
      
      cardImageList.add(new ImageIcon("Cards\\King_Clubs.jpg"));
      cardImageList.add(new ImageIcon("Cards\\King_Diamonds.jpg"));
      cardImageList.add(new ImageIcon("Cards\\King_Hearts.jpg"));
      cardImageList.add(new ImageIcon("Cards\\King_Spades.jpg"));
      
      cardImageList.add(new ImageIcon("Cards\\Ace_Clubs.jpg"));
      cardImageList.add(new ImageIcon("Cards\\Ace_Diamonds.jpg"));
      cardImageList.add(new ImageIcon("Cards\\Ace_Hearts.jpg"));
      cardImageList.add(new ImageIcon("Cards\\Ace_Spades.jpg"));
                                                  
   }
  
   /**
      Private inner class that handles the event when
      the user clicks the button.
   */
   
   private class ButtonListener implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
    	  // Dealing another card for the player
    	  Random rand = new Random();
    	  
    	  if (location == 4) {
    		  int index4 = rand.nextInt(cardImageList.size());
    		  cardImage4 = cardImageList.get(index4);
    		  cardImageList.remove(index4);
    		  cardLabel4.setIcon(cardImage4);
    		  userScore += getScore(cardImage4.toString());
    		  
    	  } else if (location == 5) {
    		  int index5 = rand.nextInt(cardImageList.size());
    		  cardImage5 = cardImageList.get(index5);
    		  cardImageList.remove(index5);
    		  cardLabel5.setIcon(cardImage5);
    		  userScore += getScore(cardImage5.toString());
    		  
    	  } else if (location == 6) {
    		  int index6 = rand.nextInt(cardImageList.size());
    		  cardImage6 = cardImageList.get(index6);
    		  cardImageList.remove(index6);
    		  cardLabel6.setIcon(cardImage6);
    		  userScore += getScore(cardImage6.toString());
    		  button.setEnabled(false);
    		  button2.setEnabled(false);
    		  compPlay();
    		  
    	  } else {
    		  button.setEnabled(false);
    		  button2.setEnabled(false);
    	  }
    	  
    	  location ++;
    	  if (userScore > maxScore) {
    		  button.setEnabled(false);
    		  button2.setEnabled(false);
    		  JOptionPane.showMessageDialog(null, "You went over 35! You lose!");
    		  
    	  }
    	  
      }
   }

   private class ButtonListener2 implements ActionListener
   {

	@Override
	public void actionPerformed(ActionEvent arg0) {
		button.setEnabled(false);
		button2.setEnabled(false);
		compPlay();
	}
	   
   }
   
   private class ButtonListener3 implements ActionListener
   {

	@Override
	public void actionPerformed(ActionEvent e) {
		setupGame();
	}
	   
   }
   /**
      The main method creates an instance of the CardDealer
      class, causing it to display its window.
   */
   public static void main(String[] args)
   {
      thirtyFive gui = new thirtyFive();
      
      gui.setVisible(true);
   }

     

}
