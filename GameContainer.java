package kablewie;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.print.DocFlavor.URL;
import javax.swing.*;

/**
 * @file	-GameContainer.java
 * @author	-Tereza Stoyanova, Thomas Fisher, Ben Harris
 * @date    -28/11/2015
 * @see		-Game.java
 *
 * A container class for the game core. Also adds small
 * control panel at the foot of the container.
 */
public class GameContainer extends JFrame {
	public static final DEFAULT_GAME_SIZE = 10;
	public static final NAME_CHAR_LIM = 20;
	public static final CONTROL_PANEL_X = 2;
	public static final CONTROL_PANEL_Y = 3;
	public static final TEXT_FIELD_SIZE = 10;
	
	/**
	 * A getter method that returns this instance of GameContainer
	 * @return this instance of GameContainer
	 */
	public GameContainer getGameContainer() {
		return this;
	}
	
	/**
	 * Main method for this class. Simply instantiates this class with
	 * the DEFAULT_GAME_SIZE as parameters
	 * @see GameContainer(int, int)
	 */
	public static void main( String args[] ) {
		GameContainer gc = 
		new GameContainer(DEFAULT_GAME_SIZE,DEFAULT_GAME_SIZE);
	}
	
	/**
	 * Constructor for this class, taking in two integers
	 * @param s Size of game board measured in tiles
	 * @param m Amount of mines to be added to board
	 * @see InputHandler.actionPerformed(actionEvent)
	 * @see isNumeric(String)
	 * @see resetGame(Game)
	 */
	public GameContainer(int s, int m) {
		final int INPUT_HEIGHT = 100;
        
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setResizable(false);
		setTitle("Kablewie!");
        Game g = new Game(s,m);
        String playerName = JOptionPane.showInputDialog("Enter your name: ",
							"New Challenger");
        if (playerName != null) {
        	if(playerName.length() > NAME_CHAR_LIM) {
            	playerName = JOptionPane.showInputDialog("Sorry character "+
				      "limit is 20.\n Enter your name: ", "New Challenger");
            }
        } else {playerName = "N/A";}
        g.newPlayer(playerName);
        JPanel input = new JPanel(); input.setSize(g.getWidth(), INPUT_HEIGHT);
        input.setLayout(new GridLayout(CONTROL_PANEL_Y, CONTROL_PANEL_X));
        JLabel lblSize = new JLabel("Size: ");
        input.add(lblSize);
        JTextField tfSize = new JTextField(TEXT_FIELD_SIZE);input.add(tfSize);
        JLabel lblMines = new JLabel("Number of mines: ");input.add(lblMines);
        JTextField tfMines = new JTextField(TEXT_FIELD_SIZE);input.add(tfMines);
        JButton btnNewGame = new JButton("New Game");input.add(btnNewGame);
        JButton btnExit = new JButton("Exit");input.add(btnExit);
        
        class InputHandler implements ActionListener {
			/**
			 * Implementation of abstract method inherited from ActionListener
			 * This method adds functionality to the buttons at the footer
			 * of game container
			 * @param e An ActionEvent 
			 */
        	public void actionPerformed(ActionEvent e) {
        		int size = 10;
        		int mines = -1;
        		boolean valid = true;
        		boolean defaultValue = false;
        		int sizeInput = 10;
        		int mineInput = -1;
        		
        		if (e.getSource() == btnNewGame) {
 	        		if (tfSize.getText().equals("") || 
						!isNumeric(tfSize.getText())) {
 	        			size = 10; defaultValue = true;
 	        		} else {sizeInput = Integer.parseInt(tfSize.getText());}
 	        		if ((sizeInput <= 30) && (sizeInput > 0) && 
					   (isNumeric(tfSize.getText()) || defaultValue)){
 	        			size = sizeInput; } else {valid = false;}
					if (tfMines.getText().equals("") || 
					   !isNumeric(tfSize.getText())){
 	        			mines = size; mineInput = size;
 	        		} else {mineInput = Integer.parseInt(tfMines.getText()); }
 	        		if ((mineInput <= 150) && 
					   (mineInput < (sizeInput*sizeInput)) && 
					   (isNumeric(tfSize.getText()) || defaultValue)){
 	        			mines = mineInput;
 	        		} else {valid = false;}
 	        		if (valid){new GameContainer(size, mines); dispose();}else{
 	        			JOptionPane.showMessageDialog(getGameContainer(),
          					"The size must be a number between 1 and 30. "+
							"\n\nThe number of mines must be between 0 \n"
 	        				+ "and the size squared and must not exceed 150.",
 	        				"Incorrect value(s) entered",
							JOptionPane.WARNING_MESSAGE);
 	        		}
 	        		tfSize.setText(""); tfMines.setText("");
                } else if (e.getSource() == btnExit) { dispose();}
        	}	
        }
        InputHandler handler = new InputHandler();
        btnNewGame.addActionListener(handler);
        btnExit.addActionListener(handler);
        getContentPane().add(g, BorderLayout.NORTH);
        getContentPane().add(input, BorderLayout.CENTER);
        g.getScoreboard().updateTime(); setResizable(false); 
		pack(); setLocationRelativeTo(null); setVisible(true);
	}
	
	/**
	 * Method to reset the entire game
	 * @param g Game object to be reapplied
	 * @see Board.getBoardSize()
	 * @see Board.getBoardSize()
	 */
	public void resetGame(Game g) {
		int size = g.getBoard().getBoardSize();
		int mines = g.getBoard().getNumberOfMines();
		g = new Game(size,mines);
	}
	
	/**
	 * Method to test if inputs are numeric
	 * @param s String to test
	 * @return whether string is numeric
	 */
	public static boolean isNumeric(String string) {  
		try {  
			int testNumber = Integer.parseInt(string);  
		} catch(NumberFormatException e) {  
			return false;  
		}  
		
		return true;  
	}
	

}
