package kablewie;
import java.awt.Component;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SpringLayout;

/**
 * @file    -Scoreboard.java
 * @author  -Rabidra Thapa
 * @date    -07/12/2015
 * @see     -Board.java
 * @see	    -Game.java
 *
 * A Scoreboard panel that displays many details of the current game
 */
public class Scoreboard extends JPanel {
    /* Initialisation of variables */
    private int m_time;
    private Game m_game;
    private Board m_board;
    private int m_numberOfTilesRevealed;
    private int m_spaceFromBorder = 10;
    private int m_spaceFromLbl = 5;
    private JLabel m_lblName;
    private JLabel m_lblTime;
    private JLabel m_lblDiffused;
    private JLabel m_lblRevealed;
    private JLabel m_lblGameState;
    private JLabel m_lblHidden;
    private JLabel m_lblMines;
    private Timer m_timer;
    private static final long MS_IN_SECOND = 1000L;
    public final int SECS_MINS = 60;
    private int m_numberOfTilesNotRevealed;
    
    /**
     * Constructor for the Scoreboard class.
     * @param g The game object that the spring board is in.
     * @see Game.java
     */
    public Scoreboard(Game g) {
    	SpringLayout layout = new SpringLayout();
        setLayout(layout);
        
        m_game = g;
        m_board = g.getBoard();
        m_lblName = new JLabel();
        m_lblTime = new JLabel("Time - " + getTime());
        m_lblDiffused = new JLabel("Number Diffused - 0");
        m_lblRevealed = new JLabel("Tiles Revealed - " + getNumberOfRevealed());
        m_lblGameState = new JLabel("Good luck!");
        m_lblHidden = new JLabel("Hidden Tiles - " + getNumberOfNotRevealed());
        m_lblGameState = new JLabel();
        m_lblMines = new JLabel("Number of Mines - " 
        						+ m_board.getNumberOfMines());
        
        addComponent(m_lblName);
        addComponent(m_lblTime);
	    addComponent(m_lblDiffused);
        addComponent(m_lblGameState);
        addComponent(m_lblRevealed);
        addComponent(m_lblHidden);
        addComponent(m_lblMines);
        
        /* Layout */
        layout.putConstraint(SpringLayout.WEST, m_lblName,
        	  m_spaceFromBorder,
  	          SpringLayout.WEST, this);
  	   layout.putConstraint(SpringLayout.NORTH, m_lblName,
  	          0,
  	          SpringLayout.NORTH, this);
  		  
  	   layout.putConstraint(SpringLayout.EAST, m_lblTime,
  			  -10,
  			  SpringLayout.EAST, this);
  	   layout.putConstraint(SpringLayout.NORTH, m_lblTime,
  			  0,
  			  SpringLayout.NORTH, this);
  		  
  	   layout.putConstraint(SpringLayout.WEST, m_lblRevealed,
  			  m_spaceFromBorder,
  			  SpringLayout.WEST, this);
  	   layout.putConstraint(SpringLayout.NORTH, m_lblRevealed,
  			  m_spaceFromLbl,
  			  SpringLayout.SOUTH, m_lblName);
  	      
  	   layout.putConstraint(SpringLayout.EAST, m_lblDiffused,
  			  -10,
  			  SpringLayout.EAST, this);
  	   layout.putConstraint(SpringLayout.NORTH, m_lblDiffused,
  			  m_spaceFromLbl,
  			  SpringLayout.SOUTH, m_lblTime);
  	
  	   layout.putConstraint(SpringLayout.EAST, m_lblHidden,
  			  -10,
  			  SpringLayout.EAST, this);
  	   layout.putConstraint(SpringLayout.NORTH, m_lblHidden,
  			  5,
  	    	  SpringLayout.SOUTH, m_lblDiffused);
  	   
  	   layout.putConstraint(SpringLayout.NORTH, m_lblMines,
  			  5,
  			  SpringLayout.SOUTH, m_lblRevealed);
  	   
  	   layout.putConstraint(SpringLayout.WEST, m_lblMines, 
  			  m_spaceFromBorder, 
  			  SpringLayout.WEST, this);
  	   
   	   layout.putConstraint(SpringLayout.WEST, m_lblGameState,
  		   	  m_spaceFromBorder,
  	  		  SpringLayout.WEST, this);
  	  	   
   	   layout.putConstraint(SpringLayout.NORTH, m_lblGameState,
  	  		  5,
  	  		  SpringLayout.SOUTH, m_lblHidden);
    }
    
    /**
     * A method that sets the m_lblGameState label to
     * the string given in the parameter
     * @param message A string passed through the parameter.
     */
    public void setGameState(String message) {
    	m_lblGameState.setText(message);
    } 
    
