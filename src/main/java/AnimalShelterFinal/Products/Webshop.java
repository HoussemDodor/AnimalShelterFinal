package AnimalShelterFinal.Products;

import AnimalShelterFinal.SaveToFile;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Webshop implements Serializable {
    SaveToFile save;
    public List<Product> products = new ArrayList<>();

    public Webshop() {
        save = new SaveToFile();
        products = save.getListFromFile();
    }

    public void newProduct(String name, int price){
        products.add(new Product(name, price));
        save.saveListToFile(products);
    }

    public void removeProduct(Product product){
        products.remove(product);
        save.saveListToFile(products);
    }
}
