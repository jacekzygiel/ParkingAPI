package pl.jacek.parking.location;

import org.springframework.stereotype.Service;
import pl.jacek.parking.spot.ParkingSpot;


import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class LocationInMemoryDatabase {

    private ConcurrentHashMap<UUID, Location> locations = new ConcurrentHashMap<>();

    public void save(final Location location) {
        this.locations.putIfAbsent(location.getId(), location);
    }

    public List<HashMap<String,Object>> listLocations() {
        final List<HashMap<String, Object>> locationDetail = new ArrayList<>();

        this.locations
                .entrySet()
                .stream()
                .map(Map.Entry::getValue)
                .map(this::createLocationDetail)
                .forEach(locationDetail::add);
        return locationDetail;
    }

    private HashMap<String, Object> createLocationDetail(Location location) {
        HashMap<String, Object> locationDetail = new HashMap<>();
        locationDetail.put("name", location.getName());
        locationDetail.put("street_name", location.getStreetName());
        locationDetail.put("street_number", location.getStreetNumber());
        locationDetail.put("spots", location.getSpots());
        return locationDetail;
    }
}
