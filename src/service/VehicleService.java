package service;

import config.DbConfig;
import entity.Vehicle;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VehicleService {

    public void addVehicle(Vehicle vehicle) throws SQLException
    {
        Connection conn = DbConfig.getConnection();
        PreparedStatement ps =
                conn.prepareStatement("INSERT INTO vehicle (customer_id, number_plate) VALUES (?,?)");
        ps.setInt(1, vehicle.getCustomerId());
        ps.setString(2, vehicle.getNumberPlate());
        ps.executeUpdate();
        ps.close();
        conn.close();
    }

    public List<Vehicle> getAllVehicles() throws SQLException
    {
        List<Vehicle> list = new ArrayList<>();
        Connection conn = DbConfig.getConnection();
        Statement st= conn.createStatement();
        ResultSet rs= st.executeQuery("SELECT * from vehicle");
        while(rs.next())
        {
            list.add(new Vehicle(rs.getInt("id"),
                    rs.getInt("customer_id"),
                    rs.getString("number_plate")));
        }
        rs.close();
        st.close();
        conn.close();
        return list;
    }

    public List<Vehicle> getVehiclesByCustomerId(int customerId) throws SQLException
    {
        List<Vehicle> list = new ArrayList<>();
        Connection conn = DbConfig.getConnection();
        PreparedStatement ps = conn.prepareStatement("SELECT * from vehicle where customer_id = ?");
        ps.setInt(1, customerId);
        ResultSet rs = ps.executeQuery();
        while(rs.next())
        {
            list.add(new Vehicle(rs.getInt("id"),
                    rs.getInt("customer_id"),
                    rs.getString("number_plate")));
        }
        rs.close();
        ps.close();
        conn.close();
        return list;
    }
}