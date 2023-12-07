package ExerciseTrackerV2;

import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.util.ArrayList;

public class SummaryPanel extends JPanel{

    private ArrayList<RunWalk> exercises;
    private JTextArea exerciseSummary;
    private JLabel labelSummary;

    public void setupGUI(){
        setLayout(new BorderLayout());

        JPanel panNorth = new JPanel();
        panNorth.setLayout(new FlowLayout());
        labelSummary = new JLabel("Exercise Summary");
        panNorth.add(labelSummary);
        add(panNorth, BorderLayout.NORTH);

        exerciseSummary = new JTextArea(10,30);
        exerciseSummary.setEditable(false);
        add(exerciseSummary, BorderLayout.CENTER);

    }

    public void setSummaryLabel(String txt){
        labelSummary.setText(txt);
    }

    public void updateList(){
        exerciseSummary.setText("");
        String text = "";

        for(RunWalk e : exercises){
            text  = text + e.toString() + "\n";
        }

        exerciseSummary.setText(text);
    }

    public SummaryPanel(ArrayList<RunWalk> exercises){
        this.exercises = exercises;
        setupGUI();
    }
    
}
