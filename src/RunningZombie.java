public class RunningZombie extends Zombie {
    RunningZombie(int _x, int _y) {
        super(_x, _y, 3, 3, 2);
    }

    public void preMove() {
        if (!isShot()) {
            if (-10 <= xPos && xPos <= -3) {
                xNxt = xPos + 2;
                yNxt = yPos;
            } else if (3 <= xPos && xPos <= 10) {
                xNxt = xPos - 2;
                yNxt = yPos;
            } else if (xPos == 2) {
                xNxt = xPos - 1;
                yNxt = yPos;
            } else if (xPos == -2) {
                xNxt = xPos + 1;
                yNxt = yPos;
            }
        } else shot -= 1;
    }

    public String toString() {
        if (!isShot()) return "\uD83C\uDD81";
        else return "/\uD83C\uDD81";
    }
}
