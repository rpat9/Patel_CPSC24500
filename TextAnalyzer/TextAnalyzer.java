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
        System.out.println("File is not found.");
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
      System.out.println("File is not found.");
    }
    return consonantCount;
  }

  
  /**
   * This method calculates how many words there are in a given file.
   * @param fileName File that the user wants to check.
   * @return Returns the word count.
   */
  public static int countWords(String fileName){
    int count = 0;
  
    try{
      Scanner fsc = new Scanner(new File(fileName));

      String line;
      String allTogether = "";

      while (fsc.hasNextLine()) {
        line = fsc.nextLine();
        allTogether = allTogether + line + " ";
      }

      fsc.close();

      for (char a : allTogether.toCharArray()){
        if(a == ' '){
          count++;
        }
      }

      return count;

    } catch (Exception e) {
      System.out.println("File not found.");
      
    }
    return 0;
  }


  /**
   * This method writes to a summary of the file to another file, both names are given by the user.
   * @param fileName The file that contains that text to summarize.
   * @param outputFileName The file that the method writes to and prints summary.
   * @return returns true of false whether the task was done or not.
   */
  public static Boolean writeToFile(String fileName, String outputFileName){
    
    String line;

    try{
      Scanner fsc = new Scanner(new File(fileName));
      PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(new File(outputFileName))));

      while(fsc.hasNextLine()){
        line = fsc.nextLine() + " ";
        pw.print(line);
      }

      pw.println("\n\nThere are " + countVowels(fileName) + " vowels, " + countConsonants(fileName) + " consonants, and " + countWords(fileName) + " words.");

      fsc.close();
      pw.close();

    } catch (Exception e){
      System.out.println("The summary was not written to the file. ");
      return false;
    }

    return true;
  }


  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    printWelcome();

    System.out.print("What file would you like to analyze? ");
    String fileName = scan.nextLine();

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

        } else if (choice == 3){

          System.out.printf("There are %d words.\n", countWords(fileName));

        } else if (choice == 4){

          System.out.print("Enter the name of the file to write the summary: ");
          String outputFile = scan.nextLine();

          if(writeToFile(fileName, outputFile)){
            System.out.println("The summary was written to a file.");
          } else {
            System.out.println("The summary was not written to a file.");
          }

        }

      } catch (Exception e) {
        System.out.println("You have to enter the number of your choice. You didn't type a number.");
        scan.nextLine(); //Need to use this to clear the stream otherwise the program crashes by printing options infnite times.
      }
      
    }
    scan.close();
  }
}
