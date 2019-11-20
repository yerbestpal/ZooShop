/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

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
        
        Admin validAdmin = db.adminLogin("admin1@admin1.com", "admin1");
        if (validAdmin != null) {
            System.out.println("Valid admin logged in");
        }
        else {
            System.out.println("Valid admin NOT logged in");
        }
        
        Admin invalidAdmin = db.adminLogin("admin1@admin1.com", "admin2");
        if (invalidAdmin != null) {
            System.out.println("invalid admin logged in");
        }
        else {
            System.out.println("invalid admin NOT logged in");
        }
    }
}
