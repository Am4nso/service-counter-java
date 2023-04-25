/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servicecounter;

/**
 *
 * @author USER
 */
public class Employee extends Person {
    final private int employeeId;
    
    private String username;
    private String password;
    
    // entry format:
    // 
    private static DataStorage storage = new DataStorage("employee");
    
    private Counter counter;

    public Employee(String username, String password, String name, String gender, int phoneNumber, double balance) {
        super(name, gender, phoneNumber, balance);
        this.employeeId = this.getId();
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public Counter getCounter() {
        return counter;
    }

    public void setCounter(Counter counter) {
        this.counter = counter;
    }
    
}
