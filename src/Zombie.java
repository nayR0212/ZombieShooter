import java.util.ArrayList;

public class Zombie implements Attacker, Damageable, Moveable, Positionable {
    public static ArrayList<Zombie> zombies = new ArrayList<>();
    protected final int maxHealth;
    protected int ID;
    protected int currHealth;
    protected int shot = 0;
    protected int xPos;
    protected int yPos;
    protected int xNxt;
    protected int yNxt;
    protected int rank;
    protected int strength;
    private Damageable target;

    public Zombie(int _x, int _y, int _max, int _str, int _rank) {
        maxHealth = _max;
        currHealth = maxHealth;
        strength = _str;
        rank = _rank;
        ID = zombies.size() + Game.dead.size();
        xPos = _x;
        yPos = _y;
        zombies.add(this);
    }

    public void attack() {
        if (isAlive()) target.damage(strength);
    }

    public void addTarget(Damageable _target) {
        target = _target;
    }

    public int getHealth() {
        return currHealth;
    }

    public void setHealth(int _health) {
        currHealth = _health;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public void damage(int _value) {
        currHealth -= _value;
    }

    public boolean isAlive() {
        return currHealth > 0;
    }

    public void preMove() {
    }

    public void unMove() {
        xNxt = xPos;
        yNxt = yPos;
    }

    //add: check if space ahead is empty and move (if can't move)
    public void move() {
        int i = zombies.size() - 1;
        for (Zombie zombie : zombies) {
            if (xNxt == zombie.getNxtX() && yNxt == zombie.getNxtY() && ID != zombie.ID) {
                if (zombie.getNxtX() == zombie.getX() && zombie.getNxtY() == zombie.getY()) {
                    unMove();
                    break;
                } else if (rank < zombie.getRank()) {
                    unMove();
                    break;
                } else {
                    xPos = xNxt;
                    yPos = yNxt;
                }
            } else if (i-- == 0) {
                xPos = xNxt;
                yPos = yNxt;
                break;
            }
        }
    }

    public int getNxtX() {
        return xNxt;
    }

    public int getNxtY() {
        return yNxt;
    }

    public int getX() {
        return xPos;
    }

    public void setX(int _x) {
        xPos = _x;
    }

    public int getY() {
        return yPos;
    }

    public void setY(int _y) {
        yPos = _y;
    }

    public boolean isShot() {
        return shot > 0;
    }

    public void toggleShot() {
        shot = 3;
    }

    public int getRank() {
        return rank;
    }
}