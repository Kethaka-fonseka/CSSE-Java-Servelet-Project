package com.csse.service;

import com.csse.model.Manager;

import java.util.ArrayList;

public interface IManagerService {
    boolean addManager(Manager Manager);

    Manager getManagerByID(String managerID);

    ArrayList<Manager> getManager();

    ArrayList<String> getUserIDs();

    boolean removeManager(String userID);

    boolean updateManager(String userID, Manager Manager);
}
