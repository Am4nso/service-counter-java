/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servicecounter;

import java.util.ArrayList;
import java.util.Scanner;
import servicecounter.person.Employee;

/**
 *
 * @author Osama
 */
public class Rating {
    
    private int score;
    private String message;
    
    // score:message:employeeUsername
    private static DataStorage storage = new DataStorage("rating");

    public Rating(int score, String message) {
        this.score = score;
        this.message = message;
    }
    
    public static ArrayList<Rating> getAllRatings(Employee employee) {
        ArrayList<Rating> list = new ArrayList<>();
        
        Scanner s = storage.getFile();
        while (s.hasNextLine()) {
            String[] data = s.nextLine().split(":");
            
            if (!data[2].equals(employee.getUsername())){
                continue;
            }
            
            list.add(new Rating(Integer.parseInt(data[0]), data[1]));
            
        }
        
        return list;
    }
    
    public static void postRating(int score, String message, Employee employee) {
        storage.addEntry(score + ":" + message + ":" + employee.getUsername());
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }
    
}
