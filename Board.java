package kablewie;

import javax.swing.*;

import java.util.ArrayList;
import java.util.Random;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JPanel;
import javax.swing.border.BevelBorder;

/**
* @file Board.java
* @author Thomas Fisher, Ben Harris, Adina Ardeleanu, Tereza Stoyanova
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
     * An incrementor method taking in no arguments and incrementing m_numberDiffused
     * @see Game.java
     */
    public void incrementNumberDiffused() {
    	m_numberDiffused++;
    	((Game) getParent()).getScoreboard().setMinesDiffused();
    }
    
    /**
     * An decrementor method taking in no arguments and decrementing m_numberDiffused
     * @see Game.java
     */
    public void decrementNumberDiffused() {
    	m_numberDiffused--;
    	((Game) getParent()).getScoreboard().setMinesDiffused();
    }
    
    /**
     * An accessor method taking in no arguments and returning the number tiles diffused
     * @return Value of m_gameOver
     */
    public int getNumberDiffused() {
    	return m_numberDiffused;
    }
    
    /**
     * An accessor method taking in 2 arguments and returning a tile 
     * @param x the x-coordinate of the tile.
     * @param y the y-coordinate of the tile.
     * @see Tile.java
     * @return The tile at location (x,y).
     */
    public Tile getTile(int x, int y) {
    	return m_tiles[x][y];
    }
    
    /**
     * An accessor method taking in no arguments and returning the height of the board.
     * @return The height of the board in pixels.
     * @see Tile.java
     */
    public int getHeight() {
    	int defaultSize = m_size * Tile.TILE_SIZE;
    	
    	if (defaultSize < DEFAULT_BOARD_HEIGHT) {
    		defaultSize = DEFAULT_BOARD_HEIGHT;
    	}
    	
    	return defaultSize;
    }
    
    
    /**
     * An accessor method taking in no arguments and returning the width of the board.
     * @return The width of the board in pixels.
     * @see Tile.java
     */
    public int getWidth() {
    	int defaultSize = m_size * Tile.TILE_SIZE;
    	
    	if (defaultSize < DEFAULT_BOARD_WIDTH) {
    		defaultSize = DEFAULT_BOARD_WIDTH;
    	}
    	
    	return defaultSize;
    }
    
    /**
    * An accessor method taking in no arguments and returning the value of m_size
    * @return The size of one side of the board.
    */
    public int getBoardSize() {
        return m_size;
    }
    
    /**
    * An accessor method taking in no arguments and returning the value of m_numberOfMines
    * @return The number of mines on the board.
    */
    public int getNumberOfMines() {
        return m_numberOfMines;
    }
  
    /**
    * A method that updates the state of the game when called.
    * @see Game.java
    */
    public void updateGameState() {
        if (m_gameOver) {
        	((Game) getParent()).endGame('l');
        }
    }
    
    /**
     * A mutator method taking in one argument and returning nothing.
     */
    public void setGameOver(boolean tf) {
    	m_gameOver = tf;
    }
    
    /**
     * A method that recursively reveals tiles starting from the tile given as an argument.
     * @param tile the tile to start recursively revealing from.
     * @see Tile.java
     */
	public void reveal(Tile tile) {
		int x = tile.getPosX();
    	int y = tile.getPosY();
    	
    	if (!tile.isRevealed() && !m_gameOver) {
    		((Game) getParent()).getScoreboard().incrementTilesRevealed();
    	}
    	
    	if (m_tiles[x][y].hasMine()) {
    		if (!m_gameOver) {
    			m_gameOver = true;
           		updateGameState();
    		}
    		
			try {
				tile.showGraphic(0);
			} catch (IOException e) {}
    	} else {
    		checkTile(tile);
        	if (tile.getIcon() == new JButton().getIcon()) {
	
            	int delay = 50;
            	Timer timer = new Timer( delay, new ActionListener(){
            		@Override
            		public void actionPerformed( ActionEvent e ){
            			if (!m_tiles[x][y].hasMine() 
            					|| checkTile(m_tiles[x][y]) == 0) {
            				if ((x+1 < m_size) && ( y+1 < m_size)) {
            					if (m_tiles[x+1][y+1].isEnabled()) { 
            						reveal(m_tiles[x+1][y+1]); 
            					} 
            				}
            				if (x+1 < m_size) {
            					if (m_tiles[x+1][y].isEnabled()) { 
            						reveal(m_tiles[x+1][y]); 
            					}
            				}
            				if ((x+1 < m_size) && (y-1 >= 0)) {
            					if (m_tiles[x+1][y-1].isEnabled()) { 
            						reveal(m_tiles[x+1][y-1]); 
            					}
            				}
            				if (y-1 >= 0) {
            					if (m_tiles[x][y-1].isEnabled()) { 
            						reveal(m_tiles[x][y-1]); 
            					} 
            				}
            				if ((x-1 >= 0) && (y-1 >= 0)) {
            					if (m_tiles[x-1][y-1].isEnabled()) { 
            						reveal(m_tiles[x-1][y-1]); 
            					} 
            				}
            				if (x-1 >= 0) {
            					if (m_tiles[x-1][y].isEnabled()) { 
            						reveal(m_tiles[x-1][y]); 
            					} 
            				}
            				if ((x-1>=0 && (y+1<m_size))) {
            					if (m_tiles[x-1][y+1].isEnabled()) { 
            						reveal(m_tiles[x-1][y+1]); 
            					}
            				}
            				if (y+1 < m_size) {
            					if (m_tiles[x][y+1].isEnabled()) { 
            						reveal(m_tiles[x][y+1]); 
            					} 
            				}
            			}
            		}
            	} );
            	timer.setRepeats( false );
            	timer.start();
        	}
    	}
    }
    
	/**
	 * A method that checks how many surrounding mines a tile given as an argument has and sets its icon accordingly.
	 * @param tile the tile to check for surrounding mines
	 * @see Tile.java
	 * @see Mine.java
	 * @return
	 */
    private int checkTile(Tile tile){
    	int x = tile.getPosX();
    	int y = tile.getPosY();
    	
        int mineCount = 0;
        
        if (x+1 < m_size) {
        	//Tile to the right
			if (m_tiles[x+1][y].hasMine()) {mineCount++; }
        }
        
        if (x-1 >= 0) {
        	//Tile to the left
			if (m_tiles[x-1][y].hasMine()) {mineCount++; }
        }
        
        if ((y+1 < m_size)) {
        	//Tile below
			if (m_tiles[x][y+1].hasMine()) {mineCount++; }	
        }
        
        if (y-1 >= 0) {
        	//Tile above
			if (m_tiles[x][y-1].hasMine()) {mineCount++; }
        }
        
        if ((x-1 >= 0) && (y-1 >= 0)) {
        	//Tile to top left
			if (m_tiles[x-1][y-1].hasMine()) {mineCount++; }
        }
        
        if ((x+1 < m_size) && (y-1 >= 0)) {
        	//Tile to top right
			if (m_tiles[x+1][y-1].hasMine()) {mineCount++; }
        }
        
        if ((x-1 >= 0) && (y+1 < m_size)) {
        	//Tile to bottom left
			if (m_tiles[x-1][y+1].hasMine()) {mineCount++; }
        }
        
        if ((x+1 < m_size) && (y+1 < m_size)) {
        	//Tile to bottom right
			if (m_tiles[x+1][y+1].hasMine()) {mineCount++; }
        }

        if(mineCount != 0 || (tile.hasMine())){		
						try {
							tile.showGraphic(mineCount);
						} catch (IOException e) {
						}
        } else {
        	tile.setEnabled(false);
        }
        
        return mineCount;
    }
    
    /**
    * A constructor taking two arguments and returning a new instance of Board.
    * @param sideLength the length of a side of the board.
    * @param numberOfMines an integer representing the number of mines.
    * @see Tile.java
    * @return New board object
    */
    public Board(int sideLength, int numberOfMines) {

    	m_size = sideLength;
       	m_numberOfMines = numberOfMines;
    
        
        m_tiles = new Tile[m_size][m_size];

        GridBagLayout boardLayout = new GridBagLayout();
        GridBagConstraints c = new GridBagConstraints();
        
        setLayout(boardLayout);
        
        //Create array of tiles
        for (int y = 0; y < m_size; y++) {
        	for (int x = 0; x < m_size; x++) {
        		Tile tile = new Tile(x, y);
        		c.gridx = x;
        		c.gridy = y;
        		add(tile, c);
        		m_tiles[x][y] = tile;
        	}
        }
        
        allocateMines();
    }
    
    /**
     * A method that allocates mines in random locations on the board.
     * @see Tile.java
     * @see Mine.java
     */
	public void allocateMines () {
		Random randomMines = new Random();
		
		ArrayList<int[]> freeLocations = new ArrayList<int[]>();
		
		for (int i=0; i<m_size; i++) {
			for (int j=0; j<m_size; j++) {
				int[] location = {j,i};
				freeLocations.add(location);
			}
		}
		
		for (int mineCount=0; mineCount < m_numberOfMines; mineCount++) {
			int randNo = randomMines.nextInt(freeLocations.size());
			
			int[] pos = freeLocations.get(randNo);
			m_tiles[pos[0]] [pos[1]] = new Mine(pos[0], pos[1]);
			freeLocations.remove(randNo);
		}
	}
	
	public final static int SPACING = 3;
	public final static int DEFAULT_SIZE = 10;
	public final static int DEFAULT_BOARD_HEIGHT = 250;
	public final static int DEFAULT_BOARD_WIDTH = 300;
	public final static int HEIGHT_SPACING = 15;
	public final static int WIDTH_SPACING = 3;
	private int m_size;
	private int m_numberOfMines;
	private boolean m_gameOver;
	private Tile[][] m_tiles;
	private int m_numberDiffused;
}
	
