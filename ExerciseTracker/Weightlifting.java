package ExerciseTracker;

public class Weightlifting extends Exercise{

    private double poundsLifted;
    private double durationOfTheWorkout;
    private String name;

    public Weightlifting(double duration, String c, String n, String d, double poundsLifted){
        super(duration, c, n, d);
        this.poundsLifted = poundsLifted;
        this.name = n;
        durationOfTheWorkout = duration;
    }

    public String getName(){
        return name;
    } 

    public void setName(String na){
        name = na;
    }

    public void setPoundsLifted(int pounds){
        poundsLifted = pounds;
    }

    public double getPoundsLifted(){
        return poundsLifted;
    }

    @Override
    public double getDuration(){ 
    return durationOfTheWorkout;
    }

    public void setDuration(int d){
    durationOfTheWorkout = d;
    }

    @Override
    public double calculateCalories(){
        return (poundsLifted/durationOfTheWorkout)*50;
    }

    @Override
    public String getType(){
        return "weightlifting";
    }

    @Override
    public String toString(){
        return getType() + "\t" + name + "\t" + super.getDateString() + "\t" + calculateCalories();
    }
}
