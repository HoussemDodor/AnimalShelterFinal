package AnimalShelterFinal.Products;

import AnimalShelterFinal.ISellable;

public class AnimalFood implements ISellable {
    private String Name;
    private int Price;

    public AnimalFood(String name, int price){
        Name = name;
        Price = price;
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
