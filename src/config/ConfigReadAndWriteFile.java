package config;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ConfigReadAndWriteFile<T> {
public static final String PATH = "G:\\Code gym\\Module 2\\MD2-Case Study-StaffManagement\\src\\data\\";
public List<T> readFromFile(String path){
    List<T> tList = new ArrayList<>();
    try {
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(path));
        tList = (List<T>) objectInputStream.readObject();
        objectInputStream.close();
    } catch (Exception e) {
        System.out.println(e.getMessage());
    }
    return tList;
}

public void writeToFile(String path, List<T> tList){
    try {
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(path));
        objectOutputStream.writeObject(tList);
        objectOutputStream.close();
    } catch (FileNotFoundException e) {
        e.printStackTrace();
    } catch (IOException e) {
        System.out.println(e.getMessage());
    }
}
}
