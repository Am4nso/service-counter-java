/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servicecounter.services;

import java.io.IOException;
import servicecounter.Service;

/**
 *
 * @author USER
 */
public class Repair extends Service{

    private String device;
    private String damage;
    private double repairDuration;
    
    public Repair() {
        super("repair");
        device = "";
        damage = "";
        repairDuration = 30; // default
    }

    public Repair(String device, String damage, double repairDuration, int id) {
        super(id, "repair");
        this.device = device;
        this.damage = damage;
        this.repairDuration = repairDuration;
    }

    public String getDevice() {
        return device;
    }

    public void setDevice(String device) {
        this.device = device;
    }

    public String getDamage() {
        return damage;
    }

    public void setDamage(String damage) {
        this.damage = damage;
    }
    
    @Override
    public double getAverageETA() {
        return repairDuration;
    }

    public void setRepairDuration(double repairDuration) {
        this.repairDuration = repairDuration;
    }
    
    @Override
    public boolean hasAnsweredQuestions(){
        return !(device.equals("") && damage.equals(""));
    }
    
    @Override 
    public String toString() {
        return getId() + ":repair:" + device + ":" + damage + ":" + repairDuration;
    }
}
