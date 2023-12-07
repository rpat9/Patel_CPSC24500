package ExerciseTrackerV2;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.text.SimpleDateFormat;

public class MainFrame extends JFrame implements ActionListener{

    private ArrayList<RunWalk> exercises;
    private ExerciseDetailPanel edp;
    private JButton bttnAddExercise;
    private JMenuItem miLogin;
    private SimpleDateFormat df = new SimpleDateFormat("MM/dd/yyyy");//new
    private Date date;
    
    public void setupGUI(){
        setBounds(100,100,500,400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Exercise Tracker V2.0");
        
        Container c = getContentPane();
        c.setLayout(new BorderLayout());

        edp = new ExerciseDetailPanel();
        SummaryPanel sumPan = new SummaryPanel(exercises);
        c.add(edp, BorderLayout.WEST);
        c.add(sumPan, BorderLayout.EAST);

        JPanel panSouth = new JPanel();
        bttnAddExercise = new JButton("Add Exercise");
        bttnAddExercise.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                
                ArrayList<String> errors = new ArrayList<String>();
                String errorMessage = "";
                double dis=0, dur=0;
                String n = edp.getName();
                String d = edp.getDate();

                try {
                    dis = edp.getDistance();
                } catch (Exception ex) {
                    errors.add("The distance must be a number.");
                }

                try {
                    d = edp.getDate();
                    date = df.parse(d);
                    d = df.format(date);
                } catch (Exception ex) {
                    errors.add("The date must be entered in mm/dd/yyyy format.");
                }

                try {
                    dur = edp.getDuration();
                } catch (Exception ex) {
                    errors.add("The duration must be a number.");
                }

                String c = edp.getComment();

                
                if(errors.size()>0){
                    for(String error : errors){
                        errorMessage = errorMessage + error + " ";
                    }
                    JOptionPane.showMessageDialog(null, "These errors occured: " + errorMessage);
                } else {
                    RunWalk rw = new RunWalk(n, d, c, dis, dur);
                    exercises.add(rw);
    
                    sumPan.updateList();
                    edp.clearEntries();
                    sumPan.setSummaryLabel(String.format("Exercise Summary (%.2f burned).", RunWalk.getCaloriesBurned(exercises)));
                    repaint(); //updates what is shown on the frame
                }
            }
        });

        panSouth.setLayout(new FlowLayout());
        panSouth.add(bttnAddExercise);
        c.add(panSouth, BorderLayout.SOUTH);
        setupMenu();
        enableControls(false);
    }

    public void setupMenu(){
        JMenuBar mBar = new JMenuBar();
        setJMenuBar(mBar);

        JMenu menuFile = new JMenu("File");
        mBar.add(menuFile);

        JMenu menuHelp = new JMenu("Help");
        mBar.add(menuHelp);

        miLogin = new JMenuItem("Login");
        JMenuItem miLogout = new JMenuItem("Logout");
        JMenuItem miSave = new JMenuItem("Save");
        JMenuItem miExit = new JMenuItem("Exit");
        menuFile.add(miLogin);
        menuFile.add(miLogout);
        menuFile.add(miSave);
        menuFile.add(miExit);

        miLogin.addActionListener(this);
        miLogout.addActionListener(this);

        miExit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                System.exit(0);
            }
        });

        miSave.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){

                JFileChooser chooser = new JFileChooser();
                File f;
                String fileName;

                if(chooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION){
                    f = chooser.getSelectedFile();
                    fileName = f.getAbsolutePath();
                    
                    if(WriteToFile.writeExercisesToFile(fileName, exercises)){
                        JOptionPane.showMessageDialog(null, "Exercises were saved!");
                    } else {
                        JOptionPane.showMessageDialog(null, "Exercises were not saved.");
                    }
                }
            }
        });

        JMenuItem miAbout = new JMenuItem("About");
        menuHelp.add(miAbout);
        miAbout.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                JOptionPane.showMessageDialog(null, "Exercise app which can log and save exercises you enter.");
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == miLogin){
            LoginForm dialogLogin = new LoginForm(this, "Login", true);
            dialogLogin.setVisible(true);

            if(dialogLogin.isLoggedIn()){
                enableControls(true);
            } else {
                enableControls(false);
            }

        } else{
            enableControls(false);
        }
    }

    public void enableControls(boolean enableYN){
        edp.enableEntries(enableYN);
        bttnAddExercise.setEnabled(enableYN);
    }

    public MainFrame(ArrayList<RunWalk> excercises){
        this.exercises = excercises;
        setupGUI();
    }
}