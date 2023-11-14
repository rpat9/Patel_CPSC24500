package ExerciseTracker;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

public class ExerciseApp {

  public static void printMenu(){
    System.out.println("*".repeat(80));
    System.out.println("                             EXERCISE TRACKER V1.0");
    System.out.println("*".repeat(80));
  }

  public static void printOptions(){
    System.out.println("\nThese are your choices:\n1. Add an exercise\n2. Print exercises to file\n3. List sorted by date\n4. List sorted by calories burned\n5. Exit");
    System.out.print("Enter the number of your choice: ");
  }
  public static void main(String[] args) {
    
    Scanner scan = new Scanner(System.in);
    ArrayList<Exercise> es = new ArrayList<Exercise>();

    printMenu();

    int choice, weightLiftedInPounds, heightOfWall, timesClimbed;
    double userDistance, userDuration;
    String userExercise, userExerciseWorkoutName, userComment, userDate;

    while(true){
    
      printOptions();
      try{
        choice = scan.nextInt();
      } catch (Exception e){
        System.out.println("You need to enter an integer. Try again.");
        scan.nextLine();
        continue;
      }

      if(choice < 0 || choice > 5){
        System.out.println("Please enter a valid number. Try again.");
        continue;

      } else if (choice == 5){
        break;

      } else if (choice == 1){
        scan.nextLine();
        System.out.print("Enter R for run/walk, W for weightlifting, or C for rock climbing: ");
        userExercise = scan.nextLine().toLowerCase();

        System.out.print("Enter a name for the workout: ");
        userExerciseWorkoutName = scan.nextLine();

        System.out.print("Enter date of workout: ");
        userDate = scan.nextLine();

        System.out.print("How long did you workout in minutes: ");
        userDuration = scan.nextDouble();

        if(userExercise.equals("r")){
          System.out.print("Enter the distance you ran or walked in miles: ");
          userDistance = scan.nextDouble();
          scan.nextLine(); //clears the stream

          System.out.print("Enter a comment about the workout: ");
          userComment = scan.nextLine();

          es.add(new RunningAndWalking(userDuration, userComment, userExerciseWorkoutName, userDate, userDistance));

        } else if (userExercise.equals("w")){
          System.out.print("Enter the total weight lifted in pounds: ");
          weightLiftedInPounds = scan.nextInt();
          scan.nextLine(); //clears the stream

          System.out.print("Enter a comment about the workout: ");
          userComment = scan.nextLine();

          es.add(new Weightlifting(userDuration, userComment, userExerciseWorkoutName, userDate, weightLiftedInPounds));

        } else if (userExercise.equals("c")){
          System.out.print("Enter the height of the wall in feet: ");
          heightOfWall = scan.nextInt();

          System.out.print("Enter number of times you climbed it: ");
          timesClimbed = scan.nextInt();
          scan.nextLine(); //clears the stream

          System.out.print("Enter a comment about the workout: ");
          userComment = scan.nextLine();

          es.add(new Rockclimbing(userDuration, userComment, userExerciseWorkoutName, userDate, heightOfWall, timesClimbed));

        }

      } else if (choice == 2){
        scan.nextLine(); //clears the stream
        System.out.println("Enter the name of the file to save: ");
        String fileName = scan.nextLine();

        if(WriteExercisesToFile.writeToFile(es, fileName)){
          System.out.println("Your exercises were written to the file.");
        } else{
          System.out.println("Your exercises were not written to the file");
        }

      } else if (choice == 3){
        Collections.sort(es);

        for(Exercise e : es){
          System.out.println(e);
        }

      } else if (choice == 4){

        Collections.sort(es, new CompareExercisesByCalories());
        for(Exercise e : es){
          System.out.println(e);
        }

      }

    }
    scan.close();
  }
}
