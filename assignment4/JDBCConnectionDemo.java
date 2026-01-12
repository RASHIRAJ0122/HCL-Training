package assignment4;

import java.sql.*;

public class JDBCConnectionDemo {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/college_db";
        String user = "root";
        String password = "password";

        try {
            Connection con = DriverManager.getConnection(url, user, password);
            if (con != null) {
                System.out.println("Connection Successful");
                con.close();
            } else {
                System.out.println("Unable to connect");
            }
        } catch (SQLException e) {
            System.out.println("Unable to connect");
            e.printStackTrace();
        }
    }
}
