package assignment4;

import java.sql.*;

public class IncreaseCSEPercentage {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/college_db";
        String user = "root";
        String password = "rootpassword";

        try (Connection con = DriverManager.getConnection(url, user, password);
             Statement stmt = con.createStatement()) {

            String updateQuery = "UPDATE Students SET percentage = percentage * 1.05 WHERE branch='CSE'";
            int rows = stmt.executeUpdate(updateQuery);
            System.out.println("Updated " + rows + " record(s) for CSE branch");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
