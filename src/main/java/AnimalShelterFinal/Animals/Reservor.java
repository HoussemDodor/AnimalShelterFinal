package AnimalShelterFinal.Animals;
import java.time.LocalDateTime;

public class Reservor {

    private String name;
    private LocalDateTime reservedAt;

    public String getName() {
        return this.name;
    }
    public LocalDateTime getReservedAt() { return this.reservedAt; }

    public Reservor(String name, LocalDateTime reservedAt) {
        this.name = name;
        this.reservedAt = reservedAt;
    }
}