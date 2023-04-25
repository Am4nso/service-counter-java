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
    
    private double consultDuration;
    private String topic;

    public Consultation() {
        super("consultation");
        topic = "";
        consultDuration = 0;
    }

    public Consultation(String topic, double consultDuration, int id) {
        super(id, "consultation");
        this.consultDuration = consultDuration;
        this.topic = topic;
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
    
    @Override
    public boolean hasAnsweredQuestions(){
        return !topic.equals("");
    }
    
    @Override 
    public String toString() {
        return getId() + ":repair:" + topic + ":" + consultDuration;
    }
}
