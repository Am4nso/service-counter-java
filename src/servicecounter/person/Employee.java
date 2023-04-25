/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servicecounter.person;

import java.io.IOException;
import java.util.ArrayList;
import servicecounter.Counter;
import servicecounter.DataStorage;
import servicecounter.Rating;

/**
 *
 * @author USER
 */
public class Employee extends Person {
    
    private String username;
    private String password;
    private ArrayList<Rating> ratings;
    
    private static DataStorage storage = new DataStorage("employee");
    
    private Counter counter;

    public Employee(String username, String password, String name, String gender, int phoneNumber, double balance) {
        super(name, gender, phoneNumber, balance);
        this.username = username;
        this.password = password;
        
        ratings = new ArrayList<>();
        
        storage.addEntry(this.toString());
    }
    
    public Employee(String username, String password, String name, String gender, int phoneNumber, double balance, ArrayList<Rating> ratings) { 
        super(name, gender, phoneNumber, balance);
        this.ratings = ratings;
    }
    
    public static Employee login(String username, char[] passwordArray) {
        String password = new String(passwordArray);
        
        String[] userEntry = storage.findEntry(0, username.toLowerCase());
        
        if (userEntry == null) {
            return null;
        }
        
        String linePassword = userEntry[1];
        
        if (!linePassword.equals(password)) {
            return null;
        }
                
        Employee a = new Employee(username.toLowerCase(), linePassword, userEntry[2], userEntry[3], Integer.parseInt(userEntry[4]), Double.parseDouble(userEntry[5]));
        
        return a;
    }
    
    public boolean checkPassword(String password) {
        return this.password.equals(password);
    }
    
    public static boolean usernameAvailability(String username) {
        return storage.findEntry(0, username) == null;
    }

    public String getUsername() {
        return username;
    }

    public ArrayList<Rating> getRatings() {
        return Rating.getAllRatings(this);
    }
    
    public Counter getCounter() {
        return counter;
    }

    public void setCounter(Counter counter) {
        this.counter = counter;
    }
    
    public int calculateRating() {
        if (getRatings().isEmpty()){
            return 0;
        }
        int rating = 0;
        for (Rating i : getRatings()) {
            rating += i.getScore();
        }
        return rating/getRatings().size();
    }
    
    public String getRatingMessages() {
        if (getRatings().isEmpty()){
            return "";
        }
        String message = "";
        for (Rating i : getRatings()) {
            message += i.getMessage() + "\n\n";
        }
        return message;
    }
    
    public void deposite(double amount) {
        addToAccount(amount);
        String old = String.join(":", storage.findEntry(0, username));
        storage.replaceEntry(old, toString());
    }
    
    @Override 
    public String toString() {
        return username + ":" + password + ":" + this.getName() + ":" + this.getGender() + ":" + this.getPhoneNumber() + ":" + this.getBalance();
    }
}
