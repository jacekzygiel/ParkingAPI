package pl.jacek.parking.location;

import pl.jacek.parking.spot.ParkingSpot;

import java.util.List;

public class LocationDTO {
    private String name;
    private String streetName;
    private String streetNumber;
    private List<ParkingSpot> spots;

    private LocationDTO() {
    }

    public LocationDTO(String name, String streetName, String streetNumber, List<ParkingSpot> spots) {
        this.name = name;
        this.streetName = streetName;
        this.streetNumber = streetNumber;
        this.spots = spots;
    }

    public String getName() {
        return name;
    }

    public String getStreetName() {
        return streetName;
    }

    public String getStreetNumber() {
        return streetNumber;
    }

    public List<ParkingSpot> getSpots() {
        return spots;
    }
}
