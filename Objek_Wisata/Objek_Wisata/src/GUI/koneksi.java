/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author ariff
 */
public class koneksi {
    Connection koneksi=null;
    public static Connection koneksiDb(){
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            Connection koneksi = DriverManager.getConnection("jdbc:mysql://localhost/Aplikasi_Objek_Wisata","root","");
            return koneksi;
        }
        catch(Exception e)
        {
         JOptionPane.showMessageDialog(null,e);
         return null;
        }
        }
    public static Connection getConnection() throws SQLException {
        Connection connection = null;
        String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/Aplikasi_Objek_Wisata";
        String user = "root";
        String password = "";
        if (connection == null) {
            try {
                Class.forName(driver);
                connection = DriverManager.getConnection(url, user, password); 
            } catch (ClassNotFoundException | SQLException error) {
                System.exit(0);
            }
    }
    return connection;
}
}
