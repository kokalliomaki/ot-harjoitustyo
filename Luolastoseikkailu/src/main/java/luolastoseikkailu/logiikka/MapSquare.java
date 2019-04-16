
package luolastoseikkailu.logiikka;

import java.util.ArrayList;
import java.util.List;

public class MapSquare {
    private boolean wall;
    private Monster occupant;
    private Item item;
    
    public MapSquare(char sq) {
        if (sq == '#') {
            this.wall = true;
        }
        if (sq == '.') {
            this.wall = false;           
        }
        this.occupant = null;
        this.item = null;
    }
    
    public void setOccupant(Monster occ) {
        this.occupant = occ;
    }
    
    public void addItem (Item item) {
        this.item = item;
    }
    
    public Monster getOccupant() {
        return this.occupant;
    }
    
    public Item getItem() {
        return this.item;
    }
        
    public boolean isWall() {
        return this.wall;
    }
    
    public void removeOccupant() {
        this.occupant = null;
    }
    
    public void removeItem() {
        this.item = null;
    }
    
    public boolean isOccupied() {
        if (this.wall || this.occupant != null) return true;
        return false;
    }
    
    public String toString() {
        if (this.wall) return "#";
        if (this.occupant != null) return occupant.getSymbol();
        if (this.item != null) return item.toString();
        return ".";
    }
    
}
