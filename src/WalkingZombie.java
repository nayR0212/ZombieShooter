public class WalkingZombie extends Zombie {
    WalkingZombie(int _x, int _y) {
        super(_x, _y, 6, 6, 1);
    }

    public void preMove() {
        if (!isShot()) {
            if (xPos <= -2) {
                xNxt = xPos + 1;
                yNxt = yPos;
            } else if (xPos >= 2) {
                xNxt = xPos - 1;
                yNxt = yPos;
            }

        } else shot -= 1;
    }

    public String toString() {
        if (!isShot()) return "\uD83C\uDD86";
        else return "/\uD83C\uDD86";
    }
}
