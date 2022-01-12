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

    //not finished... zombie type, xpos
/*    public Zombie spawnZombie() {
        int random_side = (int)(Math.random() * 2);
        int y = (int)(Math.random() * 6) - 1;

        if(random_side == 0) {

        } else {

        }
    }*/

    public void checkDead() {
        for (Iterator<Zombie> zombie = Zombie.zombies.iterator(); zombie.hasNext(); ) {
            Zombie zt = zombie.next();
            if (zt.isAlive() == false) {
                //bandage... this works wtf... maybe cast zombie to positionable
                for (Iterator<Positionable> piece = pieces.iterator(); piece.hasNext(); ) {
                    Positionable pt = piece.next();
                    if (zt.getX() == pt.getX() && zt.getY() == pt.getY()) {
                        piece.remove();
                    }
                }
                dead.add(zt);
                zombie.remove();
            }
        }
    }

    //not tested
    public boolean gameActive() {
        for (Barricade barricade : Barricade.barricades) {
            if (barricade.isAlive() == false) {
                for (Zombie zombie : Zombie.zombies) {
                    if (barricade.getX() == zombie.getX() && barricade.getY() == zombie.getY()) return false;
                }
            }
        }
        return Zombie.zombies.size() > 0;
    }

    public static Comparator<Zombie> Compare_xPos = new Comparator<Zombie>() {
        //may not need math abs
        public int compare(Zombie a, Zombie b) {
            return Integer.valueOf(a.getX()).compareTo(b.getX());
        }
    };
}
