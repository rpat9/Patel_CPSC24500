package EmailerProgram;

import java.util.Scanner;

public class EmailApp {

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

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    printWelcome();

    int choice;
    String r1, r2, body, subject;

    while (true) {

      printChoices();

      try {
        choice = sc.nextInt();
      } catch (Exception e) {
        System.out.println("You must enter a valid integer. Try again.");
        sc.nextLine();
        continue;
      }

      if (choice == 5) {

        System.out.println("\nThank you for using this program.");
        break;

      } else if (choice == 1) {

        System.out.print("Enter recepients' email: ");
        r1 = sc.next();
        r2 = sc.nextLine();
        System.out.print("Enter subject: ");
        subject = sc.nextLine();
        System.out.print("Enter body: ");
        body = sc.nextLine();

      }

    }

    sc.close();
  }
}
