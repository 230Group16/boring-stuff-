package kablewie;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.*;

public class GameContainer extends JFrame {
	
	public GameContainer(String s) {
		super(s);
	}
	public static void main( String args[] ) {
	        final int INPUT_HEIGHT = 100;
	        boolean running = true;
	        
	        /* create frame for Board and Scoreboard */
	        GameContainer gc = new GameContainer( "Kablewie!!!");
	        gc.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
	        gc.setLayout(new BorderLayout());
	        
	        Game g = new Game(10,10);
	        
	        gc.setSize(g.getWidth(), g.getHeight() + INPUT_HEIGHT);
	        
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
	        
	        JButton btnNewGame = new JButton();
	        input.add(btnNewGame);
	        btnNewGame.setText("New Game");
	        
	        gc.add(g, BorderLayout.NORTH);
	        gc.add(input, BorderLayout.CENTER);
	        Scoreboard.updatetime();
	        
	        /* set container layout to boxlayout */
	        
	        /* display frame */
	        gc.setVisible(true);
	        
	        /* set frame resizable to false */
	        gc.setResizable(true);
	        
	        while(running){
	        	g.getScoreboard().update();
	        }
	}
}
