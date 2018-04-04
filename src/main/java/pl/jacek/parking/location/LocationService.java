package pl.jacek.parking.location;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.jacek.parking.vehicle.VehicleType;

import javax.transaction.Transactional;
import java.util.UUID;

@Service
public class LocationService {
    private final LocationRepository repository;

    @Autowired
    public LocationService(final LocationRepository repository) {
        this.repository = repository;
    }

    public void addLocation(final LocationDTO dto) {
        final Location location = new Location(
                UUID.randomUUID(),
                dto.getName(),
                dto.getStreetName(), dto.getStreetNumber()
        );

        this.repository.saveAndFlush(location);

    }

    @Transactional
    public void addSpot(final LocationIdentifier locationIdentifier, final ParkingSpotDTO dto) {

        final Location location = this.repository
                .loadByIdentifier(UUID.fromString(locationIdentifier.getId()))
                .orElseThrow(() ->  new IllegalStateException("Location not found!"));


        final VehicleType vehicleType = VehicleType.values()[dto.getType()];

        final ParkingSpot parkingSpot = new ParkingSpot(UUID.randomUUID(), dto.getName(), vehicleType);
        location.addSpot(parkingSpot);

        this.repository.saveAndFlush(location);
    }
}
