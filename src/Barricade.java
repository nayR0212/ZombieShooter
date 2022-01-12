import java.util.ArrayList;

public class Barricade implements Positionable, Damageable {
    private final int maxHealth = 100;
    private int currHealth = 100;
    private final int xPos;
    private final int yPos;
    static ArrayList<Barricade> barricades = new ArrayList<>();

    public Barricade(int _x, int _y) {
        xPos = _x;
        yPos = _y;
        barricades.add(this);
    }

    public int getX() {
        return xPos;
    }

    public int getY() {
        return yPos;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public int getHealth() {
        return currHealth;
    }

    public void setHealth(int _health) {
        this.currHealth = _health;
    }

    public void damage(int _value) {
        currHealth -= _value;
    }

    public boolean isAlive() {
        return currHealth > 0;
    }

    public String toString() {
        if (currHealth > 75) return "☰";
        if (currHealth > 50) return "☲";
        if (currHealth > 25) return "☳";
        if (currHealth > 0) return "☷";
        else return "✕";
    }
}

