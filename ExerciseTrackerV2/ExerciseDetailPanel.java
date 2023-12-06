package ExerciseTrackerV2;

import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.GridLayout;
import javax.swing.JLabel;
import java.awt.BorderLayout;

public class ExerciseDetailPanel extends JPanel{

    private JTextField textName;
    private JTextField textDate;
    private JTextField textDuration;
    private JTextField textDistance;
    private JTextArea textComment;

    public void setupGUI(){
        setLayout(new BorderLayout());
        
        JPanel panNorth = new JPanel();
        textName = new JTextField(5);
        panNorth.setLayout(new GridLayout(4, 2));
        JLabel nameLabel = new JLabel("Name:");
        JLabel dateLabel = new JLabel("Date:");
        textDate = new JTextField(5);
        JLabel durationLabel = new JLabel("Duration:");
        textDuration = new JTextField(5);
        JLabel distanceLabel = new JLabel("Distance:");
        textDistance = new JTextField(5);
        panNorth.add(nameLabel);
        panNorth.add(textName);
        panNorth.add(dateLabel);
        panNorth.add(textDate);
        panNorth.add(durationLabel);
        panNorth.add(textDuration);
        panNorth.add(distanceLabel);
        panNorth.add(textDistance);
        add(panNorth, BorderLayout.NORTH); //Added this panel to the north

        JPanel panComment = new JPanel();
        panComment.setLayout(new BorderLayout());
        JLabel commentLabel = new JLabel("Add comment: ");
        panComment.add(commentLabel, BorderLayout.NORTH);
        textComment = new JTextArea(5, 10);
        panComment.add(textComment, BorderLayout.CENTER);
        add(panComment, BorderLayout.CENTER); //Added this panel to the remaining space


    }

    public ExerciseDetailPanel(){
        setupGUI();
    }

    public String getName(){
        return textName.getText();
    }

    public String getDate(){
        return textDate.getText();
    }

    public double getDuration(){
        return Double.parseDouble(textDuration.getText());
    }

    public double getDistance(){
        return Double.parseDouble(textDistance.getText());
    }

    public String getComment(){
        return textComment.getText();
    }
}
