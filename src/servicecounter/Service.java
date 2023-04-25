/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servicecounter;

import java.util.ArrayList;
import java.util.Scanner;
import servicecounter.services.Consultation;
import servicecounter.services.Repair;


/**
 *
 * @author USER
 */
public class Service {
    
    final private int id;
    final private String type;

    private static int nextId = 1;
    
    
    public Service(String type) {
        this.id = nextId;
        this.type = type;
        nextId++;
    }
    
    // old ticket
    public Service(int id, String type) {
        this.id = id;
        this.type = type;
    }

    public int getId() {
        return id;
    }
    
    public String getType() {
        return type;
    }
    
    public double getAverageETA() {
        return 0;
    }
    
    public boolean hasAnsweredQuestions() {
        return true;
    }
    
    // id:type
    @Override 
    public String toString() {
        return id + ":" + type;
    }
}
