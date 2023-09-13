package Payday;

import java.util.Scanner;
import java.util.Random;

public class Payday {

  private static double numOfHours;
  private static double hourlyPayRate;
  private static boolean isUnionMember;
  private static double unionDuesPercent = 0.05;
  private static double medicalDeductionPercent;

  public static void main(String[] args) {

    // Making Objects
    Scanner scan = new Scanner(System.in);
    Random rand = new Random();

    double incidentPay = 200 * rand.nextDouble(); // Calculates incidentPay upto $200.
    int addOrSubtract = 1 + rand.nextInt(2); // If 1 then, add. If 2, then subtract.

    System.out.println("**************************************************");
    System.out.println("********************");

    scan.close();
  }

}