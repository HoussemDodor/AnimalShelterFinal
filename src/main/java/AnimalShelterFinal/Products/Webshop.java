package AnimalShelterFinal.Products;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Webshop implements Serializable {
    private String fileNameSerialize = "student.dat";
    public List<Product> products = new ArrayList<>();

    //TODO Maak  een SAVE FILE CLASS OM DUPlicated code te verwijderen.

    public Webshop() {
        try {
            FileInputStream fileIn = new FileInputStream(fileNameSerialize);
            ObjectInputStream in = new ObjectInputStream(fileIn);
            products = (ArrayList<Product>)in.readObject();
            in.close();
            fileIn.close();
        } catch (IOException i) {
            i.printStackTrace();
            return;
        } catch (ClassNotFoundException c) {
            System.out.println("Not found");
            c.printStackTrace();
            return;
        }
    }

    public void newProduct(String name, int price){
        products.add(new Product(name, price));
        try {
            FileOutputStream fileOut =
                    new FileOutputStream(fileNameSerialize);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(products);
            out.close();
            fileOut.close();
            System.out.printf("Serialized data is saved in /tmp/employee.ser");
        } catch (IOException i) {
            i.printStackTrace();
        }
    }

    public void removeProduct(Product product){
        //
        product.remove();
        products.remove(product);

        try {
            FileOutputStream fileOut =
                    new FileOutputStream(fileNameSerialize);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(products);
            out.close();
            fileOut.close();
            System.out.printf("/tmp/employee.ser");
        } catch (IOException i) {
            i.printStackTrace();
        }

    }
}
