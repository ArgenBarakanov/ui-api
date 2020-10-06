package com.argen.uiapi.repository;

import com.argen.uiapi.entity.Role;
import com.argen.uiapi.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, User> {
    Optional<Role> findByName(String name);
}
