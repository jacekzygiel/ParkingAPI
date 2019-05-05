package pl.jacek.parking.vehicle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(path = "/api/vehicles")
public class VehicleController {

    private VehicleInMemoryDatabase repository;

    @Autowired
    public VehicleController(VehicleInMemoryDatabase repository) {
        this.repository = repository;
    }

   @GetMapping(path = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<HashMap<String, Object>> vehicleList() {
        return this.repository.listVehicles();
   }

   @PostMapping(path = "/", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void addCar(@RequestBody VehicleDTO vehicleDTO) {

       final Vehicle vehicle = new Vehicle(UUID.randomUUID(), vehicleDTO.getName(),
               vehicleDTO.getPlateNumber(), vehicleDTO.getType());
       this.repository.save(vehicle);
   }
}
