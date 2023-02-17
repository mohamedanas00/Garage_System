package Garage;

public class Vehicle implements IObserver{
   private String model_name;
   private int Model_year;
   private int unique_identification;
   private int width;
   private int length;
   private int phone;
   private String mail;
   private Duration Time=new Duration();

  

    public Vehicle(String model_name, int model_year, int unique_identification, int phone,String mail,int width, int length) {
        this.model_name = model_name;
        Model_year = model_year;
        this.unique_identification = unique_identification;
        this.phone=phone;
        this.mail=mail;
        this.width = width;
        this.length = length;
        Time.setStartTime();
    }

    public Vehicle() {}

    public void setModel_name(String model_name) {
        this.model_name = model_name;
    }

    public void setModel_year(int model_year) {
        Model_year = model_year;
    }

    public void setUnique_identification(int unique_identification) {
        this.unique_identification = unique_identification;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public void setTime(Duration time) {
        Time = time;
    }

    public String getModel_name() {
        return model_name;
    }

    public int getModel_year() {
        return Model_year;
    }

    public int getUnique_identification() {
        return unique_identification;
    }

    public int getWidth() {
        return width;
    }

    public int getLength() {
        return length;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public  void printInfo()
    {
        System.out.println("model_name:"+getModel_name()+" - model_year:"+getModel_year()+" - Unique_identification:"+getUnique_identification()+" - Width:"+getWidth()+"cm - Length"+getLength()+"cm");
        System.out.println("Your Phone:"+getPhone()+" - Your Mail:"+getMail());
    }

    public Duration getTime() {
        return Time;
    }



    @Override
    public void Updat(Imessage imessage) {
        imessage.DisplayMessage();
    }
}

