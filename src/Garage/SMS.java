package Garage;
import java.util.Date;

public class SMS implements  Imessage{
    Date EndDate;
    Date StartDate;
    int phone;
    int payment;
    @Override
    public void Create(int fees, ParkingareaENT park, int id) {
        Slot[][] slots =park.getSlots();
        boolean confirm=false;
        for (int i = 0; i < park.floor; i++) {
            for (int j = 0; j < park.nSlots; j++) {
                if(slots[i][j].getVehicle()!=null&&slots[i][j].getVehicle().getUnique_identification()==id)
                {
                    phone= slots[i][j].getVehicle().getPhone();
                    StartDate= slots[i][j].getVehicle().getTime().saveStartDate;
                    EndDate=slots[i][j].getVehicle().getTime().saveEndDate;
                    payment=fees;
                    confirm=true;
                    break;
                }
            }
            if(confirm)
            {break;}
        }

    }

    @Override
    public void DisplayMessage() {
        System.out.println("You have new SMS Notifications");
        System.out.println("   Garage ");
        System.out.println("Your Phone number:"+phone);
        System.out.println("YOU Enter Garage at:"+StartDate);
        System.out.println("You leave Garage at:"+EndDate);
        System.out.println("Your total Payment is:"+payment);


    }
}
