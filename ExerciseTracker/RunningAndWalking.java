package ExerciseTracker;

public class RunningAndWalking extends Exercise {

  private double miles;

  public double getDistance() {
    return miles;
  }

  public void setDistance(double mi) {
    miles = mi;
  }

  @Override
  public double calculateCalories() {
    double distByDuration = miles; // Change this

    return 0; // CHANGE THIS
  }

  @Override
  public String getType() {
    return "Running and Walking"; // MAY HAVE TO CHANGE THIS
  }

  @Override
  public String toString() {
    return ""; // CHANGE THIS
  }

}
