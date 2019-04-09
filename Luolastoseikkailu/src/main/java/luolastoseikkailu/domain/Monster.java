
package luolastoseikkailu.domain;

public interface Monster {
    
    public int getY();
    public int getX();
    public int getArmor();
    public int getAttack();
    public String getSymbol();
    public boolean move(int xoffset, int yoffset);
    public boolean takeDamage(int damage);
    
}
