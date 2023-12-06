package ExerciseTrackerV2;

import java.util.ArrayList;

public class ExerciseV2App {
    public static void main(String[] args) {
        ArrayList<RunWalk> exercises = new ArrayList<RunWalk>();
        
        MainFrame frame = new MainFrame(exercises);
        frame.setVisible(true);
    }
}
