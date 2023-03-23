package Controller;

import DAO.DonorDAO;
import DAO.RegionDAO;
import View.*;
import Model.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.List;

public class DonorController {
    public DonorView donorView;
    public Donor donor;
    public DonorDAO donorDAO;
    public RegionDAO regionDAO;

    public DonorController(DonorView donorView, Donor donor) {
        this.donorView = donorView;
        this.donor = donor;
        this.donorDAO = new DonorDAO();
        this.regionDAO = new RegionDAO();

        this.donorView.usernameField.setText(donor.getUsername());
        this.donorView.passwordField.setText(donor.getPassword());
        this.donorView.bloodTypeField.setText(donor.getBloodType());

        this.donorView.editDonorButton.addActionListener(new EditDonorListener());
        this.donorView.deleteDonorButton.addActionListener(new DeleteDonorListener());
        this.donorView.goBackButton.addActionListener(new GoBackListener());

        refreshDoctorCombo();
    }

    // ActionListener class for editing a doctor
    class EditDonorListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {

            String username = donorView.usernameField.getText();
            String password = donorView.passwordField.getText();
            String bloodType = donorView.bloodTypeField.getText();

            Donor updatedDonor = new Donor(username, password, bloodType);
            updatedDonor.setId(donor.getId());

            donorDAO.updateDonor(updatedDonor);
        }
    }

    class DeleteDonorListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            // Remove the selected Doctor from the database
            donorDAO.deleteDonor(donor.getId());
            donorView.setVisible(false);
            WelcomeView welcomeView = new WelcomeView();
            WelcomeController welcomeController = new WelcomeController(welcomeView);
            welcomeController.welcomeView.setVisible(true);
        }
    }

    class GoBackListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            donorView.setVisible(false);
            WelcomeView welcomeView = new WelcomeView();
            WelcomeController welcomeController = new WelcomeController(welcomeView);
            welcomeController.welcomeView.setVisible(true);
        }
    }

    private void refreshDoctorCombo() {
        DefaultComboBoxModel<String> comboModel = new DefaultComboBoxModel<>();
        List<Region> regions = regionDAO.getAllRegions();
        for (Region region : regions)
            comboModel.addElement(region.getRegionName());
        donorView.regionsCombo.setModel(comboModel);
    }
}
