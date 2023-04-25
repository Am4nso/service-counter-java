/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servicecounter;


/**
 *
 * @author USER
 */
public class Service {
    
    
    private String type;
    
    private static int defaultPrice = 3500;
    private static double totalRevenue = 0;

    public String getType() {
        return type;
    }
    
    public double getAverageETA() {
        return 0;
    }

    public static double getTotalRevenue() {
        return totalRevenue;
    }

    public static void addRevenue(double revenue) {
        totalRevenue+=revenue;
    }
    
    public void endService() {
        addRevenue(defaultPrice);
    }
}
