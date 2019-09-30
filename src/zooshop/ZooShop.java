/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zooshop;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author M20086155
 */
public class ZooShop {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        DBManager db = new DBManager();
        HashMap<String, Admin> admins = db.loadAdmins();
        
        for(Map.Entry<String, Admin> adminEntry : admins.entrySet()) {
            Admin admin = adminEntry.getValue();
            System.out.println("Email: " + admin.getEmail());
            System.out.println("Password: " + admin.getPassword());
        }
    }
    
}
