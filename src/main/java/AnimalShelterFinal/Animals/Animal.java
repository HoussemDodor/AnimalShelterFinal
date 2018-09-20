package AnimalShelterFinal.Animals;

import AnimalShelterFinal.ISellable;

import java.time.LocalDateTime;

public abstract class Animal implements ISellable {
    // fields
    private String name;
    private Gender gender;
    private Reservor reservedBy;

    public Reservor getReservedBy() {
        return this.reservedBy;
    }
    public Gender getGender() { return this.gender; }

    // Constructor
    public Animal(String name, Gender gender) {
        this.name = name;
        this.gender = gender;
    }

    // Methods
    public boolean reserve(String reservedBy) {
        if (this.reservedBy == null) {
            this.reservedBy = new Reservor(reservedBy, LocalDateTime.now());
            return true;
        }
        return  false;
    }

    @Override
    public String name() {
        return this.name;
    }

    @Override
    public int price() {
        return -1;
    }

    @Override
    public String toString(){
        String reserved = "not reserved";
        if (this.reservedBy != null)
        {
            reserved = ", reserved by: " + getReservedBy().getName();
        }

        return name() + ", Price: €" + this.price() + ",- , " + this.gender.toString() + ", " + reserved;
    }
}
