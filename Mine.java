/**
* @file Tile.java
* @author Nate , Ben ...
* @date 04 Dec 2015
* @see Tile.java for related information.
*
* Adding mines to the tile attributes.
*/

package kablewie;

import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;

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
}
