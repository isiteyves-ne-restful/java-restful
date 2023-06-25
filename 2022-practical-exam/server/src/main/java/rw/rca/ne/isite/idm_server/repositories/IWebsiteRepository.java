package rw.rca.ne.isite.idm_server.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import rw.rca.ne.isite.idm_server.models.Website;

public interface IWebsiteRepository extends JpaRepository<Website, Integer> {
}
