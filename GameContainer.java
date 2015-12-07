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
	public void resetGame(Game g) {
		int size = g.getBoard().getBoardSize();
		int mines = g.getBoard().getNumberOfMines();
		
		g = new Game(size,mines);
	}
	
	public GameContainer(int s, int m) {
		final int INPUT_HEIGHT = 100;
        
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setResizable(false);
		setTitle("Kablewie!");
		
        Game g = new Game(s,m);
        
        String playerName = JOptionPane.showInputDialog("Enter your name: ", "New Challenger");
        
        if (playerName != null) {
        	if(playerName.length() > 20) {
            	playerName = JOptionPane.showInputDialog("Sorry character limit is 20.\n Enter your name: ", "New Challenger");
            }
        } else {
        	playerName = "N/A";
        }
        
        g.newPlayer(playerName);
        
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
        		boolean defaultValue = false;
        		int sizeInput = 10;
        		int mineInput = -1;
        		
        		if (e.getSource() == btnNewGame) {
 	        		if (tfSize.getText().equals("") || !isNumeric(tfSize.getText())) {
 	        			size = 10;
 	        			defaultValue = true;
 	        		} else {
 	        			sizeInput = Integer.parseInt(tfSize.getText());
 	        		}
 	        		
 	        		if ((sizeInput <= 30) && (sizeInput > 0) && (isNumeric(tfSize.getText()) || defaultValue)){
 	        			size = sizeInput;
 	        		} else {
 	        			valid = false;
 	        		}
 	        		
 	        		if (tfMines.getText().equals("") || !isNumeric(tfSize.getText())) {
 	        			mines = size;
 	        			mineInput = size;
 	        		} else {
 	        			mineInput = Integer.parseInt(tfMines.getText()); 
 	        		}
 	        		
 	        		if ((mineInput <= 150) && (mineInput < (sizeInput*sizeInput)) && (isNumeric(tfSize.getText()) || defaultValue)){
 	        			mines = mineInput;
 	        		} else {
 	        			valid = false;
 	        		}
 	        		
 	        		if (valid) {
 	        			new GameContainer(size, mines);
 	        			dispose();
 	        		} else {
 	        			JOptionPane.showMessageDialog(getGameContainer(), "The size must be a number between 1 and 30. \n\n"
 	        					+ "The number of mines must be between 0 \n"
 	        					+ "and the size squared and must not exceed 150.",
 	        					"Incorrect value(s) entered", JOptionPane.WARNING_MESSAGE);
 	        		}
 	        		tfSize.setText("");
 	        		tfMines.setText("");
 	        		
 	        		
                 }  else if (e.getSource() == btnExit) {
                     dispose();
                 }
        	}
        	
        	
        }
        
        InputHandler handler = new InputHandler();
        btnNewGame.addActionListener(handler);
        btnExit.addActionListener(handler);
        
        getContentPane().add(g, BorderLayout.NORTH);
        getContentPane().add(input, BorderLayout.CENTER);
        g.getScoreboard().updateTime();
       
        /* set frame resizable to false */
        setResizable(false);
        
        pack();
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	public GameContainer getGameContainer() {
		return this;
	}
	
	public static void main( String args[] ) {
		GameContainer gc = new GameContainer(10,10);
	}
	
	public static boolean isNumeric(String string) {  
		try {  
			int testNumber = Integer.parseInt(string);  
		} catch(NumberFormatException e) {  
			return false;  
		}  
		
		return true;  
	}
	

}
