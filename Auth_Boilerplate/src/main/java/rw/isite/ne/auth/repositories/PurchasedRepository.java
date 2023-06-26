package rw.isite.ne.auth.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rw.isite.ne.auth.models.Purchased;

import java.util.UUID;

@Repository
public interface PurchasedRepository extends JpaRepository<Purchased, UUID> {
    // Add any additional custom query methods here if needed
}
