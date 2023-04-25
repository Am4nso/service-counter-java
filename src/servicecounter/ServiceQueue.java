/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servicecounter;

import java.util.HashMap;
import java.util.Queue;

/**
 *
 * @author USER
 */
public class ServiceQueue {
    
    // Last element means last in queue
    private Queue<Customer> line;
    private Ticket currentTicket;
    
    private static HashMap<String, ServiceQueue> allQueues;
    
    public boolean addToQueue(Customer customer) {
        if (line.contains(customer)) {
            return false;
        }
        line.add(customer);
        return true;
    }
    
    public Customer nextCustomer() {
        return line.remove();
    }
    
    public double getEstimatedTime(Customer customer) {
        double totalTime = 0;
        for (Customer c : line) {
           if (c == customer) {
               break;
           }
           totalTime += c.getTicket().getService().getAverageETA();
        }
        return totalTime;
    }
    
}
