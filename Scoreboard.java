package kablewie;

import java.awt.Component;
import java.awt.GridLayout;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class Scoreboard extends JPanel {
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
        setLayout(new GridLayout(3,1));
 
        m_playerName = "";
        lblName = new JLabel("Player's Name: " + m_playerName);
    	lblTime = new JLabel("Game time: " + getGTime());
    	lblGameState = new JLabel("Good luck!");
    	
        addComponent(lblName);
        addComponent(lblTime);
        addComponent(lblGameState);
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
	
    public void setGameStateMessage(String message) {
		lblGameState.setText(message);
		
	}
    
    public void update() {
	      lblTime.setText(("Game time - " + (getGTime()/(SECS_MINS * SECS_MINS)) + ":" + (getGTime()/SECS_MINS) + ":" + (getGTime() % SECS_MINS)));
    }
    
    public static void updatetime(){
    	//Creates a timer and sets a task to iterate m_time at every second
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask()
        {
             public void run()
             {
            	 Scoreboard.m_time += 1;
             	 //System.out.println(Scoreboard.m_time);
             }
        }, MS_IN_SECOND, MS_IN_SECOND);
	}
	
    /* Initialisation of variables */	
	private String m_playerName;
	JLabel lblName;
	JLabel lblTime;
	JLabel lblGameState;
    final static long MS_IN_SECOND = 1000L;
    public final int SECS_MINS = 60;

	
}
