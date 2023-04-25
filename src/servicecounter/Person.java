/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servicecounter;

/**
 *
 * @author USER
 */
public class Person {
    private int id;
    private String name;
    private String gender;
    private int phoneNumber;
    private double balance;
    
    private static int nextId = 1;

    public Person(String name, String gender, int phoneNumber, double balance) {
        this.id = nextId;
        this.name = name;
        this.gender = gender;
        this.phoneNumber = phoneNumber;
        this.balance = balance;
        nextId++;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public double getBalance() {
        return balance;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void deposite(double amount) {
        balance+=amount;
    }
    
    public boolean withdraw(double amount) {
        if (balance < amount) {
            return false;
        }
        
        balance-=amount;
        return true;
    }

}
