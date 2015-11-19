package kablewie;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class Scoreboard extends JPanel {
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
	                         BAR_LENGTH );
	      
	      /* set new drawing color using predefined variable */
	      graphics.setColor(Color.BLACK);
	      graphics.drawString( "Crap", TEXT_X_COORD, TEXT_Y_COORD );
	   } // end method paintComponent
	
	private static final int COLOR_COMPONENT = 255;
	private static final int FIRST_X_COORD = 0;
	private static final int FIRST_Y_COORD = 0;
	private static final int BAR_LENGTH = 200;
	private static final int BAR_WIDTH = 700;
	private static final int TEXT_X_COORD = 30;
	private static final int TEXT_Y_COORD = 30;
}
