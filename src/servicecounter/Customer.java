/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servicecounter;

import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

/**
 *
 * @author USER
 */
public class Customer extends Person {
   
    private String username;
    private String password;
    private Ticket ticket;
    private boolean available;
    
    // entry format:
    // username:password:name:gender:phonenumber:balance
    private static DataStorage storage = new DataStorage("customer");
    
    private static HashMap<String, Customer> cache = new HashMap<>();
    
    // Registeration constructor
    public Customer(String username, String password, String name, String gender, int phoneNumber) {
        super(name, gender, phoneNumber, 0);
        this.username = username;
        this.password = password;
        try {   
            storage.addEntry(this.toString());
        } catch (IOException e) {
            System.out.println("A critical error occured. Seems like the program doesn't have permissions to write files.");
        }
    }
    
    public Customer(String username, String password, String name, String gender, int phoneNumber, double balance, Ticket ticket) {
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
        
        Scanner theStorage = storage.getFile();
        
        if (theStorage == null) {
            return null;
        }
        
        while (theStorage.hasNextLine()) {
            
            String[] data = theStorage.nextLine().split(":");
            
            System.out.println(data.length);
            
            String lineUsername = data[0];
            String linePassword = data[1];
            System.out.println(lineUsername);
            System.out.println(linePassword);
            
            if (lineUsername.equals(username) && linePassword.equals(password)) {
                
                // todo find ticket if exists.
                Ticket t = null;
                
                Customer a = new Customer(lineUsername, linePassword, data[2], data[3], Integer.parseInt(data[4]), Double.parseDouble(data[5]), t);
                cache.put(username, a);
                return a;
            }
        }
        
        return null;
    }
    
    public boolean checkPassword(String password) {
        return this.password.equals(password);
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }
    
    public Ticket getTicket() {
        if (ticket == null) {
            
        }
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }
    
    @Override 
    public String toString() {
        return username + ":" + password + ":" + this.getGender() + ":" + this.getPhoneNumber() + ":" + this.getBalance();
    }
    
}
