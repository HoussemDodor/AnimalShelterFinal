package AnimalShelterFinal.Animals;

public class Cat extends Animal{

    private String badHabits;

    public String getBadHabits() { return this.badHabits; }

    public Cat(String name, Gender gender, String badHabits){
        super(name, gender);
        this.badHabits = badHabits;
    }

    @Override
    public int price() {
        int p = 350;

        if (this.badHabits.length() > 15){
            p = 35;
        }
        else {
            int x = this.badHabits.length() * 20;
            p = p - x;
        }
        return p;
    }

    @Override
    public String toString() {
        return super.toString() + ", bad habits: " + this.badHabits.toLowerCase();
    }
}
