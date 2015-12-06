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
			gc.setResizable(false);

	        Game g = new Game(10,10);
	        gc.getContentPane().setSize(g.getWidth(), g.getHeight() + INPUT_HEIGHT);
     		gc.pack();
     		
	        
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
	        		int size = 10;
	        		int mines = -1;
	        		boolean valid = true;
	        		int sizeInput = 10;
	        		int mineInput = -1;
	        		
	        		 if (e.getSource() == btnNewGame) {
	        			g.endGame('r');
	 	        		g.removeAll();
	 	        		
	 	        		if (tfSize.getText().equals("")) {
	 	        			size = 10;
	 	        		} else {
	 	        			sizeInput = Integer.parseInt(tfSize.getText());
	 	        		}
	 	        		
	 	        		if ((sizeInput <= 30) && (sizeInput > 0)){
	 	        			size = sizeInput;
	 	        		} else {
	 	        			valid = false;
	 	        		}
	 	        		
	 	        		if (tfMines.getText().equals("")) {
	 	        			mines = size;
	 	        			mineInput = size;
	 	        		} else {
	 	        			mineInput = Integer.parseInt(tfMines.getText()); 
	 	        		}
	 	        		
	 	        		if ((mineInput <= 150) && (mineInput < (sizeInput*sizeInput))){
	 	        			mines = mineInput;
	 	        		} else {
	 	        			valid = false;
	 	        		}
	 	        		
	 	        		
	 	        		if (valid) {
	 	        			g.makeGame(size, mines);
		 	        		gc.getContentPane().setSize(g.getWidth(), g.getHeight() + INPUT_HEIGHT);
		 	        		gc.pack();
	 	        		} else {
	 	        			JOptionPane.showMessageDialog(gc, "The size must be between 10 and 30. \n\n"
	 	        					+ "The number of mines must be between 0 \n"
	 	        					+ "and the size squared and must not exceed 150.",
	 	        					"Incorrect value(s) entered", JOptionPane.WARNING_MESSAGE);
	 	        		}
	 	        		
	 	        		
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
