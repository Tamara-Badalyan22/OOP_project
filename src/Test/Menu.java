package Test;

import model.SmartPhone;
import services.SmartPhoneService;

import java.sql.SQLOutput;
import java.util.Scanner;

public class Menu {
    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        SmartPhoneService service = new SmartPhoneService();

        System.out.println("Please enter file Name : ");
        String path = s.next();

        System.out.println("***_Menu_***");
        System.out.println("1.Add phone");
        System.out.println("2.Print all phones");
        System.out.println("3.Maximum Price ");
        System.out.println("4.Cheapest phone");
        System.out.println("5.Order By Price");
        System.out.println("6.Exit");

        boolean isActive = true;
        while (isActive) {
            System.out.println("Enter number");

            int   number = s.nextInt();
            switch (number) {
                case 1:
                    service.addPhoneIntoFile(path);
                    System.out.println("Added");
                    break;
                case 2:
                    service.printInfoOfPhones(service.readFromFile(path));
                    break;
                case 3:
                    SmartPhone[] phones = service.readFromFile(path);
                    System.out.println("Max price is : " + service.maxPrice(phones));
                    System.out.println("************");
                    break;
                case 4:
                    service.printInfoOfPhone(service.cheapestPhone(service.readFromFile(path)));
                    System.out.println("************");
                    break;
                case 5:
                    service.orderByPrice(service.readFromFile(path));
                    System.out.println("************");
                    break;
                case 6:
                    System.out.println("---Exit---");
                    System.out.println("************");
                    isActive=false;
                    break;
                default:
                    System.out.println("Invalid input,please enter again!!");
            }
        }
    }
}
