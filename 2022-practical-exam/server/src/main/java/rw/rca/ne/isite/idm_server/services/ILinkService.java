package rw.rca.ne.isite.idm_server.services;

import rw.rca.ne.isite.idm_server.models.Link;
import rw.rca.ne.isite.idm_server.models.Website;

import java.net.URL;
import java.util.List;


public interface ILinkService {

    Link download(URL url,String path, Website website);

    List<Link> findByWebsite(Integer websiteId);
}
