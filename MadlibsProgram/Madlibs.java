package MadlibsProgram;

import java.util.Scanner;
import java.io.File;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Random;

public class Madlibs {

  private static LinkedHashMap<String, ArrayList<String>> words = new LinkedHashMap<String, ArrayList<String>>();
  private static ArrayList<String> story1 = new ArrayList<String>();
  private static ArrayList<String> story2 = new ArrayList<String>();
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

  /**
   * This function stores the files with words into a linked hash map with a
   * unique key.
   * 
   * @param folder   The folder in which the files are located.
   * @param fileName The filename in which a particular set of words are in.
   * @param key      A short unique key that identifies the type of words that are
   *                 in the file.
   * @return Returns true or false whether or not the task was done successfully.
   */
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

  /**
   * This function makes arraylists for stories and stores sentences.
   * 
   * @param folder   The folder in which the files are stored.
   * @param fileName The name of the story file.
   * @return Returns a true of false value whether or not the task was done
   *         successfully.
   */
  public static boolean loadStories(String folder, String fileName) {
    try {
      Scanner fsc = new Scanner(new File(folder, fileName));
      String line;

      while (fsc.hasNextLine()) {
        line = fsc.nextLine();
        if (fileName.equals("story1.txt")) {
          story1.add(line);
        } else {
          story2.add(line);
        }
      }

      return true;

    } catch (Exception e) {
      return false;
    }
  }

  /**
   * This function randomly chooses a word given a category.
   * 
   * @param key The type of word needed to be generated.
   * @return Returns a randomly generated word.
   */
  public static String generateRandomWord(String key) {
    rnd = new Random();
    int random = rnd.nextInt(words.get(key).size());
    return words.get(key).get(random);
  }

  /**
   * This function does all the dirty work of replacing placeholders from the
   * story to actual words.
   * 
   * @param storyNumber The story number in which the words want to be replaced.
   * @return Returns an arraylist with replaced sentences from the story chosen.
   */
  public static ArrayList<String> replaceStoryWords(int storyNumber) {
    ArrayList<String> temp;
    String line;

    if (storyNumber == 1) {
      temp = new ArrayList<String>(story1);

      line = temp.get(0);
      line = line.replace("<adj>", generateRandomWord("adj"));
      line = line.replaceFirst("<singnoun>", generateRandomWord("sgn"));
      line = line.replaceFirst("<pastverb>", generateRandomWord("psv"));
      line = line.replaceFirst("<singnoun>", generateRandomWord("sgn"));
      temp.set(0, line);

      line = temp.get(1);
      line = line.replaceFirst("<singnoun>", generateRandomWord("sgn"));
      line = line.replaceFirst("<adj>", generateRandomWord("adj"));
      line = line.replaceFirst("<adj>", generateRandomWord("adj"));
      line = line.replaceFirst("<singnoun>", generateRandomWord("adj"));
      temp.set(1, line);

      line = temp.get(2);
      line = line.replaceFirst("<plunoun>", generateRandomWord("pln"));
      line = line.replaceFirst("<pluverb>", generateRandomWord("plv"));
      line = line.replaceFirst("<adv>", generateRandomWord("adv"));
      line = line.replaceFirst("<pastverb>", generateRandomWord("psv"));
      temp.set(2, line);

      line = temp.get(3);
      line = line.replaceFirst("<singnoun>", generateRandomWord("sgn"));
      line = line.replaceFirst("<pastverb>", generateRandomWord("psv"));
      line = line.replaceFirst("<adj>", generateRandomWord("adj"));
      line = line.replaceFirst("<plunoun>", generateRandomWord("pln"));
      temp.set(3, line);

      line = temp.get(4);
      line = line.replaceFirst("<adj>", generateRandomWord("adj"));
      temp.set(4, line);

      line = temp.get(5);
      line = line.replaceFirst("<plunoun>", generateRandomWord("pln"));
      line = line.replaceFirst("<plunoun>", generateRandomWord("pln"));
      line = line.replaceFirst("<singnoun>", generateRandomWord("sgn"));
      temp.set(5, line);

      line = temp.get(6);
      line = line.replaceFirst("<adv>", generateRandomWord("adv"));
      temp.set(6, line);

      return temp;

    } else {
      temp = new ArrayList<String>(story2);

      line = temp.get(0);
      line = line.replaceFirst("<pastverb>", generateRandomWord("psv"));
      line = line.replaceFirst("<singnoun>", generateRandomWord("sgn"));
      temp.set(0, line);

      line = temp.get(1);
      line = line.replaceFirst("<singnoun>", generateRandomWord("sgn"));
      line = line.replaceFirst("<pluverb>", generateRandomWord("plv"));
      line = line.replaceFirst("<plunoun>", generateRandomWord("pln"));
      temp.set(1, line);

      line = temp.get(2);
      line = line.replaceFirst("<pluverb>", generateRandomWord("plv"));
      line = line.replaceFirst("<plunoun>", generateRandomWord("pln"));
      line = line.replaceFirst("<pluverb>", generateRandomWord("plv"));
      line = line.replaceFirst("<plunoun>", generateRandomWord("pln"));
      temp.set(2, line);

      line = temp.get(3);
      line = line.replaceFirst("<adv>", generateRandomWord("adv"));
      line = line.replaceFirst("<pastverb>", generateRandomWord("psv"));
      line = line.replaceFirst("<singnoun>", generateRandomWord("sgn"));
      temp.set(3, line);

      line = temp.get(4);
      line = line.replaceFirst("<pluverb>", generateRandomWord("plv"));
      line = line.replaceFirst("<adj>", generateRandomWord("adj"));
      line = line.replaceFirst("<singnoun>", generateRandomWord("sgn"));
      line = line.replaceFirst("<pluverb>", generateRandomWord("plv"));
      temp.set(4, line);

      line = temp.get(5);
      line = line.replaceFirst("<adj>", generateRandomWord("adj"));
      line = line.replaceFirst("<pastverb>", generateRandomWord("psv"));
      line = line.replaceFirst("<singnoun>", generateRandomWord("sgn"));
      temp.set(5, line);

      return temp;
    }
  }

