import java.util.ArrayList;

public class TestBarricade {

    public static void main(String[] args) {
        Barricade b = new Barricade(0,0);
        new Barricade(0,1);
        ArrayList<Barricade> t = Barricade.barricades;

        //testing barricades were added to the list
        System.out.print("Barricades added?");
        if(t.size() == 2) System.out.println(" -- pass");
        else System.out.println(" -- fail -- \tgot: "+t.size()+"\texpected: 2");

        //testing damage and print @full - maybe getHealth
        b.damage(17);
        System.out.print("damage Barricade b for 17 points");
        if(b.getHealth() == 83) System.out.println(" -- pass");
        else System.out.println(" -- fail -- \tgot: "+b.getHealth()+"\texpected: 83");

        System.out.print("Barricade print @ full");
        if(b.toString().charAt(0) == '█') System.out.println(" -- pass");
        else System.out.println(" -- fail -- \tgot: "+b+"\texpected: █");

        //testing set health and print @little damage
        b.setHealth(70);
        System.out.print("set Barricade health to 70");
        if(b.getHealth() == 70) System.out.println(" -- pass");
        else System.out.println(" -- fail -- \tgot: "+b.getHealth()+"\texpected: 70");

        System.out.print("Barricade print @ little damage");
        if(b.toString().charAt(0) == '▓') System.out.println(" -- pass");
        else System.out.println(" -- fail -- \tgot: "+b+"\texpected: ▓");

        //testing max health
        System.out.print("get Barricade max health");
        if(b.getMaxHealth() == 100) System.out.println(" -- pass");
        else System.out.println(" -- fail -- \tgot: "+b.getMaxHealth()+"\texpected: 100");

        //testing print @ some damage
        b.setHealth(40);
        System.out.print("Barricade print @ some damage");
        if(b.toString().charAt(0) == '▒') System.out.println(" -- pass");
        else System.out.println(" -- fail -- \tgot: "+b+"\texpected: ▒");

        //testing print @ heavy damage
        b.setHealth(15);
        System.out.print("Barricade print @ heavy damage");
        if(b.toString().charAt(0) == '░') System.out.println(" -- pass");
        else System.out.println(" -- fail -- \tgot: "+b+"\texpected: ░");

        //testing isAlive (T/F) and print @ broken
        System.out.print("is Barricade alive test");
        if(b.isAlive()) System.out.println(" -- pass");
        else System.out.println(" -- fail -- \tgot: "+b.isAlive()+"\texpected: true");

        b.damage(20);
        System.out.print("Barricade print @ broken");
        if(b.toString().charAt(0) == '▯') System.out.println(" -- pass");
        else System.out.println(" -- fail -- \tgot: "+b+"\texpected: ▯");

        System.out.print("is Barricade not alive test");
        if(!b.isAlive()) System.out.println(" -- pass");
        else System.out.println(" -- fail -- \tgot: "+b.isAlive()+"\texpected: false");

        //testing positions
        int[] xTests = {0,0};
        int[] yTests = {0,1};
        for(int i=0; i<t.size(); i++) {
            Barricade tb = t.get(i);
            System.out.print("x position of Barricade @ index "+i);
            if(tb.getX()==xTests[i]) System.out.println(" -- pass");
            else System.out.println(" -- fail -- \tgot: "+tb.getX()+"\texpected: "+xTests[i]);
        }
        for(int i=0; i<t.size(); i++) {
            Barricade tb = t.get(i);
            System.out.print("y position of Barricade @ index "+i);
            if(tb.getY()==yTests[i]) System.out.println(" -- pass");
            else System.out.println(" -- fail -- \tgot: "+tb.getY()+"\texpected: "+yTests[i]);
        }

        //haven't test Barricade's ID
    }




}
