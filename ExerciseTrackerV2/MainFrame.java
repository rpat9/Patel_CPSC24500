package ExerciseTrackerV2;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class MainFrame extends JFrame{

    private ArrayList<RunWalk> exercises;
    
    public void setupGUI(){
        setBounds(100,100,500,400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Exercise Tracker V2.0");
        
        Container c = getContentPane();
        c.setLayout(new BorderLayout());

        ExerciseDetailPanel edp = new ExerciseDetailPanel();
        SummaryPanel sumPan = new SummaryPanel(exercises);
        c.add(edp, BorderLayout.WEST);
        c.add(sumPan, BorderLayout.EAST);

        JPanel panSouth = new JPanel();
        JButton bttnAddExercise = new JButton("Add Exercise");
        bttnAddExercise.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                String n = edp.getName();
                String d = edp.getDate();
                double dis = edp.getDistance();
                double dur = edp.getDuration();
                String c = edp.getComment();

                RunWalk rw = new RunWalk(n, d, c, dis, dur);
                exercises.add(rw);

                sumPan.updateList();
                repaint(); //updates what is shown on the frame
            }
        });
        panSouth.setLayout(new FlowLayout());
        panSouth.add(bttnAddExercise);
        c.add(panSouth, BorderLayout.SOUTH);

    }

    public MainFrame(ArrayList<RunWalk> excercises){
        this.exercises = excercises;
        setupGUI();
    }
}