  public static void main(String[] args) {

    Scanner scan = new Scanner(System.in);
    rnd = new Random();

    printWelcome();

    System.out.println("\nThis program generates random stories using wordlists you supply.");

    System.out.print(
        "\nEnter the name of the folder where the stories and wordlists are. Or just press Enter to accept the default location: ");

    String folder = scan.nextLine();

    boolean a = loadHashMap(folder, "adj.txt", "adj");
    boolean b = loadHashMap(folder, "adv.txt", "adv");
    boolean c = loadHashMap(folder, "pastverb.txt", "psv");
    boolean d = loadHashMap(folder, "plunoun.txt", "pln");
    boolean e = loadHashMap(folder, "pluverb.txt", "plv");
    boolean f = loadHashMap(folder, "singnoun.txt", "sgn");
    boolean g = loadHashMap(folder, "singverb.txt", "sgv"); // Just testing out my ideas.

    if (!(a && b && c && d && e && f && g)) {
      System.exit(1); // You can't continue forward if 1 or more files fail to load.
    }

    boolean story1Success = loadStories(folder, "story1.txt");
    boolean story2Success = loadStories(folder, "story2.txt");

    if (!(story1Success && story2Success)) {
      System.exit(1); // You can't continue if 1 or more stories fail to load.
    }

    String choice;
    ArrayList<String> result;

    while (true) {
      System.out.print("\nEnter a story number or q to quit: ");
      choice = scan.nextLine();

      if (choice.equals("q")) {
        System.out.println("\nThank you for using this program.");
        break;
      }

      try {

        if (Integer.parseInt(choice) == 1) {
          result = new ArrayList<String>(replaceStoryWords(1));
          System.out.println("\nHere is your Madlib: \n");

          for (String sentence : result) {
            System.out.print(sentence + " ");
          }

          System.out.println(); // New line

        } else if (Integer.parseInt(choice) == 2) {
          result = new ArrayList<String>(replaceStoryWords(2));
          System.out.println("\nHere is your Madlib: \n");

          for (String sentence : result) {
            System.out.print(sentence + " ");
          }

          System.out.println(); // New line

        } else {
          System.out.println("\nThat story does not exist. Choose again.");
        }

      } catch (Exception E) {
        System.out.println("\nThat story does not exist. Choose again.");
        continue;
      }

    }
    scan.close();
  }
}