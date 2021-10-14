package com.csse.service;

import com.csse.model.Staff;
import com.csse.model.Supplier;
import com.csse.model.User;

import java.util.ArrayList;

public interface IRegisterService {


    boolean addSupplier(User user, Supplier supplier);


    boolean removeSupplier(String userID);

    Supplier getSupplierByID(String supplierID);

    ArrayList<Supplier> getSuppliers();

    boolean updateSupplier(String userID, Supplier Supplier);

    ArrayList<String> getUserIDs();
}
