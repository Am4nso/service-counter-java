/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servicecounter;

import java.util.ArrayList;
import servicecounter.person.Employee;

/**
 *
 * @author USER
 */
public class Ticket {
    private ServiceQueue queue;
    private Service service;
    private boolean compelete;
    
    private Employee serviceEmployee;

    private static ArrayList<Ticket> tickets = new ArrayList<>();

    public Ticket(ServiceQueue queue, Service service) {
        this.queue = queue;
        this.service = service;
        this.compelete = false;
        
        tickets.add(this);
    }
    
    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    public boolean isCompelete() {
        return compelete;
    }
    
    public void makeComplete() {
        compelete = true;
    }

    public ServiceQueue getQueue() {
        return queue;
    }

    public void setQueue(ServiceQueue queue) {
        this.queue = queue;
    }

    public Employee getServiceEmployee() {
        return serviceEmployee;
    }

    public void setServiceEmployee(Employee serviceEmployee) {
        this.serviceEmployee = serviceEmployee;
    }
    
    
    
    
}
