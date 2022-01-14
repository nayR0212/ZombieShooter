import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        Game game = new Game();

        game.pieces.add(game.player);

        for (int i = 1; i <= 5; i++) {
            game.pieces.add(new Barricade(1, i));
            game.pieces.add(new Barricade(-1, i));
        }

        while (game.gameActive()) {
            game.spawnZombie();

            Collections.sort(Zombie.zombies, Game.Compare_xPos);
            game.moveAll();
            game.zombieAttack();

        }
    }
}