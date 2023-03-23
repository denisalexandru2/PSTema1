package DAO;

import Connection.ConnectionFactory;
import Model.Doctor;
import Model.Region;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RegionDAO {
    private Connection connection;

    public RegionDAO() {
        connection = ConnectionFactory.getConnection();
    }

    public List<Region> getAllRegions() {
        List<Region> regions = new ArrayList<>();
        try {
            String query = "SELECT * FROM region";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Region region = new Region(resultSet.getInt("id"), resultSet.getString("regionname"));
                regions.add(region);
            }
            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return regions;
    }
}
