
package luolastoseikkailu.domain;

import java.util.Random;

public class Orc implements Monster {
    private int hp;
    private int maxhp;
    private int attack;
    private int armor;
    private String symbol;
    private int xcoord;
    private int ycoord;
    private Map currentMap;
    
    
    public Orc(int x, int y, Map map) {
        this.hp = 3;
        this.maxhp = 5;
        this.symbol = "o";
        this.xcoord = x;
        this.ycoord = y;
        this.currentMap = map;
        this.attack = 2;
        this.armor = 0;
        this.currentMap.setMonster(x, y, this);
    }
    
    public int getX() {
        return this.xcoord;
    }
    
    public int getY() {
        return this.ycoord;
    }
    
    public String getSymbol() {
        return this.symbol;
    }
    
    public int getAttack() {
        return this.attack;
    }
    
    public int getArmor() {
        return this.armor;
    }
    
    public boolean takeDamage(int damage) {
        this.hp -= damage;
        return this.hp > 0;        
    }
    
    public boolean move(int xoffset, int yoffset) {
        Random rand = new Random();
        while (xoffset == 0 && yoffset == 0) {
            xoffset = rand.nextInt(3)-1;
            yoffset = rand.nextInt(3)-1;
        }
        MapSquare target = currentMap.getSquare(xcoord+xoffset, ycoord+yoffset);
        if (target.isWall()) return false;
        if (target.isOccupied()) {
            this.currentMap.combat(this, target.getOccupant());
            return true;
        }
        currentMap.getSquare(xcoord, ycoord).removeOccupant();
        this.ycoord += yoffset;
        this.xcoord += xoffset;
        target.setOccupant(this);
        return true;            
    }
    
}
