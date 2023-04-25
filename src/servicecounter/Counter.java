/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servicecounter;

import servicecounter.person.Customer;

/**
 *
 * @author USER
 */
public class Counter {
    
    private ServiceQueue queue;
    private Customer currentCustomer;
    
    public static double revenue = 0;
    

    public Counter() {
        this.queue = new ServiceQueue();
        this.currentCustomer = null;
    }

    public ServiceQueue getQueue() {
        return queue;
    }

    public Customer getCurrentCustomer() {
        return currentCustomer;
    }

    public void setCurrentCustomer(Customer currentCustomer) {
        this.currentCustomer = currentCustomer;
    }
    
    public String queueList() {
        
        String list = "";
        
        for (Customer i : queue.getLine()) {
            list += i.getName() + "\n";
        }
        
        return list;
    }
    
}
