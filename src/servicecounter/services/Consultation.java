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
public class Consultation extends Service{

    final private static double rateInMinute = 50;
    
    private double consultDuration = 30;
    private String topic;
    
    @Override
    public void endService() {
        addRevenue(rateInMinute*consultDuration);
    }
    
    public void endService(double specialRate) {
        addRevenue(rateInMinute*specialRate);
    }

    @Override
    public double getAverageETA() {
        return consultDuration;
    }

    public void setConsultDuration(double consultDuration) {
        this.consultDuration = consultDuration;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }
    
    
}
