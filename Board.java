package kablewie;

import javax.swing.*;

import java.util.Random;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

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
	 * 
	 */
	private static final long serialVersionUID = 1L;


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
    public boolean[][] getMineLocations() {
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
    	/**
    	* A method that takes a Tile object as a parameter 
	* and reveals the tiles around the clicked tile, 
	* or just the tile itself if it is not a mine.
	* @param tile takes an object representing one tile.
    	*/
	public void reveal(Tile tile) {
		int x = tile.getPosX();
    	int y = tile.getPosY();
    	
    	if (m_tiles[x][y].hasMine()) {
    		System.out.println("mine");
    		//Mine mine = (Mine) m_tiles[tile.getPosX()][tile.getPosY()];
			try {
				tile.showGraphic(0);
			} catch (IOException e) {
			}
    	} else {
    		checkTile(tile);
        	if (tile.getIcon() == new JButton().getIcon()) {
            	
           	if (tile.hasMine()) {
            	m_gameOver = true;
           		updateGameState();
           	}
            	
            	
            	int delay = 50;
            	Timer timer = new Timer( delay, new ActionListener(){
            		@Override
            		public void actionPerformed( ActionEvent e ){  
            			//If tile has no surrounding mines, reveal all surrounding tiles
            			if (!m_tiles[x][y].hasMine() || checkTile(m_tiles[x][y]) == 0) {
            				if ((x+1 < m_size) && (y+1 < m_size)) {
            					if (m_tiles[x+1][y+1].isEnabled()) { reveal(m_tiles[x+1][y+1]); } //Bottom right
            					if (m_tiles[x+1][y].isEnabled()) { reveal(m_tiles[x+1][y]); } //Right
            					if (m_tiles[x][y+1].isEnabled()) { reveal(m_tiles[x][y+1]); } //Bottom
            				}
            				
            				if ((x-1 >= 0) && (y-1 >= 0)) {
            					if (m_tiles[x-1][y-1].isEnabled()) { reveal(m_tiles[x-1][y-1]); } //Top left
            					if (m_tiles[x][y-1].isEnabled()) { reveal(m_tiles[x][y-1]); } //Top
            					if (m_tiles[x-1][y].isEnabled()) { reveal(m_tiles[x-1][y]); } //Left
            				}
            				
            				if ((x+1 < m_size) && (y-1 >= 0)) {
            					if (m_tiles[x+1][y-1].isEnabled()) { reveal(m_tiles[x+1][y-1]); }//Top right
            					 
            				}
            				
            				if ((x-1 >= 0) && (y+1 < m_size)) {
            					if (m_tiles[x-1][y+1].isEnabled()) { reveal(m_tiles[x-1][y+1]); }//Bottom left
               				}
            				
            				
            			}
            		}
            	} );
            	
            	timer.setRepeats( false );
            	timer.start();
        	}
        	
        	if (m_tiles[x][y].hasMine()) {
        		try {
    				m_tiles[x][y].showGraphic(0);
    			} catch (IOException e) {
    				// TODO Auto-generated catch block
    				e.printStackTrace();
    			}
        	}
    	}
    	
    	
    }
    
     /**
     * A method that take a Tile object as a parameter and 
     * checks whether the clicked tile is a mine or not.
     * @return returns mineCount an integer argument.
     * @param tile takes an object representing one tile.
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
    * @return New board object
    */
    public Board(int sideLength, int numberOfMines) {
        if (sideLength == -1) {
        	m_size = 10;
        } else {
            m_size = sideLength;        	
        }
        
        if (numberOfMines != 0) {
        	m_numberOfMines = numberOfMines;
        } else {
		m_numberOfMines = m_size;
	}
        
        m_tiles = new Tile[sideLength][sideLength];

        GridLayout boardLayout = new GridLayout(0,m_size);
        this.setLayout(boardLayout);
        this.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.setPreferredSize(new Dimension(BAR_WIDTH, BAR_HEIGHT));
        
        for (int y = 0; y < m_size; y++) {
        	for (int x = 0; x < m_size; x++) {
        		Tile tile = new Tile(x, y);
        		this.add(tile); //Create new tile with location (i,j)
        		m_tiles[x][y] = tile;
        	}
        }
        
        //m_tiles[0][0] = new Mine(0,0);
        allocateMines();
    }
    
    int m_size;
    int m_numberOfMines;
    boolean[][] m_mineLocations;
    boolean m_gameOver;
    Tile[][] m_tiles;
    //private static final int TILE_SIZE = 30;
    private static final int BAR_HEIGHT = Game.getMBarHeight() - 100;
    private static final int BAR_WIDTH = Game.getMBarWidth();
    
	/**
        * A method that randomly assigns mines to different tiles. 
        */
	public void allocateMines () {
		Random randomMines = new Random();
		m_mineLocations = new boolean[m_size][m_size];
		
		for(int i = 0; i < m_size; i++){
			for(int j = 0; j < m_size; j++) { m_mineLocations[i][j] = false; }
		}
		
		int mineCount = 0;
		
		while(mineCount < m_numberOfMines) {
			int x = randomMines.nextInt(m_size - 1);
			int y = randomMines.nextInt(m_size - 1);
			
			if(!m_mineLocations[x][y]){
				m_tiles[x][y] = new Mine(x,y);
				m_mineLocations[x][y] = true;
				mineCount++;
			}
		}
	}
}
