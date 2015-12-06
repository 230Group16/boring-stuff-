package kablewie;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.print.DocFlavor.URL;
import javax.swing.*;

public class GameContainer extends JFrame {
	
	public GameContainer(String s) {
		super(s);
	}
	
	public static void main( String args[] ) {
	        final int INPUT_HEIGHT = 100;
	        
	        
	        /* create frame for Board and Scoreboard */
	        GameContainer gc = new GameContainer( "Kablewie!");
	        gc.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
	        gc.setLayout(new BorderLayout());
	        
	        Game g = new Game(10,10);
	        
	        gc.getContentPane().setSize(g.getWidth(), g.getHeight() + INPUT_HEIGHT);
	        gc.setResizable(false);
	        
	        JPanel input = new JPanel();
	        input.setSize(g.getWidth(), INPUT_HEIGHT);
	        input.setLayout(new GridLayout(3,2));
	        
	        JLabel lblSize = new JLabel("Size: ");
	        input.add(lblSize);
	        
	        JTextField tfSize = new JTextField(10);
	        input.add(tfSize);
	        
	        JLabel lblMines = new JLabel("Number of mines: ");
	        input.add(lblMines);
	        
	        JTextField tfMines = new JTextField(10);
	        input.add(tfMines);
	        
	        JButton btnNewGame = new JButton("New Game");
	        input.add(btnNewGame);
	        
	        JButton btnExit = new JButton("Exit");
	        input.add(btnExit);
	        
	        
	        
	        class InputHandler implements ActionListener {	
	        	public void actionPerformed(ActionEvent e) {
	        		int size;
	        		int mines;
	        		
	        		 if (e.getSource() == btnNewGame) {
	        			 g.endGame('r');
	 	        		g.removeAll();
	 	        		
	 	        		if (tfSize.getText().equals("")) {
	 	        			size = -1;
	 	        		} else {
	 	        			size = Integer.parseInt(tfSize.getText());
	 	        		}
	 	        		
	 	        		if (tfMines.getText().equals("")) {
	 	        			mines = -1;
	 	        		} else {
	 	        			mines = Integer.parseInt(tfMines.getText());
	 	        		}
	 	        		
	 	        		g.makeGame(size, mines);
	 	        		gc.getContentPane().setSize(g.getWidth(), g.getHeight() + INPUT_HEIGHT);
	 	        		gc.pack();
	                 }  else if (e.getSource() == btnExit) {
	                     gc.dispose();
	                 }
	        		
	        		
	        		
	        		
	        	}
	        }
	        
	        InputHandler handler = new InputHandler();
	        btnNewGame.addActionListener(handler);
	        btnExit.addActionListener(handler);
	        
	        gc.getContentPane().add(g, BorderLayout.NORTH);
	        gc.getContentPane().add(input, BorderLayout.CENTER);
	        Scoreboard.updatetime();
	        
	        gc.pack();
	        
	        /* set container layout to boxlayout */
	        
	        /* display frame */
	        gc.setVisible(true);
	        
	        /* set frame resizable to false */
	        gc.setResizable(true);
	        
	        while(m_running){
	        	g.getScoreboard().update();
	        }
	}
	
	private static boolean m_running = true;
	
	public static boolean isRunning() {
		return m_running;
	}
	
	public static void start() {
		m_running = true;
	}
	
	public static void stop() {
		m_running = false;
	}
}
