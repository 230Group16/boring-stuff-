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
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Game extends JPanel {
    
	public Board getBoard() {
		return m_board;
	}
	
	public Scoreboard getScoreboard() {
		return m_scoreboard;
	}
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
    
    static Timer timer = new Timer();
    static int seconds = 0;
    public static boolean running = true;
    
    private static void updatetime(){
		/* Creates a timer and sets a task to iterate m_time at every second */
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask()
        {
             public void run()
             {
            	 Scoreboard.m_time += 1;
             	 System.out.println(Scoreboard.m_time);
             }
        }, MS_IN_SECOND, MS_IN_SECOND);
	}
    
    public static void main( String args[] ) {
        
        /* create frame for Board and Scoreboard */
        JFrame frame = new JFrame( "Kablewie!!!");
        frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        
        /* create container */
        Container pane = frame.getContentPane();
        
        updatetime();
        
        /* set container layout to boxlayout */
        pane.setLayout(new BoxLayout(pane, BoxLayout.Y_AXIS));
        
        /* creates Board and Scoreboard panels and sets their verticle alignmenrt and preferred sizes */
        Scoreboard scoreboardPanel = new Scoreboard();
        scoreboardPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        scoreboardPanel.setPreferredSize(new Dimension(scoreboardPanel.getWidth(), scoreboardPanel.getHeight()));
        m_scoreboard = scoreboardPanel;
        
        Board boardPanel = new Board(10,10);
        m_board = boardPanel;
        
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
        
        while(running){
        	scoreboardPanel.update();
        }
        
    }
    
    private static final int BAR_WIDTH = 700;
    private static final int BAR_HEIGHT = 700;
    final static long MS_IN_SECOND = 1000L;
    static Board m_board;
    static Scoreboard m_scoreboard;
}
