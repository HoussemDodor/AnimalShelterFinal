package AnimalShelterFinal;

import AnimalShelterFinal.Products.Product;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class SaveToFile {
    private String fileNameSerialize = "student.dat";

    public SaveToFile() {};

    public void saveListToFile(List<Product> list) {
        try {
            FileOutputStream fileOut = new FileOutputStream(fileNameSerialize);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(list);
            out.close();
            fileOut.close();
        }
        catch (IOException i) {
            i.printStackTrace();
        }
    }

    public ArrayList<Product> getListFromFile() {
        try {
            FileInputStream fileIn = new FileInputStream(fileNameSerialize);
            ObjectInputStream in = new ObjectInputStream(fileIn);
            ArrayList<Product> list = (ArrayList<Product>)in.readObject();
            in.close();
            fileIn.close();
            return list;
        } catch (IOException i) {
            i.printStackTrace();
            return null;
        } catch (ClassNotFoundException c) {
            System.out.println("Not found");
            c.printStackTrace();
            return null;
        }
    }
}
