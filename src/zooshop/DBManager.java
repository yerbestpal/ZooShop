/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zooshop;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;
import java.util.HashMap;

/**
 *
 * @author M20086155
 */
public class DBManager {
    private final String driver = "net.ucanaccess.jdbc.UcanaccessDriver";
    private final String connectionString = "jdbc:ucanaccess://H:\\HND\\object_oriented_programming\\ZooShop\\data\\ZooShopDB.accdb";
    
    public HashMap<String, Admin> loadAdmins() {
        HashMap<String, Admin> admins = new HashMap();
        try {
           Class.forName(driver);
           Connection conn = DriverManager.getConnection(connectionString);
           Statement stmt = conn.createStatement();
           ResultSet rs = stmt.executeQuery("SELECT * FROM Admins");
           
           while (rs.next()) {
               String emailAddress = rs.getString("EmailAddress");
               String name = rs.getString("PersonName");
               String password = rs.getString("Password");
               Date dob = rs.getDate("DateOfBirth");
               boolean superUser = rs.getBoolean("SuperUser");
               
               // Admin(String email, String name, String password, Date dob, boolean superUser)
               Admin admin = new Admin(emailAddress, name, password, dob, superUser);
               
               admins.put(emailAddress, admin);
           }
           
           conn.close();
        } 
        catch (Exception ex) {
            System.out.println("Exception: " + ex.getMessage());
        } 
        finally {
            return admins;
        }
    }
}
