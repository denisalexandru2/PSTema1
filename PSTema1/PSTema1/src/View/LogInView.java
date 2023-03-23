package View;

import Controller.LogInController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LogInView extends JFrame implements ActionListener {

    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton logInButton, cancelButton;

    public LogInView() {

        // Set window properties
        setTitle("Log In");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 200);
        setLocationRelativeTo(null);
        setResizable(false);

        // Create main panel
        JPanel mainPanel = new JPanel(new GridLayout(3, 1, 10, 10));
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

        // Create button panel
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        logInButton = new JButton("Log In");
        cancelButton = new JButton("Cancel");
        logInButton.addActionListener(this);
        cancelButton.addActionListener(this);
        buttonPanel.add(logInButton);
        buttonPanel.add(cancelButton);
        mainPanel.add(buttonPanel);

        // Add main panel to frame
        add(mainPanel);

        // Show window
        setVisible(true);

    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == logInButton) {
            LogInController controller = new LogInController(this);
            controller.actionPerformed(e);
        } else if (e.getSource() == cancelButton) {
            dispose();
            new WelcomeView();
        }
    }

    public String getUsernameField() {
        return this.usernameField.getText();
    }

    public String getPasswordField() {
        return this.passwordField.getText();
    }

    public void addLogInListener(ActionListener listener) {
        logInButton.addActionListener(listener);
    }
}
