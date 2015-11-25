package kablewie;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Calendar;

import javax.swing.JPanel;

public class Scoreboard extends JPanel {
	Calendar m_gameTime;
	int m_minesDiffused;
	int m_numberOfTilesRevealed;
	
	public void update() {
		
	}
	
	public Calendar getGameTime() {
		return m_gameTime;
	}
	
	public int getMinesDiffused() {
		return m_minesDiffused;
	}
	
	public int getNumberOfRevealed() {
		return m_numberOfTilesRevealed;
	}
	
	public void paintComponent( Graphics graphics ) {

	      /* call superclass's paintComponent */
	      super.paintComponent( graphics );

	      /* set new drawing color using integers */
	      graphics.setColor(new Color(COLOR_COMPONENT, 
	                                  COLOR_COMPONENT,
	                                  COLOR_COMPONENT ) );
	      graphics.fillRect(FIRST_X_COORD,
	    		  			FIRST_Y_COORD,
	    		  			BAR_WIDTH,
	    		  			BAR_HEIGHT);
	      
	      /* set new drawing color using predefined variable */
	      graphics.setColor(Color.BLACK);
	      graphics.drawString( "Scoreboard goes here.", TEXT_X_COORD, TEXT_Y_COORD );
	   } // end method paintComponent
	
	public int getWidth(){
		return BAR_WIDTH;
	}
	
	public int getHeight(){
		return BAR_HEIGHT;
	}
	
	private static final int COLOR_COMPONENT = 255;
	private static final int FIRST_X_COORD = 0;
	private static final int FIRST_Y_COORD = 0;
	private static final int BAR_WIDTH = 700;
	private static final int BAR_HEIGHT = 200;
	private static final int TEXT_X_COORD = 30;
	private static final int TEXT_Y_COORD = 30;
}
