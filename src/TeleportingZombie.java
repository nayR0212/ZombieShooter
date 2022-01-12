public class TeleportingZombie extends Zombie {
    TeleportingZombie(int _x, int _y) {
        super(_x, _y, 2, 2, 3);
    }

    public void preMove() {
        int random_int = (int) Math.floor(Math.random() * (5 - 1 + 1) + 1);
        if (xPos % 2 == 0 && xPos != 2) {
            xNxt = xPos / 2;
            yNxt = random_int;
        } else if (xPos % 2 != 0 && xPos != 2) {
            xNxt = (xPos * 3) + 1;
            yNxt = random_int;
        }
    }
    //odd 3x +1 | even x/2 | 1-20 x & 1-5 y

    public String toString() {
        if (!isShot()) return "\uD83C\uDD83";
        else return "/\uD83C\uDD83";
    }
}