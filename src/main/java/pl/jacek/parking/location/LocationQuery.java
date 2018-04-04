package pl.jacek.parking.location;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;


import java.io.IOException;
import java.util.*;

@Service
public class LocationQuery {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public LocationQuery(final JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<HashMap<String, Object>> listLocations() {

        return this.jdbcTemplate
                .query("SELECT l.id, l.name, l.street_name, l.street_number, " +
                        "  json_agg(json_build_object('spot_name', spot.name, 'spot_id', spot.id)) as spots " +
                        "FROM location as l " +
                        "JOIN parking_spot as spot on l.id = spot.location_id\n" +
                        "GROUP BY l.id", (resultSet, i) -> {
                    final HashMap<String, Object> locationDetail = new HashMap<>();
                    locationDetail.put("location_id", resultSet.getString("id"));
                    locationDetail.put("location_name", resultSet.getString("name"));
                    locationDetail.put("location_street", resultSet.getString("street_name"));
                    locationDetail.put("location_number", resultSet.getString("street_number"));
                    locationDetail.put("location_spots", this.normalize(resultSet.getString("spots")));
                    return locationDetail;

                });
    }

    private List<Map<String, Object>> normalize(final String spots) {
        final ObjectMapper mapper = new ObjectMapper();

        final List<Map<String, Object>> result = new ArrayList<>();

        try {
            result.addAll(mapper.readValue(spots, new com.fasterxml.jackson.core.type.TypeReference<List<Map<String, Object>>>() {}));
        } catch (IOException e) {


            e.printStackTrace();
        }


        return result;
    }

}
