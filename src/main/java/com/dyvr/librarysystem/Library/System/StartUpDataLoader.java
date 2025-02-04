package com.dyvr.librarysystem.Library.System;

import com.dyvr.librarysystem.Library.System.dao.RoleRepository;
import com.dyvr.librarysystem.Library.System.model.Role;
import com.dyvr.librarysystem.Library.System.model.RoleType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class StartUpDataLoader implements CommandLineRunner {

    // This class is to execute the steps at the time of app start up
    @Autowired
    private RoleRepository roleRepository;

    public void run(String... args){

        /* Here the different type of user roles are being populated
         into roles table in database. */

        List<RoleType> predefinedRoles = Arrays.asList(RoleType.ROLE_USER, RoleType.ROLE_ADMIN);

        for(RoleType roleType: predefinedRoles){
            if(roleRepository.findByName(roleType).isEmpty()){
                roleRepository.save(new Role(roleType));
            }
        }
    }
}
