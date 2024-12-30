/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package i_am_just_a_cake.logic;

import java.io.*;
import java.util.ArrayList;
import java.util.List; 

/**
 *
 * @author ASUS
 */
public class FileManager {
    //class for dealing with binary files
    
     private static final Object fileLock = new Object(); // Lock object for synchronization
    
    public static <T > List<T> readFromFile (String path)throws  ClassNotFoundException, IOException{
          synchronized (fileLock) {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream( new File(path)))) {
                return (List<T>) ois.readObject();

            }catch (EOFException | FileNotFoundException e) {// If the file is empty or not found, return null
                return null;
            }
          }
    }
    
    public static <T> void writeObjToFile(String path, T newObj) throws ClassNotFoundException, IOException {
         synchronized (fileLock) {
            createDirIfNotExists(path);

            List<T> existingList = readFromFile(path);

            if (existingList == null)
                existingList = new ArrayList<>();

            existingList.add(newObj);

            writeListToFile(path, existingList); 
         }
    }

    public static <T> void writeListToFile(String path, List<T> list) throws  IOException {
         synchronized (fileLock) {
            createDirIfNotExists(path);  

            try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(new File(path)))) {
                oos.writeObject(list);
            }
         }
    }

    public static void createDirIfNotExists(String path) throws IOException {
        File file = new File(path);

        if (!file.exists()) {
            file.getParentFile().mkdirs();
            file.createNewFile();
        }
    }

}
