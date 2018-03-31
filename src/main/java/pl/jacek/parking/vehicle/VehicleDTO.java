package pl.jacek.parking.vehicle;

public class VehicleDTO {
    private String name;
    private String plateNumber;
    private VehicleType type;

    private VehicleDTO() {
    }

    public VehicleDTO(String name, String plateNumber, VehicleType type) {
        this.name = name;
        this.plateNumber = plateNumber;
        this.type = type;
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
