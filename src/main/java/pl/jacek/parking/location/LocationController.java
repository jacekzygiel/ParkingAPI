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
    private LocationQuery repository;
    private final LocationService service;

    @Autowired
    public LocationController(final LocationQuery repository, final LocationService service) {
        this.repository = repository;
        this.service = service;
    }

    @GetMapping(path = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<HashMap<String, Object>> locationList() {
        return this.repository.listLocations();
    }

    @PostMapping(path = "/", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void addLocation(@RequestBody LocationDTO locationDTO) {
        this.service.addLocation(locationDTO);
    }


    @PutMapping(path = "/{id}/spots", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void addPost(@PathVariable("id") LocationIdentifier locationIdentifier, @RequestBody ParkingSpotDTO dto) {
        this.service.addSpot(locationIdentifier, dto);
    }
}