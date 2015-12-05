/**
* @file Tile.java
* @author Nate , Ben ...
* @date 04 Dec 2015
* @see Tile.java for related information.
*
* Adding mines to the tile attributes.
*/

package kablewie;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;


public class Mine extends Tile {
    
	/**
	* An assigning method taking in no argument and returning true.
	* @return returns true.
	*/
    public boolean hasMine(){
        return true;
    }
	
    /**
     * A constructor taking two arguments and returning a new instance of Mine.
     * @param x an integer argument.
     * @param y an integer argument.
     * @return New mine object
     */
    public Mine(int x, int y){
        super(x,y);
    }
    

    /**
	* An display method taking in one argument and calling a method from Tile.
	* @param mineCount an integer argument.
	*/
    public void showGraphic(int mines) {
    	    setIcon(new ImageIcon(Game.class.getResource("/images/mine.jpg")));
    }
}
