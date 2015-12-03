package kablewie;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class Tile extends JButton {
    
    private boolean m_enabled;
    private boolean m_flag;
    private Graphics2D m_graphic;
    private int m_x;
    private int m_y;
    private Graphics2D img[];
    
    public Tile(int x, int y){
        m_enabled = true;
        m_flag = false;
        m_graphic = null;
        m_x = x;
        m_y = y;
        
        createGraphicsArray();
        addHandler();
    }
    
    public void toggleFlag(){
        m_flag = !m_flag;
    }
    
    public void m_showGraphic(int mineCount){
        switch (mineCount){
            case 1:
            m_graphic = new Graphics2D(/*pic of 1*/);
            break;
            case 2:
            m_graphic = new Graphics2D(/*pic of 2*/);
            break;
            case 3:
            m_graphic = new Graphics2D(/*pic of 3*/);
            break;
            case 4:
            m_graphic = new Graphics2D(/*pic of 4*/);
            break;
            case 5:
            m_graphic = new Graphics2D(/*pic of 5*/);
            break;
            case 6:
            m_graphic = new Graphics2D(/*pic of 6*/);
            break;
            case 7:
            m_graphic = new Graphics2D(/*pic of 7*/);
            break;
            case 8:
            m_graphic = new Graphics2D(/*pic of 8*/);
            break;
            case 9:
            m_graphic = new Graphics2D(/*pic of Flag*/);
            break;
            case 10:
            m_graphic = new Graphics2D(/*pic of Bomb*/);
            break;
            
        }
    }
    
    public Graphics2D getGraphic(){
        return m_graphic;
    }
    
    public boolean hasMine(){
        return false;
    }
    
    public boolean m_hasFlag(){
        return m_flag;
    }
    
    public void addHandler(){
        class MouseHandle implements MouseListener{
            public void mousePressed(MouseEvent e){
                if(e.getButton() == MouseEvent.BUTTON1)
                {
                    setEnabled(false);
                    Board b = (Board) getParent();
                    b.reveal(getThis());
                }
                else if(e.getButton() == MouseEvent.BUTTON3)
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
    
    public void createGraphicsArray(){
        img = new Graphics2D[10];
        //add images for each Aled
    }
    
    public int getPosX(){
        return m_x;
    }
    
    public int getPosY(){
        return m_y;
    }
}
