/**
 * @file    -TextFieldFrameProper.java
 * @author  -P.J. Deitel, H.M. Deitel and R.S. Laramee
 * @date    -6 Dec '10
 * @see     -Deitel and Deitel, Fig. 11.9, page 394
 *
 *  \brief A simple Java Swing Example that demonstrates
 *  the JTextField class.
 *
 *  This example is an improvement over TextFieldFrameCrappy.
 *  There are many small but very important differences.
 *
 *
 ************ NOT COMMENTED PROPERLY (COPY PASTA) ^^^ **************
 */

package kablewie;

import java.awt.BorderLayout;

import javax.swing.JFrame;

public class Game {
	
    public static void main( String args[] ) {
    	
    	/* create frame for Board and Scoreboard */
    	JFrame frame = new JFrame( "Klablewie!!!");
    	frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    	
    	/* create Board and Scoreboard panels */
    	Board boardpanel = new Board();
    	Scoreboard scoreboardpanel = new Scoreboard();
    	
    	/* add boardpanel and scoreboardpanel to frame */
    	frame.add(scoreboardpanel);
    	
    	/* set frame size */
    	frame.setSize( FRAME_WIDTH/2, FRAME_HEIGHT );
    	
    	/* display frame */
        frame.setVisible( true );
        
    	frame.add(boardpanel);
    	
    	/* set frame size */
    	frame.setSize( FRAME_WIDTH, FRAME_HEIGHT );
    	
    	/* display frame */
        frame.setVisible( true );
        
        /* set frame resizable to false */
        frame.setResizable(false);
	}
    
    /** The width of the Game frame */
    private static final int FRAME_WIDTH = 700;
    /** The height of the Game frame */
    private static final int FRAME_HEIGHT = 700;
    
}
