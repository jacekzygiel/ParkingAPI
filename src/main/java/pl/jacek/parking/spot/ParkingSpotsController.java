package pl.jacek.parking.spot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(path = "/api/parking_spot")
public class ParkingSpotsController {
    private ParkingSpotInMemoryDatabase repository;

    @Autowired
    public ParkingSpotsController(ParkingSpotInMemoryDatabase repository) {
        this.repository = repository;
    }

    @GetMapping(path = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<HashMap<String, Object>> parkingSpotList() {
        return this.repository.listParkingSpots();
    }

    @PostMapping(path = "/", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void addParkingSpot(@RequestBody ParkingSpotDTO parkingSpotDTO) {
        final ParkingSpot parkingSpot = new ParkingSpot(UUID.randomUUID(), parkingSpotDTO.getName(),
                parkingSpotDTO.getType());
        this.repository.save(parkingSpot);
    }
}

