package ExerciseTrackerV2;

import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class Exercise {

    private String ExerciseName;
    private Date date;
    private String comment;
    private SimpleDateFormat df = new SimpleDateFormat("MM/dd/yyyy"); 
    private String dateString;

    public Exercise(){
        ExerciseName = "";
        comment = "";
    }

    public Exercise(String name, String dateStr, String comm){
        this.ExerciseName = name;
        this.comment = comm;
        try {
            date = df.parse(dateStr);
            dateString = df.format(date);
          } catch (Exception e) {
            date = new Date();
            dateString = ""; 
        }
    }

    public String getDateString(){
        return dateString;
    }

    public String getExerciseName() {
        return ExerciseName;
    }

    public void setExerciseName(String exerciseName) {
        ExerciseName = exerciseName;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public abstract double calculateCaloriesBurned();

    public abstract String getType();

    public abstract String toString();
}
