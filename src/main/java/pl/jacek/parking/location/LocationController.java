package pl.jacek.parking.location;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(path = "/api/locations")
public class LocationController {
    private LocationInMemoryDatabase repository;

    @Autowired
    public LocationController(LocationInMemoryDatabase repository) {
        this.repository = repository;
    }

    @GetMapping(path = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<HashMap<String, Object>> locationList() {
        return this.repository.listLocations();
    }

    @PostMapping(path = "/", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void addLocation(@RequestBody LocationDTO locationDTO) {
        final Location location = new Location(UUID.randomUUID(), locationDTO.getName(),
                locationDTO.getStreetName(), locationDTO.getStreetNumber());
        this.repository.save(location);
    }
}