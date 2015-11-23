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
 */

package kablewie;

import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JComponent;
import javax.swing.JFrame;

public class Game {
	
    public static void main( String args[] ) {
    	
    	/* create frame for Board and Scoreboard */
    	JFrame frame = new JFrame( "Klablewie!!!");
    	frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    	
    	Container pane = frame.getContentPane();
    	
    	pane.setLayout(new BoxLayout(pane, BoxLayout.Y_AXIS));
    	
    	
    	
    	/* create Board and Scoreboard panels */
    	Scoreboard scoreboardpanel = new Scoreboard();
    	scoreboardpanel.setAlignmentX(Component.CENTER_ALIGNMENT);
    	scoreboardpanel.setPreferredSize(new Dimension(scoreboardpanel.getWidth(), scoreboardpanel.getHeight()));
    	Board boardpanel = new Board();
    	boardpanel.setAlignmentX(Component.CENTER_ALIGNMENT);
    	boardpanel.setPreferredSize(new Dimension(boardpanel.getWidth(), boardpanel.getHeight()));
    	
    	
    	/* set frame size */
    	//frame.setSize( FRAME_HEIGHT, FRAME_WIDTH );
    	
    	/* add boardpanel and scoreboardpanel to frame */
    	pane.add(scoreboardpanel);
    	pane.add(boardpanel);
    	
    	frame.pack();
    	/* display frame */
        frame.setVisible(true);
        
        /* set frame resizable to false */
        frame.setResizable(true);
	}
    
}
