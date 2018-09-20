import AnimalShelterFinal.Animals.Reservor;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.junit.Assert.assertEquals;

public class ReservorTest {

    @Test
    public void testConstructor() {
        LocalDateTime reservedAt = LocalDateTime.now();
        Reservor reservor = new Reservor("John Doe", reservedAt);
        assertEquals("John Doe", reservor.getName());
        assertEquals(reservedAt, reservor.getReservedAt());
    }
}
