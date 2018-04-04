package pl.jacek.parking.location;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
@Entity
 final class Location {

    @Id
    @GenericGenerator(name = "uuid-gen", strategy = "uuid2")
    @GeneratedValue(generator = "uuid-gen")
    @Type(type = "pg-uuid")
    private UUID id;

    private String name;
    private String streetName;
    private String streetNumber;

    @OneToMany(mappedBy = "location", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<ParkingSpot> parkingSpots = new ArrayList<>();

   private Location() {
   }

   Location(UUID id, String name, String streetName, String streetNumber) {
        this.id = id;
        this.name = name;
        this.streetName = streetName;
        this.streetNumber = streetNumber;
    }

    void addSpot(ParkingSpot parkingSpot) {

        parkingSpot.assignToLocation(this);
        this.parkingSpots.add(parkingSpot);
    }

}
