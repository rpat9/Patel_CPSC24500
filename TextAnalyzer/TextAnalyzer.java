package TextAnalyzer;

import java.util.Scanner;
import java.io.File;

/**
 * This program asks the user for the file that they want to analyze and prints
 * out information that the user requests and quits when the user wants to.
 */

public class TextAnalyzer {

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

  // static int countVowels(String fileName)

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    printWelcome();

    System.out.print("What file would you like to analyze? ");
    String fileName = scan.nextLine();

    int choice;

    do {
      printOptions();
      choice = scan.nextInt();

    } while (choice != 5);

    scan.close();
  }

}
