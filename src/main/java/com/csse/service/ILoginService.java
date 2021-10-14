package com.csse.service;

import com.csse.model.Staff;
import com.csse.model.User;

import java.util.logging.Logger;

public interface ILoginService {
    Logger log = Logger.getLogger(ILoginService.class.getName());


    User getUserByEmail(String email);
}
