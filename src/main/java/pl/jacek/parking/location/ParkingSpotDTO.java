package pl.jacek.parking.location;


public class ParkingSpotDTO {
    private String name;
    private int type;

    private ParkingSpotDTO() {
    }

    public ParkingSpotDTO(String name, int type) {
        this.name = name;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public int getType() {
        return type;
    }
}
