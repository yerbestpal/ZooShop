package zooshop;


public class Animal {
    
    // attributes
    private int animalId;
    private String name;
    private String type;
    private int age;
    private double cost;
    private boolean isAvailable;
    private char gender;
    
    
    // getters
    public int getAnimalId() {
        return animalId;
    }
    
    public String getName() {
        return name;
    }
    
    public String getType() {
        return type;
    }
    
    public int getAge() {
        return age;
    }
    
    public double getCost() {
        return cost;
    }
    
    public boolean getIsAvailable() {
        return isAvailable;
    }
    
    public char getGender() {
        return gender;
    }
    
    
    // setters
    public void setAnimalId(int animalId) {
        this.animalId = animalId;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public void setType(String type) {
        this.type = type;
    }
    
    public void setAge(int age) {
        this.age = age;
    }
    
    public void setCost(double cost) {
        this.cost = cost;
    }
    
    public void setIsAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }
    
    public void setGender(char gender) {
        this.gender = gender;
    }
    
    
    // default constructor
    public Animal() {
        animalId = 0;
        name = "";
        type = "";
        age = 0;
        cost = 0.0;
        isAvailable = false;
        gender = ' ';
    }
    
    
    // overloaded constructor (all parameters)
    public Animal(int animalId, String name, String type, int age, double cost, boolean isAvailable, char gender) {
        this.animalId = animalId;
        this.name = name;
        this.type = type;
        this.age = age;
        this.cost = cost;
        this.isAvailable = isAvailable;
        this.gender = gender;
    }
    
    
    // overloaded constructor (6 parameters)
    public Animal(String name, String type, int age, double cost, boolean isAvailable, char gender) {
        this.animalId = 0; // overloaded with value instead of parameter
        this.name = name;
        this.type = type;
        this.age = age;
        this.cost = cost;
        this.isAvailable = isAvailable;
        this.gender = gender;
    }
}
