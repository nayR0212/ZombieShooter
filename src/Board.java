import java.util.ArrayList;

public class Board {
    public void updateBoard(ArrayList<Positionable> pieces, Player player) {
        System.out.println();

        for (int y = 5; y >= 1; y--) {
            System.out.print(y);

            //print left
            for (int x = -10; x <= -1; x++) {
                int i = pieces.size() - 1;
                outerloop:
                for (Positionable piece : pieces) {
                    //idk anymore... barricade doesnt print if zombie dies on it
                    if (x == piece.getX() && y == piece.getY()) { //this doesnt happen when zombie dies on barricade
                        if (piece instanceof Barricade) {
                            if (Zombie.zombies.size() == 0) {
                                System.out.print("   ▎" + piece);
                                break;
                            }
                            int j = Zombie.zombies.size() - 1;
                            for (Zombie zombie : Zombie.zombies) {
                                if (x == zombie.getX() && y == zombie.getY()) {
                                    System.out.print("  " + zombie + piece);
                                    break outerloop;
                                } else if (j-- == 0) System.out.print("   ▎" + piece);
                            }
                        } else {
                            System.out.print(" " + piece);
                            break;
                        }
                    } else if (i-- == 0) {
                        System.out.print(" \uD83D\uDD33");
                    }
                }
            }

            //print player
            if (y == player.getY()) System.out.print(" " + player + " ");
            else System.out.print("   ");

            //print right
            for (int x = 1; x <= 10; x++) {
                int i = pieces.size() - 1;
                outerloop2:
                for (Positionable piece : pieces) {
                    if (x == piece.getX() && y == piece.getY()) {
                        if (piece instanceof Barricade) {
                            if (Zombie.zombies.size() == 0) {
                                System.out.print(piece + "▎   ");
                                break;
                            }
                            int j = Zombie.zombies.size() - 1;
                            for (Zombie zombie : Zombie.zombies) {
                                if (x == zombie.getX() && y == zombie.getY()) {
                                    System.out.print(piece.toString() + zombie + "  ");
                                    break outerloop2;
                                } else if (j-- == 0) System.out.print(piece + "▎   ");
                            }
                        } else {
                            System.out.print(piece + " ");
                            break;
                        }
                    } else if (i-- == 0) {
                        System.out.print("\uD83D\uDD33 ");
                    }
                }
            }

            System.out.println();
        }
    }
}
