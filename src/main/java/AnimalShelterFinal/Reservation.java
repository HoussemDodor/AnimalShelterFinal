package AnimalShelterFinal;
import AnimalShelterFinal.Animals.*;


import java.util.ArrayList;
import java.util.List;

public class Reservation {

    public List<Animal> Animals = new ArrayList<>();

    public void NewCat(String name, Gender gender, String badHabits){
        this.Animals.add(new Cat(name, gender, badHabits));
    }

    public void NewDog(String name, Gender gender) {
        this.Animals.add(new Dog(name, gender));
    }
}