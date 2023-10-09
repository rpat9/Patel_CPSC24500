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

  /**
   * This method calculates the number of vowels in a file.
   * 
   * @param fileName File that the user wants to check.
   * @return Returns the vowel count.
   */
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
        }
      }

    } catch (Exception e) {
      System.out.println("File is not found");
    }
    return vowelCount;
  }

  /**
   * This function finds the number of consonant letters in a file and returns it.
   * 
   * @param fileName File that the user wants to check.
   * @return Returns the consonants count.
   */
  public static int countConsonants(String fileName) {

    int consonantCount = 0;

    try {
      Scanner fsc = new Scanner(new File(fileName));

      String line;
      String allTogether = "";

      while (fsc.hasNextLine()) {
        line = fsc.nextLine().trim();
        allTogether = allTogether + line;
        allTogether = allTogether.toUpperCase();
      }

      fsc.close();

      for (int i = 0; i < allTogether.length(); i++) {
        if (allTogether.charAt(i) >= 'A' && allTogether.charAt(i) <= 'Z') {
          if (allTogether.charAt(i) != 'A' && allTogether.charAt(i) != 'E' && allTogether.charAt(i) != 'I'
              && allTogether.charAt(i) != 'O' && allTogether.charAt(i) != 'U') {
            consonantCount++;
          }
        }
      }

    } catch (Exception e) {
      System.out.println("File is not found");
    }
    return consonantCount;
  }

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    printWelcome();

    System.out.print("What file would you like to analyze? ");
    String fileName = scan.nextLine();

    int choice = 0;

    while (choice != 5) {
      printOptions();

      choice = scan.nextInt();
      if (choice > 5 || choice <= 0) {
        System.out.println("That is not a valid choice.");
        continue;
      } else if (choice == 1) {
        System.out.printf("There are %d vowels.", countVowels(fileName));
      } else if (choice == 2) {
        System.out.printf("There are %d consonants.", countConsonants(fileName));
      }

    }

    scan.close();
  }

}
