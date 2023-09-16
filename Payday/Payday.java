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

    //Calculating and printing gross pay.
    double grossPay = hourlyPayRate * numOfHours;
    System.out.printf("%-15s $%8.2f\n", "Gross Pay", grossPay); 

    //Calculating and printing union dues, if any.
    double unionMoney = grossPay*unionDuesPercent;

    if(isUnionMember) {
      System.out.printf("%-15s $%8.2f\n", "Union Dues", unionMoney);
    } else System.out.printf("%-15s $%8.2f\n", "Union Dues", 0.00);

    //Calculating medical deduction if person desires.
    double medDeduction = grossPay*medicalDeductionPercent;
    System.out.printf("%-15s $%8.2f\n", "Med Deduction", medDeduction);

    //Calculating incident dues, whether to add or subtract.
    if(addOrSubtract==1){
      System.out.printf("%-15s $%8.2f\n", "Incident Pay", incidentPay);
    } else System.out.printf("%-15s $%8.2f\n", "Incident Pay", incidentPay*-1.0);

    //Determining tax rate.
    double taxRate = 0;

    if(grossPay>=2500){
      taxRate = 0.25;
    } else if (grossPay >= 1500 && grossPay < 2500){
      taxRate = 0.15;
    } else if (grossPay >= 500 && grossPay < 1500){
      taxRate = 0.1;
    } else taxRate = 0.05;

    //Calculations for Net Pay.
    double netPay = grossPay;

    if(addOrSubtract==1){netPay+=incidentPay;}else{netPay-=incidentPay;} //Adds or subtracts incident pay randomly.

    double grossAndIncidentTotal = netPay;

    if(isUnionMember){
      netPay-=unionMoney; //Only subtracts from gross pay if union member.
      grossAndIncidentTotal-=unionMoney; //Deduction for taxes.
    } 

    netPay-=medDeduction; //Medical deduction.

    double taxes = (grossAndIncidentTotal-medDeduction)*taxRate; //Calculating taxes.
    netPay-=taxes;

    System.out.printf("%-15s $%8.2f\n", "Taxes", taxes);
    System.out.printf("%-15s $%8.2f\n", "Net Pay", netPay);
    System.out.println("--------------------------");
    
    System.out.printf("Prepared for %s\n", name);
    System.out.println("\nThank you for using this program.");

    scan.close();
  }

}