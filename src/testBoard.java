/* import java.util.ArrayList;

public class testBoard {

    Positionable[][] board = new Positionable[5][21];
    ArrayList<Zombie> ZombieArray = Zombie.zombies;
    ArrayList<Barricade> BarricadeArray = Barricade.barricades;

    public static void main(String[] args) {

        Barricade a = new Barricade(10, 1);
        Barricade b = new Barricade(10, 2);
        Barricade c = new Barricade(10, 3);
        Barricade d = new Barricade(10, 4);
        Barricade e = new Barricade(10, 5);

        Barricade aa = new Barricade(12, 1);
        Barricade bb = new Barricade(12, 2);
        Barricade cc = new Barricade(12, 3);
        Barricade dd = new Barricade(12, 4);
        Barricade ee = new Barricade(12, 5);

        Player p = new Player(12, 3);
        ArrayList<Barricade> t = Barricade.barricades;

        System.out.println("");

        for (int y = 5; y >= 1; y--) {
            String out1 = new String();
            String out2 = new String();
            String out3 = new String();

            System.out.print(y);
            for (int x = 1; x <= 10; x++) {
                if (x == t.get(y - 1).getX() && y == t.get(y - 1).getY()) {
                    out1 += (" ▏" + t.get(y - 1).toString());
                } else out1 += " \uD83D\uDD33";
            }
            for (int x = 11; x <= 12; x++) {
                if (x == p.getX()&& y == p.getY()){
                    out2 += p.toString();
                } else out2 += " ";
            }
            for (int x = 12; x <= 21; x++) {
                //out3+="k";
                if (x == t.get(y - 1 +5).getX() && y == t.get(y - 1 +5).getY()) {
                    out3 += (" "+t.get(y - 1 +5).toString()+"▏");
                } else out3 += (" \uD83D\uDD33");
            }

            System.out.println(out1+out2+out3+" "+y);

        }
    }
}

*/