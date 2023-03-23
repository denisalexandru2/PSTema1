package View;

import javax.swing.*;
import java.awt.*;

public class DoctorView extends JFrame {
    private JLabel welcomeLabel;
    private JButton logoutButton;

    public DoctorView(String username) {
        setTitle("Doctor View");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel(new BorderLayout(10, 10));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        welcomeLabel = new JLabel("Welcome, " + username);
        welcomeLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        welcomeLabel.setHorizontalAlignment(SwingConstants.CENTER);
        mainPanel.add(welcomeLabel, BorderLayout.CENTER);

        logoutButton = new JButton("Log Out");
        logoutButton.setFont(new Font("Arial", Font.PLAIN, 14));
        logoutButton.addActionListener(e -> {
            dispose();
            new LogInView();
        });
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        buttonPanel.add(logoutButton);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        add(mainPanel);
        setVisible(true);
    }
}
