package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class AdminView extends JFrame {

    public JComboBox doctorsCombo;
    public JButton addDoctorButton;
    public JButton editDoctorButton;
    public JButton deleteDoctorButton;
    public JButton goBackButton;
    public JTextField idField;
    public JTextField usernameField;
    public JTextField passwordField;
    public JLabel idLabel;
    public JLabel usernameLabel;
    public JLabel passwordLabel;

    public JPanel mainPanel = new JPanel();
    public AdminView(){

        String[] doctorsComboItems = {};

        mainPanel.setPreferredSize (new Dimension(700, 420));
        mainPanel.setLayout(null);

        //construct components
        addDoctorButton = new JButton ("Add product");
        editDoctorButton = new JButton ("Edit product");
        deleteDoctorButton = new JButton ("Delete product");
        idField = new JTextField (5);
        usernameField = new JTextField (5);
        passwordField = new JTextField (5);
        idLabel = new JLabel ("ID");
        usernameLabel = new JLabel ("Username");
        passwordLabel = new JLabel ("Password");
        goBackButton = new JButton ("Back");
        doctorsCombo = new JComboBox (doctorsComboItems);

        //set component bounds (only needed by Absolute Positioning)
        addDoctorButton.setBounds (65, 215, 100, 20);
        editDoctorButton.setBounds (180, 215, 100, 20);
        deleteDoctorButton.setBounds (295, 215, 110, 20);
        idField.setBounds (65, 130, 100, 25);
        usernameField.setBounds (180, 130, 100, 25);
        passwordField.setBounds (295, 130, 100, 25);
        idLabel.setBounds (65, 160, 100, 25);
        usernameLabel.setBounds (180, 160, 100, 25);
        passwordLabel.setBounds (295, 160, 100, 25);
        goBackButton.setBounds (65, 285, 345, 45);
        doctorsCombo.setBounds (60, 30, 565, 30);


        //add components
        mainPanel.add (addDoctorButton);
        mainPanel.add (editDoctorButton);
        mainPanel.add (deleteDoctorButton);
        mainPanel.add (idField);
        mainPanel.add (usernameField);
        mainPanel.add (passwordField);
        mainPanel.add (idLabel);
        mainPanel.add (usernameLabel);
        mainPanel.add (passwordLabel);
        mainPanel.add (goBackButton);
        mainPanel.add (doctorsCombo);

        this.setContentPane(mainPanel);
        this.setResizable(true);
        this.pack();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void addDoctorListener(ActionListener listener){
        addDoctorButton.addActionListener(listener);
    }
    public void editDoctorListener(ActionListener listener){
        editDoctorButton.addActionListener(listener);
    }
    public void deletDoctorListener(ActionListener listener){
        deleteDoctorButton.addActionListener(listener);
    }
    public void addBackListener(ActionListener listener) {
        goBackButton.addActionListener(listener);
    }
}
