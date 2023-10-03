package TextAnalyzer;

import java.util.Scanner;
import java.io.File;

/**
 * This program asks the user for the file that they want to analyze and prints
 * out information that the user requests and quits when the user wants to.
 */

public class TextAnalyzer {

  private static int consonantCount = 0;

  /**
   * This method prints the welcome banner when the program is ran.
   */
  public static void printWelcome() {
    System.out.println("*".repeat(80));
    System.out.printf("%55s", "Welcome to my TextAnalyzer V1.0\n");
    System.out.println("*".repeat(80));
  }

  /**
   * This method prints the options that the user has in this program.
   */
  public static void printOptions() {
    System.out.println("\nHere are your options: ");
    System.out.println("1. Count the number of vowels.");
    System.out.println("2. Count the number of consonants.");
    System.out.println("3. Count the number of words.");
    System.out.println("4. Print a summary to a file.");
    System.out.println("5. Quit");
    System.out.print("Enter the number of your choice: ");
  }

  public static int countVowels(String fileName) {

    int vowelCount = 0;

    try {
      Scanner fsc = new Scanner(new File(fileName));

      String line;
      String allTogether = "";

      while (fsc.hasNextLine()) {
        line = fsc.nextLine();
        allTogether = allTogether + line + " ";
        allTogether = allTogether.trim().toLowerCase();
      }

      fsc.close();

      for (int i = 0; i < allTogether.length(); i++) {
        if (allTogether.charAt(i) == 'a' || allTogether.charAt(i) == 'e' || allTogether.charAt(i) == 'i'
            || allTogether.charAt(i) == 'o' || allTogether.charAt(i) == 'u') {
          vowelCount++;
        } else {
          consonantCount++;
        }
      }

    } catch (Exception e) {
      System.out.println("File is not found");
    }
    return vowelCount;
  }

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    printWelcome();

    System.out.print("What file would you like to analyze? ");
    String fileName = scan.nextLine();

    int choice = 0;

    while (choice != 5) {
      printOptions();

      /*
       * 
       * try {
       * choice = scan.nextInt();
       * 
       * if (choice == 1) {
       * System.out.printf("There are %d vowels.\n", countVowels(fileName));
       * } else if (choice == 2) {
       * countVowels(fileName);
       * System.out.printf("There are %d consonants.\n", consonantCount);
       * 
       * } else if (choice == 3) {
       * 
       * } else if (choice == 4) {
       * 
       * } else if (choice == 5) {
       * break;
       * } else {
       * System.out.println("That is not a valid choice.");
       * continue;
       * }
       * 
       * } catch (Exception e) {
       * System.out.
       * println("You have to enter the number of your choice. You didn't type a number."
       * );
       * continue;
       * }
       */
    }

    scan.close();
  }

}
