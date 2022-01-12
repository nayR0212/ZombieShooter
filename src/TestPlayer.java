/*
public class TestPlayer {

    public static void main(String[] args) {
        Player p = new Player(0, 3);
        Damageable d = new Damageable() {
            int MAX = 8;
            int CURR = MAX;

            public int getHealth() { return CURR;}
            public int getMaxHealth() { return MAX;}
            public void setHealth(int _health) { CURR = _health;}
            public void damage(int _value) { CURR -= _value;}
            public boolean isAlive() { return CURR>0;}
        };

        //testing player getMethods (accessors)
        System.out.print("testing getX()");
        if(p.getX() == 0) System.out.println(" -- pass");
        else System.out.println(" -- fail -- \tgot: "+p.getX()+"\texpected: 0");

        System.out.print("testing getY()");
        if(p.getY() == 3) System.out.println(" -- pass");
        else System.out.println(" -- fail -- \tgot: "+p.getY()+"\texpected: 3");

        //testing player setMethods (mutators)
        System.out.print("testing setX() ");
        p.setX(-2);
        if(p.getX() == -2) System.out.println(" -- pass");
        else System.out.println(" -- fail -- \tgot: "+p.getX()+"\texpected: -2");

        System.out.print("testing setY() ");
        p.setY(4);
        if(p.getY() == 4) System.out.println(" -- pass");
        else System.out.println(" -- fail -- \tgot: "+p.getY()+"\texpected: 4");

        //testing addTarget and attack()
        System.out.println("adding d as target");
        p.addTarget(d);

        System.out.print("testing attack");
        p.attack();
        if(d.getHealth() == d.getMaxHealth()-5) System.out.println(" -- pass"); //5 is the weapon damage
        else System.out.println(" -- fail -- \tgot: "+d.getHealth()+" \texpected: "+(d.getMaxHealth() - 5));

    }

}
*/
