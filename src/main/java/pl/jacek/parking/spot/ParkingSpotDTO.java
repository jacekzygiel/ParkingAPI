package pl.jacek.parking.spot;

import pl.jacek.parking.vehicle.VehicleType;

public class ParkingSpotDTO {
    private String name;
    private VehicleType type;

    private ParkingSpotDTO() {
    }

    public ParkingSpotDTO(String name, VehicleType type) {
        this.name = name;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public VehicleType getType() {
        return type;
    }
}
