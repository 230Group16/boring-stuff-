package kablewie;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

/**
* @file Board.java
* @author Thomas Fisher ************************** Whoever works on this class add your name here **************************
* @date 28 Nov 2015
* @see Game.java, Tile.java, Mine.java and Scoreboard.java for related information.
*
* The board that a Kablewie game will be played on.
*/
public class Board extends JPanel {
    
    /**
    * An accessor method taking in no arguments and returning the value of m_gameOver
    * @return Value of m_gameOver
    */
    public boolean isGameOver() {
        return m_gameOver;
    }
    
    /**
    * An accessor method taking in no arguments and returning the value of m_size
    * @return Value of m_size
    */
    public int getBoardSize() {
        return m_size;
    }
    
    /**
    * An accessor method taking in no arguments and returning the value of m_numberOfMines
    * @return Value of m_numberOfMines
    */
    public int getNumberOfMines() {
        return m_numberOfMines;
    }
    
    /**
    * An accessor method taking in no arguments and returning the value of m_mineLocations
    * @return Value of m_mineLocations
    */
    public int[] getMineLocations() {
        return m_mineLocations;
    }
    
    /**
    * An accessor method taking in no arguments and returning the value of BAR_WIDTH
    * @return Value of BAR_WIDTH
    */
    public int getWidth(){
        return BAR_WIDTH;
    }
    
    /**
    * An accessor method taking in no arguments and returning the value of BAR_HEIGHT
    * @return Value of BAR_HEIGHT
    */
    public int getHeight(){
        return BAR_HEIGHT;
    }
    
    /**
    * A method that updates all necessary data when called.
    */
    public void updateGameState() {
        
    }
    
    /**
    * A constructor taking no arguments and returning a new instance of Board with default values.
    * @return New board object
    */
    public Board() {
        m_size = 10;
        m_numberOfMines = 10;
        
    }
    
    /**
    * A constructor taking one argument and returning a new instance of Board with default number of mines.
    * @param sideLength the length of a side of the board.
    * @return New board object
    */
    public Board(int sideLength) {
        m_size = sideLength;
        m_numberOfMines = sideLength;
    }
    
    /**
    * A constructor taking two arguments and returning a new instance of Board.
    * @param sideLength the length of a side of the board.
    * @param numberOfMines an integer representing the number of mines.
    * @return New board object
    */
    public Board(int sideLength, int numberOfMines) {
        m_size = sideLength;
        m_numberOfMines = numberOfMines;
    }
    
    /**
    * A method taking in one argument that displays the board on the screen
    * @param graphics the object to be displayed on the screen.
    * @see Game.java
    */
    public void paintComponent( Graphics graphics ) {
        
        /* call superclass's paintComponent */
        super.paintComponent( graphics );
        
        /* set new drawing color using integers */
        graphics.setColor(new Color(COLOR_COMPONENT,
        COLOR_COMPONENT,
        COLOR_COMPONENT ) );
        graphics.fillRect( FIRST_X_COORD,
        FIRST_Y_COORD,
        BAR_WIDTH,
        BAR_HEIGHT);
        
        /* set new drawing color using predefined variable */
        graphics.setColor(Color.BLUE);
        graphics.drawString( "Board goes here.", TEXT_X_COORD, TEXT_Y_COORD );
    }
    
    int m_size;
    int m_numberOfMines;
    int[] m_mineLocations;
    boolean m_gameOver;
    Tile[] m_tiles;
    private static final int COLOR_COMPONENT = 0;
    private static final int FIRST_X_COORD = 0;
    private static final int FIRST_Y_COORD = 0;
    private static final int BAR_HEIGHT = Game.getMBarHeight() - 100;
    private static final int BAR_WIDTH = Game.getMBarWidth();
    private static final int TEXT_X_COORD = 30;
    private static final int TEXT_Y_COORD = 230;
    
}
