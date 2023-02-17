package Garage;

import java.util.ArrayList;

public class GarageCTRL implements ISubject {
    private final ParkingareaENT park ;
    TotalIncome total = new TotalIncome();
    private ArrayList<IObserver> observers;



    int Fees;

    GarageCTRL(int floors,int _slots,IBuilder build) {
        park=ParkingareaENT.getInstance( floors,_slots,build);
       observers = new ArrayList<IObserver>();
    }

    public void ViewParkingArea() {
        park.ParkingArea();
    }

    //if user forget his/her car slot this function return the place
    public void Find_MYVehicle(int _id) {
        park.get_Vehicle(_id);
    }

    //return available slots that not car park in it.
    public int ShowAvailableSlot() {
        return park.GetAvailableSlot();
    }

    //park in garage and book best/first slot in it
    public void ParkIn(String modelName, int modelYear, int id, int phone, String mail, int width, int length, ISelection select) {
       Vehicle car=new Vehicle(modelName,modelYear, id,phone,mail,width,  length);
        Slot[][] arr = park.getSlots();
        for (Slot[] i:arr) {
            for (Slot j:i) {
                if(!j.GetSituationOfSlot()&&id==j.getVehicle().getUnique_identification()){
                    System.out.println("Your Unique_id is invalid");
                    System.out.println();
                    return;
                }
            }
        }
        select.Selection(car, park);
        AttachObserver(car);
    }
    //park out from garage and delete data of this vehicle &make slot available& add new income to garage entity &return fess
    public  boolean ParkOut(int available, IPayment payment,Imessage imessage) {
        boolean check=false;
        Fees = payment.CalculateFees(available, park);

        if(Fees>0) {
            imessage.Create(Fees,park,available);
            total.AddIncome(Fees);
            Slot[][] arr = park.getSlots();
            for (Slot[] i:arr) {
                for (Slot j:i) {
                    if(!j.GetSituationOfSlot()&&available==j.getVehicle().getUnique_identification()){
                            notifyObservers(imessage);
                            park.setAvailableSlot(available);
                            UnsubscribeObserver(j.getVehicle());
                            check=true;
                            break;
                    }
                }
                if (check){break;}
            }
        }
        return check;
    }

    public void DisplayDimensions() {
        park.GetDimensions();
    }


    public int DisplayTotalIncome() {
        return total.getSum();
    }
    public void DisplayAvailableSlot(int width, int length) {
        park.AvailableParkingSlots(width, length);
    }

    @Override
    public void AttachObserver(IObserver observer) {
        observers.add(observer);

    }

    @Override
    public void UnsubscribeObserver(IObserver observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers(Imessage imessage) {

        for(int i=0;i<observers.size();i++)
        {
            observers.get(i).Updat(imessage);
            break;
        }

    }
}


