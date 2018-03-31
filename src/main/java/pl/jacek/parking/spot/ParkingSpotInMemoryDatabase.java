package pl.jacek.parking.spot;

import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class ParkingSpotInMemoryDatabase {

    private ConcurrentHashMap<UUID, ParkingSpot>  parkingSpots = new ConcurrentHashMap<>();

    public void save(final ParkingSpot parkingSpot) {
        this.parkingSpots.putIfAbsent(parkingSpot.getId(), parkingSpot);
    }

    public List<HashMap<String, Object>> listParkingSpots() {
        final List<HashMap<String, Object>> parkingSpotDetail = new ArrayList<>();

        this.parkingSpots
                .entrySet()
                .stream()
                .map(Map.Entry::getValue)
                .map(this::createParkingSpotDetail)
                .forEach(parkingSpotDetail::add);

        return parkingSpotDetail;
    }

    private HashMap<String, Object> createParkingSpotDetail(ParkingSpot parkingSpot) {
        HashMap<String, Object> parkingSpotDetail = new HashMap<>();
        parkingSpotDetail.put("name", parkingSpot.getName());
        parkingSpotDetail.put("type", parkingSpot.getType());
        return parkingSpotDetail;
    }
}
