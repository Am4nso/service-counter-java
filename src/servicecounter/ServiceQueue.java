/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servicecounter;

import java.util.ArrayList;
import java.util.LinkedList;
import servicecounter.person.Customer;
import java.util.Queue;
import java.util.UUID;

/**
 *
 * @author USER
 */
public class ServiceQueue {
    
    // Last element means last in queue
    private String Id;
    private LinkedList<Customer> line;
    
    private static ArrayList<ServiceQueue> allQueues = new ArrayList<>();

    public ServiceQueue() {
        this.Id = UUID.randomUUID().toString();
        line = new LinkedList<>();
        
        System.out.println("Added " + Id);
        
        allQueues.add(this);
        
        System.out.println(findBestQueue().getId());
    }
    
    public static ServiceQueue findBestQueue() {
        ServiceQueue best = null;
        for (ServiceQueue queue : allQueues) {
            System.out.println(queue.getId());
            if (best == null || best.getLine().size() > queue.getLine().size()) {
                best = queue;
            }
        }
        return best;
    }
    

    public String getId() {
        return Id;
    }
    
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

    public Queue<Customer> getLine() {
        return line;
    }
    
    
    
}
