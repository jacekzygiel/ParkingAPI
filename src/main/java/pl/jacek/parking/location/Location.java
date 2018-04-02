package pl.jacek.parking.location;

import pl.jacek.parking.spot.ParkingSpot;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Location {
    private UUID id;
    private String name;
    private String streetName;
    private String streetNumber;
    private List spots;

    public Location(UUID id, String name, String streetName, String streetNumber) {
        this.id = id;
        this.name = name;
        this.streetName = streetName;
        this.streetNumber = streetNumber;
        spots = new ArrayList();
    }


    public UUID getId() {
        return id;
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

    public void addSpot(ParkingSpot parkingSpot) {
        spots.add(parkingSpot);
    }

    public List getSpots() {
        return spots;
    }

    public void addMultipleSpots(List<ParkingSpot> parkingSpots) {
        spots.addAll(parkingSpots);
    }
}
