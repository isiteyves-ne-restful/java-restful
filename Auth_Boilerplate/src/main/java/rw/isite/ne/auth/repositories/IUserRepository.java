package rw.isite.ne.auth.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rw.isite.ne.auth.models.Customer;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface IUserRepository extends JpaRepository<Customer, UUID> {
    Optional<Customer> findByEmail(String email);

    Optional<Customer> findByEmailOrPhoneNumber(String email, String phoneNumber);


}
