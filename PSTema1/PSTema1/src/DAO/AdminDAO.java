package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Connection.ConnectionFactory;
import Model.Admin;

public class AdminDAO {
    private Connection connection;

    public AdminDAO() {
        connection = ConnectionFactory.getConnection();
    }

    public void addAdmin(Admin admin) {
        try {
            String query = "INSERT INTO admin (username, password) VALUES (?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, admin.getUsername());
            preparedStatement.setString(2, admin.getPassword());
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteAdmin(int id) {
        try {
            String query = "DELETE FROM admin WHERE id=?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateAdmin(Admin admin) {
        try {
            String query = "UPDATE admin SET username=?, password=? WHERE id=?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, admin.getUsername());
            preparedStatement.setString(2, admin.getPassword());
            preparedStatement.setInt(3, admin.getId());
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Admin> getAllAdmins() {
        List<Admin> admins = new ArrayList<Admin>();
        try {
            String query = "SELECT * FROM admin";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Admin admin = new Admin(resultSet.getInt("id"), resultSet.getString("username"),
                        resultSet.getString("password"));
                admins.add(admin);
            }
            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return admins;
    }

    public Admin getAdminById(int id) {
        Admin admin = null;
        try {
            String query = "SELECT * FROM admin WHERE id=?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                admin = new Admin(resultSet.getInt("id"), resultSet.getString("username"),
                        resultSet.getString("password"));
            }
            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return admin;
    }

    public Admin getAdminByUsernameAndPassword(String username, String password) {
        Admin admin = null;
        try {
            String query = "SELECT * FROM admin WHERE username=? AND password=?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                admin = new Admin(resultSet.getInt("id"), resultSet.getString("username"),
                        resultSet.getString("password"));
            }
            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return admin;
    }
}
