
package luolastoseikkailu.domain;

public class Player implements Monster {
    private String name;
    private int hp;
    private int maxhp;
    private int level;
    private String symbol;
    private int xcoord;
    private int ycoord;
    private Map currentMap;
    
    public Player(String name, int x, int y, Map map) {
        this.name = name;
        this.hp = 10;
        this.maxhp = 10;
        this.level = 1;
        this.symbol = "@";
        this.xcoord = x;
        this.ycoord = y;
        this.currentMap = map;
        currentMap.setPlayer(x, y, this);
    }
    
    public boolean move(int xoffset, int yoffset) {
        MapSquare target = currentMap.getSquare(xcoord+xoffset, ycoord+yoffset);
        if (target.isWall()) return false;
        currentMap.getSquare(xcoord, ycoord).removeOccupant();
        this.ycoord += yoffset;
        this.xcoord += xoffset;
        target.setOccupant(this);
        return true;            
    }
    
    public String getSymbol() {
        return this.symbol;
    }
}
