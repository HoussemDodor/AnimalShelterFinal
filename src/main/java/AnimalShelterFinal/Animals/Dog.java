package AnimalShelterFinal.Animals;

import java.time.LocalDateTime;

public class Dog extends Animal{

    // fields
    private LocalDateTime LastWalk;

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
    }

    // Methods
    public String ToString() {
        return super.toString() + ", last walk: " + this.LastWalk.toString();
    }
}