package AnimalShelterFinal.Animals;

public class Cat extends Animal{

    private String BadHabits;

    public Cat(String name, Gender gender, String badHabits){
        super(name, gender);
        this.BadHabits = badHabits;
    }

    @Override
    public int price() {
        int p = 350;

        if (BadHabits.length() > 15){
            p = 35;
        }
        else {
            int x = BadHabits.length() * 20;
            p = p - x;
        }
        return p;
    }

    @Override
    public String toString() {
        return super.toString() + ", bad habits: " + BadHabits.toLowerCase();
    }
}
