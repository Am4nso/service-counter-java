/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servicecounter.person;

/**
 *
 * @author USER
 */
public class Person {
    private String name;
    private String gender;
    private int phoneNumber;
    private double balance;

    public Person(String name, String gender, int phoneNumber, double balance) {
        this.name = name;
        this.gender = gender;
        this.phoneNumber = phoneNumber;
        this.balance = balance;
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

    public void addToAccount(double amount) {
        balance+=amount;
    }
    
    public void removeFromAccount(double amount) {
        balance-=amount;
    }

}
