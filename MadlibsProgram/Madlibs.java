package MadlibsProgram;

import java.util.Scanner;
import java.io.File;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Random;

public class Madlibs {

  private static LinkedHashMap<String, ArrayList<String>> words = new LinkedHashMap<String, ArrayList<String>>();
  private static Random rnd;

  /**
   * This method prints a centered welcome banner when the program starts running.
   */
  public static void printWelcome() {
    System.out.println(); // Empty line to seperate the start of the program from other stuff.
    System.out.println("*".repeat(60));
    System.out.println("*\t\t  Welcome to Madlibs V1.0\t\t   *");
    System.out.println("*".repeat(60));
  }

  public static boolean loadHashMap(String folder, String fileName, String key) {
    ArrayList<String> wordsArrayList = new ArrayList<String>();

    try {
      String line;
      Scanner fsc = new Scanner(new File(folder, fileName));

      while (fsc.hasNextLine()) {
        line = fsc.nextLine().trim();
        wordsArrayList.add(line);
      }

      words.put(key, wordsArrayList);

      return true;

    } catch (Exception e) {
      return false;
    }
  }

  public static void main(String[] args) {

    Scanner scan = new Scanner(System.in);
    rnd = new Random();

    printWelcome();

    System.out.println("\nThis program generates random stories using wordlists you supply.");

    System.out.print(
        "\nEnter the name of the folder where the stories and wordlists are. Or just press Enter to accept the default location:");

    String folder = scan.nextLine();

    boolean a = loadHashMap(folder, "adj.txt", "adj");
    boolean b = loadHashMap(folder, "adv.txt", "adv");
    boolean c = loadHashMap(folder, "pastverb.txt", "psv");
    boolean d = loadHashMap(folder, "plunoun.txt", "pln");
    boolean e = loadHashMap(folder, "pluverb.txt", "plv");
    boolean f = loadHashMap(folder, "singnoun.txt", "sgn");
    boolean g = loadHashMap(folder, "singverb.txt", "sgv"); // Just testing out my ideas.

  }
}