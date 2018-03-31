package pl.jacek.parking.spot;

import pl.jacek.parking.vehicle.VehicleType;

import java.util.UUID;

public class ParkingSpot {
    private UUID id;
    private String name;
    private VehicleType type;

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
}
