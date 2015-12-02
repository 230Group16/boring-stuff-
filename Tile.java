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
	
	public void Tile(int x, int y){
		m_enabled = true;
		m_flag = false;
		m_graphic = null;
		m_x = x;
		m_y = y;
		
		
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
	
	public void setGraphic(Graphics2D g){
		m_graphic = g;
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
}
