package assignment4;

import java.sql.*;

public class CreateAndInsertStudents {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/college_db";
        String user = "root";
        String password = "password";

        try (Connection con = DriverManager.getConnection(url, user, password);
             Statement stmt = con.createStatement()) {

            String createTable = "CREATE TABLE IF NOT EXISTS Students (" +
                    "id INT PRIMARY KEY AUTO_INCREMENT," +
                    "name VARCHAR(50)," +
                    "branch VARCHAR(20)," +
                    "year_of_passing INT," +
                    "semester INT," +
                    "percentage DOUBLE" +
                    ")";
            stmt.execute(createTable);

            String insert1 = "INSERT INTO Students (name, branch, year_of_passing, semester, percentage) " +
                    "VALUES ('Alice', 'CSE', 2025, 7, 85.0)";
            String insert2 = "INSERT INTO Students (name, branch, year_of_passing, semester, percentage) " +
                    "VALUES ('Bob', 'EC', 2025, 7, 78.0)";
            String insert3 = "INSERT INTO Students (name, branch, year_of_passing, semester, percentage) " +
                    "VALUES ('Charlie', 'Civil', 2024, 6, 80.0)";

            stmt.executeUpdate(insert1);
            stmt.executeUpdate(insert2);
            stmt.executeUpdate(insert3);

            System.out.println("Table created and records inserted successfully");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
