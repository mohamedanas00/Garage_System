package Garage;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ParkingareaENT {
    private Slot[][] slots;
    private static ParkingareaENT park=null;
    int floor;
    int nSlots;

    public static ParkingareaENT getInstance(int Floor ,int s,IBuilder build ){
        if(park==null){
            park=new ParkingareaENT(Floor,s,build);
        }
        return park;
    }

    public Slot[][] getSlots() {
        return slots;
    }
    private ParkingareaENT(int Floor ,int s,IBuilder build) {
        build.build(Floor,s);
        slots= build.getSlot();
        floor=Floor;
        nSlots=s;
    }


    //Show available slots in garage that not have car
    public int GetAvailableSlot() {
        int count = 0;
        for (int i = 0; i < floor; i++) {
            for (int j = 0; j < nSlots; j++) {
                if (slots[i][j].GetSituationOfSlot()) {
                    count++;
                }
            }
        }
        return count;
    }

    //enter Unique_identification of your car return car information and it is place in park
    public void get_Vehicle(int id) {
        boolean confirm = false;
        for (int i = 0; i < floor; i++) {
            for (int j = 0; j < nSlots; j++) {
                if (!slots[i][j].GetSituationOfSlot()&&slots[i][j].getVehicle().getUnique_identification() == id) {
                    confirm = true;
                    System.out.print("your car is in slot:");
                    System.out.println(slots[i][j].getUnique_id());
                    System.out.print("your car info:");
                    slots[i][j].getVehicle().printInfo();
                    break;
                }
            }

        }
        if (!confirm) {
            System.out.println("your car is not found please try again");
        }

    }

    public void BookSlot(int x, int z, Vehicle car, boolean check) {
        if (check) {
            slots[x][z].setVehicle(car);
            slots[x][z].setSituationOfSlot(false);
            System.out.println("BOOKED successful");
            System.out.println("your suitable slot is in:"+slots[x][z].getUnique_id());
            System.out.println();
        } else {
            System.out.println("Sorry! no slot is suitable for your car");
        }
    }

    public void setAvailableSlot(int id) {
        for (int i = 0; i < floor; i++) {
            for (int j = 0; j < nSlots; j++) {
                if (!slots[i][j].GetSituationOfSlot() && slots[i][j].getVehicle().getUnique_identification() == id) {
                    slots[i][j].setSituationOfSlot(true);
                    slots[i][j].setVehicle(null);
                    break;
                }
            }
        }
    }

    public void GetDimensions() {
        for (int i = 0; i < floor; i++) {
            for (int j = 0; j < nSlots; j++) {
                System.out.print(slots[i][j].getUnique_id());
                System.out.print(slots[i][j].getWidth()+" "+slots[i][j].getDepth()+" "+"cost:"+slots[i][j].getSlotCost()+" EGP");
                System.out.print("  ");
            }
            System.out.println();
        }
    }
    //the view of all garage
    void ParkingArea() {
        for (int i = 0; i < floor; i++) {
            for (int j = 0; j < nSlots; j++) {

                System.out.print(slots[i][j].getUnique_id());
                if (slots[i][j].GetSituationOfSlot()) {
                    System.out.print(" " + "Green" + " ");
                } else {
                    System.out.print(" " + "Red  " + " ");
                }

            }
            System.out.println();
        }
    }


    public void AvailableParkingSlots(int width, int length)
    {
        int count=0;
        for (int i = 0; i < floor; i++) {
            for (int j = 0; j < nSlots; j++) {
                 if(length <= slots[i][j].getDepth() &&width <= slots[i][j].getWidth())
                 {
                     count++;
                     System.out.print(slots[i][j].getUnique_id());
                     System.out.print(slots[i][j].getWidth()+" "+slots[i][j].getDepth()+" "+"cost:"+slots[i][j].getSlotCost()+" EGP");
                     System.out.print("  ");
                 }
            }
            System.out.println();
        }
        System.out.println("Number of available slot is:"+count);
    }

}