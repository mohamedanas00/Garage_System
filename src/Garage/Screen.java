package Garage;

import java.util.Scanner;

public class Screen {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);


        int choice;
        boolean test = true;
        do {
            try {
                System.out.println("    Welcome to our garage  ");
                System.out.print("Enter number of floors: ");
                int floor = Integer.parseInt(scanner.nextLine());
                System.out.print("Enter number of slots : ");
                IBuilder Obj= new AreaBuild();
                int s = Integer.parseInt(scanner.nextLine());

                GarageCTRL ctrl = new GarageCTRL(floor,s,Obj);
                System.out.println();

                while (true) {
                    do {

                        try {


                            System.out.println("Enter your choice");

                            System.out.println("1.View garage park.");
                            System.out.println("2.view Dimensions of slots.");
                            System.out.println("3.view all available slots for car.");
                            System.out.println("4.Book slot.");
                            System.out.println("5.find My car place.");
                            System.out.println("6.leave garage.");
                            System.out.println("7.Garage Total Income.");
                            System.out.println("8.Exit.");

                            choice = Integer.parseInt(scanner.nextLine());
                            System.out.println();
                            if (choice == 1) {
                                ctrl.ViewParkingArea();
                                System.out.println();
                            }
                            if (choice == 2) {
                                ctrl.DisplayDimensions();
                                System.out.println();
                            }
                            if (choice == 3) {

                                boolean check = true;
                                do {


                                    try {

                                        System.out.println("First,Please enter information of your car");
                                        System.out.print("your car width:");
                                        int width = Integer.parseInt(scanner.nextLine());
                                        if (width > 200 || width < 120) {
                                            System.out.println("our suitable width range from 120-200 try again:");
                                            System.out.println();
                                            break;
                                        }

                                        System.out.print("your car length:");
                                        int length = Integer.parseInt(scanner.nextLine());
                                        if (length > 300 || length < 200 || length <= width) {
                                            System.out.println("our suitable depth range from 120-300 and bigger than your width try booking again:");
                                            System.out.println();
                                            break;
                                        }
                                        ctrl.DisplayAvailableSlot(width, length);
                                        check = false;
                                        System.out.println();

                                    } catch (NumberFormatException e) {
                                        System.out.println("you enter wrong data please try again");
                                    }
                                } while (check);

                            }
                            if (choice == 4) {
                                if (ctrl.ShowAvailableSlot() != 0) {
                                    boolean check = true;
                                    do {


                                        try {

                                            System.out.println("First,Please enter information of your car");
                                            System.out.print("vehicle model name:");
                                            String modelName = scanner.nextLine();
                                            System.out.print("Vehicle model year:");
                                            int modelYear = Integer.parseInt(scanner.nextLine());
                                            System.out.print("Unique identification number:");
                                            int ui = Integer.parseInt(scanner.nextLine());
                                            System.out.print("Vehicle owner phone:");
                                            int phone = Integer.parseInt(scanner.nextLine());
                                            System.out.print("vehicle owner mail:");
                                            String mail = scanner.nextLine();
                                            System.out.print("your car width:");
                                            int width = Integer.parseInt(scanner.nextLine());
                                            if (width > 200 || width < 120) {
                                                System.out.println("our suitable width range from 120-200 try again:");
                                                System.out.println();
                                                break;
                                            }

                                            System.out.print("your car length:");
                                            int length = Integer.parseInt(scanner.nextLine());
                                            if (length > 300 || length < 200 || length <= width) {
                                                System.out.println("our suitable depth range from 120-300 and bigger than your width try booking again:");
                                                System.out.println();
                                                break;
                                            }
                                            check = false;
                                            System.out.println();
                                            do {
                                                ISelection Object = null;
                                                System.out.print("Enter away of select 1.BestFitSelection - 2.FirstFitSelection:");
                                                int x = Integer.parseInt(scanner.nextLine());
                                                if (x == 1) {
                                                    Object = new BestFitSelection();
                                                    ctrl.ParkIn(modelName, modelYear, ui, phone, mail, width, length, Object);
                                                     break;
                                                } else if(x==2) {
                                                    Object = new FirstFitSelection();
                                                    ctrl.ParkIn(modelName, modelYear, ui, phone, mail, width, length, Object);
                                                    break;
                                                }
                                            } while (true);
                                        } catch (NumberFormatException e) {
                                            System.out.println("you enter wrong data please try again");
                                        }
                                    } while (check);
                                } else {
                                    System.out.println("oh!sorry garage is full");
                                }

                            }
                            if (choice == 5) {
                                System.out.print("Enter unique identification number of your car:");
                                int carId = Integer.parseInt(scanner.nextLine());
                                ctrl.Find_MYVehicle(carId);
                                System.out.println();
                            }
                            if (choice == 6) {
                                System.out.print("Enter unique identification number of your car:");
                                int carId = Integer.parseInt(scanner.nextLine());
                                System.out.print("Would you like us to send you the detailed parking receipt via email or SMS?\n" +
                                        "For SMS press 1 \n" +
                                        "For Email press 2");
                                boolean bool=false;
                                int y = Integer.parseInt(scanner.nextLine());
                                if (y == 1) {
                                     bool = ctrl.ParkOut(carId, new CashPayment(),new SMS());

                                } else if (y == 2) {
                                    bool = ctrl.ParkOut(carId, new CashPayment(),new Mail());
                                }
                                if (bool==false) {
                                    System.out.println("your car is not found please check your unique identification number again.");
                                }
                                System.out.println();
                            }
                            if (choice == 7) {
                                System.out.print("Garage Total Income:");
                                System.out.println(ctrl.DisplayTotalIncome() + " EGP");
                                System.out.println();
                            }

                            if (choice == 8) {
                                System.out.println("THANKS...");
                                test = false;

                                break;
                            }

                        } catch (NumberFormatException e) {
                            System.out.println("you enter wrong data please try again");
                        }
                        if (!test) {
                            break;
                        }
                    } while (true);
                    if (!test) {
                        break;
                    }
                }
            } catch (NumberFormatException e) {
                System.out.println("you enter wrong data please try again");
            }
            if (!test) {
                break;
            }
        } while (true);

    }
}


