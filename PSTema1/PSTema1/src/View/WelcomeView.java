package View;

import Controller.LogInController;
import Controller.RegisterController;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class WelcomeView extends JFrame implements ActionListener {
    private static final long serialVersionUID = 1L;
    private JLabel welcomeLabel;
    private JButton loginButton;
    private JButton registerButton;

    public WelcomeView() {
        setTitle("Welcome to the Blood Bank Application");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.insets = new Insets(10, 10, 10, 10);

        welcomeLabel = new JLabel("Welcome to the Blood Bank Application");
        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 24));
        welcomeLabel.setForeground(Color.RED);
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = 2;
        panel.add(welcomeLabel, constraints);

        loginButton = new JButton("Log In");
        loginButton.setFont(new Font("Arial", Font.BOLD, 16));
        loginButton.addActionListener(this);
        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.gridwidth = 1;
        panel.add(loginButton, constraints);

        registerButton = new JButton("Register");
        registerButton.setFont(new Font("Arial", Font.BOLD, 16));
        registerButton.addActionListener(this);
        constraints.gridx = 1;
        constraints.gridy = 1;
        constraints.gridwidth = 1;
        panel.add(registerButton, constraints);

        add(panel);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == loginButton) {
            dispose();
            new LogInController(new LogInView());
        } else if (e.getSource() == registerButton) {
            dispose();
            new RegisterController(new RegisterView());
        }
    }
}
