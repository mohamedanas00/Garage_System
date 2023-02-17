package Garage;

public interface IBuilder {
    void build(int floor,int slots);
    Slot[][] getSlot();
}
