package kablewie;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SpringLayout;

public class Scoreboard extends JPanel {
    
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	static int m_time;
    int m_minesDiffused;
    int m_numberOfTilesRevealed;
    
    public void setPlayerName(String name) {
    	m_playerName = name;
    }
    
    public int getGameTime() {
        return m_time;
    }
    
    public int getMinesDiffused() {
        return m_minesDiffused;
    }
    
    public int getNumberOfRevealed() {
        return m_numberOfTilesRevealed;
    }
    
    public Scoreboard() {
        /*Sets grid layout for scoreboard */
        this.setLayout(new GridLayout(3,1));
 
        this.addComponent(lblName);
        this.addComponent(lblTime);
    }
    
    private void addComponent(Component x){
        this.add(x);
    }
    
    public String getPlayerName(){
        return m_playerName;
    }
    
    public static int getGTime(){
		return m_time;
	}
	
    public void update() {
	      lblTime.setText("Game time: " + getGTime());
	}
    
    public static void updatetime(){
		//Creates a timer and sets a task to iterate m_time at every second
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
	
    /* Initialisation of variables */
    private String m_playerName = "";
    /* Creates a label for the player's name */
    JLabel lblName = new JLabel("Player's Name: " + m_playerName);
    /* Creates a label for the player's name */
	JLabel lblTime = new JLabel("Game time: " + getGTime());
    final static long MS_IN_SECOND = 1000L;
}
