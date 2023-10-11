package TextAnalyzer;

import java.util.Scanner;
import java.io.File;

import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.PrintWriter;

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
  public static void printMenu() {
    System.out.println("\nHere are your options: ");
    System.out.println("1. Count the number of vowels.");
    System.out.println("2. Count the number of consonants.");
    System.out.println("3. Count the number of words.");
    System.out.println("4. Print a summary to a file.");
    System.out.println("5. Quit");
    System.out.print("Enter the number of your choice: ");
  }

  /**
   * This method reads the file and returns the contents of the file as a String.
   * 
   * @param fileName The file that the user inputs.
   * @return Returns a string or null whether or not the file was read.
   */
  public static String readFile(String fileName) {
    try {
      Scanner fsc = new Scanner(new File(fileName));
      String line;
      String allTogether = "";
      while (fsc.hasNextLine()) {
        line = fsc.nextLine();
        allTogether = allTogether + line + " ";
      }
      fsc.close();
      return allTogether;

    } catch (Exception e) {
      return null;
    }
  }

  /**
   * This method calculates the number of vowels in a file.
   * 
   * @param fileName File that the user wants to check.
   * @return Returns the vowel count.
   */
  public static int countVowels(String fileName) {
    int vowelCount = 0;

    String allTogether = readFile(fileName).toLowerCase();

    for (int i = 0; i < allTogether.length(); i++) {
      if (allTogether.charAt(i) == 'a' || allTogether.charAt(i) == 'e' || allTogether.charAt(i) == 'i'
          || allTogether.charAt(i) == 'o' || allTogether.charAt(i) == 'u') {
        vowelCount++;
      }
    }

    return vowelCount;
  }

  /**
   * This method finds the number of consonant letters in a file.
   * 
   * @param fileName File that the user wants to check.
   * @return Returns the consonants count.
   */
  public static int countConsonants(String fileName) {

    int consonantCount = 0;
    String allTogether = readFile(fileName).toUpperCase();

    for (int i = 0; i < allTogether.length(); i++) {
      if (allTogether.charAt(i) >= 'A' && allTogether.charAt(i) <= 'Z') {
        if (allTogether.charAt(i) != 'A' && allTogether.charAt(i) != 'E' && allTogether.charAt(i) != 'I'
            && allTogether.charAt(i) != 'O' && allTogether.charAt(i) != 'U') {
          consonantCount++;
        }
      }
    }
    return consonantCount;
  }

  /**
   * This method calculates how many words there are in a given file.
   * 
   * @param fileName File that the user wants to check.
   * @return Returns the word count.
   */
  public static int countWords(String fileName) {
    int count = 0;
    String allTogether = readFile(fileName);

    for (char a : allTogether.toCharArray()) {
      if (a == ' ') {
        count++;
      }
    }
    return count;
  }

  /**
   * This method writes to a summary of the file to another file, both names are
   * given by the user.
   * 
   * @param fileName       The file that contains that text to summarize.
   * @param outputFileName The file that the method writes to and prints summary.
   * @return returns true of false whether the task was done or not.
   */
  public static Boolean writeToFile(String fileName, String outputFileName) {

    String allTogether = readFile(fileName);

    try {
      PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(new File(outputFileName))));

      pw.print(allTogether);
      pw.println("\n\nThere are " + countVowels(fileName) + " vowels, " + countConsonants(fileName)
          + " consonants, and " + countWords(fileName) + " words.");

      pw.close();
      return true;

    } catch (Exception e) {
      return false;
    }
  }

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    printWelcome();

    System.out.print("What file would you like to analyze? ");
    String fileName = scan.nextLine();

    boolean allGood = false;
    while (!allGood) {

      if (readFile(fileName) == null) {
        System.out.println("There was an error reading the file");
        System.out.print("What file would you like to analyze? ");
        fileName = scan.nextLine();
      } else {
        break;
      }
    }

    int choice = 0;

    while (choice != 5) {

      try {
        printMenu();
        choice = scan.nextInt();
        scan.nextLine();

        if (choice > 5 || choice <= 0) {
          System.out.println("That is not a valid choice.");
          continue;

        } else if (choice == 1) {

          System.out.printf("There are %d vowels.\n", countVowels(fileName));

        } else if (choice == 2) {

          System.out.printf("There are %d consonants.\n", countConsonants(fileName));

        } else if (choice == 3) {

          System.out.printf("There are %d words.\n", countWords(fileName));

        } else if (choice == 4) {

          System.out.print("Enter the name of the file to write the summary: ");
          String outputFile = scan.nextLine();

          if (writeToFile(fileName, outputFile)) {
            System.out.println("The summary was written to a file.");
          } else {
            System.out.println("The summary was not written to a file.");
          }

        }

      } catch (Exception e) {
        System.out.println("You have to enter the number of your choice. You didn't type a number.");
        scan.nextLine(); // Need to use this to clear the stream otherwise the program crashes by printing options infnite times.
      }

    }
    System.out.println("\nThank you for using this program.");
    scan.close();
  }
}