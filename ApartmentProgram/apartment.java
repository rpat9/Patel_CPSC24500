package ApartmentProgram;

 /*
  Rudra Patel, CPSC24500, MWF 11-11:50am.

  Started this program on 9/6.

  This program is designed to calculate the amount of paint and primer needed
  to paint the apartment.
  */

public class apartment {

  private static double longWallWidth = 32.75;
  private static double narrowWallWidth = 25.62;
  private static int ceilingHeight = 10;
  private static double windowHeight = 5.5;
  private static double windowWidth = 14.4;
  private static int doorHeight = 8;
  private static double doorWidth = 3.25;
  private static int numOfUnits = 8;
  private static int paintCoverage = 400;
  private static int primerCoverage = 300;
  private static double paintCostPerGallon = 34.99;
  private static double primerCostPerGallon = 24.49;

  public static void main(String[] args) {

    // Calculations for the first wall at the entrance and the other long wall
    double windowArea = windowHeight * windowWidth;
    double doorArea = doorWidth * doorHeight;
    double windowAndDoor = windowArea + doorArea;
    double firstWallArea = (longWallWidth * ceilingHeight) - windowAndDoor;

    double firstAndOtherWallArea = firstWallArea + (longWallWidth * ceilingHeight);

    // Calculations for the narrow walls
    double narrowWallsArea = 2 * (narrowWallWidth * ceilingHeight);

    //Wall area per unit
    double wallAreaPerUnit = firstAndOtherWallArea + narrowWallsArea;

    // Calculations for ceiling area
    double celiingArea = longWallWidth * narrowWallWidth;

    // Total wall area for # of units
    double totalWallArea = wallAreaPerUnit * numOfUnits;
    double totalCeilingArea = celiingArea * numOfUnits;

    double totalArea = totalCeilingArea + totalWallArea;

    // Calculating the number of gallons needed
    double gallonsOfPaint = Math.ceil(totalArea/paintCoverage);
    double gallonsOfPrimer = Math.ceil(totalArea/primerCoverage);

    //Total Cost
    double paintCost = Math.ceil(gallonsOfPaint) * paintCostPerGallon;
    double primerCost = Math.ceil(gallonsOfPrimer) * primerCostPerGallon;

    double totalCost = paintCost + primerCost;

    //Printing Details
    System.out.println("**********************************************************");

    System.out.printf("%-35s%10.2f\n","Wall area per unit", wallAreaPerUnit);
    System.out.printf("%-35s%10.2f\n","Celing area per unit", celiingArea);
    System.out.printf("%-35s%10.2f\n", "Total area to paint and prime", totalArea);

    System.out.printf("\nYou must purchase %d gallons of paint for $%.2f.\n", (int)gallonsOfPaint, paintCost);
    System.out.printf("You must purchase %d gallons of primer for $%.2f.\n", (int)gallonsOfPrimer, primerCost);

    System.out.printf("\nYour total cost to paint and prime all units is $%.2f.\n", totalCost);

    System.out.println("**********************************************************");

  }

}