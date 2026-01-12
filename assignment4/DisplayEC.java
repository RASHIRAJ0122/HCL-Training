package assignment4;

import java.sql.*;

public class DisplayEC{
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/college_db";
        String user = "root";
        String password = "rootpassword";

        try (Connection con = DriverManager.getConnection(url, user, password);
             Statement stmt = con.createStatement()) {

            String selectQuery = "SELECT * FROM Students WHERE branch='EC' AND semester=7";
            ResultSet rs = stmt.executeQuery(selectQuery);

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String branch = rs.getString("branch");
                int year = rs.getInt("year_of_passing");
                int sem = rs.getInt("semester");
                double perc = rs.getDouble("percentage");

                System.out.println(id + " | " + name + " | " + branch + " | " + year + " | " + sem + " | " + perc);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
