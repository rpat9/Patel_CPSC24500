package EmailerProgram;

import java.util.Scanner;
import java.util.ArrayList;

/**
 * This is the main proram which utilized two other classes and their functions
 * as help.
 */

// FOR ME:
/*
 * prints the welcome banner, repeatedly prints the menu until the user decides
 * to quit, and responds to the user's selection,
 * including warning the user when they enter an invalid option.
 * 
 * The program successfully interviews the user for details about an
 * email and then creates an Email object and adds it to an ArrayList of them.
 * 
 * The program prints the details of all the emails as shown in the sample
 * output. It calls EmailPrinter’s function for writing to
 * the screen to accomplish this.
 * 
 * The program tells all the Email objects to send() so that their send status
 * switches to true when the user elects to send them.
 */

public class EmailApp {

  private static ArrayList<Email> ems = new ArrayList<Email>();

  public static void printWelcome() {
    System.out.println("*".repeat(80));
    System.out.println("                              Emailer Version 1.0");
    System.out.println("*".repeat(80));

  }

  public static void printChoices() {
    System.out.println("\nHere are your choices: ");
    System.out.println("1. Write email\n2. List emails\n3. Send emails\n4. Save emails to file\n5. Exit");
    System.out.print("Enter the number of your choice: ");
  }

  public static void getEmailList() {
    System.out.println("Here are your emails:");
    for (Email em : ems) {
      System.out.printf("\n%-15s%s,%s", "To:", em.getRecipient1(), em.getRecipient2());
      System.out.printf("\n%-15s%s", "Subject:", em.getSubject());
      System.out.printf("\n%-15s%s", "Status:", em.getStatus());
      System.out.printf("\n%-15s\n%s\n", "Body:", em.getBody());
    }
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    printWelcome();

    int choice;
    String r1, r2, sub, bod, file;

    while (true) {

      // Getting a valid user choice
      printChoices();
      try {
        choice = sc.nextInt();

        if (choice > 5 || choice <= 0) {
          System.out.println("Please enter a valid number. Try again.");
          continue;
        }

      } catch (Exception e) {
        System.out.println("Please enter a number. Try again.");
        sc.nextLine();
        continue;
      }

      // Making valid choices
      if (choice == 5) {
        System.out.println("\nThank you for using this program!");
        break;

      } else if (choice == 1) {
        System.out.print("Enter the recipients' email: ");
        r1 = sc.next();
        r2 = sc.nextLine();
        System.out.print("Enter the subject: ");
        sub = sc.nextLine();
        System.out.print("Enter the body: ");
        bod = sc.nextLine();

        ems.add(new Email(r1, r2, sub, bod));

      } else if (choice == 2) {
        getEmailList();

      } else if (choice == 3) {
        for (Email em : ems) {
          em.send();
        }
        System.out.println("All emails have been sent.");

      } else if (choice == 4) {
        sc.nextLine();
        System.out.print("Enter the name of the file to save: ");
        file = sc.nextLine();

        for (Email em : ems) {
          EmailPrinter.writeToFile(file, em);
        }
      }

    }
    sc.close();
  }
}
