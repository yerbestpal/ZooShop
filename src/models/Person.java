package models;

// imports
import java.util.Date;


public class Person {
    
//    attributes
    private String email;
    private String name;
    private String password;
    private Date dob;
    
    
    // getters
    public String getEmail() {
        return email;
    }
    
    public String getName() {
        return name;
    }
    
    public String getPassword() {
        return password;
    }
    
    public Date getDob() {
        return dob;
    }
    
    
    // setters
    public void setEmail(String email) {
        this.email = email;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    
    public void setDob(Date dob) {
        this.dob = dob;
    }
    
    
    // default constructor (0 parameter)
    public Person() {
        email = "";
        name = "";
        password = "";
        dob = new Date();
    }
    
    
    // overloading constructor (4 parameters)
    public Person(String email, String name, String password, Date dob) {
        this.email = email;
        this.name = name;
        this.password = password;
        this.dob = dob;
    }
}
