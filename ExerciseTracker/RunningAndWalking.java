package ExerciseTracker;

public class RunningAndWalking extends Exercise {

  private double miles;
  private double durationOfTheWorkout;
  String name;
  
  /**
   * The specific RunningAndWalking that takes in unique parameters.
   * @param duration The duration of the workout.
   * @param c The comment that the user made about the workout.
   * @param n The name that the user made about the workout.
   * @param d The duration of the workout.
   * @param milesRan The number of miles ran by the user in the workout.
   */
  public RunningAndWalking(double duration, String c, String n, String d, double milesRan){
    super(duration, c, n, d);
    miles = milesRan;
    this.name = n;
    durationOfTheWorkout = duration;
  }

  /**
   * This method sets the name of the workout.
   * @param name The name of the workout.
   */
  public void setName(String n){
    name = n;
  }

  /**
   * This method gives access to the name of the workout.
   * @return The name of the workout.
   */
  @Override
  public String getName(){
    return name;
  }

  /**
   * This method gives access to the distance ran or walked.
   * @return The distance ran or walked
   */
  public double getDistance() {
    return miles;
  }

  /**
   * This method sets the distance ran or walked.
   * @param mi The distance ran or walked.
   */
  public void setDistance(double mi) {
    miles = mi;
  }

  /**
   * This method gives access to the duration of the workout.
   * @return The duration of the workout.
   */
  @Override
  public double getDuration(){ 
    return durationOfTheWorkout;
  }

  /**
   * This method sets the duration.
   * @param durationOfTheWorkout The duration of the workout.
   */
  public void setDuration(int d){
    durationOfTheWorkout = d;
  }

   /**
    * This method gives access to the calories burned.
    * @return The calories burned.
    */
  @Override
  public double calculateCalories() {
    return (miles/getDuration())*9000;
  }

  /**
   * This method gives access to the type of workout.
   * @return The type of the workout.
   */
  @Override
  public String getType() {
    return "runwalk"; // MAY HAVE TO CHANGE THIS
  }

  /**
   * This method gives access to the String version of Rockclimbing Exercise.
   * @return String version of the RockClimbing Exercise.
   */
  @Override
  public String toString() {
    return getType() + "\t" + name + "\t" + super.getDateString() + "\t" + calculateCalories();
  }
}