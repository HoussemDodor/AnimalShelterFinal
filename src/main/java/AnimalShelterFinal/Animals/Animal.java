package AnimalShelterFinal.Animals;

import AnimalShelterFinal.ISellable;

import java.time.LocalDateTime;

public abstract class Animal implements ISellable {
    // fields
    private String Name;
    private Gender Gender;
    private Reservor ReservedBy;

    public Reservor getReservedBy() {
        return ReservedBy;
    }

    // Constructor
    public Animal(String name, Gender gender) {
        this.Name = name;
        this.Gender = gender;
    }

    // Methods
    public boolean reserve(String reservedBy) {
        if (getReservedBy() == null) {
            this.ReservedBy = new Reservor(reservedBy, LocalDateTime.now());
            return true;
        }
        return  false;
    }

    @Override
    public String name() {
        return this.Name;
    }

    @Override
    public int price() {
        return -1;
    }

    @Override
    public String toString(){
        String reserved = "not reserved";
        if (this.ReservedBy != null)
        {
            reserved = ", reserved by: " + getReservedBy().getName();
        }

        return name() + ", Price: €" + this.price() + ",- , " + this.Gender.toString() + ", " + reserved;
    }
}
