package DAO;

import Connection.ConnectionFactory;
import Model.Doctor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DoctorDAO {
    private Connection connection;

    public DoctorDAO() {
        connection = ConnectionFactory.getConnection();
    }

    public void addDoctor(Doctor doctor) {
        try {
            String query = "INSERT INTO doctor (id, username, password) VALUES (?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, String.valueOf(doctor.getId()));
            preparedStatement.setString(2, doctor.getUsername());
            preparedStatement.setString(3, doctor.getPassword());
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteDoctor(int id) {
        try {
            String query = "DELETE FROM doctor WHERE id=?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateDoctor(Doctor doctor) {
        try {
            String query = "UPDATE doctor SET username=?, password=? WHERE id=?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, doctor.getUsername());
            preparedStatement.setString(2, doctor.getPassword());
            preparedStatement.setInt(3, doctor.getId());
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Doctor> getAllDoctors() {
        List<Doctor> doctors = new ArrayList<Doctor>();
        try {
            String query = "SELECT * FROM doctor";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Doctor doctor = new Doctor(resultSet.getInt("id"), resultSet.getString("username"),
                        resultSet.getString("password"));
                doctors.add(doctor);
            }
            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return doctors;
    }

    public Doctor getDoctorById(int id) {
        Doctor doctor = null;
        try {
            String query = "SELECT * FROM doctor WHERE id=?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                doctor = new Doctor(resultSet.getInt("id"), resultSet.getString("username"),
                        resultSet.getString("password"));
            }
            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return doctor;
    }

    public Doctor getDoctorByUsername(String username) {
        Doctor doctor = null;
        try {
            String query = "SELECT * FROM doctor WHERE username=?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, username);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                doctor = new Doctor(resultSet.getInt("id"), resultSet.getString("username"),
                        resultSet.getString("password"));
            }
            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return doctor;
    }

    public Doctor getDoctorByUsernameAndPassword(String username, String password) {
        Doctor doctor = null;
        try {
            String query = "SELECT * FROM doctor WHERE username=? AND password=?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                doctor = new Doctor(resultSet.getInt("id"), resultSet.getString("username"),
                        resultSet.getString("password"));
            }
            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return doctor;
    }
}