/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

/**
 *
 * @author M20086155
 */
public class DBManager {
    private final String driver = "net.ucanaccess.jdbc.UcanaccessDriver";
    
    /* CONNECTIONSTRING FOR COLLEGE */
//    private final String connectionString = "jdbc:ucanaccess://H:\\HND\\oop\\ZooShop\\data\\ZooShopDB.accdb";
    
    
/* CONNECTIONSTRING FOR HOME */
    private final String connectionString = "jdbc:ucanaccess://data/ZooShopDB.accdb";

    
    
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
    
    
    public Admin adminLogin(String emailAddress, String password) {
        HashMap<String, Admin> admins = loadAdmins();
        
        if (admins.containsKey(emailAddress)) {
            Admin foundAdmin = admins.get(emailAddress);
            if (foundAdmin.getPassword().equals(password)) {
                return foundAdmin;
            }
            else {
                return null;
            }
        }
        else {
            return null;
        }
    }
    
    
    public HashMap<String, ZooKeeper> loadZooKeepers() {
       HashMap<String, ZooKeeper> ZooKeepers = new HashMap();
       try {
          Class.forName(driver);
          Connection conn = DriverManager.getConnection(connectionString);
          Statement stmt = conn.createStatement();
          ResultSet rs = stmt.executeQuery("SELECT * FROM ZooKeepers");

          while (rs.next()) {
              String emailAddress = rs.getString("EmailAddress");
              String name = rs.getString("PersonName");
              String password = rs.getString("Password");
              Date dob = rs.getDate("DateOfBirth");
              String telephoneNo = rs.getString("TelephoneNo");

              // ZooKeeper(String email, String name, String password, Date dob, String telephoneNo)
              ZooKeeper zk = new ZooKeeper(emailAddress, name, password, dob, telephoneNo);

              ZooKeepers.put(emailAddress, zk);
          }

          conn.close();
       } 
       catch (Exception ex) {
           System.out.println("Exception: " + ex.getMessage());
       } 
       finally {
           return ZooKeepers;
       }
    }
    
    
    public ZooKeeper zooKeeperLogin(String emailAddress, String password) {
        HashMap<String, ZooKeeper> zooKeepers = loadZooKeepers();
        
        if (zooKeepers.containsKey(emailAddress)) {
            ZooKeeper foundZooKeeper = zooKeepers.get(emailAddress);
            if (foundZooKeeper.getPassword().equals(password)) {
                return foundZooKeeper;
            }
            else {
                return null;
            }
        }
        else {
            return null;
        }
    }
     
     
    public HashMap<Integer, Animal> loadAnimals() {
       HashMap<Integer, Animal> animals = new HashMap();
       try {
          Class.forName(driver);
          Connection conn = DriverManager.getConnection(connectionString);
          Statement stmt = conn.createStatement();
          ResultSet rs = stmt.executeQuery("SELECT * FROM Animals");

          while (rs.next()) {
              int animalId = rs.getInt("AnimalID");
              String animalName = rs.getString("AnimalName");
              char gender = rs.getString("Gender").charAt(0);
              String type = rs.getString("Type");
              int age = rs.getInt("Age");
              String location = rs.getString("Location");
              String waterType = rs.getString("WaterType");
              boolean canFly = rs.getBoolean("CanFly");
              boolean availability = rs.getBoolean("Availability");
              double cost = rs.getDouble("Cost");
              
              if (waterType == null) {
                  // make bird
                  Bird bird = new Bird(animalId, animalName, type, age, cost, 
                                       availability, gender, canFly);
                  
                  animals.put(animalId, bird);
              }
              else if (waterType.equals("")) {
                  // make bird
                  Bird bird = new Bird(animalId, animalName, type, age, cost, 
                                       availability, gender, canFly);
                  
                  animals.put(animalId, bird);
              }
              else {
                  // make fish
                  Fish fish = new Fish(animalId, animalName, type, age, cost, 
                                       availability, gender, waterType);
                  animals.put(animalId, fish);
              }
          }

          conn.close();
       } 
       catch (Exception ex) {
           System.out.println("Exception: " + ex.getMessage());
       } 
       finally {
           return animals;
       }
    }
    
    
    public boolean registerZooKeeper(ZooKeeper zookeeper) {
        try {
          Class.forName(driver);
          Connection conn = DriverManager.getConnection(connectionString);
          Statement stmt = conn.createStatement();
          
          stmt.executeUpdate("INSERT INTO ZooKeepers (EmailAddress, PersonName, Password, DateOfBirth, TelephoneNo) " 
                  + "VALUES ('" + zookeeper.getEmail() + "',"
                          + "'" + zookeeper.getName() + "',"
                          + "'" + zookeeper.getPassword() + "',"
                          + "'" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(zookeeper.getDob()) + "',"
                          + "'" + zookeeper.getTelehphoneNo() + "')");
          conn.close();
          return true;
        }
        catch (Exception ex) {
            System.out.println("Exception: " + ex.getMessage());
            return false;
        }
    }
    
    
    public void deleteZooKeeper(String zooKeeperEmail) {
        try {
          Class.forName(driver);
          Connection conn = DriverManager.getConnection(connectionString);
          Statement stmt = conn.createStatement();
          stmt.executeUpdate("DELETE FROM ZooKeepers "
                           + "WHERE EmailAddress = '" + zooKeeperEmail + "';");
          conn.close();
        }
        catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }
    
    
    public void deleteAnimal(int AnimalID) {
        try {
          Class.forName(driver);
          Connection conn = DriverManager.getConnection(connectionString);
          Statement stmt = conn.createStatement();
          stmt.executeUpdate("DELETE FROM Animals "
                           + "WHERE AnimalID = " + AnimalID + ";");
          conn.close();
        }
        catch (Exception ex) {
            System.out.println("Error - cannot delete: " + ex.getMessage());
        }
    }
}
