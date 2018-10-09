import AnimalShelterFinal.Animals.Gender;
import AnimalShelterFinal.Reservation;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ReservationTest {
    private Reservation reservation;

    @Before
    public void setUp() {
        reservation = new Reservation();
    }

    @Test
    public void testNewDog() {
        assertEquals(0, this.reservation.Animals.size());
        this.reservation.newDog("Ms. Meow", Gender.female);
        assertEquals(1, this.reservation.Animals.size());
    }

    @Test
    public void testNewCat() {
        assertEquals(0, this.reservation.Animals.size());
        this.reservation.newCat("Ms. Meow", Gender.female, "Scratches couch");
        assertEquals(1, this.reservation.Animals.size());
    }
}
