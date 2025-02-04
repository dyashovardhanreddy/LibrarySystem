package com.dyvr.librarysystem.Library.System.dao;


import com.dyvr.librarysystem.Library.System.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Integer> {

    Optional<User> findByUsername(String username);

    boolean existsByUsername(String username);
}
