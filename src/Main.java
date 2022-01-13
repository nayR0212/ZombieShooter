import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        Game game = new Game();

        game.pieces.add(game.player);

        for (int i = 1; i <= 5; i++) {
            game.pieces.add(new Barricade(1, i));
            game.pieces.add(new Barricade(-1, i));
        }
        //game doesn't work if a zombie isn't added here
        game.pieces.add(new RunningZombie(10, 3));

        int score = 0;
        while (game.gameActive()) {
            score++;

            game.spawnZombie();

            Collections.sort(Zombie.zombies, Game.Compare_xPos);
            game.board.updateBoard(game.pieces, game.player);
            game.moveAll();
            game.checkDead();

        }

        System.out.println("You lose!");
        System.out.println("Score: " + score);
    }
}
