package pl.jacek.parking.location;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;
import java.util.UUID;

public interface LocationRepository  extends JpaRepository<Location, UUID> {
    @Query("SELECT l FROM Location l where l.id = :uuid")
    Optional<Location> loadByIdentifier(@Param("uuid") UUID uuid);
}
