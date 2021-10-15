package com.csse.service;

import com.csse.model.Item;
import com.csse.model.Site;
import org.junit.jupiter.api.Test;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.sql.SQLException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SiteServiceImplTest {

    @Test
    void addSite() {
        Site site=new Site();
        site.setSiteName("JMIS");
        site.setSiteLocation("Malabe");
        site.setSiteBudget(10000);
        site.setMinBudget(8500);

        SiteService siteService = new SiteServiceImpl();
        boolean actual_result = siteService.addSite(site);

        assertEquals(true,actual_result);

    }

    @Test
    void editSite() throws SQLException, ParserConfigurationException, ClassNotFoundException, SAXException {

        Site site=new Site();
        SiteService siteService = new SiteServiceImpl();
        site.setSiteId("1");
        Site actual_result = siteService.editSite("1");

        assertEquals(site.getSiteId(),actual_result.getSiteId());

    }

    @Test
    void updateSite() {

        Site site=new Site();
        site.setSiteId("1");
        site.setSiteName("DP-CONSTRUCTIONS");
        site.setSiteLocation("COLOMBO-07");
        site.setSiteBudget(1000);
        site.setMinBudget(5000);

        SiteService siteService = new SiteServiceImpl();
        boolean actual_result = siteService.updateSite(site);

        assertEquals(true,actual_result);
    }

    @Test
    void deleteSite() {
        Site site=new Site();
        SiteService siteService = new SiteServiceImpl();

        site.setSiteId("1");
        int actual_result =siteService.deleteSite(site);

        assertEquals(1,actual_result);
    }

    @Test
    void getSite() throws SQLException, ParserConfigurationException, ClassNotFoundException, SAXException {

        SiteService siteService = new SiteServiceImpl();
        List<Site> actual_result = siteService.getSite();

        assertEquals("2",actual_result.get(0).getSiteId());
    }
}