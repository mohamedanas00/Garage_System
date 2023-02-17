package Garage;
import java.util.Date;
public class Duration {
Date current ;
Date saveEndDate;
Date saveStartDate;
private int totalHours;

    public Date getSaveEndDate() {
        return saveEndDate;
    }

    public Date getSaveStartDate() {
        return saveStartDate;
    }

    public void setEndTime() {
        current = new Date();
        saveEndDate = current;
    }

    public void setStartTime() {
            current = new Date();
            saveStartDate = current;
   }

    public int getTotalTime() {
        long diffMs = saveEndDate.getTime() - saveStartDate.getTime();
        long diffSec = diffMs / 1000;
        long difMin = diffSec / 60;

        totalHours = (int) difMin / 60;

        // check if there is a remainder
        if (difMin % 60 != 0) {
            totalHours++;
        }

        return totalHours ;
    }
}
