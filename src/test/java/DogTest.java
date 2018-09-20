import AnimalShelterFinal.Animals.Dog;
import AnimalShelterFinal.Animals.Gender;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.*;

public class DogTest {
    private Dog dog;

    @Before
    public void setUp() throws Exception {
        this.dog = new Dog("Sgt. Woof", Gender.male);
    }

    @Test
    public void testConstructor() {
        assertEquals("Sgt. Woof", this.dog.name());
        assertEquals(Gender.male, this.dog.getGender());
        assertNull(this.dog.getReservedBy());
        assertEquals(LocalDate.now(), this.dog.getLastWalk().toLocalDate());
        assertFalse(this.dog.needsWalk());
    }

    @Test
    public void testReserve() {
        assertNull(this.dog.getReservedBy());
        assertTrue(this.dog.reserve("John Doe"));
        assertNotNull(this.dog.getReservedBy());
        assertEquals("John Doe", this.dog.getReservedBy().getName());
        assertFalse(this.dog.reserve("Jane Doe"));
    }
}
