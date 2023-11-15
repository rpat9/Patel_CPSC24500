package ExerciseTracker;

public class Rockclimbing extends Exercise{

    private double wallHeight;
    private double timesClimbed;
    private double durationOfTheWorkout;
    private String name;

    /**
     * The specific Rockclimbing that takes in unique parameters.
     * @param duration The duration of the workout.
     * @param c The comment that the user makes about the worout.
     * @param n The name that the user makes about the workout.
     * @param d The date that the user had the workout.
     * @param height The height of the wall climbed.
     * @param numOfTimesClimbed The number of times that wall was climbed.
     */
    public Rockclimbing(double duration, String c, String n, String d, double height, double numOfTimesClimbed){
        super(duration, c, n, d);
        this.name = n;
        durationOfTheWorkout = duration;
        this.wallHeight = height;
        this.timesClimbed = numOfTimesClimbed;
    }

    /**
     * This method gives access to the wall height.
     * @return The wall height.
     */
    public double getWallHeight() {
        return wallHeight;
    }

    /**
     * This method sets a new wall height.
     * @param wallHeight The new wall height.
     */
    public void setWallHeight(double wallHeight) {
        this.wallHeight = wallHeight;
    }

    /**
     * This method gives access to the number of times the wall was climbed.
     * @return The number of times the wall was climbed.
     */
    public double getTimesClimbed() {
        return timesClimbed;
    }

    /**
     * This method sets number of times the wall was climbed.
     * @param timesClimbed The number of times the wall was climbed.
     */
    public void setTimesClimbed(double timesClimbed) {
        this.timesClimbed = timesClimbed;
    }

    /**
     * This method gives access to the duration of the workout.
     * @return The duration of the workout.
     */
    public double getDurationOfTheWorkout() {
        return durationOfTheWorkout;
    }

    /**
     * This method sets the duration.
     * @param durationOfTheWorkout The duration of the workout.
     */
    public void setDurationOfTheWorkout(double durationOfTheWorkout) {
        this.durationOfTheWorkout = durationOfTheWorkout;
    }

    /**
     * This method gives access to the name of the workout.
     * @return The name of the workout.
     */
    public String getName() {
        return name;
    }

    /**
     * This method sets the name of the workout.
     * @param name The name of the workout.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * This method gives access to the calories burned.
     * @return The calories burned.
     */
    @Override
    public double calculateCalories(){
        return ((wallHeight*timesClimbed)/durationOfTheWorkout)*100;
    }

    /**
     * This method gives access to the type of workout.
     * @return The type of the workout.
     */
    @Override
    public String getType(){
        return "rock climbing";
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