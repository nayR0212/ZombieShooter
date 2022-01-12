public class Main {
    public static void main(String[] args) {
        Game game = new Game();

        game.pieces.add(game.player);

        for (int i = 1; i <= 5; i++) {
            game.pieces.add(new Barricade(1, i));
            game.pieces.add(new Barricade(-1, i));
        }
        game.pieces.add(new RunningZombie(10, 3));
        game.pieces.add(new WalkingZombie(-5, 3));

        game.pieces.add(new WalkingZombie(3, 4));
        game.spawnZombie();


        while (true) {
            for(Zombie zombie : Zombie.zombies) {
                System.out.print(zombie.getX());
                System.out.print(" "+ zombie.getY());
                System.out.println();
            }

            game.checkDead();
            Zombie.zombies.sort(Game.Compare_xPos);
            game.board.updateBoard(game.pieces, game.player);
            game.moveAll();


        }
    }
}
