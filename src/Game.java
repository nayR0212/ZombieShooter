import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;

public class Game {
    Board board = new Board();
    ArrayList<Positionable> pieces = new ArrayList<>();
    public static ArrayList<Zombie> dead = new ArrayList<>();
    Player player = new Player(0, 4);

    public void moveAll() {
        player.move();
        for (Zombie zombie : Zombie.zombies) {
            zombie.preMove();
            zombie.move();
        }
    }

    public void spawnZombie() {
        int random_side = (int) (Math.random() * 2);
        int ratio = (int) (Math.random() * 101);
        outerloop:
        while (true) {
            int y = (int) (Math.random() * 5) + 1;

            if (random_side == 0) {
                for (Zombie zombie : Zombie.zombies) {
                    if (-11 == zombie.getX() && y == zombie.getY()) break;
                    else {
                        if (ratio <= 50) {
                            pieces.add(new WalkingZombie(-11, y));
                            break outerloop;
                        } else if (ratio <= 80) {
                            pieces.add(new RunningZombie(-11, y));
                            break outerloop;
                        } else {
                            pieces.add(new TeleportingZombie(-11, y));
                            break outerloop;
                        }
                    }
                }
            } else {
                for (Zombie zombie : Zombie.zombies) {
                    if (11 == zombie.getX() && y == zombie.getY()) break;
                    else {
                        if (ratio <= 50) {
                            pieces.add(new WalkingZombie(11, y));
                            break outerloop;
                        } else if (ratio <= 80) {
                            pieces.add(new RunningZombie(11, y));
                            break outerloop;
                        } else {
                            pieces.add(new TeleportingZombie(11, y));
                            break outerloop;
                        }
                    }
                }
            }
        }
    }

    public void checkDead() {
        for (Iterator<Zombie> zombie = Zombie.zombies.iterator(); zombie.hasNext(); ) {
            Zombie zt = zombie.next();
            if (!zt.isAlive()) {
                //bandage... this works wtf... maybe cast zombie to positionable
                pieces.removeIf(pt -> zt.getX() == pt.getX() && zt.getY() == pt.getY());
                dead.add(zt);
                zombie.remove();
            }
        }
    }

    public boolean gameActive() {
        for (Barricade barricade : Barricade.barricades) {
            if (!barricade.isAlive()) {
                for (Zombie zombie : Zombie.zombies) {
                    if (barricade.getX() == zombie.getX() && barricade.getY() == zombie.getY()) return false;
                }
            }
        }
        return true;
    }

    //may not need math abs
    public static Comparator<Zombie> Compare_xPos = (a, b) -> Math.abs(Integer.compare(a.getX(), b.getX()));
}