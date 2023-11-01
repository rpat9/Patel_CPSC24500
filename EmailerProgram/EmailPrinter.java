package EmailerProgram;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class EmailPrinter {

  public static void writeToFile(String fileName, Email em) {
    try {
      PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(new File(fileName))));
      pw.println(em);

    } catch (IOException e) {

    }
  }

}
