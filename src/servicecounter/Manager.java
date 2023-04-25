/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servicecounter;

import java.util.ArrayList;

/**
 *
 * @author USER
 */
public class Manager extends Employee {
    
    ArrayList<Employee> managedEmployees;

    public Manager(ArrayList<Employee> managedEmployees, Counter counter, String name, String gender, int phoneNumber, double balance) {
        super(counter, name, gender, phoneNumber, balance);
        this.managedEmployees = managedEmployees;
    }
    
    public void manageEmployee(Employee e) {
        managedEmployees.add(e);
    }
    
    public boolean fireEmployee(Employee e) {
        if (!managedEmployees.contains(e)){
            return false;
        }
        
        managedEmployees.remove(e);
        
        return true;
    }
    
}
