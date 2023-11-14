package ExerciseTracker;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;


public class WriteExercisesToFile {

    public static boolean writeToFile(ArrayList<Exercise> exercises, String fileName){
        try{

            PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(new File(fileName))));

            for (Exercise e : exercises){
                pw.println(e);
            }

            pw.close();
            return true;

        } catch(Exception e){
            return false;
        }
    }
    
}
