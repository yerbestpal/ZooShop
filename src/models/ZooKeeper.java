/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.util.Date;

/**
 *
 * @author M20086155
 */
public class ZooKeeper extends Person {
    private String telephoneNo;
    private boolean isRegistered;
    
    
    public String displayGreeting() {
        String greeting = "<html>Hello " + getName() + "<br>"
                + "You are logged in as a ZooKeeper";

        return greeting;
    }

    
    
    public String getTelehphoneNo() {
        return telephoneNo;
    }

    public boolean getIsRegistered() {
        return isRegistered;
    }
    
    
    
    public void setTelephoneNo(String telephoneNo) {
        this.telephoneNo = telephoneNo;
    }
    
    public void setIsRegistered(boolean isRegistered) {
        this.isRegistered = isRegistered;
    }
    
    
    
    public ZooKeeper() {
        super();
        this.telephoneNo = "";
        this.isRegistered = true;
    }
    
    public ZooKeeper(String email, String name, String password, Date dob, String telephoneNo, boolean isRegistered) {
        super(email, name, password, dob);
        this.telephoneNo = telephoneNo;
        this.isRegistered = isRegistered;
    }
    
    public ZooKeeper(String email, String name, String password, Date dob, String telephoneNo) {
        super(email, name, password, dob);
        this.telephoneNo = telephoneNo;
        this.isRegistered = true;
    }
}
