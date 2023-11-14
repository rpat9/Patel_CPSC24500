package ExerciseTracker;

public class RunningAndWalking extends Exercise {

  private double miles;
  private double durationOfTheWorkout;
  String name;
  

  public RunningAndWalking(double duration, String c, String n, String d, double milesRan){
    super(duration, c, n, d);
    miles = milesRan;
    this.name = n;
    durationOfTheWorkout = duration;
  }


  public void setName(String n){
    name = n;
  }

  @Override
  public String getName(){
    return name;
  }

  public double getDistance() {
    return miles;
  }

  public void setDistance(double mi) {
    miles = mi;
  }

  @Override
  public double getDuration(){ 
    return durationOfTheWorkout;
  }

  public void setDuration(int d){
    durationOfTheWorkout = d;
  }

  @Override
  public double calculateCalories() {
    return (miles/getDuration())*9000;
  }

  @Override
  public String getType() {
    return "runwalk"; // MAY HAVE TO CHANGE THIS
  }

  @Override
  public String toString() {
    return getType() + "\t" + name + "\t" + super.getDateString() + "\t" + calculateCalories();
  }
}