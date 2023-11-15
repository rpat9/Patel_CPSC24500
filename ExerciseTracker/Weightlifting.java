package ExerciseTracker;

public class Weightlifting extends Exercise{

    private double poundsLifted;
    private double durationOfTheWorkout;
    private String name;

    /**
     * The specific weightlifting that takes in unique paramters.
     * @param duration The duration of the workout
     * @param c The comment that the user made about the workout.
     * @param n The name that the user made about the workout.
     * @param d The date that the user had the workout.
     * @param poundsLifted The amount of pounds lifted.
     */
    public Weightlifting(double duration, String c, String n, String d, double poundsLifted){
        super(duration, c, n, d);
        this.poundsLifted = poundsLifted;
        this.name = n;
        durationOfTheWorkout = duration;
    }

    /**
     * This method gives access to the name of the workout.
     * @return The name of the workout.
     */
    public String getName(){
        return name;
    } 

    /**
     * This method sets the name of the workout.
     * @param name The name of the workout.
     */
    public void setName(String na){
        name = na;
    }

    /**
     * This method sets the pounds lifted.
     * @param pounds The pounds lifted.
     */
    public void setPoundsLifted(int pounds){
        poundsLifted = pounds;
    }

    /**
     * This method gives access to the pounds lifted.
     * @return The pounds lifted.
     */
    public double getPoundsLifted(){
        return poundsLifted;
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
    public double calculateCalories(){
        return (poundsLifted/durationOfTheWorkout)*50;
    }

    /**
     * This method gives access to the type of workout.
     * @return The type of the workout.
     */
    @Override
    public String getType(){
        return "weightlifting";
    }

    /**
     * This method gives access to the String version of Rockclimbing Exercise.
     * @return String version of the RockClimbing Exercise.
     */
    @Override
    public String toString(){
        return getType() + "\t" + name + "\t" + super.getDateString() + "\t" + calculateCalories();
    }
}
