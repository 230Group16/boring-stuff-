package kablewie;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

/**
* @file Tile.java
* @author Nate , Ben ...
* @date 04 Dec 2015
* @see Game.java, Board.java, and for related information.
*
* Assign tile attributes to the grid from board.
*/
public class Tile extends JButton {
	private boolean m_flag;
    private Graphics2D m_graphic;
    private int m_x;
    private int m_y;
    public static final int TILE_SIZE = 20;
    
	/**
	* A constructor taking two arguments 
	* and returning a new instance of Tile.
    * @param x an integer argument.
    * @param y an integer argument.
    * @return new Tile object
    */
    public Tile(int x, int y) {
        m_flag = false;
        m_graphic = null;
        m_x = x;
        m_y = y;
        setPreferredSize(new Dimension(TILE_SIZE, TILE_SIZE));
        addHandler();
    }
    
    /**
    * A method that assigns flag icons to the tiles when clicked.
    */
    public void toggleFlag() {
        m_flag = !m_flag;
        if (m_flag) {
        	setIcon(new ImageIcon(Game.class.getResource("/images/flag.png")));
        } else {
        	setIcon(new JButton().getIcon());
        }
    }
    
    /**
    * A method  taking an integer argument 
    * that assigns mine icons to the tiles.
    * @param mineCount an integer argument.
    */
    public void showGraphic(int mineCount) throws IOException {
            if (mineCount != 0) {
            	setIcon(new ImageIcon(Game.class.getResource("/images/" + mineCount + ".png")));
            } else {
            	setIcon(new ImageIcon(Game.class.getResource("/images/mine.png")));  
            }    
    }
    
    /**
    * An accessor method taking no arguments and 
    * returning the  
    * @return m_graphic a Graphics2D argument
    */
    public Graphics2D getGraphic() {
        return m_graphic;
    }
    
    /**
    * An assigning method taking in no argument and returning false.
    * @return returns false
    */
    public boolean hasMine() {
        return false;
    }
    
    /**
    * An assigning method taking in no argument and returning m_flag.
    * @return returns m_flag a boolean argument
    */
    public boolean hasFlag() {
        return m_flag;
    }
    
    /**
    * 
    */
    public void addHandler() {
        class MouseHandle implements MouseListener {
            public void mousePressed(MouseEvent e){
                if((e.getButton() == MouseEvent.BUTTON1) && isEnabled() && (getIcon() == new JButton().getIcon()))
                {
                    Board b = (Board) getParent();
                    b.reveal(getThis());
                }
                else if((e.getButton() == MouseEvent.BUTTON3) && isEnabled() 
                		&& ((getIcon() == new JButton().getIcon() || m_flag)))
                {
                    toggleFlag();
                }
            }
            public void mouseReleased(MouseEvent e) {
                
            }
            public void mouseEntered(MouseEvent e) {
                
            }
            public void mouseExited(MouseEvent e) {
                
            }
            public void mouseClicked(MouseEvent e) {
                
            }
        }
        
        MouseHandle mh = new MouseHandle();
        this.addMouseListener(mh);
    }
    
	/**
    * An accessor method taking in no arguments and returning the
    * instance of a tile we are currently accessing. 
    * @return the current tile
    */
    public Tile getThis() {
        return this;
    }
	
    /**
    * An accessor method taking in no arguments and returning 
    * the x-axis value of the current tile.
    * @return the x-axis value of the tile
    */
    public int getPosX() {
        return m_x;
    }
    
	/**
    * An accessor method taking in no arguments and returning 
	* the y-axis value of the current tile.
    * @return the y-axis value of the tile
    */
    public int getPosY() {
        return m_y;
    }
}
