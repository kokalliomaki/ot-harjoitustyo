
package luolastoseikkailu.domain;

public class Map {
    private int xSize;
    private int ySize;
    private MapSquare[][] map;
    private int dlevel;
    
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
    }
    
    public void setPlayer(int x, int y, Player player) {
        this.map[y][x].setOccupant(player);
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
