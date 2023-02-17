package Garage;

public class Slot {
   private int width;
   private int depth;
   private String unique_id;
   private Vehicle vehicle;
   private boolean SituationOfSlot;
   private int SlotCost;


    public Slot() { vehicle=new Vehicle();
    }

    public Slot(int width, int depth, String unique_id,int slotCost) {
        this.width = width;
        this.depth = depth;
        this.unique_id = unique_id;
        vehicle=new Vehicle();
        this.SlotCost=slotCost;


    }


    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;

    }

    public boolean GetSituationOfSlot() {
        return SituationOfSlot;
    }

    public void setSituationOfSlot(boolean situationOfSlot) {
        SituationOfSlot = situationOfSlot;
    }

    public void setUnique_id(String unique_id) {
        this.unique_id = unique_id;
    }

    public int getWidth() {
        return width;
    }

    public int getDepth() {
        return depth;
    }

    public String getUnique_id() {
        return unique_id;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public int getSlotCost() {
        return SlotCost;
    }


}

