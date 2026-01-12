package assignment4;

import java.sql.*;

public class DeleteCivil{
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/college_db";
        String user = "root";
        String password = "rootpassword";

        try (Connection con = DriverManager.getConnection(url, user, password);
             Statement stmt = con.createStatement()) {

            String deleteQuery = "DELETE FROM Students WHERE branch='Civil' AND year_of_passing=2024";
            int rows = stmt.executeUpdate(deleteQuery);
            System.out.println("Deleted " + rows + " record(s) of Civil branch passing 2024");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
