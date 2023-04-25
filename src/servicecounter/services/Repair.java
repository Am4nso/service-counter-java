/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servicecounter.services;

import servicecounter.Service;

/**
 *
 * @author USER
 */
public class Repair extends Service{

    private String device;
    private String damage;
    private double repairDuration;

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
}
