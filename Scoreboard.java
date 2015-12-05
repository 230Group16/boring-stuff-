package kablewie;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
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
    
    public void paintComponent( Graphics graphics ) {
        
        /* call superclass's paintComponent */
        super.paintComponent( graphics );
        
        /* set new drawing color using integers */
        graphics.setColor(new Color(COLOR_COMPONENT,
        COLOR_COMPONENT,
        COLOR_COMPONENT ) );
        graphics.fillRect(FIRST_X_COORD,
        FIRST_Y_COORD,
        getWidth(),
        getHeight());
        
        /* set new drawing color using predefined variable */
        graphics.setColor(Color.BLACK);
        graphics.drawString( "Scoreboard goes here.", TEXT_X_COORD, TEXT_Y_COORD );
        
        /*Sets spring latout for scoreboard */
        SpringLayout layout = new SpringLayout();
        this.setLayout(layout);
        
        
        this.addComponent(namelbl);
        this.addComponent(gTimelbl);
        
        layout.putConstraint(SpringLayout.WEST, namelbl,
        5,
        SpringLayout.WEST, this);
        layout.putConstraint(SpringLayout.NORTH, namelbl,
        5,
        SpringLayout.NORTH, this);
        
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
	      gTimelbl.setText("Game time: " + getGTime());
	}
    
    /*public static void updatetime(){
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
	}*/
	
    /* Initialisation of variables */
    private String m_playerName = "";
    /* Creates a label for the player's name */
    JLabel namelbl = new JLabel("player's name: " + m_playerName);
    /* Creates a label for the player's name */
	JLabel gTimelbl = new JLabel("Game time: " + getGTime());
    private static final int COLOR_COMPONENT = 255;
    private static final int FIRST_X_COORD = 0;
    private static final int FIRST_Y_COORD = 0;
    private static final int TEXT_X_COORD = 30;
    private static final int TEXT_Y_COORD = 30;
    final static long MS_IN_SECOND = 1000L;
}
