package rw.isite.ne.auth.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rw.isite.ne.auth.models.Quantity;

import java.util.UUID;

@Repository
public interface QuantityRepository extends JpaRepository<Quantity, UUID> {
    // Add any additional custom query methods here if needed
}
