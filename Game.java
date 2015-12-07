/**
* @file    -Game.java
* @author  -Rabidra Thapa
* @date    -28/11/2015
* @see     -Board.java
* @see	    -Scoreboard.java
*
* A simple frame that can contain panels
*
*/

package kablewie;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Game extends JPanel {
	
	public int getHeight() {
		return m_height;
	}
	
	public int getWidth() {
		return m_width;
	}
	
	public Board getBoard() {
		return m_board;
	}
	
	public Scoreboard getScoreboard() {
		return m_scoreboard;
	}
	
	public Human getPlayer() {
		return m_player;
	}
	
	public Human newPlayer(String name) {
    	m_scoreboard.setPlayerName(name);
    	return new Human(name, this);
    }
	
    public Game(int size, int mines) {
        makeGame(size, mines);
    }
    
    
    
    public void makeGame(int s, int m){
    	m_board = new Board(s, m);
        m_scoreboard = new Scoreboard(this);
        
        m_height = m_board.getHeight() + SCOREBOARD_HEIGHT;
        m_width = m_board.getWidth();
        
        m_scoreboard.setBackground(Color.WHITE);
        
        /* add board and scoreboard to frame */
        add(m_scoreboard);
        add(m_board);
        
          
       
        
        setLayout(null);
        m_scoreboard.setBounds(0,0, m_width, SCOREBOARD_HEIGHT);
        m_board.setBounds(0,SCOREBOARD_HEIGHT, m_width, m_board.getHeight());
        setPreferredSize(new Dimension(m_width, m_height));
        updateUI();
    }
    
    public void endGame(char gameState) {    

    	switch(gameState){
        case 'w':
            //Win
        	m_scoreboard.setGameState("You win!");
            break;
        case 'l':
            //Loss and display animation
            m_scoreboard.setGameState("You lose!");
            Animations a = new Animations(this); 
            add(a);  
            a.setBounds(0,SCOREBOARD_HEIGHT, m_width, m_board.getHeight());
            m_scoreboard.stopTimer();
            break;
        case 'r':
            m_scoreboard.reset();
            break;
        }
    	 
		for (int i=0; i<m_board.getBoardSize(); i++){
	    	for (int j=0; j<m_board.getBoardSize();j++) {
	    		m_board.reveal(m_board.getTile(j, i));
	    	}
		}
		
        
    }
    
	
    private Board m_board;
    private Scoreboard m_scoreboard;
    public static final int SCOREBOARD_HEIGHT = 100; 
    private int m_height;
    private int m_width;
    private Human m_player;
}
