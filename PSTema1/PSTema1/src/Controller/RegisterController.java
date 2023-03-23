package Controller;

import DAO.DonorDAO;
import View.DonorView;
import View.RegisterView;
import Model.Donor;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class RegisterController implements ActionListener {

    private RegisterView registerView;

    public RegisterController(RegisterView registerView) {
        this.registerView = registerView;
        this.registerView.addConfirmListener(this);
        this.registerView.addBackListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        String username = registerView.getUsername();
        char[] password = registerView.getPassword().toCharArray();
        char[] confirmPassword = registerView.getConfirmPassword().toCharArray();
        String bloodType = registerView.getBloodType();

        DonorDAO donorDAO = new DonorDAO();

        // Check if passwords match
        if (!String.valueOf(password).equals(String.valueOf(confirmPassword))) {
            JOptionPane JOptionPane = new JOptionPane();
            JOptionPane.showMessageDialog(registerView, "Passwords do not match.");
            return;
        }

        // Check if username is already taken
        Donor donor = donorDAO.getDonorByUsername(username);
        if (donor != null) {
            JOptionPane.showMessageDialog(registerView, "Username already taken.");
            return;
        }

        // Insert donor into database
        Donor newDonor = new Donor(username, String.valueOf(password), bloodType);
        donorDAO.addDonor(newDonor);

        // Switch to donor view
        registerView.dispose();
        new DonorView(newDonor.username);
    }
}
