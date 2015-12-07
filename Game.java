package kablewie;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
* @file    -Game.java
* @author  -Ben Harris, Thomas Fisher, David Jones
* @date    -28/11/2015
* @see	   -GameContainer.java
* @see     -Board.java
* @see	   -Scoreboard.java
*
* A simple panel that can contains the core of the game
*
*/

public class Game extends JPanel {
	public static final int SCOREBOARD_HEIGHT = 100; 
	
	private Board m_board;
	private Scoreboard m_scoreboard;
	private Human m_player;
	private int m_height;
	private int m_width;
   
    	/**
	 * Getter method returning the height of the game panel
	 * @return m_height (Game height in pixels)
	 */
	public int getHeight() {
		return m_height;
	}
	
	/**
	 * Getter method returning the width of the game panel
	 * @return m_width (Game width in pixels)
	 */
	public int getWidth() {
		return m_width;
	}
	
	/**
	 * Getter method returning the Board panel (a child of Game)
	 * @return m_board (the board contained in Game)
	 */
	public Board getBoard() {
		return m_board;
	}
	
	/**
	 * Getter method returning the Scoreboard panel (a child of Game)
	 * @return m_scoreboard (the scoreboard contained in game)
	 */
	public Scoreboard getScoreboard() {
		return m_scoreboard;
	}
	
	/**
	 * Getter method returning the Human object
	 * @return m_player (the player object)
	 */
	public Human getPlayer() {
		return m_player;
	}
	
	/**
	 * Constructor for this class. Takes in two args for use in makeGame()
	 * @param size The width and height of the board (measured in tiles)
	 * @param mines The amount of mines to be added to the board
	 * @see makeGame(int, int)
	 */
	public Game(int size, int mines) {
        makeGame(size, mines);
	}
	
	/**
	 * Method that takes a string and uses it to create
	 * a human object as well as set the name on the scoreboard
	 * @param name a string argument used to set name and initialise Human
	 * @see Scoreboard.java
	 * @see Human.java
	 * @return a new Human object, using name and this (Game) as parameters
	 */
	public Human newPlayer(String name) {
    		m_scoreboard.setPlayerName(name);
		return new Human(name, this);
	}
	
	/**
	 * The primary method for this class that takes in two integers and
	 * uses them to create the core of the game (The board and the scoreboard)
	 * @param s Size of board measured in tiles
	 * @param m Amount of mines to be placed into the board
	 * @see Board.java
	 * @see Scoreboard.java
	 */
	public void makeGame(int s, int m){
    		m_board = new Board(s, m);
        	m_scoreboard = new Scoreboard(this);
        
        	m_height = m_board.getHeight() + SCOREBOARD_HEIGHT;
		m_width = m_board.getWidth();
        
        	m_scoreboard.setBackground(Color.WHITE);
        
        	add(m_scoreboard);
		add(m_board);
        
		setLayout(null);
		m_scoreboard.setBounds(0,0, m_width, SCOREBOARD_HEIGHT);
		m_board.setBounds(0,SCOREBOARD_HEIGHT, m_width, m_board.getHeight());
		setPreferredSize(new Dimension(m_width, m_height));
		updateUI();
	}
    
	/**
	 * This method ends the game in one of three ways - Reset, Win or Loss
	 * with the character being r for reset, w for win and l for loss.
	 * Upon loss also adds the loss animation to the game
	 * @param gameState A character representation for each state
	 * @see Scoreboard.setGameState(String)
	 * @see Scoreboard.stopTimer()
	 * @see Animations.java
	 */
	public void endGame(char gameState) {    

		switch(gameState){
        	case 'w':
        		m_scoreboard.setGameState("You win!");
            		break;
        	case 'l':
			m_scoreboard.setGameState("You lose!");
			Animations a = new Animations(this); 
			add(a);
			remove(m_board);
			a.setBounds(0,SCOREBOARD_HEIGHT, m_width, m_board.getHeight());
			m_scoreboard.stopTimer();
			break;
		case 'r':
			m_scoreboard.reset();
			break;
		}
	}
}
