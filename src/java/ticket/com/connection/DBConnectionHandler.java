/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ticket.com.connection;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Emrul
 */
public class DBConnectionHandler {

    Connection con = null;

    public static Connection getConnection() {
        Connection con = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");//Mysql Connection
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DBConnectionHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
       con = (Connection) DriverManager.getConnection("jdbc:mysql://127.4.21.130:3306/ticket", "adminrpb8ac9", "NIqAX44vxl7Y");//mysql database
 // con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/ticket", "root", "123");//mysql database

        } catch (SQLException ex) {
            Logger.getLogger(DBConnectionHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        return con;
    }
}
