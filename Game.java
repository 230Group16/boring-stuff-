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
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Game extends JPanel {
    
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
        JFrame frame = new JFrame( "Kablewie!!!");
        frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        
        /* create container */
        Container pane = frame.getContentPane();
        
        /* set container layout to boxlayout */
        pane.setLayout(new BoxLayout(pane, BoxLayout.Y_AXIS));
        
        /* creates Board and Scoreboard panels and sets their verticle alignmenrt and preferred sizes */
        Scoreboard scoreboardPanel = new Scoreboard();
        scoreboardPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        scoreboardPanel.setPreferredSize(new Dimension(scoreboardPanel.getWidth(), scoreboardPanel.getHeight()));
        
        
        Board boardPanel = new Board(10,10);
        
        /* set frame size */
        //frame.setSize( FRAME_HEIGHT, FRAME_WIDTH );
        
        /* add boardPanel and scoreboardPanel to frame */
        pane.add(scoreboardPanel, BorderLayout.NORTH);
        pane.add(boardPanel, BorderLayout.CENTER);
        
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
