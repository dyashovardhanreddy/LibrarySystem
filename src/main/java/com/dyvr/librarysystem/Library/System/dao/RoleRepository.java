package com.dyvr.librarysystem.Library.System.dao;

import com.dyvr.librarysystem.Library.System.model.Role;
import com.dyvr.librarysystem.Library.System.model.RoleType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(RoleType name);
}
