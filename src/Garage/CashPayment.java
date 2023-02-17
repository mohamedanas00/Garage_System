package Garage;

public class CashPayment implements IPayment {
    private int TotalPayment;
    @Override
    public int CalculateFees(int id, ParkingareaENT park) {

        Slot[][] slots =park.getSlots();
        boolean confirm=false;
        for (int i = 0; i < park.floor; i++) {
            for (int j = 0; j < park.nSlots; j++) {
                if (!slots[i][j].GetSituationOfSlot()&&slots[i][j].getVehicle().getUnique_identification()==id) {
                        Vehicle car=slots[i][j].getVehicle();
                        Duration time=car.getTime();
                        time.setEndTime();
                        int t= time.getTotalTime();
                        TotalPayment=t*slots[i][j].getSlotCost();
                        confirm=true;
                        break;
                }
            }
            if(confirm)
            {break;}
        }
        return TotalPayment;
    }
}


