package AnimalShelterFinal.Animals;

import java.time.LocalDateTime;

public class Dog extends Animal{

    // fields
    private LocalDateTime lastWalk;
    private static int dogCount;
    private int price;

    // properties
    public LocalDateTime getLastWalk() {
        return this.lastWalk;
    }
    public boolean needsWalk() {
        return  (LocalDateTime.now().getDayOfYear() - getLastWalk().getDayOfYear()) >= 1;
    }

    // constructor
    public Dog(String name, Gender gender) {
        super(name, gender);
        this.lastWalk = LocalDateTime.now();
        this.price = calculatePrice();
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
        return this.price;
    }

    @Override
    public String toString() {
        return super.toString() + ", last walk: " + this.lastWalk.toString();
    }
}