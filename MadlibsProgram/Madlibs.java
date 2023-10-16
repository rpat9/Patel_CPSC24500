package MadlibsProgram;

import java.util.Scanner;
import java.io.File;
import java.util.ArrayList;
import java.util.LinkedHashMap;

public class Madlibs {

  private static LinkedHashMap<String, ArrayList<String>> words = new LinkedHashMap<String, ArrayList<String>>();

  public static void printWelcome() {
    System.out.println(); // Empty line to seperate the start of the program from other stuff.
    System.out.println("*".repeat(60));
    System.out.println("*\t\t   Welcome to Madlibs V1.0\t\t   *");
    System.out.println("*".repeat(60));
  }

  public static void readWordsFile(String fileName, String key) {
    ArrayList<String> wordsArrayList = new ArrayList<String>();

    try {
      String line;
      Scanner fsc = new Scanner(new File(fileName));

      while (fsc.hasNextLine()) {
        line = fsc.nextLine().trim();
        wordsArrayList.add(line);
      }

      words.put(key, wordsArrayList);

    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public static void main(String[] args) {
    printWelcome();
  }
}