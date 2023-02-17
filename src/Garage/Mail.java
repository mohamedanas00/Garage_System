package Garage;
import java.util.Date;
public class Mail implements Imessage{
    String From="Parking Area";
    String To;
    Date EndDate;
    Date StartDate;
    int payment;

    @Override
    public void Create(int fees, ParkingareaENT park, int id) {
        Slot[][] slots =park.getSlots();
        boolean confirm=false;
        for (int i = 0; i < park.floor; i++) {
            for (int j = 0; j < park.nSlots; j++) {
                if(slots[i][j].getVehicle()!=null&&slots[i][j].getVehicle().getUnique_identification()==id)
                {
                   To= slots[i][j].getVehicle().getMail();
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
    public void DisplayMessage(){
        System.out.println("You have new Mail Notifications");
        System.out.println("From:"+From);
        System.out.println("To:"+To);
        System.out.println("YOU Enter Garage at:"+StartDate);
        System.out.println("You leave Garage at:"+EndDate);
        System.out.println("Your total Payment is:"+payment);
    }
}
