package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Connection.ConnectionFactory;
import Model.Donor;

public class DonorDAO {
    private Connection connection;

    public DonorDAO() {
        connection = ConnectionFactory.getConnection();
    }

    public void addDonor(Donor donor) {
        try {
            String query = "INSERT INTO donor (username, password, bloodtype) VALUES (?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, donor.getUsername());
            preparedStatement.setString(2, donor.getPassword());
            preparedStatement.setString(3, donor.getBloodType());
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteDonor(int id) {
        try {
            String query = "DELETE FROM donor WHERE id=?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateDonor(Donor donor) {
        try {
            String query = "UPDATE donor SET username=?, password=?, bloodtype=? WHERE id=?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, donor.getUsername());
            preparedStatement.setString(2, donor.getPassword());
            preparedStatement.setString(3, donor.getBloodType());
            preparedStatement.setInt(4, donor.getId());
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Donor> getAllDonors() {
        List<Donor> donors = new ArrayList<Donor>();
        try {
            String query = "SELECT * FROM donor";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Donor donor = new Donor(resultSet.getInt("id"), resultSet.getString("username"),
                        resultSet.getString("password"), resultSet.getString("bloodtype"));
                donors.add(donor);
            }
            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return donors;
    }

    public Donor getDonorById(int id) {
        Donor donor = null;
        try {
            String query = "SELECT * FROM donor WHERE id=?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                donor = new Donor(resultSet.getInt("id"), resultSet.getString("username"),
                        resultSet.getString("password"), resultSet.getString("bloodtype"));
            }
            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return donor;
    }

    public Donor getDonorByUsername(String username) {
        Donor donor = null;
        try {
            String query = "SELECT * FROM donor WHERE username=?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, username);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                donor = new Donor(resultSet.getInt("id"), resultSet.getString("username"),
                        resultSet.getString("password"), resultSet.getString("bloodtype"));
            }
            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return donor;
    }

    public Donor getDonorByUsernameAndPassword(String username, String password) {
        Donor donor = null;
        try {
            String query = "SELECT * FROM donor WHERE username=? AND password =?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                donor = new Donor(resultSet.getInt("id"), resultSet.getString("username"),
                        resultSet.getString("password"), resultSet.getString("bloodtype"));
            }
            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return donor;
    }
}
