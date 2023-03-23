package Controller;

import View.*;
import DAO.*;
import Model.*;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class LogInController {

    private LogInView loginView;

    public LogInController(LogInView loginView) {
        this.loginView = loginView;
        this.loginView.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        String username = String.valueOf(loginView.getUsernameField());
        String password = String.valueOf(loginView.getPasswordField());

        AdminDAO adminDAO = new AdminDAO();
        DoctorDAO doctorDAO = new DoctorDAO();
        DonorDAO donorDAO = new DonorDAO();
        // Check if username and password are valid
        Object user = adminDAO.getAdminByUsernameAndPassword (username, password);
        if (user == null) {
            user = doctorDAO.getDoctorByUsernameAndPassword(username, password);
            if (user == null) {
                user = donorDAO.getDonorByUsernameAndPassword(username, password);
            }
        }

        // If user is valid, switch to corresponding view
        if (user != null) {
            if (user instanceof Admin) {
                AdminView adminView = new AdminView();
                AdminController controller = new AdminController(adminView);
                adminView.setVisible(true);
            } else if (user instanceof Doctor) {
                DoctorView doctorView = new DoctorView(((Doctor) user).username);
                doctorView.setVisible(true);
            } else if (user instanceof Donor) {
                DonorView donorView = new DonorView(((Donor) user).username);
                DonorController donorController = new DonorController(donorView, (Donor) user);
                donorView.setVisible(true);
            }
            loginView.dispose();
        } else {
            JOptionPane JOptionPane = new JOptionPane();
            JOptionPane.showMessageDialog(this.loginView, "Invalid username or password. Please try again.");
        }
    }
}
