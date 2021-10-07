package com.csse.service;

import com.csse.model.Supplier;
import com.csse.model.User;

import java.util.ArrayList;

public interface IRegisterService {


    boolean addSupplier(User user, Supplier supplier);

    boolean addStaff(User user, Supplier supplier);

    Supplier getSupplierByID(String supplierID);

    ArrayList<Supplier> getSuppliers();

    ArrayList<String> getUserIDs();
}
