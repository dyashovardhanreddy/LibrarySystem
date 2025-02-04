package com.dyvr.librarysystem.Library.System.service;

import com.dyvr.librarysystem.Library.System.dao.UserRepository;
import com.dyvr.librarysystem.Library.System.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public String registerUser(User user){
        userRepository.save(user);
        return "Registration Successful!!";
    }
}
