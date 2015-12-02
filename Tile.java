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
		
	
	public void setEnabled(boolean tf){
		m_enabled = tf;
	}
	
	public boolean m_isEnabled(){
		return m_enabled;
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
			     Game g = (Game) getParent();
			     g.reveal(this);
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
