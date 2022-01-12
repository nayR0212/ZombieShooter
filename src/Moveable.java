public interface Moveable {
    void preMove();

    void unMove();

    void move();

    void setX(int _x);

    void setY(int _y);

    int getNxtX();

    int getNxtY();
}
