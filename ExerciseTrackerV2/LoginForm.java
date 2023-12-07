package ExerciseTrackerV2;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginForm extends JDialog{

    private String userName;
    private String password;
    private boolean loggedIn;

    public void setupGUI(){
        setBounds(100,100,200,200);
        setTitle("Please log in");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        Container c = getContentPane();
        c.setLayout(new BorderLayout());

        JPanel panCenter = new JPanel();
        panCenter.setLayout(new FlowLayout());
        JLabel labelUsername = new JLabel("Username: ");
        JLabel labelPassword = new JLabel("Password: ");
        JTextField textUserName = new JTextField(10);
        JPasswordField textPassword = new JPasswordField(10);
        panCenter.add(labelUsername);
        panCenter.add(textUserName);
        panCenter.add(labelPassword);
        panCenter.add(textPassword);
        c.add(panCenter, BorderLayout.CENTER);

        JPanel panSouth = new JPanel();
        JButton btnOk = new JButton("OK");
        btnOk.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               String enteredUsername = textUserName.getText();
               String enteredPassword = new String(textPassword.getPassword());

               if(enteredUsername.equals(userName) && enteredPassword.equals(password)){
                loggedIn = true;
                setVisible(false);
               } else if (enteredUsername.equals(userName) && !enteredPassword.equals(password)){
                JOptionPane.showMessageDialog(null, "Password is incorrect.");
               } else if (!enteredUsername.equals(userName) && enteredPassword.equals(password)){
                JOptionPane.showMessageDialog(null, "Username is incorrect.");
               } else if (!enteredUsername.equals(userName) && !enteredPassword.equals(password)){
                JOptionPane.showMessageDialog(null, "Both Username and Password incorrect.");
               }
            }
        });
        JButton btnCancel = new JButton("Cancel");
        btnCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                loggedIn = false;
                setVisible(false);
            }
        });
        panSouth.setLayout(new FlowLayout());
        panSouth.add(btnOk);
        panSouth.add(btnCancel);
        c.add(panSouth, BorderLayout.SOUTH);


    }

    public boolean isLoggedIn(){
        return loggedIn;
    }
    
    public LoginForm(JFrame owner, String title, boolean modal){
        super(owner, title, modal);
        setupGUI();
        loggedIn = false;
        userName = "healthy";
        password = "donut";
    }
}