/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zooshop;

import java.util.Date;

/**
 *
 * @author M20086155
 */
public class Admin extends Person {
    private boolean superUser;
    
    
    
    public boolean getSuperUser() {
        return superUser;
    }
    
    
    
    public void setSuperUser(boolean superUser) {
        this.superUser = superUser;
    }
    
    
    
    public Admin() {
        super();
        this.superUser = true;
    }
    
    
    public Admin(String email, String name, String password, Date dob, boolean superUser) {
        super(email, name, password, dob);
        this.superUser = superUser;
    }
    
}
