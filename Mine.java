package kablewie;


public class Mine extends Tile {
    
    public Mine(int x, int y){
        super(x,y);
    }
    
    public boolean hasMine(){
        return true;
    }
    
    public void m_showGraphic(int mineCount){
        super.m_showGraphic(mineCount);
    }
}
