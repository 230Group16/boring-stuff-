package kablewie;

import javax.swing.*;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

/**
* @file Board.java
* @author Thomas Fisher ************************** Whoever works on this class add your name here **************************
* @date 28 Nov 2015
* @see Game.java, Tile.java, Mine.java and Scoreboard.java for related information.
*
* The board that a Kablewie game will be played on.
*/
public class Board extends JPanel {
    
    /**
    * An accessor method taking in no arguments and returning the value of m_gameOver
    * @return Value of m_gameOver
    */
    public boolean isGameOver() {
        return m_gameOver;
    }
    
    /**
    * An accessor method taking in no arguments and returning the value of m_size
    * @return Value of m_size
    */
    public int getBoardSize() {
        return m_size;
    }
    
    /**
    * An accessor method taking in no arguments and returning the value of m_numberOfMines
    * @return Value of m_numberOfMines
    */
    public int getNumberOfMines() {
        return m_numberOfMines;
    }
    
    /**
    * An accessor method taking in no arguments and returning the value of m_mineLocations
    * @return Value of m_mineLocations
    */
    public int[] getMineLocations() {
        return m_mineLocations;
    }
    
    /**
    * An accessor method taking in no arguments and returning the value of BAR_WIDTH
    * @return Value of BAR_WIDTH
    */
    public int getWidth(){
        return BAR_WIDTH;
    }
    
    /**
    * An accessor method taking in no arguments and returning the value of BAR_HEIGHT
    * @return Value of BAR_HEIGHT
    */
    public int getHeight(){
        return BAR_HEIGHT;
    }
    
    /**
    * A method that updates all necessary data when called.
    */
    public void updateGameState() {
        if (m_gameOver) {
        	
        }
    }
    
    public void reveal(Tile tile) {
    	int x = tile.getPosX();
    	int y = tile.getPosY();
    	
    	tile.setEnabled(false);
    	
    	if (tile.hasMine()) {
    		m_gameOver = true;
    		updateGameState();
    	}
    	
    	checkTile(tile);
    	
    	//If tile has no surrounding mines, reveal all surrounding tiles
    	try {
    		if ((m_tiles[x][y]).getGraphic() == null) {
        		if (m_tiles[x+1][y+1].isEnabled()) { reveal(m_tiles[x+1][y+1]); }
        		if (m_tiles[x][y+1].isEnabled()) { reveal(m_tiles[x][y+1]); }
        		if (m_tiles[x+1][y].isEnabled()) { reveal(m_tiles[x+1][y]); }
        		if (m_tiles[x+1][y-1].isEnabled()) {reveal(m_tiles[x+1][y-1]); }
        		if (m_tiles[x-1][y+1].isEnabled()) { reveal(m_tiles[x-1][y+1]); }
        		if (m_tiles[x-1][y-1].isEnabled()) {reveal(m_tiles[x-1][y-1]); }
        		if (m_tiles[x][y-1].isEnabled()) { reveal(m_tiles[x][y-1]); }
        		if (m_tiles[x-1][y].isEnabled()) { reveal(m_tiles[x-1][y]); }
        	}
    	} catch (IndexOutOfBoundsException e) {}
    }
    
    private void checkTile(Tile tile){
    	int x = tile.getX();
    	int y = tile.getY();
    	
        int mineCount = 0;
        
        try {
        	//Tile to bottom right
            if (m_tiles[x+1][y+1].hasMine()) {mineCount++; }
            
           	//Tile below
           	if (m_tiles[x][y+1].hasMine()) {mineCount++; }
            	
           	//Tile to the right
           	if (m_tiles[x+1][y].hasMine()) {mineCount++; }
            	
           	//Tile to the left
           	if (m_tiles[x-1][y].hasMine()) {mineCount++; }
            	
           	//Tile above
           	if (m_tiles[x][y-1].hasMine()) {mineCount++; }
            	
           	//Tile to top right
           	if (m_tiles[x+1][y-1].hasMine()) {mineCount++; }
            	
           	//Tile to bottom left
           	if (m_tiles[x-1][y+1].hasMine()) {mineCount++; }
            	
           	//Tile to top left
           	if (m_tiles[x-1][y-1].hasMine()) {mineCount++; }
                
            /* if(mineCount != 0){
            	tile.setGraphic(mineCount);
            } */	
        } catch (IndexOutOfBoundsException e) {}
        
    }
    
    /**
    * A constructor taking two arguments and returning a new instance of Board.
    * @param sideLength the length of a side of the board.
    * @param numberOfMines an integer representing the number of mines.
    * @return New board object
    */
    public Board(int sideLength, int numberOfMines) {
        if (sideLength == -1) {
        	m_size = 10;
        } else {
            m_size = sideLength;        	
        }
        
        if (numberOfMines == -1) {
        	m_numberOfMines = numberOfMines;
        }
        
        m_tiles = new Tile[sideLength][sideLength];

        GridLayout boardLayout = new GridLayout(0,m_size);
        this.setLayout(boardLayout);
        this.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.setPreferredSize(new Dimension(BAR_WIDTH, BAR_HEIGHT));
        
        for (int i=0;i< m_size; i++) {
        	for (int j=0;j < m_size; j++) {
        		Tile tile = new Tile(i,j);
        		this.add(tile); //Create new tile with location (i,j)
        		m_tiles[i][j] = tile;
        	}
        }
    }
    
    int m_size;
    int m_numberOfMines;
    int[] m_mineLocations;
    boolean m_gameOver;
    Tile[][] m_tiles;
    private static final int COLOR_COMPONENT = 0;
    private static final int FIRST_X_COORD = 0;
    private static final int FIRST_Y_COORD = 0;
    private static final int TILE_SIZE = 30;
    private static final int BAR_HEIGHT = Game.getMBarHeight() - 100;
    private static final int BAR_WIDTH = Game.getMBarWidth();
    private static final int TEXT_X_COORD = 30;
    private static final int TEXT_Y_COORD = 230;
    
}
