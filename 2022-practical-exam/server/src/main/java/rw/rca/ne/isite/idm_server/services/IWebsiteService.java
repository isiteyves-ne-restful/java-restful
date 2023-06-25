package rw.rca.ne.isite.idm_server.services;


import rw.rca.ne.isite.idm_server.models.Website;

import java.net.URL;
import java.util.List;


public interface IWebsiteService {

    List<Website> getAllWebsitesDownloaded();

    Website download(URL url);

    Website findById(Integer websiteId);

}
