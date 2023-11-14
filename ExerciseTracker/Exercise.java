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

  public Exercise() {
    name = "";
    comment = "";
    duration = 0;
  }

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

  public Date getDate() {
    return date;
  }

  public String getDateString() {
    return df.format(date);
  }

  public void setDate(Date d){
    date = d;
  }

  public String getName() {
    return name;
  }

  public String getComment() {
    return comment;
  }

  public double getDuration() {
    return duration;
  }

  @Override
  public int compareTo(Exercise other) {
    return date.compareTo(other.getDate());
  }

  public abstract double calculateCalories();

  public abstract String toString();

  public abstract String getType();

  // public abstract double getCaloriesBurned();

}