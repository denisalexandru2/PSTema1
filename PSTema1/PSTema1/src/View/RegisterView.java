package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class RegisterView extends JFrame implements ActionListener {

    private JTextField usernameField;
    private JPasswordField passwordField;
    private JPasswordField confirmPasswordField;
    private JComboBox<String> bloodTypeComboBox;
    private JButton confirmButton, goBackButton;

    public RegisterView() {

        // Set window properties
        setTitle("Register");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);
        setResizable(false);

        // Create main panel
        JPanel mainPanel = new JPanel(new GridLayout(5, 1, 10, 10));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Create username field
        JPanel usernamePanel = new JPanel(new BorderLayout(10, 10));
        JLabel usernameLabel = new JLabel("Username:");
        usernameField = new JTextField(20);
        usernamePanel.add(usernameLabel, BorderLayout.WEST);
        usernamePanel.add(usernameField, BorderLayout.CENTER);
        mainPanel.add(usernamePanel);

        // Create password field
        JPanel passwordPanel = new JPanel(new BorderLayout(10, 10));
        JLabel passwordLabel = new JLabel("Password:");
        passwordField = new JPasswordField(20);
        passwordPanel.add(passwordLabel, BorderLayout.WEST);
        passwordPanel.add(passwordField, BorderLayout.CENTER);
        mainPanel.add(passwordPanel);

        // Create confirm password field
        JPanel confirmPasswordPanel = new JPanel(new BorderLayout(10, 10));
        JLabel confirmPasswordLabel = new JLabel("Confirm Password:");
        confirmPasswordField = new JPasswordField(20);
        confirmPasswordPanel.add(confirmPasswordLabel, BorderLayout.WEST);
        confirmPasswordPanel.add(confirmPasswordField, BorderLayout.CENTER);
        mainPanel.add(confirmPasswordPanel);

        // Create blood type combo box
        JPanel bloodTypePanel = new JPanel(new BorderLayout(10, 10));
        JLabel bloodTypeLabel = new JLabel("Blood Type:");
        String[] bloodTypes = {"0", "A", "B", "AB"};
        bloodTypeComboBox = new JComboBox<>(bloodTypes);
        bloodTypePanel.add(bloodTypeLabel, BorderLayout.WEST);
        bloodTypePanel.add(bloodTypeComboBox, BorderLayout.CENTER);
        mainPanel.add(bloodTypePanel);

        // Create button panel
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        confirmButton = new JButton("Confirm");
        goBackButton = new JButton("Go Back");
        confirmButton.addActionListener(this);
        goBackButton.addActionListener(this);
        buttonPanel.add(confirmButton);
        buttonPanel.add(goBackButton);
        mainPanel.add(buttonPanel);

        // Add main panel to frame
        add(mainPanel);

        // Show window
        setVisible(true);

    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == confirmButton) {

        } else if (e.getSource() == goBackButton) {
            dispose();
            new WelcomeView();
        }
    }

    public String getUsername() {
        return usernameField.getText();
    }

    public String getPassword() {
        return new String(passwordField.getPassword());
    }

    public String getConfirmPassword() {
        return new String(confirmPasswordField.getPassword());
    }

    public String getBloodType() {
        return (String) bloodTypeComboBox.getSelectedItem();
    }

    public void addConfirmListener(ActionListener listener) {
        confirmButton.addActionListener(listener);
    }

    public void addBackListener(ActionListener listener) {
        goBackButton.addActionListener(listener);
    }
}
