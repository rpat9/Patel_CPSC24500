package ExerciseTrackerV2;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

public class WriteToFile {
    
    public static boolean writeExercisesToFile(String fileName, ArrayList<RunWalk> exercises){
        try {
            PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(new File(fileName))));

            for(RunWalk r: exercises){
                //pw.println(r);
                pw.format("%-20s%s%20s%20s%20.2f\n", r.getExerciseName(), r.getType(), r.getDateString(), r.getComment(), r.getDur());
            }

            pw.close();
            return true;

        } catch (Exception e) {
            return false;
        }
    }
}