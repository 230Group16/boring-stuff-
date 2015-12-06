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
    
    public Tile(int x, int y){
        m_flag = false;
        m_graphic = null;
        m_x = x;
        m_y = y;
        setPreferredSize(new Dimension(TILE_SIZE, TILE_SIZE));
        addHandler();
    }
    
    public void toggleFlag(){
        m_flag = !m_flag;
        if (m_flag) {
        	setIcon(new ImageIcon(Game.class.getResource("/images/flag.png")));
        } else {
        	setIcon(new JButton().getIcon());
        }
    }
    
    public void showGraphic(int mineCount) throws IOException{
            if (mineCount != 0) {
            	setIcon(new ImageIcon(Game.class.getResource("/images/" + mineCount + ".png")));
            } else {
            	setIcon(new ImageIcon(Game.class.getResource("/images/mine.png")));  
            }    
    }
    
    public Graphics2D getGraphic(){
        return m_graphic;
    }
    
    public boolean hasMine(){
        return false;
    }
    
    public boolean hasFlag(){
        return m_flag;
    }
    
    public void addHandler(){
        class MouseHandle implements MouseListener{
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
            public void mouseReleased(MouseEvent e){
                
            }
            public void mouseEntered(MouseEvent e){
                
            }
            public void mouseExited(MouseEvent e){
                
            }
            public void mouseClicked(MouseEvent e){
                
            }
        }
        
        MouseHandle mh = new MouseHandle();
        this.addMouseListener(mh);
    }
    
    public Tile getThis() {
        return this;
    }
    
    public int getPosX(){
        return m_x;
    }
    
    public int getPosY(){
        return m_y;
    }
}
