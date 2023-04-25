/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servicecounter.person;

import servicecounter.person.Person;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;
import servicecounter.DataStorage;
import servicecounter.Ticket;

/**
 *
 * @author USER
 */
public class Customer extends Person {
   
    private String username;
    private String password;
    private Ticket ticket;
    
    
    // entry format:
    // username:password:name:gender:phonenumber:balance
    private static DataStorage storage = new DataStorage("customer");
    
    private static HashMap<String, Customer> cache = new HashMap<>();
    
    // Registeration constructor
    public Customer(String username, String password, String name, String gender, int phoneNumber) {
        super(name, gender, phoneNumber, 0);
        this.username = username;
        this.password = password;
        
        storage.addEntry(this.toString());
    }
    
    public Customer(String username, String password, String name, String gender, int phoneNumber, double balance) {
        super(name, gender, phoneNumber, balance);
        this.username = username;
        this.password = password;
    }
    
    public static Customer login(String username, char[] passwordArray) {
        String password = new String(passwordArray);
        
        if (cache.containsKey(username)) {
            Customer a = cache.get(username);
            if (a.checkPassword(password)){
                return a;
            }
        }
        
        String[] userEntry = storage.findEntry(0, username.toLowerCase());
        
        if (userEntry == null) {
            return null;
        }
        
        String linePassword = userEntry[1];
        
        if (!linePassword.equals(password)) {
            return null;
        }
                
        Customer a = new Customer(username.toLowerCase(), linePassword, userEntry[2], userEntry[3], Integer.parseInt(userEntry[4]), Double.parseDouble(userEntry[5]));
        
        cache.put(username, a);
        
        return a;
    }
    
    public boolean checkPassword(String password) {
        return this.password.equals(password);
    }
    
    public static boolean usernameAvailability(String username) {
        return storage.findEntry(0, username) == null;
    }
    
    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }
    
    public void deposite(double amount) {
        addToAccount(amount);
        String old = String.join(":", storage.findEntry(0, username));
        storage.replaceEntry(old, toString());
    }
    
    public void withdraw(double amount) {
        removeFromAccount(amount);
        String old = String.join(":", storage.findEntry(0, username));
        storage.replaceEntry(old, toString());
    }
    
    @Override 
    public String toString() {
        return username + ":" + password + ":" + this.getName() + ":" + this.getGender() + ":" + this.getPhoneNumber() + ":" + this.getBalance();
    }
    
}
