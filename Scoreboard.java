package kablewie;

import java.awt.Component;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SpringLayout;

public class Scoreboard extends JPanel {
    
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    /* Initialisation of variables */
    static int m_time;
    private Board m_board;
    private int m_minesDiffused;
    private static int m_numberOfTilesRevealed;
    private static int m_numberOfTilesNotRevealed;
	private String m_playerName = "";
	private String gameState = "Good luck!";
    private JLabel lblName;
    private JLabel lblTime;
    private JLabel minesDlbl;
    private JLabel tilesRlbl;
    private JLabel lblGameState;
    final static long MS_IN_SECOND = 1000L;
    public final int SECS_MINS = 60;
    
    public int getMinesDiffused() {
        return m_minesDiffused;
    }
    
    public int getNumberOfRevealed() {
        return m_numberOfTilesRevealed;
    }
    
    public int getNumberOfNotRevealed() {
        return m_numberOfTilesNotRevealed;
    }
    
    public String getGameState() {
        return gameState;
    }
    
    public Scoreboard(Game g) {
        /*Sets grid layout for scoreboard */
    	SpringLayout layout = new SpringLayout();
        setLayout(layout);
        
        m_board = g.getBoard();
        lblName = new JLabel();
        lblTime = new JLabel("Game time - " + getTime());
        minesDlbl = new JLabel("Mines diffused - " + getMinesDiffused());
        tilesRlbl = new JLabel("Tiles Revealed - " + getNumberOfRevealed());
        tilesNRlbl = new JLabel("Tiles not revealed - " + getNumberOfNotRevealed());
        lblGameState = new JLabel(getGameState());
        
        addComponent(lblName);
        addComponent(lblTime);
	addComponent(minesDlbl);
        addComponent(lblGameState);
        addComponent(tilesRlbl);
        addComponent(tilesNRlbl);
        
        /* Layout */
	   layout.putConstraint(SpringLayout.WEST, lblName,
	          10,
	          SpringLayout.WEST, this);
	   layout.putConstraint(SpringLayout.NORTH, lblName,
	          0,
	          SpringLayout.NORTH, this);
		  
	   layout.putConstraint(SpringLayout.EAST, lblTime,
	   	  -10,
		  SpringLayout.EAST, this);
	   layout.putConstraint(SpringLayout.NORTH, lblTime,
		  0,
		  SpringLayout.NORTH, this);
		  
	   layout.putConstraint(SpringLayout.WEST, tilesRlbl,
		  10,
		  SpringLayout.WEST, this);
	   layout.putConstraint(SpringLayout.NORTH, tilesRlbl,
		  5,
		  SpringLayout.SOUTH, lblName);
	      
	   layout.putConstraint(SpringLayout.EAST, minesDlbl,
		  -10,
		  SpringLayout.EAST, this);
	   layout.putConstraint(SpringLayout.NORTH, minesDlbl,
	   	  5,
	   	  SpringLayout.SOUTH, lblTime);
	
	   layout.putConstraint(SpringLayout.EAST, tilesNRlbl,
	    		  -10,
	    		  SpringLayout.EAST, this);
	      layout.putConstraint(SpringLayout.NORTH, tilesNRlbl,
	    		  5,
	    		  SpringLayout.SOUTH, minesDlbl);
	      
	   layout.putConstraint(SpringLayout.WEST, lblGameState,
		  10,
		  SpringLayout.WEST, this);
	   layout.putConstraint(SpringLayout.NORTH, lblGameState,
		  5,
		  SpringLayout.SOUTH, tilesRlbl);
	      
    }
    
    private void addComponent(Component x){
        this.add(x);
    }
    
    public String getPlayerName(){
        return m_playerName;
    }
    
    public String getTime(){
    	return m_time /(SECS_MINS * SECS_MINS) + ":" + (m_time/SECS_MINS) + ":" + (m_time % SECS_MINS);
    }
    

    public void setGameState(String message) {
    	gameState = message;
        
    }
    

    public void setGameStateLabel() {
    	lblGameState.setText(gameState);
        
    }
    
    
    public void setTime() {
    	lblTime.setText("Game time - " + getTime());
        
    }
    
    public void setTilesRevealed() {
    	tilesRlbl.setText("Tiles Revealed - " + getNumberOfRevealed());
        
    }
    
    public void setTilesNotRevealed() {
    	tilesNRlbl.setText("Tiles not revealed - " + getNumberOfNotRevealed());
        
    }
    
    public void setMinesDiffused() {
    	minesDlbl.setText("Mines diffused - " + getMinesDiffused());
        
    }
    
    public void setPlayerName(String name) {
        lblName.setText("Name - " + name);
    }
    
    public void update() {
    	setTime();
    	setTilesRevealed();
    	setMinesDiffused();
    	setTilesNotRevealed();
    }
    
    public static void incrementTilesRevealed() {
    	m_numberOfTilesRevealed++;
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
}
