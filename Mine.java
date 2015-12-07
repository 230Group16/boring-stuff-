/**
* @file Mine.java
* @author Neycho Neychev, Ben Harris
* @date 04 Dec 2015
* @see Tile.java for related information.
*
* Adding mines to the tile attributes.
*/

package kablewie;

public class Mine extends Tile {
    
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
	* An assigning method taking in no argument and returning true.
	* @return returns true.
	*/
    public boolean hasMine(){
        return true;
    }
}
