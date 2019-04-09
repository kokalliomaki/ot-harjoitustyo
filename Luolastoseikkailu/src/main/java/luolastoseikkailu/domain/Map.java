
package luolastoseikkailu.domain;

import java.util.ArrayList;
import java.util.List;

public class Map {
    private int xSize;
    private int ySize;
    private MapSquare[][] map;
    private int dlevel;
    private List<Monster> monsters;
    
    public Map(char[][] basemap, int level) {
        this.ySize = basemap.length;
        this.xSize = basemap[0].length;
        map = new MapSquare[ySize][xSize];
        for (int i = 0; i < ySize; i++) {
            for (int j = 0; j < xSize; j++) {
                map[i][j] = new MapSquare(basemap[i][j]);
            }
        }            
        this.dlevel = level;
        this.monsters = new ArrayList<>();
    }
    
    public void setPlayer(int x, int y, Player player) {
        this.map[y][x].setOccupant(player);
    }
    
    public void setMonster(int x, int y, Monster monster) {
        this.monsters.add(monster);
        this.map[y][x].setOccupant(monster);
    }
    
    public void moveMonsters() {
        for (Monster monster : monsters) {
            monster.move(0, 0);
            
        }              
    }
    
    public void combat(Monster attacker, Monster defender) {
        int damage = attacker.getAttack() - defender.getArmor();
        if (!defender.takeDamage(damage)) {
            this.map[defender.getY()][defender.getX()].removeOccupant();
            this.monsters.remove(defender);
        }
    }
    
    
    public MapSquare getSquare(int x, int y) {
        return this.map[y][x];
    }
    public boolean isSquareOccupied(int x, int y) {
        return this.map[y][x].isOccupied();
    }
    
    public String toString() {
        String returnstring = "";
        for (int i = 0; i < ySize; i++) {
            for (int j = 0; j < xSize; j++) {
                returnstring += map[i][j].toString();
            }
            returnstring += "\n";
        }
        return returnstring;
    }
    
}
