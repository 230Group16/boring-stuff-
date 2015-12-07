package kablewie;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
* @file Animations.java
* @author David
* @date 07 Dec 2015
* @see Game.java for related information.
*
* Creates the losing animation of Kablewie 
*/


	public class Animations extends JPanel implements ActionListener {
		
		public Game m_game;
		private BufferedImage m_image;
		
		/**
		 * A constructor taking one argument 
		 * and returning a new instance of an animation,
		 * @param g an instance of the object Game.class.
		 * @return new Animations object
		 */
		public Animations(Game g) {
			m_game = g;
			try {
				InputStream img = Game.class.getResourceAsStream(
						"/images/kablewie.png");
				m_image = ImageIO.read(Game.class.getResourceAsStream(
						"/images/kablewie.png"));
			} catch  (IOException e) {
				e.printStackTrace();
			}
		} 
		
		Timer t = new Timer(5, this);
		int x = 0;
		int y = 150; 
		double m_velX = 1, m_velY = 1;
		
		 
	    /**
		* A method that draws the image on the screen.
		* @param g Graphics argument
		*/
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.drawImage(m_image, x, y, null);
			t.start();
		}
		
		 /**
		* A method that moves the image accross the screen.
		* @param e ActionEvent argument 
		*/
		public void actionPerformed(ActionEvent e) {
			if (x < 0 || x > (m_game.getWidth()-100)) { 
				m_velX = -m_velX;
			}
			if (y < 0 || y > (m_game.getHeight()-135)) { 
				m_velY = -m_velY;
			}
			x += m_velX;
			y += m_velY; 
			repaint(); 
		}
	}
