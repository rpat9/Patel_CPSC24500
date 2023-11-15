package ExerciseTracker;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;


public class WriteExercisesToFile {

    /**
     * This method writes all the exercises to a file and stores it.
     * @param exercises The list of all exercisesd
     * @param fileName The name of the file where it will be stored.
     * @return True or False on whether or not the task was done. 
     */
    public static boolean writeToFile(ArrayList<Exercise> exercises, String fileName){
        try{

            PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(new File(fileName))));

            for (Exercise e : exercises){
                //pw.println(e + "\t" + e.getComment());
                pw.format("%-20s %-25s %-40s %-20s %10.2f\n",e.getType(), e.getName() , e.getComment(), e.getDateString(), e.calculateCalories());
            }

            pw.close();
            return true;

        } catch(Exception e){
            return false;
        }
    }
    
}