package rw.rca.ne.isite.idm_server.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import rw.rca.ne.isite.idm_server.models.Link;
import rw.rca.ne.isite.idm_server.models.Website;

import java.util.List;

public interface ILinkRepository extends JpaRepository<Link, Integer> {

    List<Link> findByWebsite(Website website);
}
