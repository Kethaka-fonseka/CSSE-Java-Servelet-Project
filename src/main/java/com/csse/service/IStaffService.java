package com.csse.service;

import com.csse.model.Staff;
import com.csse.model.Supplier;

import java.util.ArrayList;

public interface IStaffService {

    boolean addStaff(Staff staff);

    Staff getStaffByID(String staffID);

    ArrayList<Staff> getStaff();

    ArrayList<String> getUserIDs();

    boolean removeStaff(String userID);


    boolean updateStaff(String userID, Staff Staff);
}
