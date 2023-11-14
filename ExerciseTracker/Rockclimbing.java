package ExerciseTracker;

public class Rockclimbing extends Exercise{

    private double wallHeight;
    private double timesClimbed;
    private double durationOfTheWorkout;
    private String name;

    public Rockclimbing(double duration, String c, String n, String d, double height, double numOfTimesClimbed){
        super(duration, c, n, d);
        this.name = n;
        durationOfTheWorkout = duration;
        this.wallHeight = height;
        this.timesClimbed = numOfTimesClimbed;
    }

    public double getWallHeight() {
        return wallHeight;
    }

    public void setWallHeight(double wallHeight) {
        this.wallHeight = wallHeight;
    }

    public double getTimesClimbed() {
        return timesClimbed;
    }

    public void setTimesClimbed(double timesClimbed) {
        this.timesClimbed = timesClimbed;
    }

    public double getDurationOfTheWorkout() {
        return durationOfTheWorkout;
    }

    public void setDurationOfTheWorkout(double durationOfTheWorkout) {
        this.durationOfTheWorkout = durationOfTheWorkout;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public double calculateCalories(){
        return ((wallHeight*timesClimbed)/durationOfTheWorkout)*100;
    }

    @Override
    public String getType(){
        return "rock climbing";
    }

    @Override
    public String toString(){
        return getType() + "\t" + name + "\t" + super.getDateString() + "\t" + calculateCalories();
    }
}
