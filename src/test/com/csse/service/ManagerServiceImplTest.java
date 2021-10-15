package com.csse.service;

import com.csse.model.Manager;
import com.csse.model.Site;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ManagerServiceImplTest {

    @Test
    void addManager() {
        Manager manager=new Manager();
        IManagerService managerImp = new ManagerServiceImpl();

        manager.setMobileNumber(07712346);
        manager.setSiteName("CONSTRUCT");
        manager.setUserId("E0036");
        manager.setUserRole("admin");
        manager.setUserName("SPPS");
        manager.setUserMail("spps@gmail.com");
        manager.setUserPass("1234");

        boolean actual_result = managerImp.addManager(manager);

        assertEquals(false,actual_result);

    }
    @Test
    void getManagerByID() {

        Manager manager=new Manager();
        IManagerService managerImp = new ManagerServiceImpl();
        Manager actual_result = managerImp.getManagerByID("E3002");

        assertEquals(manager,actual_result);
    }

    @Test
    void getManager() {
    }

    @Test
    void getUserIDs() {

        IManagerService managerImp = new ManagerServiceImpl();
        ArrayList<String> actual_result = managerImp.getUserIDs();

        assertEquals("1",actual_result.get(0));
        assertEquals("2",actual_result.get(1));
        assertEquals("3",actual_result.get(2));
    }

    @Test
    void removeManager() {
        Manager manager=new Manager();
        IManagerService managerImp = new ManagerServiceImpl();

        manager.setManagerId(1);
        boolean actual_result =managerImp.removeManager("1");

        assertEquals(true,actual_result);
    }

    @Test
    void updateManager() {

        Manager manager=new Manager();
        IManagerService managerImp = new ManagerServiceImpl();

        manager.setUserName("SPP-SUPPLIER");
        manager.setUserMail("spps@gmail.com");
        manager.setUserPass("1234");
        manager.setSiteName("CONSTRUCT-NEW");
        manager.setMobileNumber(0714256);
        manager.setUserId("E0036");
        
        boolean actual_result = managerImp.addManager(manager);

        assertEquals(false,actual_result);


    }
}