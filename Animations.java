package kablewie;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.Timer;


	public class Animations extends JPanel implements ActionListener {
		
		public Game m_game;
		private BufferedImage image;

		public Animations(Game g) {
			m_game = g;
			try {
				image = ImageIO.read(Game.class.getResourceAsStream("/images/kablewie.png"));
			} catch  (IOException e) {
				e.printStackTrace();
			}
		} 
		
		Timer t = new Timer(5, this);
		int x = 150;
		int y = 150; 
		double velX = 1, velY = 1;
		
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.drawImage(image, x, y, null);
			t.start();
		}
		
		public void actionPerformed(ActionEvent e) {
			if (x < 0 || x > 200) { 
				velX = -velX;
			}
			if (y < 0 || y > 250) { 
				velY = -velY;
			}
			x += velX;
			y += velY; 
			repaint(); 
		}
	}
