package Controller;

import View.*;
import DAO.*;
import Model.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.List;

public class AdminController {
    public AdminView adminView;
    public DoctorDAO doctorDAO;

    public AdminController(AdminView adminView) {
        this.adminView = adminView;
        this.doctorDAO = new DoctorDAO();
        this.adminView.addDoctorButton.addActionListener(new AddDoctorListener());
        this.adminView.editDoctorButton.addActionListener(new EditDoctorListener());
        this.adminView.deleteDoctorButton.addActionListener(new DeleteDoctorListener());
        this.adminView.goBackButton.addActionListener(new GoBackListener());
        this.adminView.doctorsCombo.addItemListener(new ComboSelListener());
        refreshDoctorCombo();
        Doctor selectedProduct = (Doctor) this.adminView.doctorsCombo.getSelectedItem();
        this.adminView.idField.setText(String.valueOf(selectedProduct.getId()));
        this.adminView.usernameField.setText(selectedProduct.getUsername());
        this.adminView.passwordField.setText(selectedProduct.getPassword().toString());
    }

    // ActionListener class for adding a doctor
    class AddDoctorListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            int id = Integer.parseInt(adminView.idField.getText());
            String username = adminView.usernameField.getText();
            String password = adminView.passwordField.getText();

            // Create a new Doctor object and add it to the database
            Doctor doctor = new Doctor(id, username, password);
            doctorDAO.addDoctor(doctor);

            // Refresh the combo box with the updated list of Doctors
            refreshDoctorCombo();
        }
    }

    // ActionListener class for editing a doctor
    class EditDoctorListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            int id = Integer.parseInt(adminView.idField.getText());
            String username = adminView.usernameField.getText();
            String password = adminView.passwordField.getText();

            // Get the selected Doctor from the combo box
            Doctor selectedDoctor = (Doctor) adminView.doctorsCombo.getSelectedItem();

            // Update the selected Doctor with the new information
            selectedDoctor.setId(id);
            selectedDoctor.setUsername(username);
            selectedDoctor.setPassword(password);
            doctorDAO.updateDoctor(selectedDoctor);

            // Refresh the combo box with the updated list of Doctors
            refreshDoctorCombo();
        }
    }

    class DeleteDoctorListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            // Get the selected Doctor from the combo box
            Doctor selectedDoctor = (Doctor) adminView.doctorsCombo.getSelectedItem();

            // Remove the selected Doctor from the database
            doctorDAO.deleteDoctor(selectedDoctor.getId());

            // Refresh the combo box with the updated list of Doctors
            refreshDoctorCombo();
        }
    }

    class GoBackListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            adminView.setVisible(false);
            WelcomeView welcomeView = new WelcomeView();
            WelcomeController welcomeController = new WelcomeController(welcomeView);
            welcomeController.welcomeView.setVisible(true);
        }
    }

    //Your code:
    private void refreshDoctorCombo() {
        DefaultComboBoxModel<Doctor> comboModel = new DefaultComboBoxModel<>();
        List<Doctor> doctors = doctorDAO.getAllDoctors();
        for (Doctor doctor : doctors)
            comboModel.addElement(doctor);
        adminView.doctorsCombo.setModel(comboModel);
    }

    class ComboSelListener implements ItemListener {

        @Override
        public void itemStateChanged(ItemEvent e) {
            Doctor selectedItem = (Doctor) adminView.doctorsCombo.getSelectedItem();
            adminView.idField.setText(String.valueOf(selectedItem.getId()));
            adminView.usernameField.setText(selectedItem.getUsername());
            adminView.passwordField.setText(selectedItem.getPassword().toString());
        }
    }
}
