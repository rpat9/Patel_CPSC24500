package ExerciseTracker;

/**
  This abstract class acts as a parent class which contains the basic structure of an exercise.
*/

import java.util.Date;
import java.text.SimpleDateFormat;

public abstract class Exercise implements Comparable<Exercise> {

  private String name;
  private String comment;
  private int duration;
  private SimpleDateFormat df = new SimpleDateFormat("MM/dd/yyyy");;
  private Date date;

  public Exercise() {
    name = "";
    name = "";
    comment = "";
    duration = 0;
  }

  public Exercise(double cal, int du, String comm, String name) {
    this.duration = du;
    this.comment = comm;
    this.name = name;
  }

  public Date getDate() {
    return date;
  }

  public String getExerciseName() {
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

  public abstract Exercise getType();

  public abstract double getCaloriesBurned();

}