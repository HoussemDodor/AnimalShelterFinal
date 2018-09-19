package AnimalShelterFinal.Products;

import AnimalShelterFinal.ISellable;

import java.io.Serializable;

public class Product implements ISellable, Serializable {
    private int ID;
    private static int countProducts = 0;
    private String Name;
    private int Price;

    public Product(String name, int price){
        Name = name;
        Price = price;
        ID = countProducts + 1;
    }

    public void remove(){
        countProducts =- 1;
    }

    @Override
    public String name() {
        return this.Name;
    }

    @Override
    public int price() {
        return Price;
    }

    @Override
    public String toString(){
        return name() + "/ Price: €" + price()+ ",-";
    }
}
