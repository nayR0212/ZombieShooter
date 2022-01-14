import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;

public class Game {
    Board board = new Board();
    ArrayList<Positionable> pieces = new ArrayList<>();
    public static ArrayList<Zombie> dead = new ArrayList<>();
    Player player = new Player(0, 4);
    int score = 0;

    public void moveAll() {
        for (int i = 0; i < 2; i++) {
            board.updateBoard(pieces, player);
            player.move();
            checkDead();
        }
        for (Zombie zombie : Zombie.zombies) {
            zombie.preMove();
            zombie.move();
        }
    }

    public void zombieAttack() {
        for (Zombie zombie : Zombie.zombies) {
            zombie.attack();
        }
    }

    public void spawnZombie() {
        int random_side = (int) (Math.random() * 2);
        int ratio = (int) (Math.random() * 101);
        outerloop:
        while (true) {
            int y = (int) (Math.random() * 5) + 1;

            if (Zombie.zombies.size() == 0) {
                if (ratio <= 50) {
                    pieces.add(new WalkingZombie(-11, y));
                    break outerloop;
                } else if (ratio <= 90) {
                    pieces.add(new RunningZombie(-11, y));
                    break outerloop;
                } else {
                    pieces.add(new TeleportingZombie(-11, y));
                    break outerloop;
                }
            } else if (random_side == 0) {
                for (Zombie zombie : Zombie.zombies) {
                    if (-11 == zombie.getX() && y == zombie.getY()) break;
                    else {
                        if (ratio <= 50) {
                            pieces.add(new WalkingZombie(-11, y));
                            break outerloop;
                        } else if (ratio <= 90) {
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
                Positionable piece = zt;
                dead.add(zt);
                pieces.remove(piece);
                zombie.remove();
                score++;
            }
        }
    }

    public boolean gameActive() {
        for (Barricade barricade : Barricade.barricades) {
            if (!barricade.isAlive()) {
                for (Zombie zombie : Zombie.zombies) {
                    if (barricade.getX() == zombie.getX() && barricade.getY() == zombie.getY()) {
                        System.out.println("You lose!");
                        System.out.println("Score: " + score);
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public static Comparator<Zombie> Compare_xPos = new Comparator<Zombie>() {
        public int compare(Zombie a, Zombie b) {
            return Integer.valueOf(Math.abs(a.getX())).compareTo(Math.abs(b.getX()));
        }
    };
}