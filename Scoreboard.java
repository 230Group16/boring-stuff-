package kablewie;

import java.awt.Component;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SpringLayout;

public class Scoreboard extends JPanel {

    /* Initialisation of variables */
    private int m_time;
    
    private Game m_game;
    private Board m_board;
    private int m_minesDiffused;
    private int m_numberOfTilesRevealed;
	private String m_playerName = "";
    private JLabel lblName;
    private JLabel lblTime;
    private JLabel minesDlbl;
    private JLabel tilesRlbl;
    private JLabel lblGameState;
    private JLabel lblNRlbl;
    private JLabel tilesNRlbl;
    private JLabel lblMines;
    private static final long MS_IN_SECOND = 1000L;
    public final int SECS_MINS = 60;
    private int m_numberOfTilesNotRevealed;
    
    public int getNumberOfRevealed() {
        return m_numberOfTilesRevealed;
    }
    
    public int getNumberOfNotRevealed() {
    	m_numberOfTilesNotRevealed = m_board.getBoardSize() * m_board.getBoardSize() - m_numberOfTilesRevealed;
    	return m_numberOfTilesNotRevealed;
    }
    	
    public Scoreboard(Game g) {
        /*Sets grid layout for scoreboard */
    	SpringLayout layout = new SpringLayout();
        setLayout(layout);
        
        m_game = g;
        m_board = g.getBoard();
        lblName = new JLabel();
        lblTime = new JLabel("Game time - " + getTime());
        minesDlbl = new JLabel("Mines diffused - 0");
        tilesRlbl = new JLabel("Tiles Revealed - " + getNumberOfRevealed());
        lblGameState = new JLabel("Good luck!");
        tilesNRlbl = new JLabel("Tiles not revealed - " + getNumberOfNotRevealed());
        lblGameState = new JLabel();
        lblMines = new JLabel("Number of mines - " + m_board.getNumberOfMines());
        
        addComponent(lblName);
        addComponent(lblTime);
	    addComponent(minesDlbl);
        addComponent(lblGameState);
        addComponent(tilesRlbl);
        addComponent(tilesNRlbl);
        addComponent(lblMines);
        
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
  	   
  	   layout.putConstraint(SpringLayout.NORTH, lblMines,
  			   5,
  			   SpringLayout.SOUTH, tilesRlbl);
  	   
  	   layout.putConstraint(SpringLayout.WEST, lblMines, 
  			   10, 
  			   SpringLayout.WEST, this);
	      
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
    	lblGameState.setText(message);
        
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
    	minesDlbl.setText("Mines diffused - " + m_board.getMinesDiffused());
        
    }
    
    public void setPlayerName(String name) {
        lblName.setText("Name - " + name);
    }
    
    public void reset() {
    	m_board.setGameOver(false);
    	m_time = 0;
    	updateTime();
    	m_numberOfTilesRevealed = 0;
    	m_numberOfTilesNotRevealed =0;
    }
    
    public void update() {
    	setTime();
    	setTilesRevealed();
    	setMinesDiffused();
    	setTilesNotRevealed();
    	
    	int numberOfTiles = m_board.getBoardSize() * m_board.getBoardSize();
    	
    	if (m_numberOfTilesRevealed == numberOfTiles - m_board.getNumberOfMines()) {
    		m_board.setGameOver(true);
    		m_game.endGame('w');
    	}
    }
    
    public void incrementTilesRevealed() {
    	m_numberOfTilesRevealed++;
    	update();
    }
    
    public void updateTime(){
        //Creates a timer and sets a task to iterate m_time at every second
        m_timer = new Timer();
        m_timer.scheduleAtFixedRate(new TimerTask()
        {
             public void run()
             {
                 m_time += 1;
                 lblTime.setText("Game time - " + getTime());
             }
        }, MS_IN_SECOND, MS_IN_SECOND);
    }
    
    public void stopTimer() {
    	m_timer.cancel();
    }
    
    private Timer m_timer;
}
