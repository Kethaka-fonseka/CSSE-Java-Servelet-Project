package com.csse.service;

import com.csse.model.Site;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.sql.SQLException;
import java.util.List;

public interface SiteService {
    //add Site method
    boolean addSite(Site site);

    //edit site method
    Site editSite(String site) throws ClassNotFoundException, SQLException, ParserConfigurationException, SAXException;

    //Update site
    boolean updateSite(Site site);

    //delete site method
    int deleteSite(Site site);

    List<Site> getSite() throws ClassNotFoundException, SQLException, ParserConfigurationException, SAXException;
}
