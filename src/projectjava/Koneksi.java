/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectjava;

import java.sql.*;


/**
 *
 * @author SIDAM
 */
public class Koneksi {
    private static Connection MyConfig;

    public static Connection configDB() throws SQLException, ClassNotFoundException {
        try {
            String url = "jdbc:mysql://localhost/projectjava";
            String user = "root";
            String pass = "";

            Class.forName("com.mysql.jdbc.Driver");
            MyConfig = DriverManager.getConnection(url, user, pass);
        } catch (SQLException e) {
            System.out.println("Koneksi database gagal " + e.getMessage());
        }
        return MyConfig;
    }
    
}
