package AnimalShelterFinal.Animals;

import java.time.LocalDateTime;

public class Dog extends Animal{

    // fields
    private LocalDateTime LastWalk;
    private static int dogCount;
    private int Price;

    public boolean NeedsWalk() {
        return  (LocalDateTime.now().getDayOfYear() - getLastWalk().getDayOfYear()) >= 1;
    }

    // properties
    public LocalDateTime getLastWalk() {
        return LastWalk;
    }

    // constructor
    public Dog(String name, Gender gender) {
        super(name, gender);
        this.LastWalk = LocalDateTime.now();
        Price = calculatePrice();
        dogCount += 1;
    }

    // Methods
    private int calculatePrice() {
        int p = 500;

        if (dogCount > 9){
            p = 50;
        }
        else {
            int x = dogCount * 50;
            p = p - x;
        }
        return p;
    }

    @Override
    public int price() {
        return Price;
    }

    @Override
    public String toString() {
        return super.toString() + ", last walk: " + this.LastWalk.toString();
    }
}