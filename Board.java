package kablewie;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class Board extends JPanel {
	int m_size;
	int m_numberOfMines;
	int[] m_mineLocations;
	boolean m_gameOver;
	Tile[] m_tiles;
	
	public Board() {
		//Will handle the creation of a board using default values
	}
	
	public Board(int sideLength, Mine[] mines) {
		//Will handle the creation of a board with values input by the user
	}
	
	public boolean isGameOver() {
		return m_gameOver;
	}
	
	public int getBoardSize() {
		return m_size;
	}
	
	public int getNumberOfMines() {
		return m_numberOfMines;
	}
	
	public int[] getMineLocations() {
		return m_mineLocations;
	}
	
	public void updateGameState() {
		
	}
	
	public void paintComponent( Graphics graphics ) {

	      /* call superclass's paintComponent */
	      super.paintComponent( graphics );

	      /* set new drawing color using integers */
	      graphics.setColor(new Color(COLOR_COMPONENT, 
	                                  COLOR_COMPONENT,
	                                  COLOR_COMPONENT ) );
	      graphics.fillRect( FIRST_X_COORD,
	                         FIRST_Y_COORD,
	                         BAR_WIDTH,
	                         BAR_HEIGHT);
	      
	      /* set new drawing color using predefined variable */
	      graphics.setColor(Color.BLUE);
	      graphics.drawString( "Board goes here.", TEXT_X_COORD, TEXT_Y_COORD );
	   } // end method paintComponent
	
	public int getWidth(){
		return BAR_WIDTH;
	}
	
	public int getHeight(){
		return BAR_HEIGHT;
	}
	
	private static final int COLOR_COMPONENT = 0;
	private static final int FIRST_X_COORD = 0;
	private static final int FIRST_Y_COORD = 0;
	private static final int BAR_HEIGHT = Game.getMBarHeight() - 100;
	private static final int BAR_WIDTH = Game.getMBarWidth();
	private static final int TEXT_X_COORD = 30;
	private static final int TEXT_Y_COORD = 230;

}
