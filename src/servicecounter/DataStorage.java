/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servicecounter;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author USER
 */
public class DataStorage {
    
    final private String pathDirectory;

    public DataStorage(String filePrefix) {
        this.pathDirectory = "src/storage/" + filePrefix + "-data.txt";
    }
    
    public void addEntry(String entry) throws IOException {
        FileWriter writer = new FileWriter(pathDirectory);
        
        writer.append(entry + "\n");
        
        writer.close();
    }
    
    public Scanner getFile() {
        System.out.println(pathDirectory);
        try {   
            return new Scanner(new FileReader(pathDirectory));
        } catch (FileNotFoundException e) {
            return null;
        }
    }
    
}
