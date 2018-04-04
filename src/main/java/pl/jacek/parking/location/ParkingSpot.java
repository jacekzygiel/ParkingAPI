package pl.jacek.parking.location;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
import pl.jacek.parking.vehicle.VehicleType;

import javax.persistence.*;
import java.util.UUID;

@Entity
public class ParkingSpot {
    @Id
    @GenericGenerator(name = "uuid-gen", strategy = "uuid2")
    @GeneratedValue(generator = "uuid-gen")
    @Type(type = "pg-uuid")
    private UUID id;
    private String name;
    private VehicleType type;

    @ManyToOne(targetEntity = Location.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "locationId", referencedColumnName = "id")
    private Location location;

    private ParkingSpot() {

    }
    public ParkingSpot(UUID id, String name, VehicleType type) {
        this.id = id;
        this.name = name;
        this.type = type;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public VehicleType getType() {
        return type;
    }

    public void assignToLocation(final Location location) {
        this.location = location;
    }
}
