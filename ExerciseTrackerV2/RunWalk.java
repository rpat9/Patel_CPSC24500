package ExerciseTrackerV2;

import java.util.ArrayList;

public class RunWalk extends Exercise{

    private double dist;
    private double dur;

    public RunWalk(){
        super();
    }

    public RunWalk(String name, String dateStr, String comm, double dist, double dur){
        super(name, dateStr, comm);
        this.dist = dist;
        this.dur = dur;
    }

    public double getDist() {
        return dist;
    }

    public void setDist(double distance) {
        if(distance>=0){
            this.dist = distance;
        }
    }

    public double getDur() {
        return dur;
    }

    public void setDur(double duration) {
        if(duration>=0){
            this.dur = duration;
        }
    }

    public static double getCaloriesBurned(ArrayList <RunWalk> ex){
        double total = 0;
        for (RunWalk r : ex){
            total+=r.calculateCaloriesBurned();
        }
        return total;
    }

    @Override
    public double calculateCaloriesBurned() {
        return (dist/getDur())*9000;
    }

    @Override
    public String getType(){
        return "runwalk";
    }

    @Override
    public String toString() {
        return String.format("%-20s%s%20s%20.2f", getExerciseName(), getType(), getDateString(), getDur());
    }
    
}
