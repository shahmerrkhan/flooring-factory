/**
 * Flooring Factory
 * A estimation tool for calculating flooring costs.
 * Calculates room area, allows selection from various flooring materials,
 * and generates a detailed quote including material costs, labour, and HST.
 * Supports multiple estimates and provides a grand total for all calculations.
 * * @author Muhammad Shahmeer Khan
 * @date 12 03 2026
 */



import java.io.*;
import java.util.Scanner;

public class FlooringFactory {
    
    static Scanner s = new Scanner(System.in);

    // function to ask for user input and calculate area of room
    public static double calculateArea() {
        
        
        // ask for length and width of room in meters + error trapped
        System.out.print("Enter the length of the room in meters: ");
        double length = s.nextDouble();
        while (true) {
            if (length <= 0) {
                System.out.println("Invalid input. Please enter a positive number.");
                System.out.print("Enter the length of the room in meters: ");
                length = s.nextDouble();
            } // end if
            
            else {
                break;
            } // end else
        } // end while

        System.out.print("Enter the width of the room in meters: ");
        double width = s.nextDouble();
        while (true) {
            if (width <= 0) {
                System.out.println("Invalid input. Please enter a positive number.");
                System.out.print("Enter the width of the room in meters: ");
                width = s.nextDouble();
            } // end if
            
            else {
                break;
            } // end else
        } // end while

        // calculate area
        double area = length * width;

        // display result
        System.out.println("The area of the room is: " + area + " square meters.");
        return area;
    } // end calculateArea

    // method to call the type of flooring needed based on area
    public static double typeOfFlooring(double area, String[] floor, double[] price) {

    System.out.println("\nPlease select the type of flooring you want:");
    System.out.println("#. Type of flooring         Cost per square meter:");

    for (int i = 0; i < floor.length; i++) {
        System.out.printf("%d. %-20s $ %.2f%n", (i + 1), floor[i], price[i]);
    }

    System.out.print("Enter your choice: ");
    int choice = s.nextInt();

    while (choice < 1 || choice > floor.length) {
        System.out.println("Invalid input. Please enter a number between 1 and " + floor.length + ".");
        System.out.print("Enter your choice: ");
        choice = s.nextInt();
    }

    System.out.println("\nYou have selected option " + choice + ".");
    return price[choice - 1];


    } // end typeOfFlooring
    public static void main(String[] args) throws IOException {
        
    BufferedReader in = new BufferedReader(new FileReader("floors.csv"));
    int num = Integer.parseInt(in.readLine()); // reads the number at the top

    String [] floor = new String[num];
    double [] price = new double[num];

    for (int i =  0; i < num; i++) {
        String text = in.readLine();
        text = text.trim();
        String[] data = text.split(",");
        floor[i] = data[0].trim();
        price[i] = Double.parseDouble(data[1].trim());
    }
    in.close();

        // Heading
        System.out.println("Welcome to the Flooring Factory!");
        System.out.println("Welcome to Fablous Frank’s! We aim to please, or at the very least, cover your floors!");
        System.out.println("This program will help you determine the cost for flooring.");
        System.out.println();
        
        // declare variables
        double area;
        double material_cost;
        double price_for_materials = 0;
        double labour_charge = 0;
        double subTotal = 0;
        double hst = 0;
        double total = 0;
        boolean keepGoing = true;
        double grandTotal = 0;

        while (keepGoing) {
        // call function to calculate area
        area = calculateArea();

        // call function to calculate material cost
        material_cost = typeOfFlooring(area, floor, price);

        // calculations 
        price_for_materials = material_cost * area;
        labour_charge = area * 6.50;
        subTotal = price_for_materials + labour_charge;
        hst = subTotal * 0.13; // 13 percent HST
        total = subTotal + hst;
        grandTotal += total;

        // display result
        System.out.println("\n-------------------------------------------");
        System.out.printf("%-20s %10.2f\n", "Material cost:", price_for_materials);
        System.out.printf("%-20s %10.2f\n", "Labour charge:", labour_charge);
        System.out.printf("%-20s %10s\n", "", "----------"); // Alignment line
        System.out.printf("%-20s %10.2f\n", "Sub-total:", subTotal);
        System.out.printf("%-20s %10.2f\n", "HST:", hst);
        System.out.printf("%-20s %10s\n", "", "----------"); // Alignment line
        System.out.printf("%-20s %10.2f\n", "TOTAL COST:", total);
        System.out.println("-------------------------------------------");
        System.out.println();

        // asking user again if they want to calculate another estimate
        System.out.print("Would you like to calculate another estimate? (Y/N): ");
        String answer = s.next();
        if (answer.equalsIgnoreCase("Y")) {
            System.out.println();
            keepGoing = true;
            continue;
        } // end if
        else if (answer.equalsIgnoreCase("N")) {
            keepGoing = false;
            break;
        } // end else if
        else {
            System.out.println("Invalid input. Please enter Y or N.");
            System.out.print("Would you like to calculate another estimate? (Y/N): ");
            answer = s.next();
        } // end else

    } // end while

    // Show grand total
    System.out.println();
    System.out.println("The grand total for all estimates is: $" + String.format("%.2f", grandTotal));

    // Closing message
    System.out.println();
    System.out.println("This estimate is valid for 30 days!");
    System.out.println("Thank you and have a nice day!");
    
} // end main
} // end class







