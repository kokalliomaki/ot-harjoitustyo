
package luolastoseikkailu.domain;

import java.util.Random;

public class Orc implements Monster {
    private int hp;
    private int maxhp;
    private String symbol;
    private int xcoord;
    private int ycoord;
    private Map currentMap;
    
    
    public Orc(int x, int y, Map map) {
        this.hp = 5;
        this.maxhp = 5;
        this.symbol = "o";
        this.xcoord = x;
        this.ycoord = y;
        this.currentMap = map;
        this.currentMap.setMonster(x, y, this);
    }
    
    public String getSymbol() {
        return this.symbol;
    }
    
    public boolean move(int xoffset, int yoffset) {
        Random rand = new Random();
        xoffset = rand.nextInt(3)-1;
        yoffset = rand.nextInt(3)-1;
        MapSquare target = currentMap.getSquare(xcoord+xoffset, ycoord+yoffset);
        if (target.isWall()) return false;
        currentMap.getSquare(xcoord, ycoord).removeOccupant();
        this.ycoord += yoffset;
        this.xcoord += xoffset;
        target.setOccupant(this);
        return true;            
    }
    
    public void move() {
        
    }
    
}
