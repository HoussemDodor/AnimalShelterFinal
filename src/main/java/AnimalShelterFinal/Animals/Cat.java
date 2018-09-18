package AnimalShelterFinal.Animals;

public class Cat extends Animal{

    private String BadHabits;

    public String getBadHabits() {
        return BadHabits;
    }

    public Cat(String name, Gender gender, String badHabits){
        super(name, gender);
        this.BadHabits = badHabits;
    }

    @Override
    public String toString() {
        return super.toString() + ", bad habits: " + BadHabits.toLowerCase();
    }
}
