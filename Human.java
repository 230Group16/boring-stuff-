package kablewie;

/**
* @file Human.java
* @author Aled...
* @date 04 Dec 2015
* @see Game.java, Board.java, and Scoreboard.java for related information.
*
* Handles player actions.
*/
public class Human{
    
	/**
	* An accessor method taking in no arguments and returning the value of m_name
	* @return Value of n_name
	*/
    public String getName (){
        return m_name;
    }
    
    
    /**
	* An assigning method taking in one argument and setting it as m_name.
	* @param n a string
	*/
    public void setName (String n) {
        m_name = n;
    }
    
    /**
	* A method that keeps track of the player and his progress
	*/
    public void takeTurn() {
        m_scoreboard.update();
        
        if(m_board.isGameOver()){
            m_game.endGame('l');
        } else {
        	//m_game.endGame(false);
        }
        
    }
    /**
     * A constructor taking two arguments and returning a new instance of Human.
     * @param name is the name of the player.
     * @param g an instance of the object Game.class.
     * @return New human(player) object
     */
    public Human (String name, Game g){
        m_name = name ;
        m_game = g;
        m_board = g.getBoard();
        m_scoreboard = g.getScoreboard();
        //m_scoreboard.s(m_name); ???
        
        takeTurn();
        
        /*class GameListener implements ActionListener{
            public void actionPerformed(ActionEvent e){	
                takeTurn();
            }
        }
        
        GameListener gl = new GameListener();
        m_game.addActionListener(gl); */
    }
    
    
    private String m_name;
    private Board m_board;
    private Scoreboard m_scoreboard;
    private Game m_game;
}