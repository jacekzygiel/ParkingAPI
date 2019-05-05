package pl.jacek.parking.vehicle;

import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class VehicleInMemoryDatabase {

    private ConcurrentHashMap<UUID, Vehicle> vehicles = new ConcurrentHashMap<>();

    public void save(final Vehicle vehicle) {
        this.vehicles.putIfAbsent(vehicle.getId(), vehicle);
    }

    public List<HashMap<String, Object>> listVehicles() {
        final List<HashMap<String, Object>> vehiclesDetail = new ArrayList<>();
        this.vehicles
                .entrySet()
                .stream()
                .map(Map.Entry::getValue)
                .map(this::createCarDetail)
                .forEach(vehiclesDetail::add);

        return vehiclesDetail;
    }

    private HashMap<String, Object> createCarDetail(Vehicle vehicle) {
        HashMap<String, Object> vehiclesDetail = new HashMap<>();
        vehiclesDetail.put("name", vehicle.getName());
        vehiclesDetail.put("plateNumber", vehicle.getPlateNumber());
        vehiclesDetail.put("vehicleType", vehicle.getType());
        return vehiclesDetail;
    }
}
