package Payday;

import java.util.Scanner;
import java.util.Random;

public class Payday {

  private static double numOfHours;
  private static double hourlyPayRate;
  private static boolean isUnionMember = false; // Assume the person isn't a union member.
  private static double unionDuesPercent = 0.05; // For this problem, this is a constant value.
  private static double medicalDeductionPercent;

  public static void main(String[] args) {

    // Making Objects
    Scanner scan = new Scanner(System.in);
    Random rand = new Random();

    double incidentPay = 200 * rand.nextDouble(); // Calculates incidentPay upto $200.
    int addOrSubtract = 1 + rand.nextInt(2); // If 1 then, add. If 2, then subtract.

    System.out.println("**************************************************");
    System.out.printf("%30s", "Payday V1.0\n");
    System.out.println("**************************************************\n");

    System.out.print("Enter name: ");
    String name = scan.nextLine(); // Getting name from the user.

    System.out.print("Enter hours worked: ");
    numOfHours = scan.nextDouble(); // Getting hours worked for the user.

    System.out.print("Enter hourly pay rate: ");
    hourlyPayRate = scan.nextDouble(); // Getting the hourly pay rate for the user.

    scan.nextLine(); // Fixes the end of line issue. Inputs below can now be stored.

    System.out.print("Are you a union member (y or n)? ");
    String union = scan.nextLine(); // Finding out if the person is a union member.

    if (union.equalsIgnoreCase("y")) {
      isUnionMember = true; // Accounts for the case where the user types uppercase.
    }

    System.out.print("What percentage do you want to withold for your medical savings account? ");
    medicalDeductionPercent = scan.nextDouble(); // Getting input for medical deduction.
    medicalDeductionPercent /= 100; // Turning it into a decimal value for easier calculations.

    System.out.println("\n---------PAYCHECK---------");

    double grossPay = hourlyPayRate * numOfHours;
    System.out.printf("%.2f", grossPay);

    scan.close();
  }

}