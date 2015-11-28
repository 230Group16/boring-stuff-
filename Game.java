/**
 * @file    -Game.java
 * @author  -Rabidra Thapa
 * @date    -28/11/2015
 * @see     -Board.java
 * @see		-Scoreboard.java
 *
 * A simple frame that can contain panels
 * 
 */

package kablewie;

import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import javax.swing.BoxLayout;
import javax.swing.JFrame;

public class Game {
	
	/* *
     * Get method for frame Height 
     * @return Frame's height
     */
	public static int getMBarHeight() {
		return BAR_HEIGHT;
	}
	
	/* *
     * Get method for frame Width 
     * @return Frame's width
     */
	public static int getMBarWidth() {
		return BAR_WIDTH;
	}
	
	
    public static void main( String args[] ) {
    
    	/* create frame for Board and Scoreboard */
    	JFrame frame = new JFrame( "Klablewie!!!");
    	frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    	
    	/* create container */
    	Container pane = frame.getContentPane();
    	
    	/* set container layout to boxlayout */
    	pane.setLayout(new BoxLayout(pane, BoxLayout.Y_AXIS));
    	
    	/* creates Board and Scoreboard panels and sets their verticle alignmenrt and preferred sizes */
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
    	
    	/* Sets frame size */
    	frame.setSize(BAR_WIDTH, BAR_HEIGHT);
    	
    	/* display frame */
        frame.setVisible(true);
        
        /* set frame resizable to false */
        frame.setResizable(false);
	}
	
	private static final int BAR_WIDTH = 700;
	private static final int BAR_HEIGHT = 700;
    
}
