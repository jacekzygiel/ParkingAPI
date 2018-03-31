package pl.jacek.parking.vehicle;

import java.util.UUID;

public class Vehicle {
    private UUID id;
    private String name;
    private String plateNumber;
    private VehicleType type;

    public Vehicle(UUID id, String name, String plateNumber, VehicleType type) {
        this.id = id;
        this.name = name;
        this.plateNumber = plateNumber;
        this.type = type;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public VehicleType getType() {
        return type;
    }
}