    /**
     * A method that sets the m_lblTime label to "Time - " 
     * concatenated with the value the gameTime() method returns.
     * @see getTime()
     */
    public void setTime() {
    	m_lblTime.setText("Time - " + getTime());
    }
    
    /**
     * A method that sets the m_lblRevealed label to "Tiles Revealed - " 
     * concatenated with the value the getNumberOfRevealed() method returns.
     * @see getNumberOfRevealed()
     */
    public void setTilesRevealed() {
    	m_lblRevealed.setText("Tiles Revealed - " + getNumberOfRevealed());
    }
    
    /**
     * A method that sets the m_lblHidden label to "Hidden Tiles - " 
     * concatenated with the value the getNumberOfNotRevealed() method returns.
     * @see getNumberOfNotRevealed()
     */
    public void setTilesNotRevealed() {
    	m_lblHidden.setText("Hidden Tiles - " + getNumberOfNotRevealed());
    }
    
    /**
     * A method that sets the m_lblDiffused label to "Number Diffused - "
     * concatenated with the value the m_board.getMinesDiffused() method
     * returns.
     * @see m_board.getMinesDiffused()
     */
    public void setMinesDiffused() {
    	m_lblDiffused.setText("Number Diffused - " 
    						+ m_board.getMinesDiffused());
    }
    
    /**
     * A method that sets the m_lblName label to "Name - "
     * concatenated with the string given in the parameter
     * @param name A string passed through the parameter.
     */
    public void setPlayerName(String name) {
        m_lblName.setText("Name - " + name);
    }
    
    /**
     * A method that gets the game time in HH:MM:SS format.
     * @return game time in HH:MM:SS format.
     */
    public String getTime(){
    	return m_time /(SECS_MINS * SECS_MINS) + ":" + 
    	(m_time/SECS_MINS) + ":" + (m_time % SECS_MINS);
    }
    
    /**
     * A method that gets the number of tiles that are revealed.
     * @return number of tiles that are revealed.
     */
    public int getNumberOfRevealed() {
        return m_numberOfTilesRevealed;
    }
    
    /**
     * A method that gets the number of tiles that are not revealed.
     * @return number of tiles that are revealed.
     */
    public int getNumberOfNotRevealed() {
    	int boardArea = m_board.getBoardSize() * m_board.getBoardSize();
    	m_numberOfTilesNotRevealed = boardArea - m_numberOfTilesRevealed;
    	return m_numberOfTilesNotRevealed;
    }
    
    /**
     * A method that adds the given parameter component
     * to the panel where the method is called
     * @param x the component that is added.
     */
    private void addComponent(Component x){
        this.add(x);
    }
    
    /**
     * A method that resets some of the values on the scoreboard
     * and calls setGameOver() on the board and calls updateTime()
     * @see setGameOver()
     * @see updateTime()
     */
    public void reset() {
    	m_board.setGameOver(false);
    	m_time = 0;
    	updateTime();
    	m_numberOfTilesRevealed = 0;
    	m_numberOfTilesNotRevealed =0;
    }
    
    /**
     * Updates the values that the labels display
     * and checks if the player has won
     * @see setTime()
     * @see setTilesRevealed()
     * @see setMinesDiffused()
     * @see setTilesNotRevealed()
     */
    public void update() {
    	setTime();
    	setTilesRevealed();
    	setMinesDiffused();
    	setTilesNotRevealed();
    	
    	int numberOfTiles = m_board.getBoardSize() * m_board.getBoardSize();
    	int numberOfNonMineTiles = numberOfTiles - m_board.getNumberOfMines();
    	
    	if (m_numberOfTilesRevealed == numberOfNonMineTiles) {
    		m_board.setGameOver(true);
    		m_game.endGame('w');
    	}
    }
    
    /**
     * Increments the value that tracks number of revealed
     * tiles and updates the labels
     * @see update()
     */
    public void incrementTilesRevealed() {
    	m_numberOfTilesRevealed++;
    	update();
    }
    
    /**
     * Creates a timer and sets a task to execute at a fixed period of time
     */
    public void updateTime(){
        //Creates a timer and sets a task to iterate m_time at every second
        m_timer = new Timer();
        m_timer.scheduleAtFixedRate(new TimerTask()
        {
             public void run()
             {
                 m_time += 1;
                 m_lblTime.setText("Time - " + getTime());
             }
        }, MS_IN_SECOND, MS_IN_SECOND);
    }
    
    /**
     * Stops timer
     */
    public void stopTimer() {
    	m_timer.cancel();
    }
    
}
