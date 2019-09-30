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
public class Bird extends Animal {
    private boolean canFly;
    
    
    
    public boolean getCanFly() {
        return canFly;
    }
    
    

    public void setCanFly(boolean canFly) {
        this.canFly = canFly;
    }
    
    
    
    public Bird() {
        super();
        this.canFly = true;
    }
    
    public Bird(int animalId, String name, String type, int age, double cost, boolean isAvailable, char gender, boolean canFly) {
        super(animalId, name, type, age, cost, isAvailable, gender);
        this.canFly = canFly;
    }
    
    public Bird(String name, String type, int age, double cost, boolean isAvailable, char gender, boolean canFly) {
        super(1, name, type, age, cost, isAvailable, gender);
        this.canFly = canFly;
    }
}
