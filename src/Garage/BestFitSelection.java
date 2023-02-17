package Garage;
//Best Fit selection where the slot with the best dimension match should be used where
//the wasting area of the slot is minimized.
public class BestFitSelection implements ISelection {
    @Override
    public void Selection(Vehicle car,ParkingareaENT park) {
        Slot[][] slots =park.getSlots();
        int minimize;
        int lastMinimize=10000000;
        boolean check = false;
        int x = 0,z=0;
        for (int i = 0; i < park.floor; i++) {
            for (int j = 0; j <park.nSlots; j++) {
                //هنا انا طول مالمني اصغر من القبلها  يبقي ده المكان الاحسن وبيخليه يلف لحد ما يلاقي الاحسن منه
                if (car.getLength() <= slots[i][j].getDepth() && car.getWidth() <= slots[i][j].getWidth() && slots[i][j].GetSituationOfSlot()) {
                    minimize=(slots[i][j].getDepth()-car.getLength())+(slots[i][j].getWidth()-car.getWidth());
                    if (lastMinimize>minimize) {
                        lastMinimize=minimize;
                        x=i;
                        z=j;
                        check=true;
                    }
                }

            }
        }
        park.BookSlot(x,z, car, check);
    }
}
