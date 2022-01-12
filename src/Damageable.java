public interface Damageable {
    int getHealth();

    int getMaxHealth();

    void setHealth(int _health);

    void damage(int _value);

    boolean isAlive();
}
