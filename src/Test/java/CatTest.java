import AnimalShelterFinal.Animals.Cat;
import AnimalShelterFinal.Animals.Gender;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CatTest {
    private Cat cat;

    @Before
    public void setUp() {
        this.cat = new Cat("Ms. Meow", Gender.female, "Scratches couch");
    }

    @Test
    public void testConstructor() {
        assertEquals("Ms. Meow", this.cat.name());
        assertEquals(Gender.female, this.cat.getGender());
        assertNull(this.cat.getReservedBy());
        assertEquals("Scratches couch", this.cat.getBadHabits());
    }

    @Test
    public void testReservation() {
        assertNull(this.cat.getReservedBy());
        assertTrue(this.cat.reserve("John Doe"));
        assertNotNull(this.cat.getReservedBy());
        assertEquals("John Doe", this.cat.getReservedBy().getName());
        assertFalse(this.cat.reserve("Jane Doe"));
    }
}
