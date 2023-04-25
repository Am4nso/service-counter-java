/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servicecounter;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
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
    
    public String[] findEntry(int index, String value) {
        Scanner s = this.getFile();
        while (s.hasNextLine()) {
            String[] data = s.nextLine().split(":");
            if (data[index].equals(value)) {
                return data;
            }
        }
        return null;
    }
    
    public void addEntry(String entry) {
        File file = new File(pathDirectory);

        try {
            FileWriter writer = new FileWriter(file, true); // Append mode

            writer.write(entry + System.getProperty("line.separator"));

            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void replaceEntry(String oldLine, String newLine) {
        File file = new File(pathDirectory);

        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            StringBuilder stringBuilder = new StringBuilder();
            String line;
            boolean found = false;

            while ((line = reader.readLine()) != null) {
               if (line.equals(oldLine)) {
                  stringBuilder.append(newLine).append(System.getProperty("line.separator"));
                  found = true;
               } else {
                  stringBuilder.append(line).append(System.getProperty("line.separator"));
               }
            }

            if (!found) {
               stringBuilder.append(newLine).append(System.getProperty("line.separator"));
            }

            reader.close();

            BufferedWriter writer = new BufferedWriter(new FileWriter(file));
            writer.write(stringBuilder.toString());
            writer.close();
         } catch (IOException e) {
            e.printStackTrace();
        }
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
