package ExerciseTracker;

/**
  This abstract class acts as a parent class which contains the basic structure of an exercise.
*/

import java.util.Date;
import java.text.SimpleDateFormat;

public abstract class Exercise implements Comparable<Exercise> {

  private String name;
  private String comment;
  private double duration;
  private SimpleDateFormat df = new SimpleDateFormat("MM/dd/yyyy"); // Used to convert back and forth between date and strings.
  private Date date;

  /**
   * Generic Exericse with null or 0 for varaibles.
   */
  public Exercise() {
    name = "";
    comment = "";
    duration = 0;
  }

  /**
   * Specific Exercise that takes in several key things to store.
   * @param duration The duration of the workout in minutes.
   * @param comment The comment that user made about the workout.
   * @param name The name that the user chose for the workout.
   * @param dateStr The String version of date that the user had the workout.
   */
  public Exercise(double duration, String comment, String name, String dateStr) {
    this.duration = duration;
    this.comment = comment;
    this.name = name;
    try {
      date = df.parse(dateStr);
    } catch (Exception e) {
      date = new Date(); // Sets the excerise date to today if user's date fails/
    }
  }

  /**
   * This method gives access to the date in object form.
   * @return Returns the date in object form.
   */
  public Date getDate() {
    return date;
  }

  /**
   * This method gives access to the date in String form.
   * @return Returns the date in String form.
   */
  public String getDateString() {
    return df.format(date);
  }

  /**
   * This method changes the date object to a new date given.
   * @param d The new date.
   */
  public void setDate(Date d){
    date = d;
  }

  /**
   * This method returns the name of the workout that the user had made
   * @return Name of the workout.
   */
  public String getName() {
    return name;
  }

  /**
   * This method returns the comment that the user made about the workout.
   * @return Comment about the workout.
   */
  public String getComment() {
    return comment;
  }

  /**
   * This method returns the duration that the user had their workout for.
   * @return Duration of the workout.
   */
  public double getDuration() {
    return duration;
  }

  /**
   * This method compares exercises by their date.
   * @param other Other Exerise that is compared.
   * @return Integer indicating if the date is less, greater or equal to the date of the other Exercise.
   */
  @Override
  public int compareTo(Exercise other) {
    return date.compareTo(other.getDate());
  }

  /**
   * This abstract method calculates calories, which will be used in subclasses.
   * @return The calories burned
   */
  public abstract double calculateCalories();

  /**
   * This abstract method gives access to the string representation of the Exercise object.
   * @return The string representation
   */
  public abstract String toString();

  /**
   * This abstract method gives access to the type of Exercise.
   * @return The type of Exericse.
   */
  public abstract String getType();
}