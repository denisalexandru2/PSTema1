package View;

import javax.swing.*;
import java.awt.*;

public class DonorView extends JFrame {

    public JComboBox regionsCombo;
    public JButton editDonorButton;
    public JButton deleteDonorButton;
    public JTextField usernameField;
    public JTextField passwordField;
    public JTextField bloodTypeField;
    public JLabel usernameLabel;
    public JLabel passwordLabel;
    public JLabel bloodTypeLabel;
    public JButton goBackButton;

    public JLabel welcomeLabel;
    public JPanel mainPanel = new JPanel();

    public DonorView(String username){
        setTitle("Donor View");

        String[] regionsComboItems = {};

        mainPanel.setPreferredSize (new Dimension(500, 420));
        mainPanel.setLayout(null);

        editDonorButton = new JButton ("Save account changes");
        deleteDonorButton = new JButton ("Delete account");
        goBackButton = new JButton ("Back");

        regionsCombo = new JComboBox(regionsComboItems);

        usernameField = new JTextField (5);
        passwordField = new JTextField (5);
        bloodTypeField = new JTextField (5);
        usernameLabel = new JLabel ("Username");
        passwordLabel = new JLabel ("Password");
        bloodTypeLabel = new JLabel ("Blood Type");

        //set component bounds (only needed by Absolute Positioning)

        //editDonorButton.setBounds (180, 215, 100, 20);
        usernameField.setBounds (65, 130, 100, 25);
        passwordField.setBounds (180, 130, 100, 25);
        bloodTypeField.setBounds (295, 130, 100, 25);

        usernameLabel.setBounds (65, 160, 100, 25);
        passwordLabel.setBounds (180, 160, 100, 25);
        bloodTypeLabel.setBounds (295, 160, 100, 25);

        editDonorButton.setBounds (65, 215, 330, 45);
        deleteDonorButton.setBounds (65, 285, 330, 45);
        goBackButton.setBounds(65, 355, 330, 45);

        regionsCombo.setBounds (60, 30, 330, 30);


        //add components
        mainPanel.add (editDonorButton);
        mainPanel.add (deleteDonorButton);
        mainPanel.add (usernameField);
        mainPanel.add (passwordField);
        mainPanel.add (bloodTypeField);
        mainPanel.add (usernameLabel);
        mainPanel.add (passwordLabel);
        mainPanel.add (bloodTypeLabel);
        mainPanel.add (goBackButton);
        mainPanel.add(regionsCombo);

        this.setContentPane(mainPanel);
        this.setResizable(true);
        this.pack();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
