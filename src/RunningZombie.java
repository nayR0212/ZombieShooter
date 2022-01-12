public class RunningZombie extends Zombie {
    RunningZombie(int _x, int _y) {
        super(_x, _y, 3, 3, 2);
    }

    public void preMove() {
        if (!isShot()) {
            if (xPos <= -3) {
                xNxt = xPos + 2;
                yNxt = yPos;
            } else if (xPos >= 3) {
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
