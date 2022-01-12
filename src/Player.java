import java.util.Scanner;

public class Player implements Positionable, Moveable, Attacker {
    public int xPos;
    public int yPos;
    public int xNxt;
    public int yNxt;
    public Damageable target;
    public int dir = -1;
    public int weaponDamage = 5;

    Scanner IO = new Scanner(System.in);

    public Player(int _x, int _y) {
        xPos = _x;
        yPos = _y;
    }

    public void attack() {
        target = null;
        if (dir == -1)
            for (Zombie zombie : Zombie.zombies) {
                if (yPos == zombie.getY() && zombie.getX() < 0) {
                    target = zombie;
                    break;
                }
            }
        else {
            for (Zombie zombie : Zombie.zombies) {
                if (yPos == zombie.getY() && zombie.getX() > 0) {
                    target = zombie;
                    break;
                }
            }
        }
        if (target != null) target.damage(weaponDamage);
    }

    public void addTarget(Damageable _target) {
        target = _target;
    }

    public void preMove() {

    }

    public void unMove() {
        xNxt = xPos;
        yNxt = yPos;
    }

    public int getValidInput() {
        while (true) {
            System.out.println("Player Move:");
            String user = IO.nextLine().toLowerCase();
            if(user.length() == 0) {
                System.out.println("No Input");
            } else {
                char input = user.charAt(0);

                switch (input) {
                    case 'w':
                        if (yPos != 5) return 1;

                    case 's':
                        if (yPos != 1) return 2;

                    case 'a':
                        return 3;

                    case 'd':
                        return 4;

                    default:
                        System.out.println("Invalid Input");
                }
            }
        }
    }

    // doesn't target sometimes idk... toggleshotstate for zombie... only shoot if visible
    public void move() {
        int input = getValidInput();
        switch (input) {
            case 1:
                yPos += 1;
                break;
            case 2:
                yPos -= 1;
                break;
            case 3:
                dir = -1;
                attack();
                break;
            case 4:
                dir = 1;
                attack();
                break;
        }
    }

    public void setX(int _x) {
        xPos = _x;
    }

    public void setY(int _y) {
        yPos = _y;
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

    public int getY() {
        return yPos;
    }

    public String toString() {
        if (dir == -1) {
            return "<";
        } else return ">";
    }
}