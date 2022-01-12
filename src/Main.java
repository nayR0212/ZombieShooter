import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        Game Game = new Game();

        Game.pieces.add(Game.player);

        for (int i = 1; i <= 5; i++) {
            Game.pieces.add(new Barricade(1, i));
            Game.pieces.add(new Barricade(-1, i));
        }
        Game.pieces.add(new RunningZombie(10, 3));
        Game.pieces.add(new WalkingZombie(-5, 3));

        Game.pieces.add(new WalkingZombie(3, 4));


        while (true) {
            System.out.println(Game.pieces.toString());

            Game.checkDead();
            Collections.sort(Zombie.zombies, Game.Compare_xPos);
            Game.board.updateBoard(Game.pieces, Game.player);
            Game.moveAll();


        }
    }
}
