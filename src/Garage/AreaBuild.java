package Garage;

import java.util.Random;

public class AreaBuild implements IBuilder{
    private Slot[][] slots;

    @Override
    public void build(int floor, int slot) {
        slots = new Slot[floor][slot];
        Random rand = new Random();
        int minwidth = 120;
        int maxwidth = 200;
        int mindepth = 200;
        int maxdepth = 300;

        int assii = 65;
        char c;
        char x;
        int num = 48;
        boolean available = true;

        String nameOfSlot;
        for (int i = 0; i < floor; i++) {
            c = (char) assii;
            num = 48;
            for (int j = 0; j < slot; j++) {
                //Generate random int value
                int width = rand.nextInt ((maxwidth - minwidth) )+ minwidth;
                int depth = rand.nextInt(maxdepth - mindepth ) + mindepth;
                int sum=width+depth;
                int cost = 0;
                if(sum>320&&sum<350)
                {
                    cost=5;
                }
                if(sum>=350&&sum<380)
                {
                    cost=10;
                }
                if(sum>=380&&sum<400)
                {
                    cost=15;
                }
                if(sum>=400&&sum<430)
                {
                    cost=20;
                }
                if(sum>=430&&sum<=500)
                {
                    cost=25;
                }
                x = (char) num;
                nameOfSlot = String.valueOf(c);
                nameOfSlot += x + " ";
                slots[i][j] = new Slot(width, depth, nameOfSlot,cost);
                slots[i][j].setUnique_id(nameOfSlot);
                slots[i][j].setSituationOfSlot(available);
                num++;
            }
            assii++;
        }
    }

    @Override
    public Slot[][] getSlot() {
        return slots;
    }
}
