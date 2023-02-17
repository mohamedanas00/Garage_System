package Garage;
//First Fit selection where the first slot with big enough dimension to host the vehicle will
//be selected
public class FirstFitSelection implements ISelection {
    @Override
    public void Selection(Vehicle car,ParkingareaENT park) {
     Slot[][] slots =park.getSlots();
        boolean check = false;
        int x=0;
        int y=0;

        for (int i = 0; i < park.floor; i++) {
            for (int j = 0; j <park.nSlots; j++) {
                x=i;
                y=j;
                if (car.getLength() <= slots[i][j].getDepth() && car.getWidth() <= slots[i][j].getWidth() && slots[i][j].GetSituationOfSlot()) {
                    check = true;
                    park.BookSlot(i,j,car,true);
                    break;
                }
            }
            if (check) {
              break;
            }
        }
      if(!check){  park.BookSlot(x,y,car,false);
         }
    }
}
