/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servicecounter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 *
 * @author USER
 */
public class Ticket {
    
    private int ticketNumber;
    private ServiceQueue queue;
    private Service service;
    
    private static HashMap<String, Ticket> allTickets = new HashMap<>();
    private static int nextNumber = 1;
    
    // ticketNumber:service:queueType
    private static DataStorage storage = new DataStorage("ticket");
    
    static {
        Scanner s = storage.getFile();
        while (s.hasNextLine()) {
            String[] data = s.nextLine().split(":");
            
            int ticketNumber = Integer.parseInt(data[0]);
            service
        }
    }

    public int getTicketNumber() {
        return ticketNumber;
    }
    
    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    public ServiceQueue getQueue() {
        return queue;
    }

    public void setQueue(ServiceQueue queue) {
        this.queue = queue;
    }

    public static HashMap<String, Ticket> getAllTickets() {
        return allTickets;
    }    
    
}
