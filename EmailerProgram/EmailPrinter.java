package EmailerProgram;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 * This program is used to store all the emails created by the user into a
 * seperate file. The program will
 * utilize information from the Email class, and the EmailApp class.
 */

public class EmailPrinter {

  /**
   * This method stores all the emails created into a file.
   * 
   * @param fileName The name of the file where the user wants to store data.
   * @param ems      An arraylist of emails that the user created to be stored.
   */
  public static void writeToFile(String fileName, ArrayList<Email> ems) {
    try {
      PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(new File(fileName))));

      for (Email em : ems) {
        pw.println(em);
      }
      pw.close();
      System.out.println("Emails were saved successfully.");

    } catch (Exception e) {
      System.out.println("There was a problem saving emails to the file.");
    }
  }

}