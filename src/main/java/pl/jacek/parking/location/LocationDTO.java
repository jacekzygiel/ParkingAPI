package pl.jacek.parking.location;

import java.util.List;

public class LocationDTO {
    private String name;
    private String streetName;
    private String streetNumber;

    private LocationDTO() {
    }

    public LocationDTO(String name, String streetName, String streetNumber) {
        this.name = name;
        this.streetName = streetName;
        this.streetNumber = streetNumber;
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
}
