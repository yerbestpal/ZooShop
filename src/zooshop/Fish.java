/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zooshop;

/**
 *
 * @author M20086155
 */
public class Fish extends Animal {
    private String waterType;
    
    
    
    public String getWaterType() {
        return waterType;
    }
    
    

    public void setWaterType(String waterType) {
        this.waterType = waterType;
    }

    
    
    public Fish() {
        super();
        this.waterType = "fresh";
    }
    
    public Fish(int animalId, String name, String type, int age, double cost, boolean isAvailable, char gender, int waterType) {
        super(animalId, name, type, age, cost, isAvailable, gender);
        this.waterType = "fresh";
    }
    
    public Fish(String name, String type, int age, double cost, boolean isAvailable, char gender, int waterType) {
        super(2, name, type, age, cost, isAvailable, gender);
        this.waterType = "fresh";
    }
}
